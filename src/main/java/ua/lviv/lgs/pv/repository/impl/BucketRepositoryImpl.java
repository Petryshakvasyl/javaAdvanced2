package ua.lviv.lgs.pv.repository.impl;

import org.apache.log4j.Logger;
import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.entity.Bucket;
import ua.lviv.lgs.pv.repository.BucketRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BucketRepositoryImpl implements BucketRepository {

    private static final Logger log = Logger.getLogger(ProductRepositoryImpl.class);

    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String DELETE_BY_ID = "delete from bucket where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private static BucketRepository instance;

    public BucketRepositoryImpl() {
        connection = ConnectionManager.createConnection();
    }

    public static BucketRepository getInstance() {
        if (instance == null) {
            instance = new BucketRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void save(Bucket bucket) {

        try (PreparedStatement preparedStatement = getPreparedStatement(bucket);
             ResultSet rs = preparedStatement.getGeneratedKeys()) {
            rs.next();
            bucket.setId(rs.getInt(1));

        } catch (SQLException e) {
           log.error("error while save bucket");
        }
    }

    private PreparedStatement getPreparedStatement(Bucket bucket) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
        connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, bucket.getUserId());
        preparedStatement.setInt(2, bucket.getProductId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(bucket.getPurchaseDate()));
        preparedStatement.executeUpdate();
        return preparedStatement;
    }

    @Override
    public Optional<Bucket> findById(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer bucketId = result.getInt("id");
            Integer userId = result.getInt("user_id");
            Integer productId = result.getInt("product_id");
            LocalDateTime purchaseDate = result.getTimestamp("purchase_date").toLocalDateTime();

            bucket = new Bucket(bucketId, purchaseDate, userId, productId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(bucket);
    }

    @Override
    public void update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
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
    public List<Bucket> findAll() {

        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer bucketId = result.getInt("id");
                Integer userId = result.getInt("user_id");
                Integer productId = result.getInt("product_id");
                LocalDateTime purchaseDate = result.getTimestamp("purchase_date").toLocalDateTime();
                bucketRecords.add(new Bucket(bucketId, purchaseDate, userId, productId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucketRecords;
    }
}
