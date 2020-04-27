package ua.lviv.lgs.pv.controller.filter;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.controller.SimpleServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class SimpleFilter implements Filter {

    private static final Logger log = Logger.getLogger(SimpleServlet.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter request");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
