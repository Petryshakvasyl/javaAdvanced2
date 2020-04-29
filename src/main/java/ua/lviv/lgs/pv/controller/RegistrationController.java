package ua.lviv.lgs.pv.controller;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.service.UserService;
import ua.lviv.lgs.pv.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private static Logger log = Logger.getLogger(RegistrationController.class);

    private UserService userService;

    public RegistrationController() {
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to get registration page");
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to register new user");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> optionalUser = userService.findByEmail(email);

        if (!optionalUser.isPresent()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setRole("USER");
            userService.save(user);
            resp.sendRedirect("login");
        }
    }
}
