package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Concern;
import com.example.tcm_kgsystem.entity.ConcernExample;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.mapper.ConcernMapper;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.service.ConcernService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ConcernServiceImpl implements ConcernService {

    @Autowired
    ConcernMapper concernMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public TransportObject ConcernByUser(User user1, User user2) {
        Concern concern=new Concern((long)0,user2.getUserId(), user1.getUserId());
        try{
            concernMapper.insert(concern);
            TransportObject transportObject=new TransportObject(200,"ok",concern);

            user1.setUserFans(user1.getUserFans()+1);
            userMapper.updateByPrimaryKey(user1);

            user2.setUserConcern(user2.getUserConcern()+1);
            userMapper.updateByPrimaryKey(user2);

            return transportObject;
        }catch (Exception e){
            e.printStackTrace();
            TransportObject transportObject=new TransportObject(300,"error",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject ConcernDelete(User user1, User user2) {
        ConcernExample concernExample=new ConcernExample();

        concernExample.createCriteria().andConcernedUserIdEqualTo(user1.getUserId()).andConcernUserIdEqualTo(user2.getUserId());
        if(CollectionUtils.isEmpty(concernMapper.selectByExample(concernExample))){
            TransportObject transportObject=new TransportObject(300,"null",null);
            return transportObject;
        }
        else{
            concernMapper.deleteByExample(concernExample);

            user1.setUserFans(user1.getUserFans()-1);
            userMapper.updateByPrimaryKey(user1);

            user2.setUserConcern(user2.getUserConcern()-1);
            userMapper.updateByPrimaryKey(user2);

            TransportObject transportObject=new TransportObject(200,"ok",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject ConcernIf(User user1, User user2) {
        ConcernExample concernExample=new ConcernExample();

        concernExample.createCriteria().andConcernedUserIdEqualTo(user1.getUserId()).andConcernUserIdEqualTo(user2.getUserId());
        List<Concern> Result=concernMapper.selectByExample(concernExample);

        if(CollectionUtils.isEmpty(Result)){
            TransportObject transportObject=new TransportObject(400,"not",false);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(200,"is",true);
            return transportObject;
        }
    }
}
