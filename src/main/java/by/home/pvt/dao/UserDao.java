package by.home.pvt.dao;

import by.home.pvt.bean.User;
import by.home.pvt.dao.exceptions.DaoException;
import by.home.pvt.dao.exceptions.UserNotFoundException;

import java.util.List;

public interface UserDao {

    void add(User user) throws DaoException;
    User getById(int id) throws DaoException, UserNotFoundException;
    List<User> getAll() throws DaoException;
    List<User> getInRange(int startId, int endId) throws DaoException;
    List<User> getFromEnd(int count) throws DaoException;
    User getByLogin(String login) throws DaoException, UserNotFoundException;
    void update(User user) throws DaoException;

    User authentication(String login, String password) throws DaoException, UserNotFoundException;
}
