package com.example.tcm_kgsystem.service.Impl;

import com.aliyuncs.utils.StringUtils;
import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.mapper.ConcernMapper;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.service.Util.JWTUtil;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ConcernMapper concernMapper;

    @Override
    public TransportObject userLogin(String userName, String email, String password) {
        TransportObject transportObject =new TransportObject();

        UserExample userExample=new UserExample();
        if(StringUtils.isNotEmpty(userName)){
            userExample.createCriteria().andUserNameEqualTo(userName);
        }
        else{
            userExample.createCriteria().andUserEmailEqualTo(email);
        }
        List<User> Result=userMapper.selectByExample(userExample);
        if(!CollectionUtils.isEmpty(Result)&&Result.get(0).getUserPassword().equals(password)){
            if(Result.get(0).getUserStatus()!=0){
                if(Result.get(0).getUserSecurity()==0){
                    User user=Result.get(0);
                    Map<String,String> payload=new HashMap<>();
                    payload.put("userId",user.getUserId().toString());
                    payload.put("userPassword",user.getUserPassword());

                    String token= JWTUtil.getToken(payload);
                    user.setUserToken(token);
                    userMapper.updateByPrimaryKey(user);

                    transportObject.setCode(200);
                    transportObject.setMsg("Success,welcome"+Result.get(0).getUserName());
                    transportObject.setObject(user);
                }
                else{
                    transportObject.setObject(201);
                    transportObject.setMsg("Success,secondary verification");
                    transportObject.setObject(Result.get(0).getUserEmail());
                }
            }
            else{
                transportObject.setCode(400);
                transportObject.setMsg("Unactivated");
                transportObject.setObject(Result.get(0).getUserEmail());
            }
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("Fail");
            transportObject.setObject(null);
        }
        return transportObject;
    }

    @Override
    public TransportObject userRegister(User user) {
        TransportObject transportObject =new TransportObject();

        UserExample userExample1=new UserExample();
        UserExample userExample2=new UserExample();
        UserExample userExample3=new UserExample();

        if(!user.getUserEmail().matches("^\\w+@(\\w+\\.)+\\w+$")){
            transportObject.setCode(300);
            transportObject.setMsg("The email format is incorrect");
            transportObject.setObject(null);
            return transportObject;
        }
        if(user.getUserPhone().length()!=11||!user.getUserPhone().matches("-?\\d+(\\.\\d+)?")){
            transportObject.setCode(300);
            transportObject.setMsg("The phone number is incorrect");
            transportObject.setObject(null);
            return transportObject;
        }

        if(StringUtils.isNotEmpty(user.getUserName()))
            userExample1.createCriteria().andUserNameEqualTo(user.getUserName());
        if(StringUtils.isNotEmpty(user.getUserEmail()))
            userExample2.createCriteria().andUserEmailEqualTo(user.getUserEmail());
        if(StringUtils.isNotEmpty(user.getUserPhone()))
            userExample3.createCriteria().andUserPhoneEqualTo(user.getUserPhone());

        if(!CollectionUtils.isEmpty(userMapper.selectByExample(userExample1))){
            transportObject.setCode(300);
            transportObject.setMsg("The name is already in use");
            transportObject.setObject(null);
        }
        else if(!CollectionUtils.isEmpty(userMapper.selectByExample(userExample2))){
            transportObject.setCode(300);
            transportObject.setMsg("The email is already in use");
            transportObject.setObject(null);
        }
        else if(!CollectionUtils.isEmpty(userMapper.selectByExample(userExample3))){
            transportObject.setCode(300);
            transportObject.setMsg("The phone is already in use");
            transportObject.setObject(null);
        }
        else{
            Date time=new Date();
            user.setUserStatus(0);
            user.setRegisterTime(time);
            user.setUserImg("default.png");
            user.setUserSecurity(0);
            try{
                userMapper.insert(user);
                transportObject.setCode(200);
                transportObject.setMsg("Success");
                transportObject.setObject(user);
            }catch (Exception e){
                e.printStackTrace();
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject userDelete(long userId) {
        TransportObject transportObject=new TransportObject();

        if(Objects.nonNull(userMapper.selectByPrimaryKey(userId))){
            userMapper.deleteByPrimaryKey(userId);
            transportObject.setCode(200);
            transportObject.setMsg("Success");
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("Fail");
        }
        transportObject.setObject(null);
        return transportObject;
    }

    @Override
    public TransportObject GetUserByName(String userName) {
        TransportObject transportObject=new TransportObject();
        UserExample userExample=new UserExample();
        if(StringUtils.isNotEmpty(userName)){
            userExample.createCriteria().andUserNameEqualTo(userName);
            if(CollectionUtils.isEmpty(userMapper.selectByExample(userExample))){
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
            }
            else{
                transportObject.setObject(200);
                transportObject.setMsg("Success");
                transportObject.setObject(userMapper.selectByExample(userExample).get(0));
            }
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("Fail,name can't be null");
            transportObject.setObject(null);
        }
        return transportObject;
    }

    @Override
    public TransportObject GetUser(long userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        TransportObject transportObject;
        if(Objects.nonNull(user)){
            transportObject = new TransportObject(200, "Success", user);
        }
        else{
            transportObject = new TransportObject(300, "Fail", null);
        }
        return transportObject;
    }

    @Override
    public TransportObject userChangePwd(long userId, String password) {
        TransportObject transportObject =new TransportObject();

        User Result=userMapper.selectByPrimaryKey(userId);
        if(Objects.nonNull(Result)){
            if(!password.equals(Result.getUserPassword())) {
                Result.setUserPassword(password);
                userMapper.updateByPrimaryKey(Result);
                transportObject.setCode(200);
                transportObject.setMsg("Success");
                transportObject.setObject(Result);
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("Fail,same password");
                transportObject.setObject(null);
            }
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("Fail");
            transportObject.setObject(null);
        }
        return transportObject;
    }

    @Override
    public TransportObject TheOldPwdConfirm(long userId, String oldPwd) {
        TransportObject transportObject =new TransportObject();

        User Result=userMapper.selectByPrimaryKey(userId);
        if(Objects.nonNull(Result)){
            if(Result.getUserPassword().equals(oldPwd)){
                transportObject.setCode(200);
                transportObject.setMsg("Success");
                transportObject.setObject(true);
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("Fail, pwd error");
                transportObject.setObject(false);
            }
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("Fail");
            transportObject.setObject(false);
        }
        return transportObject;
    }

    @Override
    public TransportObject userChangeInformation(User user) {
        TransportObject transportObject =new TransportObject();

        UserExample userExample=new UserExample();
        if(StringUtils.isNotEmpty(user.getUserName())){
            userExample.createCriteria().andUserNameEqualTo(user.getUserName()).andUserIdNotEqualTo(user.getUserId());
        }

        if(!CollectionUtils.isEmpty(userMapper.selectByExample(userExample)) ){
            transportObject.setCode(300);
            transportObject.setMsg("This name is already in use");
            transportObject.setObject(null);
        }
        else{
            User user1=userMapper.selectByPrimaryKey(user.getUserId());
            user1.setUserName(user.getUserName());
            user1.setUserSex(user.getUserSex());
            user1.setUserBirthday(user.getUserBirthday());
            try{
                userMapper.updateByPrimaryKey(user1);
                transportObject.setCode(200);
                transportObject.setMsg("Success");
                transportObject.setObject(user1);
            }catch (Exception e){
                e.printStackTrace();
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject userChangeEmail(long userId, String email) {
        TransportObject transportObject=new TransportObject();

        if(!email.matches("^\\w+@(\\w+\\.)+\\w+$")){
            transportObject.setCode(300);
            transportObject.setMsg("The email format is incorrect");
            transportObject.setObject(null);
            return transportObject;
        }

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserEmailEqualTo(email);
        if(!CollectionUtils.isEmpty(userMapper.selectByExample(userExample))){
            transportObject.setCode(300);
            transportObject.setMsg("This email is already in use");
            transportObject.setObject(null);
        }
        else{
            User user=userMapper.selectByPrimaryKey(userId);
            if(Objects.nonNull(user)){
                user.setUserEmail(email);
                try{
                    userMapper.updateByPrimaryKey(user);
                    transportObject.setCode(200);
                    transportObject.setMsg("Success");
                    transportObject.setObject(user);
                }catch (Exception e){
                    e.printStackTrace();
                    transportObject.setCode(300);
                    transportObject.setMsg("Fail");
                    transportObject.setObject(null);
                }
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject userChangePhone(long userId, String phone) {
        TransportObject transportObject=new TransportObject();

        if(phone.length()!=11||!phone.matches("-?\\d+(\\.\\d+)?")){
            transportObject.setCode(300);
            transportObject.setMsg("The phone format is incorrect");
            transportObject.setObject(null);
            return transportObject;
        }

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserPhoneEqualTo(phone);
        if(!CollectionUtils.isEmpty(userMapper.selectByExample(userExample))){
            transportObject.setCode(300);
            transportObject.setMsg("This phone is already in use");
            transportObject.setObject(null);
        }
        else{
            User user=userMapper.selectByPrimaryKey(userId);
            if(Objects.nonNull(user)){
                user.setUserPhone(phone);
                try{
                    userMapper.updateByPrimaryKey(user);
                    transportObject.setCode(200);
                    transportObject.setMsg("Success");
                    transportObject.setObject(user);
                }catch (Exception e){
                    e.printStackTrace();
                    transportObject.setCode(300);
                    transportObject.setMsg("Fail");
                    transportObject.setObject(null);
                }
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject userChangeImage(MultipartFile file, long userId) {
        TransportObject transportObject=new TransportObject();

        String folder = "C:/Users/zei/Desktop/TCM_KGSystem/src/main/resources/static/userImg";
        File imgFolder = new File(folder);
        String fileName = file.getOriginalFilename();
        if(StringUtils.isNotEmpty(fileName)){
            String ext = "." + fileName.substring(fileName.lastIndexOf(".")+1);
            //String dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
            String newFileName=userId+ext;
            File filePath = new File(imgFolder, newFileName);

            User user=userMapper.selectByPrimaryKey(userId);
            if(Objects.nonNull(user)){
                user.setUserImg(newFileName);
                userMapper.updateByPrimaryKey(user);
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
                return transportObject;
            }

            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            try{
                File[] files=imgFolder.listFiles();
                if(Objects.nonNull(files))
                for(File file1:files){
                    if(file1.getName().equals(newFileName)){
                        file1.delete();
                    }
                }
                file.transferTo(filePath);
                transportObject.setCode(200);
                transportObject.setMsg("Success");
                transportObject.setObject(filePath.getName());
            }catch (IOException e){
                e.printStackTrace();
                transportObject.setCode(300);
                transportObject.setMsg("Fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject userShowConcern(long userId, int page) {
        TransportObject transportObject=new TransportObject();
        ConcernExample concernExample=new ConcernExample();
        concernExample.createCriteria().andConcernUserIdEqualTo(userId);
        PageHelper.startPage(page,10);
        List<Concern> concerns=concernMapper.selectByExample(concernExample);
        List<User> users=new ArrayList<>();

        if(CollectionUtils.isEmpty(concerns)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            Iterator<Concern> iterator=concerns.iterator();
            while(iterator.hasNext()){
                Concern concern=iterator.next();
                users.add(userMapper.selectByPrimaryKey(concern.getConcernedUserId()));
            }
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<User> result= new PageInfo<>(users);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject userShowFans(long userId, int page) {
        TransportObject transportObject=new TransportObject();
        ConcernExample concernExample=new ConcernExample();
        concernExample.createCriteria().andConcernedUserIdEqualTo(userId);
        PageHelper.startPage(page,10);
        List<Concern> concerns=concernMapper.selectByExample(concernExample);
        List<User> users=new ArrayList<>();

        if(CollectionUtils.isEmpty(concerns)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            Iterator<Concern> iterator=concerns.iterator();
            while(iterator.hasNext()){
                Concern concern=iterator.next();
                users.add(userMapper.selectByPrimaryKey(concern.getConcernedUserId()));
            }
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<User> result= new PageInfo<>(users);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject showAll(int page) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserIdGreaterThan((long)0);
        PageHelper.startPage(page, 10);
        List<User> users=userMapper.selectByExample(userExample);
        PageInfo<User> result=new PageInfo<>(users);
        TransportObject transportObject=new TransportObject(200,"ok",result);
        return transportObject;
    }

    @Override
    public TransportObject changeUserStatus(long userId, int userStatus) {
        User user=userMapper.selectByPrimaryKey(userId);
        if(Objects.nonNull(user)){
            user.setUserStatus(userStatus);
            try{
                userMapper.updateByPrimaryKey(user);
                TransportObject transportObject=new TransportObject(200,"Success",user);
                return transportObject;
            }catch (Exception e){
                e.printStackTrace();
                TransportObject transportObject=new TransportObject(300,"Fail",null);
                return transportObject;
            }
        }
        else{
            TransportObject transportObject=new TransportObject(300,"Fail",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject changeUserSecurity(long userId, int userSecurity) {
        User user=userMapper.selectByPrimaryKey(userId);
        if(Objects.nonNull(user)){
            user.setUserSecurity(userSecurity);
            try{
                userMapper.updateByPrimaryKey(user);
                TransportObject transportObject=new TransportObject(200,"Success",user);
                return transportObject;
            }catch (Exception e){
                e.printStackTrace();
                TransportObject transportObject=new TransportObject(300,"Fail",null);
                return transportObject;
            }
        }
        else{
            TransportObject transportObject=new TransportObject(300,"null",null);
            return transportObject;
        }
    }
}
