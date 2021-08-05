package business.persistence;

import business.entities.User;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    private final static String DATABASE = "startcode";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "dev";
    private final static String PASSWORD = "devacc";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static UserMapper userMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userMapper = new UserMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

            // reset test database
            try ( Statement stmt = database.connect().createStatement() ) {
                stmt.execute("DELETE FROM users WHERE NOT id IS NULL" );
                stmt.execute(
                        "insert into users values " +
                    "(1,'Jens', 'jens@somewhere.com','jensen','11111111','student', 50), " +
                    "(2,'Ken', 'ken@somewhere.com','kensen','22222222','student', 50), " +
                    "(3,'Robin', 'robin@somewhere.com','batman','33333333','admin', 50)");
            } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(database);
    }

    @Test
    public void testLogin01() throws UserException {
        // Can we log in
        User user = userMapper.login( "jens@somewhere.com", "jensen" );
        assertTrue( user != null );
    }

    @Test
    public void testLogin02() throws UserException {
        // We should get an exception if we use the wrong password
        assertThrows(UserException.class, () ->
            {User user = userMapper.login( "jens@somewhere.com", "larsen" ); });

    }

    @Test
    public void testLogin03() throws UserException {
        // Jens is supposed to be a customer
        User user = userMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "student", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws UserException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "King Kong","king@kong.com", "uhahvorhemmeligt", 11111111 ,"konge" ,50);
        userMapper.createUser( original );
        User retrieved = userMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getRole() );
    }

    @Test
    public void unitTest(){
        //test for adding date and length
        Date date = Date.valueOf("2021-10-10");
        int length = 10;
        Date endDate = Date.valueOf(LocalDate.parse(date.toString()).plusDays (length));
        assertEquals("2021-10-20", endDate.toString());
    }
}
