package by.home.pvt.dao.impl;

import by.home.pvt.bean.User;
import by.home.pvt.dao.UserDao;
import by.home.pvt.dao.connection.ConnectionPool;
import by.home.pvt.dao.connection.ConnectionPoolException;
import by.home.pvt.dao.exceptions.DaoException;
import by.home.pvt.dao.exceptions.UserNotFoundException;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_FULL_NAME = "full_name";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_STATUS = "status";


    private static final String INSERT_USER_QUERY = "insert into users(login, password, full_name, phone_number, email, status) values(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_LOGIN_QUERY = "select * from users where login=?";
    private static final String SELECT_USERS_IN_RANGE = "select * from news where id between ? and ?";
    private static final String UPDATE_USER_QUERY = "update users set login=?, password=?, full_name=?, phone_number=?, email=?, status=? where id=?";


    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void add(User user) throws DaoException {

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getStatus());

            int result = preparedStatement.executeUpdate();

            if (result == 0) {
                throw new DaoException("User registration error in the system");
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
            throw new DaoException("User registration process error", e);
        }

    }

    @Override
    public User getById(int id) throws DaoException, UserNotFoundException {
        return null;
    }

    @Override
    public List<User> getAll() throws DaoException {
        return null;
    }

    @Override
    public List<User> getInRange(int startId, int endId) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_IN_RANGE)) {

            preparedStatement.setInt(1, startId);
            preparedStatement.setInt(2, endId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (!resultSet.next()) {
                    throw new UserNotFoundException("Users in range not found");
                }
                List<User> userList = new ArrayList<>();
                do {
                    User user = new User(
                            resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_LOGIN),
                            resultSet.getString(COLUMN_PASSWORD),
                            resultSet.getString(COLUMN_FULL_NAME),
                            resultSet.getString(COLUMN_PHONE_NUMBER),
                            resultSet.getString(COLUMN_EMAIL),
                            resultSet.getString(COLUMN_STATUS));
                    userList.add(user);

                } while (resultSet.next());

                return userList;
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Error in the users getting process", e);
        }
    }

    @Override
    public List<User> getFromEnd(int count) throws DaoException {
        return null;
    }

    @Override
    public User getByLogin(String login) throws DaoException, UserNotFoundException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN_QUERY);
        ) {
            preparedStatement.setString(1, login);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new UserNotFoundException("The user with this login was not found");
                }

                return new User(
                        resultSet.getInt(COLUMN_ID),
                        resultSet.getString(COLUMN_LOGIN),
                        resultSet.getString(COLUMN_PASSWORD),
                        resultSet.getString(COLUMN_FULL_NAME),
                        resultSet.getString(COLUMN_PHONE_NUMBER),
                        resultSet.getString(COLUMN_EMAIL),
                        resultSet.getString(COLUMN_STATUS)
                );
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(User user) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getStatus());
            preparedStatement.setInt(7, user.getId());

            int result = preparedStatement.executeUpdate();

            if (result == 0) {
                throw new DaoException("User update error in the system");
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("User update process error", e);
        }
    }

    @Override
    public User authentication(String login, String password) throws DaoException, UserNotFoundException {
        User user = getByLogin(login);

        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new DaoException("Wrong password");
        }
        return user;
    }
}
