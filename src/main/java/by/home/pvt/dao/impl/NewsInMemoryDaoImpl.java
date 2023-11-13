package by.home.pvt.dao.impl;

import by.home.pvt.bean.News;
import by.home.pvt.dao.DaoException;
import by.home.pvt.dao.NewsDao;

import java.util.ArrayList;
import java.util.List;

public class NewsInMemoryDaoImpl implements NewsDao {

    private static final List<News> newsRepo = new ArrayList<>();


    @Override
    public void addNews(News news) throws DaoException {
        newsRepo.add(news);
    }

    @Override
    public List<News> getAllNews() throws DaoException {
        return new ArrayList<>(newsRepo);
    }

    @Override
    public News getNewsByName(String name) throws DaoException {
        return newsRepo.stream().filter(q -> q.getNewsTitle().equals(name)).findFirst().orElseThrow();
    }

    @Override
    public News updateNews(News news) throws DaoException {
        return newsRepo.set(newsRepo.indexOf(getNewsByName(news.getNewsTitle())), news);

    }

    @Override
    public void deleteNewsByName(String name) throws DaoException {
        newsRepo.remove(getNewsByName(name));
    }
}
