package ua.lviv.lgs.pv.controller;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.service.UserService;
import ua.lviv.lgs.pv.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private static Logger log = Logger.getLogger(LoginController.class);

    private UserService userService;

    public LoginController() {
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to get login page");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> userOptional = userService.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            log.debug("user is present");
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("role", user.getRole());
                resp.sendRedirect("home");
            } else {
                log.debug("invalid password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            }
        } else {
            log.debug("not found user with email: " + email);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
