package ua.lviv.lgs.pv.service.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.ProductRepository;
import ua.lviv.lgs.pv.repository.impl.ProductRepositoryImpl;
import ua.lviv.lgs.pv.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private static Logger log = Logger.getLogger(ProductRepositoryImpl.class);

    private ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = ProductRepositoryImpl.getInstance();
    }

    private static ProductService instance = new ProductServiceImpl();

    public static ProductService getInstance() {
        return instance;
    }

    @Override
    public void save(Product product) {
        log.debug("save product: " + product);
        productRepository.save(product);

    }

    @Override
    public void update(Product product) {
        log.debug("update product: " + product);
        productRepository.update(product);
    }

    @Override
    public List<Product> findAll() {
        log.debug("find all products");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        log.debug("find product by id: " + id);
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("delete product by id " + id);
        productRepository.deleteById(id);
    }
}
