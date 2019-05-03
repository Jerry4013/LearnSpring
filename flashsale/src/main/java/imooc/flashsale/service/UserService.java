package imooc.flashsale.service;

import imooc.flashsale.service.model.UserModel;

public interface UserService {

    //get user object using user id
    UserModel getUserById(Integer id);
}
