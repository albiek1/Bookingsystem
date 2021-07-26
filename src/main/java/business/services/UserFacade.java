package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.ArrayList;
import java.util.List;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String name, String email, int phone, String password) throws UserException
    {
        User user = new User(name ,email, password, phone , "student", 50);
        userMapper.createUser(user);
        return user;
    }

    public List<User> getAllStudents() throws UserException {
        List<User> students = new ArrayList<>();
        students = userMapper.getAllStudents();
        return students;
    }

    public User getStudentByID(int id) throws UserException {
        return userMapper.getStudentByID(id);
    }

    public void updateStudentPoints(int points, int id) throws UserException {
        userMapper.updateStudentPoints(points, id);
    }

}
