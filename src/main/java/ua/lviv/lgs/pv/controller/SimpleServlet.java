package ua.lviv.lgs.pv.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class SimpleServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(SimpleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("req content type: " + req.getContentType());
        //            resp.setContentType("text/html");
        //            resp.getWriter().write("<h2>Hello from Servlet</h2>");

        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
