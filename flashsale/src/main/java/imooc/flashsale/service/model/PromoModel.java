package imooc.flashsale.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/19
 **/
public class PromoModel {

    private Integer id;

    //flash sale event status:
    // 1: has not started; 2: ongoing; 3: has ended
    private Integer status;

    private String promoName;

    private DateTime startDate;

    private DateTime endDate;

    private Integer itemId;

    private BigDecimal promoItemPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(BigDecimal promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }
}
