package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class viewProfileStudent extends CommandProtectedPage{

    UserFacade userFacade;
    public viewProfileStudent(String pageToShow, String role){
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User student = userFacade.getStudentByID(user.getId());
        request.setAttribute("name", student.getName());
        request.setAttribute("email", student.getEmail());
        request.setAttribute("phone", student.getPhone());
        request.setAttribute("points", student.getPoint());
        return pageToShow;
    }
}
