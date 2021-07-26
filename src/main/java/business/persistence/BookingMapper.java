package business.persistence;


import business.entities.Booking;
import business.exceptions.BookingException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper {
    private Database database;

    public BookingMapper(Database database){this.database = database;}

    public void createBooking(Booking booking) throws BookingException
    {
        try(Connection connection = database.connect())
        {
            String sql = "INSERT INTO booking (itemID, bookingStart, bookingLength, studentID) VALUES (?, ?, ?, ?)";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, booking.getItemID());
                ps.setDate(2, booking.getDate());
                ps.setInt(3, booking.getLength());
                ps.setInt(4, booking.getStudentID());
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                throw new BookingException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new BookingException(ex.getMessage());
        }
    }

    public Booking getBookingByID(int id) throws BookingException {
        Booking booking = null;
        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM booking WHERE studentID = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, id);
                ResultSet resultSet = ps.executeQuery();
                if(resultSet != null){
                    while(resultSet.next()){
                        int bookingID = resultSet.getInt("idbooking");
                        Date bookingStart = resultSet.getDate("bookingStart");
                        int bookingEnd = resultSet.getInt("bookingLength");
                        int itemID = resultSet.getInt("itemID");
                        int studentID = resultSet.getInt("studentID");
                        String status = resultSet.getString("bookingstatus");
                        booking = new Booking(bookingID, bookingStart, bookingEnd, studentID, itemID, status);
                    }
                }
            }
            catch (SQLException ex)
            {
                throw new BookingException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new BookingException(ex.getMessage());
        }
        return booking;
    }

    public List<Booking> getAllBookings()throws BookingException{
        List<Booking> bookings = new ArrayList<>();
        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM booking";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int bookingID = rs.getInt("idbooking");
                    Date bookingStart = rs.getDate("bookingStart");
                    int bookingLength = rs.getInt("bookingLength");
                    int studentID = rs.getInt("studentID");
                    int itemID = rs.getInt("itemID");
                    String status = rs.getString("bookingstatus");
                    Booking booking = new Booking(bookingID, bookingStart, bookingLength, studentID, itemID, status);
                    bookings.add(booking);
                }
            }
        }
        catch (SQLException ex){
            throw new BookingException(ex.getMessage());
        }
        return bookings;
    }

    public void updateStatus(int bookingid, Date newDate, int newLength, int newID, String status) throws BookingException {
        try(Connection connection = database.connect()){
            String sql = "UPDATE booking SET bookingStart = ?, bookingLength = ?, itemID = ?, bookingstatus = ? WHERE (idbooking = ?)";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setDate(1, newDate);
                ps.setInt(2, newLength);
                ps.setInt(3, newID);
                ps.setString(4, status);
                ps.setInt(5, bookingid);
                ps.executeUpdate();
            }
        }
        catch (SQLException ex){
            throw new BookingException(ex.getMessage());
        }
    }
}
