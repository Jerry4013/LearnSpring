package imooc.flashsale.service.impl;

import imooc.flashsale.dao.OrderDOMapper;
import imooc.flashsale.dao.SequenceDOMapper;
import imooc.flashsale.dataobject.OrderDO;
import imooc.flashsale.dataobject.SequenceDO;
import imooc.flashsale.error.BusinessException;
import imooc.flashsale.error.EmBusinessError;
import imooc.flashsale.service.ItemService;
import imooc.flashsale.service.OrderService;
import imooc.flashsale.service.UserService;
import imooc.flashsale.service.model.ItemModel;
import imooc.flashsale.service.model.OrderModel;
import imooc.flashsale.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/19
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private SequenceDOMapper sequenceDOMapper;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    @Transactional
    public OrderModel createOrder(Integer userId, Integer itemId,Integer promoId, Integer amount) throws BusinessException {

        ItemModel itemModel = itemService.getItemById(itemId);

        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Product does not exist.");
        }

        UserModel userModel = userService.getUserById(userId);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "User does not exist.");
        }

        if (amount <= 0 || amount > 99){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Amount incorrect.");
        }

        if (promoId != null) {
            if (!promoId.equals(itemModel.getPromoModel().getId())){
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Campaign info error");
            } else if (itemModel.getPromoModel().getStatus() != 2){
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Flash sale has not started.");
            }
        }

        boolean result = itemService.decreaseStock(itemId, amount);
        if (!result){
            throw new BusinessException(EmBusinessError.STOCK_NOT_ENOUGH);
        }

        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(userId);
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        if (promoId != null) {
            orderModel.setItemPrice(itemModel.getPromoModel().getPromoItemPrice());
        } else {
            orderModel.setItemPrice(itemModel.getPrice());
        }
        orderModel.setPromoId(promoId);
        orderModel.setOrderPrice(orderModel.getItemPrice().multiply(new BigDecimal(amount)));

        orderModel.setId(generateOderNo());
        OrderDO orderDO = convertFromOrderModel(orderModel);
        orderDOMapper.insertSelective(orderDO);

        itemService.increaseSales(itemId, amount);

        return orderModel;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    String generateOderNo(){
        //16-digit order number
        StringBuilder stringBuilder = new StringBuilder();

        //first 8 digits are date
        LocalDateTime now = LocalDateTime.now();
        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-", "");
        stringBuilder.append(nowDate);

        //9-14 auto incremented
        SequenceDO sequenceDO = sequenceDOMapper.getSequenceByName("order_info");
        int sequence = sequenceDO.getCurrentValue();
        sequenceDO.setCurrentValue(sequenceDO.getCurrentValue() + sequenceDO.getStep());
        sequenceDOMapper.updateByPrimaryKeySelective(sequenceDO);
        String sequenceStr = String.valueOf(sequence);
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(sequenceStr);

        //partition databases and tables, use "00" temporarily
        stringBuilder.append("00");
        return stringBuilder.toString();
    }

    private OrderDO convertFromOrderModel(OrderModel orderModel){
        if (orderModel == null) {
            return null;
        }
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderModel, orderDO);
        orderDO.setItemPrice(orderModel.getItemPrice().doubleValue());
        orderDO.setOrderPrice(orderModel.getOrderPrice().doubleValue());
        return orderDO;
    }


}
