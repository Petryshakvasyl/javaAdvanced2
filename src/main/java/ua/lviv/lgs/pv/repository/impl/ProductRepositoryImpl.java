package ua.lviv.lgs.pv.repository.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.ProductRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

	private static final Logger log = Logger.getLogger(ProductRepositoryImpl.class);

	private static String READ_ALL = "select * from products";
	private static String CREATE = "insert into products(`name`, `description`, `price`) values (?,?,?)";
	private static String READ_BY_ID = "select * from products where id =?";
	private static String UPDATE_BY_ID = "update products set name=?, description = ?, price = ? where id = ?";
	private static String DELETE_BY_ID = "delete from products where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	private static ProductRepository instance;

	private ProductRepositoryImpl() {
		connection = ConnectionManager.createConnection();
	}

	public static ProductRepository getInstance() {
		if (instance == null) {
			instance = new ProductRepositoryImpl();
		}
		return instance;
	}

	@Override
	public void save(Product product) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setBigDecimal(3, product.getPrice());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			product.setId(rs.getInt(1));
		} catch (SQLException e) {
			log.error("error while saving product ", e);
		}
	}

	@Override
	public Optional<Product> findById(Integer id) {
		Product product = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer productId = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			BigDecimal price = result.getBigDecimal("price");
			product = new Product(productId, name, description, price);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.ofNullable(product);
	}

	@Override
	public void update(Product product) {

		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setBigDecimal(3, product.getPrice());
			preparedStatement.setInt(4, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findAll() {
		List<Product> productRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer productId = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				BigDecimal price = result.getBigDecimal("price");

				productRecords.add(new Product(productId, name, description, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productRecords;
	}

}
