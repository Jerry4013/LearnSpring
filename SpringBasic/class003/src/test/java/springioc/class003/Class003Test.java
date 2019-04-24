package springioc.class003;

import org.junit.Before;
import org.junit.Test;
import springioc.class003.car.Audi;
import springioc.class003.car.Buick;
import springioc.class003.human.Human;
import springioc.class003.human.LiSi;
import springioc.class003.human.ZhangSan;

public class Class003Test {

    private IoCContainer ioCContainer = new IoCContainer();

    @Before
    public void before(){
        ioCContainer.setBeans(Audi.class, "audi");
        ioCContainer.setBeans(Buick.class, "buick");
        ioCContainer.setBeans(ZhangSan.class, "zhangsan", "audi");
        ioCContainer.setBeans(LiSi.class, "lisi", "buick");
    }

    @Test
    public void test(){
        Human zhangsan = (Human) ioCContainer.getBean("zhangsan");
        zhangsan.goHome();
        Human lisi = (Human) ioCContainer.getBean("lisi");
        lisi.goHome();

    }
}
