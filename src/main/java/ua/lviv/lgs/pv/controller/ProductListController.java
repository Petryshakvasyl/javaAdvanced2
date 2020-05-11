package ua.lviv.lgs.pv.controller;

import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.BucketRepository;
import ua.lviv.lgs.pv.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.pv.service.BucketService;
import ua.lviv.lgs.pv.service.BucketServiceImpl;
import ua.lviv.lgs.pv.service.ProductService;
import ua.lviv.lgs.pv.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product-list")
public class ProductListController extends HttpServlet {

    ProductService productService;
    BucketService bucketService;

    public ProductListController() {
        this.productService = ProductServiceImpl.getInstance();
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        Integer bucketId = (Integer) req.getSession().getAttribute("bucketId");
        req.setAttribute("productsCountInBucket", bucketService.getCountProductsInBucket(bucketId));
        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
    }
}
