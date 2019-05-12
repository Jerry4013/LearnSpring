package imooc.flashsale.service;

import imooc.flashsale.error.BusinessException;
import imooc.flashsale.service.model.UserModel;

public interface UserService {

    //get user object using user id
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
    UserModel validateLogin(String telephone, String encryptPassword) throws BusinessException;
}
