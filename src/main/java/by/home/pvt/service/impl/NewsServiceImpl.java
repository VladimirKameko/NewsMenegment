package by.home.pvt.service.impl;

import by.home.pvt.bean.News;
import by.home.pvt.dao.exceptions.DaoException;
import by.home.pvt.dao.DaoProvider;
import by.home.pvt.dao.NewsDao;
import by.home.pvt.service.NewsService;
import by.home.pvt.service.ServiceException;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    private final NewsDao newsDao = DaoProvider.getInstance().getNewsDao();

    @Override
    public void add(News news) throws ServiceException {
        try {
            newsDao.addNews(news);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<News> getAllNews() throws ServiceException {
        try {
            return newsDao.getAllNews();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public News getNewsByName(String name) throws ServiceException {
        try {
            return newsDao.getNewsByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteNewsByName(String name) throws ServiceException {
        try {
            newsDao.deleteNewsByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public News updateNewsByName(News news) throws ServiceException {
        try {
            return newsDao.updateNews(news);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
