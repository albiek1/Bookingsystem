package web.commands;

import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addNewStudentCommand extends CommandProtectedPage{

    UserFacade userFacade;
    public addNewStudentCommand(String pageToShow, String role){
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Integer phone;
        if(request.getParameter("phone") != null &&!request.getParameter("phone").equals("")){
            phone = Integer.parseInt(request.getParameter("phone"));
        }else{
            phone = null;
        }
        String password = request.getParameter("password");

        if(name != null){
            userFacade.createUser(name, email, phone, password);
            return pageToShow;
        }
        return pageToShow;
    }
}
