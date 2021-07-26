package web.commands;

import business.exceptions.BookingException;
import business.exceptions.ItemException;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandProtectedPage extends Command
{
    public String role;
    public String pageToShow;

    public CommandProtectedPage(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws BookingException, UserException, ItemException {
        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
