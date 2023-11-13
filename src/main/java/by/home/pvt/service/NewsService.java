package by.home.pvt.service;

import by.home.pvt.bean.News;

import java.util.List;

public interface NewsService {

    void add(News news) throws ServiceException;
    List<News> getAllNews() throws ServiceException;
    News getNewsByName(String name) throws ServiceException;

    void deleteNewsByName(String name) throws ServiceException;

    News updateNewsByName(News news) throws ServiceException;
}
