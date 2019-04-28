package springioc.class015;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("request")
public class TestBean {

    @RequestMapping("/testApplication")
    @ResponseBody
    public String test(){
        return this.toString();
    }
}
