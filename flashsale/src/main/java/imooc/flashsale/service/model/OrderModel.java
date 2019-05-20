package imooc.flashsale.service.model;

import java.math.BigDecimal;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/19
 **/
public class OrderModel {

    private String id;

    private Integer userId;

    private Integer itemId;

    //If not null, then this order is a flash sale order.
    private Integer promoId;

    //If promoId is not null, then this price is a flash sale price.
    private BigDecimal itemPrice;

    private Integer amount;

    //If promoId is not null, then this price is a flash sale price.
    private BigDecimal orderPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
