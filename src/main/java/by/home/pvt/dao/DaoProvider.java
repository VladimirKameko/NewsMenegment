package by.home.pvt.dao;

import by.home.pvt.dao.impl.UserDaoImpl;

public final class DaoProvider {

    private static final DaoProvider instance = new DaoProvider();


    private final UserDao userDao = new UserDaoImpl();

    public UserDao getUserDao() {
        return userDao;
    }


    public static DaoProvider getInstance() {
        return instance;
    }

}
