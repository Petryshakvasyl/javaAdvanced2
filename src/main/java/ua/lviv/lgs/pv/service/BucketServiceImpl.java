package ua.lviv.lgs.pv.service;

import ua.lviv.lgs.pv.entity.Bucket;
import ua.lviv.lgs.pv.repository.BucketRepository;
import ua.lviv.lgs.pv.repository.impl.BucketRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class BucketServiceImpl implements BucketService {

    private BucketRepository bucketRepository;

    public BucketServiceImpl() {
        this.bucketRepository = BucketRepositoryImpl.getInstance();
    }

    private static BucketService instance = new BucketServiceImpl();

    public static BucketService getInstance() {
        return instance;
    }

    @Override
    public void save(Bucket bucket) {
        bucketRepository.save(bucket);
    }

    @Override
    public void update(Bucket bucket) {
        bucketRepository.update(bucket);
    }

    @Override
    public void addProduct(Integer bucketId, Integer productId, Integer productCount) {
        bucketRepository.addProduct(bucketId, productId, productCount);
    }

    @Override
    public List<Bucket> findAll() {
        return bucketRepository.findAll();
    }

    @Override
    public Optional<Bucket> findById(Integer id) {
        return bucketRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        bucketRepository.deleteById(id);
    }

}
