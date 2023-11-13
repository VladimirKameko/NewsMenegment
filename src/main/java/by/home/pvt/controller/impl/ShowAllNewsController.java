package by.home.pvt.controller.impl;

import by.home.pvt.controller.Command;
import by.home.pvt.service.NewsService;
import by.home.pvt.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ShowAllNewsController implements Command {

    private final NewsService newsService = ServiceProvider.getInstance().getNewsService();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/jsp/all_news_page.jsp").forward(req, resp);
    }
}
