package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/06/01
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @PostMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
//        return "Description: " + limitConfig.getDescription();
        return "id: " + id;
    }
}
