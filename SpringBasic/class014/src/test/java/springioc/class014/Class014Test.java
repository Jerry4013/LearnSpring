package springioc.class014;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Class014Test {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);

        for (String s : myBean.getStringList()) {
            System.out.println("s = " + s);
        }

        for (Map.Entry<String, Integer> entry : myBean.getIntegerMap().entrySet()) {
            System.out.println("entry = " + entry);
        }

        AnotherBean anotherBean = myBean.getContext().getBean("anotherBean", AnotherBean.class);
        System.out.println("anotherBean = " + anotherBean);
    }
}
