package web.commands;

import business.entities.Booking;
import business.entities.Item;
import business.exceptions.BookingException;
import business.exceptions.ItemException;
import business.services.BookingFacade;
import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class editBookingCommandAdm extends CommandProtectedPage{

    BookingFacade bookingFacade;
    ItemFacade itemFacade;
    public editBookingCommandAdm(String pageToShow, String role){
        super(pageToShow, role);
        bookingFacade = new BookingFacade(database);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BookingException, ItemException {
        Booking booking = null;
        Date endDate;
        HttpSession session = request.getSession();
        if(request.getParameter("submit") != null){
            booking = bookingFacade.getBookingsByID(Integer.parseInt(request.getParameter("submit"))+1);
            Item item = itemFacade.getItemByID(booking.getItemID());
            endDate = Date.valueOf(LocalDate.parse(booking.getDate().toString()).plusDays (booking.getLength()));
            request.setAttribute("booking", booking);
            request.setAttribute("item", item);
            request.setAttribute("itemType", item.getItemType());
            request.setAttribute("itemName", item.getName());
            request.setAttribute("startDate", booking.getDate());
            request.setAttribute("endDate", endDate);
            request.setAttribute("length", booking.getLength());
            request.setAttribute("itemID", item.getItemID());
            request.setAttribute("status", booking.getStatus());
            session.setAttribute("bookingID", booking.getBookingID());
        }

        //set current booking

        //set new booking
        String newID = request.getParameter("newID");
        String newDateS = request.getParameter("newDate");
        if(newID != null || newDateS != null){
            Date newDate = Date.valueOf(newDateS);
            String newStatus = request.getParameter("status");
            int newLength = Integer.parseInt(request.getParameter("newLength"));
            int newIdI = itemFacade.getItemBySID(newID);
            bookingFacade.updateBooking(Integer.parseInt((String.valueOf(session.getAttribute("bookingID")))), newStatus, newLength, newIdI, newDate);
            return "showCurrentBookings";
        }
        return pageToShow;

        /*if(LocalDate.now().isAfter(LocalDate.parse(booking.getDate().toString())) && LocalDate.now().isBefore(LocalDate.parse(endDate.toString()))){
            request.setAttribute("status", "Active");
        }else{
            request.setAttribute("status", "Inactive");
        }*/
    }
}
