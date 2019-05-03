package imooc.flashsale;

import imooc.flashsale.dao.UserDOMapper;
import imooc.flashsale.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"imooc.flashsale"})
@RestController
@MapperScan("imooc.flashsale.dao")
public class FlashsaleApplication {

    @Autowired
    private UserDOMapper userDOMapper;


    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null) {
            return "User object does not exist";
        }else {
            return userDO.getName();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(FlashsaleApplication.class, args);
    }

}
