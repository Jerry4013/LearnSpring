package ericsson.airpollution.controller;


import ericsson.airpollution.CommonReturnType;
import ericsson.airpollution.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/06/01
 **/
@Controller
@RequestMapping
public class TestController extends BaseController {

    @GetMapping
    public String home(){
        return "index.html";
    }

    @GetMapping("/query")
    @ResponseBody
    public CommonReturnType query(){
        Result result = new Result();

        return CommonReturnType.create(result);
    }
}
