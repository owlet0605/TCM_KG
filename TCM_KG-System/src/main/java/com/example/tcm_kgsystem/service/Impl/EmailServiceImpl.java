package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Email;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.entity.UserExample;
import com.example.tcm_kgsystem.mapper.EmailMapper;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.service.Util.CheckCodeBuilder;
import com.example.tcm_kgsystem.service.EmailService;
import com.example.tcm_kgsystem.service.Util.JWTUtil;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailMapper emailMapper;
    @Autowired
    UserMapper userMapper;

    @Value("${spring.mail.email}")
    private String fromEmail;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String fromName;
    @Value("${spring.mail.password}")
    private String fromCode;

    @Override
    public TransportObject userEmailLink(String toEmail) {
        String key=CheckCodeBuilder.creatCode();
        String title="账号激活";
        String url="http://localhost:8080/api/user/link/confirm?key="+key+"&email="+toEmail;
        String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='"+url+"'>"+url
                +"</href></h3></body></html>";

        return sendEmail(toEmail,content,title,key);
    }

    @Override
    public TransportObject confirmEmailLink(String email, String key) {
        TransportObject transportObject=new TransportObject();

        Email result=emailMapper.selectByPrimaryKey(email);
        Date time=new Date();
        if(result.getCode().equals(key)){
            if(time.before(result.getGetTime())){
                UserExample userExample=new UserExample();
                userExample.createCriteria().andUserEmailEqualTo(email);
                User user=userMapper.selectByExample(userExample).get(0);
                user.setUserStatus(1);
                userMapper.updateByPrimaryKey(user);

                transportObject.setCode(200);
                transportObject.setMsg("success");
                transportObject.setObject(user);
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("timeout");
                transportObject.setObject(result);
            }
        }
        else{
            transportObject.setObject(300);
            transportObject.setMsg("error");
            transportObject.setObject(result);
        }
        return transportObject;
    }

    @Override
    public TransportObject userEmailCode(String toEmail) {
        String key= CheckCodeBuilder.creatCode();
        String title="邮箱验证码";
        String content = "<html><head></head><body><h1>这是一封验证邮件,验证码如下</h1><h3>"+key
                +"</h3></body></html>";

        return sendEmail(toEmail,content,title,key);
    }

    @Override
    public TransportObject confirmEmailCode(String email, String code) {
        TransportObject transportObject=new TransportObject();

        Email result=emailMapper.selectByPrimaryKey(email);
        Date time=new Date();
        if(result.getCode().equals(code)){
            if(time.before(result.getGetTime())){
                UserExample userExample=new UserExample();
                userExample.createCriteria().andUserEmailEqualTo(email);
                User user=userMapper.selectByExample(userExample).get(0);

                Map<String,String> payload=new HashMap<>();
                payload.put("userId",user.getUserId().toString());
                payload.put("userPassword",user.getUserPassword());

                String token= JWTUtil.getToken(payload);
                user.setUserToken(token);
                user.setUserStatus(1);
                userMapper.updateByPrimaryKey(user);

                transportObject.setCode(200);
                transportObject.setMsg("success");
                transportObject.setObject(user);
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("timeout");
                transportObject.setObject(result);
            }
        }
        else{
            transportObject.setObject(300);
            transportObject.setMsg("error");
            transportObject.setObject(result);
        }
        return transportObject;
    }

    TransportObject sendEmail(String toEmail, String content, String title, String key){
        TransportObject transportObject=new TransportObject();
        Date setTime=new Date();
        Date getTime=new Date(setTime.getTime() + 300000);

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        try{
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, fromCode);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(title);
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);

            if(Objects.nonNull(emailMapper.selectByPrimaryKey(toEmail))){
                Email email=emailMapper.selectByPrimaryKey(toEmail);
                email.setCode(key);
                email.setSetTime(setTime);
                email.setGetTime(getTime);
                emailMapper.updateByPrimaryKey(email);
                transportObject.setObject(email);
            }
            else{
                Email email=new Email(toEmail,key,setTime,getTime);
                emailMapper.insert(email);
                transportObject.setObject(email);
            }
            transportObject.setCode(200);
            transportObject.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            transportObject.setCode(300);
            transportObject.setMsg("fail");
            transportObject.setObject(null);
        }
        return transportObject;
    }
}
