package ua.lviv.lgs.pv.service;

import ua.lviv.lgs.pv.entity.Bucket;

public interface BucketService extends CrudService<Bucket, Integer> {

    void addProduct(Integer bucket, Integer productId, Integer productCount);

    int getCountProductsInBucket(Integer bucketId);
}
