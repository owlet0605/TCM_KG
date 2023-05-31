package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.mapper.*;
import com.example.tcm_kgsystem.service.ChatService;
import com.example.tcm_kgsystem.service.ResultService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultMapper resultMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ChatService chatService;

    @Override
    public TransportObject resultInsert(Result result) {
        TransportObject transportObject=new TransportObject();
        Date time=new Date();
        result.setResultTime(time);
        long adminId=100000000;
        result.setResultAdminId(adminId);
        try{
            resultMapper.insert(result);
            AdminExample adminExample=new AdminExample();
            adminExample.createCriteria().andAdminIdEqualTo(adminId);
            Admin admin=adminMapper.selectByExample(adminExample).get(0);
            admin.setAdminResult(admin.getAdminResult()+1);
            adminMapper.updateByPrimaryKey(admin);

            transportObject.setCode(200);
            transportObject.setMsg("ok");
            transportObject.setObject(result);
        }catch (Exception e){
            e.printStackTrace();
            transportObject.setCode(300);
            transportObject.setMsg("error");
            transportObject.setObject(null);
        }
        return transportObject;
    }

    @Override
    public TransportObject showDetail(long resultId) {
        TransportObject transportObject;
        Result result=resultMapper.selectByPrimaryKey(resultId);
        if(Objects.nonNull(result)){
            transportObject=new TransportObject(200, "ok", result);
        }
        else{
            transportObject=new TransportObject(300,"error",null);
        }
        return transportObject;
    }

    @Override
    public TransportObject resultIt(long resultId) {
        Result result=resultMapper.selectByPrimaryKey(resultId);
        if(Objects.nonNull(result)){
            result.setResultHave(1);
            resultMapper.updateByPrimaryKey(result);

            AdminExample adminExample=new AdminExample();
            adminExample.createCriteria().andAdminIdEqualTo(result.getResultAdminId());
            Admin admin=adminMapper.selectByExample(adminExample).get(0);
            admin.setAdminResult(admin.getAdminResult()-1);
            adminMapper.updateByPrimaryKey(admin);

            long chatLinkId= (long) chatService.linkOn((long)99999999,result.getResultUserId()).getObject();
            ChatMessage chatMessage=new ChatMessage((long)0,chatLinkId,"您的处理请求已完成",null,"text",1,(long)99999999,result.getResultUserId());
            chatService.saveMessage(chatMessage);

            TransportObject transportObject=new TransportObject(200,"ok",result);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(300,"null",null);
            return transportObject;
        }
    }
}
