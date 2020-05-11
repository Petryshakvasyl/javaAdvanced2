package ua.lviv.lgs.pv.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.service.BucketService;
import ua.lviv.lgs.pv.service.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/bucket/add")
public class AddToBucketController extends HttpServlet {
    private static Logger log = Logger.getLogger(AddToBucketController.class);

    private BucketService bucketService;

    public AddToBucketController() {
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("add product to bucket");
        Integer bucketId = (Integer) req.getSession().getAttribute("bucketId");


        String requestBody = req.getReader().lines().collect(Collectors.joining());
        AddProductDTO addProductDTO = new ObjectMapper().readValue(requestBody, AddProductDTO.class);
        log.debug("product : " + addProductDTO);
        bucketService.addProduct(bucketId, addProductDTO.getId(), 1);
    }

    private static class AddProductDTO{
        private Integer id;
        private Integer count;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }
}
