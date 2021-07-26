package business.services;

import business.entities.Booking;
import business.exceptions.BookingException;
import business.persistence.BookingMapper;
import business.persistence.Database;

import java.sql.Date;
import java.util.List;

public class BookingFacade {

    BookingMapper bookingMapper;

    public BookingFacade(Database database){bookingMapper = new BookingMapper(database);}

    public Booking createBooking(int itemID, Date start, int length, int studentID) throws BookingException
    {
        Booking booking = new Booking(itemID, start, length, studentID);
        bookingMapper.createBooking(booking);
        return booking;
    }

    public List<Booking> getAllBookings() throws BookingException {
        return bookingMapper.getAllBookings();
    }

    public Booking getBookingsByID(int id) throws BookingException {
        return bookingMapper.getBookingByID(id);
    }

    public void updateBooking(int bookingID ,String status, int newLength, int newID, Date newDate) throws BookingException {
        bookingMapper.updateStatus(bookingID, newDate, newLength, newID, status);
    }
}
