package ua.lviv.lgs.pv.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bucket {

    private Integer id;

    private LocalDateTime purchaseDate;

    private Integer userId;

    private Integer productId;

    public Bucket(Integer id, LocalDateTime purchaseDate, Integer userId, Integer productId) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.userId = userId;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
