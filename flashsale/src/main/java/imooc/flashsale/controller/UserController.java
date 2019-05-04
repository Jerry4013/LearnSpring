package imooc.flashsale.controller;

import imooc.flashsale.controller.viewobject.UserVO;
import imooc.flashsale.error.BusinessException;
import imooc.flashsale.error.EmBusinessError;
import imooc.flashsale.response.CommonReturnType;
import imooc.flashsale.service.UserService;
import imooc.flashsale.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {

        //Using service, retrieve user object and return to frontend
        UserModel userModel = userService.getUserById(id);

        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel){
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }


}
