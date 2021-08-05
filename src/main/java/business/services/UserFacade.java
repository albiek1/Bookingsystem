package business.services;

import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.UserMapper;

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
        return userMapper.getAllStudents();
    }

    public User getStudentByID(int id) throws UserException {
        return userMapper.getStudentByID(id);
    }

    public void updateStudentPoints(int points, int id) throws UserException {
        userMapper.updateStudentPoints(points, id);
    }

}
