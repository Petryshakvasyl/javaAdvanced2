package ua.lviv.lgs.pv.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String role = (String) session.getAttribute("role");
        if (role != null) {
            if (role.equals("ADMIN")) {
                chain.doFilter(request, response);
            } else {
                httpRequest.getRequestDispatcher("/access-deny.jsp").forward(request, response);
            }
        } else {
            ((HttpServletResponse) response).sendRedirect("/advanced/login");
        }
    }

    @Override
    public void destroy() {

    }
}
