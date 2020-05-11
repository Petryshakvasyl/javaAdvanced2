package ua.lviv.lgs.pv.repository;


import ua.lviv.lgs.pv.entity.Bucket;

public interface BucketRepository extends CrudRepository<Bucket, Integer> {

    void addProduct(Integer bucketId, Integer productId, Integer productCount);

    int getCountProductsInBucket(Integer bucketId);
}
