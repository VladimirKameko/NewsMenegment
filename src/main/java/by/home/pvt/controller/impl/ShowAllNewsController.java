package by.home.pvt.controller.impl;

import by.home.pvt.bean.News;
import by.home.pvt.controller.Command;
import by.home.pvt.service.NewsService;
import by.home.pvt.service.ServiceException;
import by.home.pvt.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ShowAllNewsController implements Command {

    private final NewsService newsService = ServiceProvider.getInstance().getNewsService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<News> allNews = newsService.getAllNews();
            req.setAttribute("allNews", allNews);
            req.getRequestDispatcher("/WEB-INF/jsp/all_news_page.jsp").forward(req, resp);
        } catch (ServiceException e) {
            throw new ServletException(e);
        }

    }
}
