package web.commands;

import business.entities.Booking;
import business.exceptions.BookingException;
import business.services.BookingFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class createBookingCommand extends CommandProtectedPage{

    private BookingFacade bookingFacade;

    public createBookingCommand(String pageToShow, String role) {
        super(pageToShow, role);
        bookingFacade = new BookingFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BookingException {
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        int bookingLength = Integer.parseInt(request.getParameter("bookingLength"));
        int studentID = (int) request.getSession().getAttribute("id");
        Booking booking = bookingFacade.createBooking(itemID, startDate, bookingLength, studentID);
        return "createNewBooking";
    }
}
