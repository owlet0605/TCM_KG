package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    TransportObject userLogin(String userName, String email, String password);

    TransportObject userRegister(User user);

    TransportObject userDelete(long userId);

    TransportObject GetUserByName(String userName);

    TransportObject GetUser(long userId);

    TransportObject userChangePwd(long userId, String password);

    TransportObject TheOldPwdConfirm(long userId, String oldPwd);

    TransportObject userChangeInformation(User user);

    TransportObject userChangeEmail(long userId, String email);

    TransportObject userChangePhone(long userId, String phone);

    TransportObject userChangeImage(MultipartFile file, long userId);

    TransportObject userShowConcern(long userId, int page);

    TransportObject userShowFans(long userId, int page);

    TransportObject showAll(int page);

    TransportObject changeUserStatus(long userId, int userStatus);

    TransportObject changeUserSecurity(long userId, int userSecurity);
}
