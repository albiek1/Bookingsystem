package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO users (sName, email, password, phone, role, point) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setInt(4, user.getPhone());
                ps.setString(5, user.getRole());
                ps.setInt(6, 50);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id, role, sName, phone, point FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("sName");
                    String role = rs.getString("role");
                    int phone = rs.getInt("phone");
                    int id = rs.getInt("id");
                    int point = rs.getInt("point");
                    User user = new User(name, email, password, phone, role, point);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<User> getAllStudents() throws UserException {
        List<User> result = new ArrayList<>();
        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM users WHERE role = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, "student");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int  id = rs.getInt("id");
                    String name = rs.getString("sName");
                    String email = rs.getString("email");
                    int phone = rs.getInt("phone");
                    int point = rs.getInt("point");
                    User user = new User(id, name, email, phone, point);
                    result.add(user);
                }
            }
            catch (SQLException ex){
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }
        return result;
    }

    public User getStudentByID(int id) throws UserException {
        User user = null;
        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM users WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int sID = rs.getInt("id");
                    String name = rs.getString("sName");
                    String email = rs.getString("email");
                    int phone = rs.getInt("phone");
                    int points = rs.getInt("point");
                    user = new User(sID, name, email, phone, points);
                }
            }
            catch (SQLException ex){
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }
        return user;
    }

    public void updateStudentPoints(int points, int id) throws UserException {
        try(Connection connection = database.connect()){
            String sql = "UPDATE users SET point = ? WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, points);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }
    }
}
