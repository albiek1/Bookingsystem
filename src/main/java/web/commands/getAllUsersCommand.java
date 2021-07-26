package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class getAllUsersCommand extends CommandProtectedPage{

    UserFacade userFacade;
    public getAllUsersCommand(String pageToShow, String role){
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        List<User> students = userFacade.getAllStudents();
        request.setAttribute("users", students);
        return "showAllStudentsPage";
    }
}
