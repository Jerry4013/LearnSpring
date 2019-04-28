package springioc.class017;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TestBean {

    @PostConstruct
    public void onInit(){
        System.out.println("TestBean.onInit");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("TestBean.onDestroy");
    }
}
