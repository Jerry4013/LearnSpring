package imooc.flashsale.service.impl;

import imooc.flashsale.dao.PromoDOMapper;
import imooc.flashsale.dataobject.PromoDO;
import imooc.flashsale.service.PromoService;
import imooc.flashsale.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/19
 **/
@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        //Get the corresponding marketing campaign of an item
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);

        //data object -> model
        PromoModel promoModel = convertFromDataObject(promoDO);
        if (promoModel == null) {
            return null;
        }

        //determine whether flash sale event has started or is coming
        if (promoModel.getStartDate().isAfterNow()) {
            promoModel.setStatus(1);
        } else if (promoModel.getEndDate().isBeforeNow()) {
            promoModel.setStatus(3);
        } else {
            promoModel.setStatus(2);
        }
        return promoModel;
    }

    private PromoModel convertFromDataObject(PromoDO promoDO){
        if (promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO, promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));
        return promoModel;
    }
}
