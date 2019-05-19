package imooc.flashsale.service;

import imooc.flashsale.error.BusinessException;
import imooc.flashsale.service.model.OrderModel;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/19
 **/

public interface OrderService {

    OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessException;
}
