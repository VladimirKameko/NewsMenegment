package by.home.pvt.dao;

import by.home.pvt.bean.News;

import java.util.List;

public interface NewsDao {

    void addNews(News news) throws DaoException;

    List<News> getAllNews() throws DaoException;

    News getNewsByName(String name) throws DaoException;

    News updateNews(News news) throws DaoException;

    void deleteNewsByName(String name) throws DaoException;
}
