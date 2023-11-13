package by.home.pvt.dao;

import by.home.pvt.dao.impl.NewsInMemoryDaoImpl;
import by.home.pvt.service.ServiceProvider;

public final class DaoProvider {

    private static final DaoProvider instance = new DaoProvider();

    private final NewsDao newsDao = new NewsInMemoryDaoImpl();

    public NewsDao getNewsDao() {
        return newsDao;
    }


    public static DaoProvider getInstance() {
        return instance;
    }

}
