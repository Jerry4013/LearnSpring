package imooc.flashsale.service.impl;

import imooc.flashsale.dao.ItemDOMapper;
import imooc.flashsale.dao.ItemStockDOMapper;
import imooc.flashsale.dataobject.ItemDO;
import imooc.flashsale.dataobject.ItemStockDO;
import imooc.flashsale.error.BusinessException;
import imooc.flashsale.error.EmBusinessError;
import imooc.flashsale.service.ItemService;
import imooc.flashsale.service.PromoService;
import imooc.flashsale.service.model.ItemModel;
import imooc.flashsale.service.model.PromoModel;
import imooc.flashsale.validator.ValidationResult;
import imooc.flashsale.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/14
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private PromoService promoService;

    @Autowired
    private ItemStockDOMapper itemStockDOMapper;

    private ItemDO convertItemDOFromItemModel(ItemModel itemModel){
        if (itemModel == null) {
            return null;
        }
        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel, itemDO);
        itemDO.setPrice(itemModel.getPrice().doubleValue());
        return itemDO;
    }

    private ItemStockDO convertItemStockDOFromItemModel(ItemModel itemModel){
        if (itemModel == null) {
            return null;
        }
        ItemStockDO itemStockDO = new ItemStockDO();
        itemStockDO.setItemId(itemModel.getId());
        itemStockDO.setStock(itemModel.getStock());
        return itemStockDO;
    }

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        //check parameters
        ValidationResult validationResult = validator.validate(itemModel);
        if (validationResult.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,validationResult.getErrMsg());
        }

        //item model -> data object
        ItemDO itemDO = convertItemDOFromItemModel(itemModel);

        //write to database
        itemDOMapper.insertSelective(itemDO);
        itemModel.setId(itemDO.getId());

        ItemStockDO itemStockDO = convertItemStockDOFromItemModel(itemModel);

        itemStockDOMapper.insertSelective(itemStockDO);

        //return created object

        return this.getItemById(itemModel.getId());
    }

    @Override
    public List<ItemModel> listItem() {
        List<ItemDO> itemDOList = itemDOMapper.listItem();
        List<ItemModel> itemModelList = itemDOList.stream().map(itemDO -> {
            ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDO.getId());
            ItemModel itemModel = convertModelFromDataObject(itemDO, itemStockDO);
            return itemModel;
        }).collect(Collectors.toList());
        return itemModelList;
    }

    @Override
    public ItemModel getItemById(Integer id) {
        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(id);
        if (itemDO == null) {
            return null;
        }
        //get stock
        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDO.getId());

        ItemModel itemModel = convertModelFromDataObject(itemDO, itemStockDO);

        //Get promotion info
        PromoModel promoModel = promoService.getPromoByItemId(itemModel.getId());
        if (promoModel != null && promoModel.getStatus() != 3) {
            itemModel.setPromoModel(promoModel);
        }

        return itemModel;
    }

    @Override
    @Transactional
    public boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException {
        int affectedRow = itemStockDOMapper.decreaseStock(itemId, amount);
        return affectedRow > 0;
    }

    @Override
    @Transactional
    public void increaseSales(Integer itemId, Integer amount) throws BusinessException {
        itemDOMapper.increaseSales(itemId, amount);
    }

    private ItemModel convertModelFromDataObject(ItemDO itemDO, ItemStockDO itemStockDO){
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO, itemModel);
        itemModel.setPrice(new BigDecimal(String.valueOf(itemDO.getPrice())));
        itemModel.setStock(itemStockDO.getStock());

        return itemModel;
    }
}
