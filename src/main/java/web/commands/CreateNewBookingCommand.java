package web.commands;

import business.entities.Booking;
import business.entities.Item;
import business.entities.User;
import business.exceptions.BookingException;
import business.exceptions.ItemException;
import business.exceptions.UserException;
import business.services.BookingFacade;
import business.services.ItemFacade;
import business.services.UserFacade;
import sun.security.util.Debug;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class CreateNewBookingCommand extends CommandProtectedPage{

    BookingFacade bookingFacade;
    UserFacade userFacade;
    ItemFacade itemFacade;
    public CreateNewBookingCommand(String pageToShow, String role){
        super(pageToShow, role);
        bookingFacade = new BookingFacade(database);
        userFacade = new UserFacade(database);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BookingException, UserException, ItemException {

        HttpSession session = request.getSession();
        request.setAttribute("id", session.getAttribute("id"));
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        Debug.println("itemID", String.valueOf(itemID));
        Date date = null;
        if(request.getParameter("date") != null){
            date = Date.valueOf(request.getParameter("date"));
        }
        int length = 0;
        if(request.getParameter("length") != null){
            length = Integer.parseInt(request.getParameter("length"));
        }
        int studentID = (int) session.getAttribute("id");
        Debug.println("date", String.valueOf(date));
        if(date != null){
            bookingFacade.createBooking(itemID, date, length, studentID);
            User user = userFacade.getStudentByID(studentID);
            itemFacade.updateItemStatus(itemID, "booked");
            //TODO: cap booking if user has no points
            Debug.println("user points", String.valueOf(user.getPoint()-length));
            userFacade.updateStudentPoints(user.getPoint()-length, studentID);
            return "studentpage";
        }

        return pageToShow;
    }
}
