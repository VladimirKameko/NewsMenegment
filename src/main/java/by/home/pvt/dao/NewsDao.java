package by.home.pvt.dao;

import by.home.pvt.bean.News;
import by.home.pvt.dao.exceptions.DaoException;
import by.home.pvt.dao.exceptions.NewsNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface NewsDao {

    void add(News news) throws DaoException;

    News getById(int id) throws DaoException, NewsNotFoundException;

    List<News> getInRange(int startId, int endId) throws NewsNotFoundException, DaoException;

    List<News> getFromEnd(int count) throws NewsNotFoundException, DaoException;

    List<News> findByPublicationDate(LocalDate date) throws DaoException, NewsNotFoundException;

    List<News> findByTitle(String date) throws DaoException, NewsNotFoundException;

    List<News> findByUserId(int userId) throws DaoException, NewsNotFoundException;

    void update(News news) throws DaoException;

    void block(int id) throws DaoException;
}
