package imooc.flashsale.service;

import imooc.flashsale.service.model.PromoModel;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/19
 **/

public interface PromoService {

    //get forthcoming event or ongoing event
    PromoModel getPromoByItemId(Integer itemId);
}
