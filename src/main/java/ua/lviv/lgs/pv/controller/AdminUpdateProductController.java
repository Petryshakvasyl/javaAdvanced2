package ua.lviv.lgs.pv.controller;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.service.ProductService;
import ua.lviv.lgs.pv.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/admin/update_product")
public class AdminUpdateProductController extends HttpServlet {

    private static Logger log = Logger.getLogger(AdminUpdateProductController.class);

    private ProductService productService;

    public AdminUpdateProductController() {
        this.productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to get create product page");
        req.getRequestDispatcher("/update-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to update product ");
        String idString = req.getParameter("id");
        Integer id = Integer.parseInt(idString);
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String priceString = req.getParameter("price");
        BigDecimal price = new BigDecimal(0);
        if (validatePrice(priceString)) {
            price = new BigDecimal(priceString);
        }
        Product product = new Product(id, name, description, price);
        productService.update(product);
        resp.sendRedirect("/product-list");
    }

    private boolean validatePrice(String priceString) {
        try {
            Double.parseDouble(priceString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
