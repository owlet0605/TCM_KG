package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Email;
import com.example.tcm_kgsystem.entity.Phone;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.service.EmailService;
import com.example.tcm_kgsystem.service.PhoneService;
import com.example.tcm_kgsystem.transport.FileToUser;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.service.UserService;
import com.example.tcm_kgsystem.transport.loginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    @Autowired
    PhoneService phoneService;

    @RequestMapping("/login")
    TransportObject userLogin(@Validated loginInfo info){
        String text=info.getText();
        String password=info.getPassword();
        if(text.matches("^\\w+@(\\w+\\.)+\\w+$"))
            return userService.userLogin(null,text,password);
        else
            return userService.userLogin(text,null,password);
    }

    @RequestMapping("/register")
    TransportObject userRegister(User user){
        return userService.userRegister(user);
    }

    @RequestMapping("/delete")
    TransportObject userDelete(User user){
        return userService.userDelete(user.getUserId());
    }

    @RequestMapping("/getUserByName")
    TransportObject GetUserByName(User user){
        return userService.GetUserByName(user.getUserName());
    }

    @RequestMapping("/getUser")
    TransportObject GetUser(User user){
        return userService.GetUser(user.getUserId());
    }

    @RequestMapping("/pwd/change")
    TransportObject ChangePwd(User user){
        return userService.userChangePwd(user.getUserId(),user.getUserPassword());
    }

    @RequestMapping("/pwd/confirm")
    TransportObject ConfirmPwd(User user){
        return userService.TheOldPwdConfirm(user.getUserId(),user.getUserPassword());
    }

    @RequestMapping("/changeInfo")
    TransportObject ChangeInformation(User user){
        return userService.userChangeInformation(user);
    }

    @RequestMapping("/changeImg")
    TransportObject ChangeImg(FileToUser ftu){
        MultipartFile file=ftu.getFile();
        long userId= ftu.getUserId();
        return userService.userChangeImage(file,userId);
    }

    @RequestMapping("/changeEmail")
    TransportObject ChangeEmail(User user){
        return userService.userChangeEmail(user.getUserId(),user.getUserEmail());
    }

    @RequestMapping("/changePhone")
    TransportObject ChangePhone(User user){
        return userService.userChangePhone(user.getUserId(), user.getUserPhone());
    }

    @RequestMapping("/email/send")
    TransportObject SendEmail(Email email){
        return emailService.userEmailCode(email.getUserEmail());
    }

    @RequestMapping("/email/confirm")
    TransportObject ConfirmEmail(Email email){
        return emailService.confirmEmailCode(email.getUserEmail(),email.getCode());
    }

    @RequestMapping("/phone/send")
    TransportObject SendPhone(Phone phone){
        return phoneService.sendPhoneCode(phone.getPhone());
    }

    @RequestMapping("/phone/confirm")
    TransportObject ConfirmPhone(Phone phone){
        return phoneService.confirmPhoneCode(phone.getPhone(),phone.getCode());
    }

    @RequestMapping("/concerns")
    TransportObject ShowConcerns(@RequestParam long userId, @RequestParam int page){
        return userService.userShowConcern(userId, page);
    }

    @RequestMapping("/fans")
    TransportObject ShowFans(@RequestParam long userId, @RequestParam int page){
        return userService.userShowFans(userId, page);
    }

    @RequestMapping("/all")
    TransportObject showAll(@RequestParam int page){
        return userService.showAll(page);
    }

    @RequestMapping("/changeStatus")
    TransportObject changeUserStatus(User user){
        return userService.changeUserStatus(user.getUserId(), user.getUserStatus());
    }

    @RequestMapping("/changeSecurity")
    TransportObject changeUserSecurity(User user){
        return userService.changeUserSecurity(user.getUserId(), user.getUserSecurity());
    }
}
