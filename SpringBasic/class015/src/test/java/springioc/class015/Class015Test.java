package springioc.class015;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Class015Test {
    @Test
    public void test(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TestConfiguration.class);
        for (int i = 0; i < 10; i++) {
            TestBean testBean1 = context.getBean("testBean1", TestBean.class);
            System.out.println("testBean1 = " + testBean1);
        }
        System.out.println("==================");
        for (int i = 0; i < 10; i++) {
            TestBean testBean2 = context.getBean("testBean2", TestBean.class);
            System.out.println("testBean2 = " + testBean2);
        }

    }
}
