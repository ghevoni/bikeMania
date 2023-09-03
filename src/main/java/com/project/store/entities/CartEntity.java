package com.project.store.entities;


import javax.persistence.*;

@Entity
@Table(name="carts")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer userId;
    private Integer bikeId;
    private Integer quantity;
    private Integer total;

    @ManyToOne
    @JoinColumn(name="bikeId", insertable = false, updatable = false)
    private BikeEntity bike;

    @ManyToOne
    @JoinColumn(name="userId", insertable = false, updatable = false)
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BikeEntity getBike() {
        return bike;
    }

    public void setBike(BikeEntity bike) {
        this.bike = bike;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
