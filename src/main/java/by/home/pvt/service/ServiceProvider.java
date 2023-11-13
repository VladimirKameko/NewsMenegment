package by.home.pvt.service;

import by.home.pvt.service.impl.NewsServiceImpl;

public final class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private final NewsService newsService = new NewsServiceImpl();


    public NewsService getNewsService() {
        return newsService;
    }

    public static ServiceProvider getInstance() {
        return instance;
    }
}
