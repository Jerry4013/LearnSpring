package springioc.class007;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Class007Test {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Bean1 bean1_1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1_1 = " + bean1_1);
        Bean1 bean1_2 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1_2 = " + bean1_2);
        System.out.println("(bean1_1 == bean1_2) = " + (bean1_1 == bean1_2));

    }
}
