package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/06/03
 **/
@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }

    @PostMapping("/luckymoney")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    @GetMapping("/luckymoney/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/luckymoney/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        service.createTwo();
    }
}
