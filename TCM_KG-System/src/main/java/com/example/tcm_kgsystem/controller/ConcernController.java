package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Concern;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.service.ConcernService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/concern")
public class ConcernController {

    @Autowired
    ConcernService concernService;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/add/user")
    TransportObject byUser(Concern concern){
        User user1=userMapper.selectByPrimaryKey(concern.getConcernedUserId());
        User user2=userMapper.selectByPrimaryKey(concern.getConcernUserId());
        return concernService.ConcernByUser(user1,user2);
    }

    @RequestMapping("/delete")
    TransportObject delete(Concern concern){
        User user1=userMapper.selectByPrimaryKey(concern.getConcernedUserId());
        User user2=userMapper.selectByPrimaryKey(concern.getConcernUserId());
        return concernService.ConcernDelete(user1,user2);
    }

    @RequestMapping("/if")
    TransportObject concernIf(Concern concern){

        User user1=userMapper.selectByPrimaryKey(concern.getConcernedUserId());
        User user2=userMapper.selectByPrimaryKey(concern.getConcernUserId());
        return concernService.ConcernIf(user1,user2);
    }
}
