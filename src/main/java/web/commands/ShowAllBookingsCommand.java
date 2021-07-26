package web.commands;

import business.entities.Booking;
import business.entities.Item;
import business.entities.User;
import business.exceptions.BookingException;
import business.exceptions.ItemException;
import business.exceptions.UserException;
import business.persistence.BookingMapper;
import business.persistence.ItemMapper;
import business.persistence.UserMapper;
import business.services.BookingFacade;
import business.services.ItemFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ShowAllBookingsCommand extends CommandProtectedPage{

    BookingFacade bookingFacade;
    UserFacade userFacade;
    ItemFacade itemFacade;

    public ShowAllBookingsCommand(String pageToShow, String role){
        super(pageToShow, role);
        bookingFacade = new BookingFacade(database);
        userFacade = new UserFacade(database);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BookingException, UserException, ItemException {
        List<Booking> bookings = bookingFacade.getAllBookings();
        List<User> users = new ArrayList<>();
        Item item;
        for(Booking booking : bookings){
            User user = userFacade.getStudentByID(booking.getStudentID());
            users.add(user);
            item = itemFacade.getItemByID(booking.getItemID());
            booking.setItemName(item.getItemID());
            booking.setItemType(item.getItemType());
            java.sql.Date endDate = Date.valueOf(LocalDate.parse(booking.getDate().toString()).plusDays (booking.getLength()));
            booking.setBookingEnd(endDate);
        }
        request.setAttribute("bookingList", bookings);
        return pageToShow;
    }
}
