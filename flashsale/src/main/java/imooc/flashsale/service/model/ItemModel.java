package imooc.flashsale.service.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/13
 **/
public class ItemModel {

    private Integer id;

    @NotBlank(message = "Product name cannot be empty")
    private String title;

    @NotNull(message = "Product price cannot be empty")
    @Min(value = 0, message = "Product price must be larger than 0")
    private BigDecimal price;

    @NotNull(message = "Stock cannot be empty")
    private Integer stock;

    @NotBlank(message = "Product description cannot be empty")
    private String description;

    private Integer sales;

    @NotBlank(message = "Product image cannot be empty")
    private String imgUrl;

    //If promoModel is not null, then this item has some campaign that is coming or ongoing
    private PromoModel promoModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public PromoModel getPromoModel() {
        return promoModel;
    }

    public void setPromoModel(PromoModel promoModel) {
        this.promoModel = promoModel;
    }
}
