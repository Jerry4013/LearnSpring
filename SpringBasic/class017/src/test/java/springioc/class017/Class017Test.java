package springioc.class017;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Class017Test {

    @Test
    public void test(){
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(TestConfiguration.class);

        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println("testBean = " + testBean);
        context.close();
    }
}
