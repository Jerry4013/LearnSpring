package springioc.class014;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan("springioc.class014")
public class MyConfiguration {

    @Bean("stringList")
    public List<String> stringList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        return list;
    }

    @Bean
    public Map<String, Integer> integerMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 666);
        map.put("bbb", 777);
        return map;
    }

    @Bean
    @Order(56)
    public String string1(){
        return "333";
    }

    @Bean
    @Order(28)
    public String string2(){
        return "444";
    }

    @Bean
    public Integer integer1(){
        return 333;
    }

    @Bean
    public Integer integer2(){
        return 444;
    }
}
