package imooc.flashsale.service;

import imooc.flashsale.error.BusinessException;
import imooc.flashsale.service.model.ItemModel;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/14
 **/

public interface ItemService {

    //Create products
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //product list
    List<ItemModel> listItem();

    //product details
    ItemModel getItemById(Integer id);

    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;

    void increaseSales(Integer itemId, Integer amount) throws BusinessException;
}
