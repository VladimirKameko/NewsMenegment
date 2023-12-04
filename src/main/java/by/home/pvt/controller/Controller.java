package by.home.pvt.controller;

import by.home.pvt.dao.connection.ConnectionPool;
import by.home.pvt.dao.connection.ConnectionPoolException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

    private final CommandProvider commandProvider = CommandProvider.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Command command = commandProvider.getCommand(req.getParameter("command"));
        command.execute(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            ConnectionPool.getInstance().dispose();
        } catch (ConnectionPoolException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            try {
                throw new ConnectionPoolException(e);
            } catch (ConnectionPoolException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
