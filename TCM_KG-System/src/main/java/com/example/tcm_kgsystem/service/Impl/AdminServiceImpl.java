package com.example.tcm_kgsystem.service.Impl;

import com.aliyuncs.utils.StringUtils;
import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.mapper.*;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    AuditMapper auditMapper;
    @Autowired
    ResultMapper resultMapper;

    @Override
    public TransportObject adminLogin(String adminName, String password) {
        TransportObject transportObject =new TransportObject();
        AdminExample adminExample=new AdminExample();
        if(StringUtils.isNotEmpty(adminName))
            adminExample.createCriteria().andAdminNameEqualTo(adminName);
        List<Admin> Result=adminMapper.selectByExample(adminExample);
        if(!CollectionUtils.isEmpty(Result)&&Result.get(0).getAdminPassword().equals(password)){
            transportObject.setCode(200);
            transportObject.setMsg("success");
            transportObject.setObject(Result.get(0));
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("fail");
            transportObject.setObject(null);
        }
        return transportObject;
    }

    @Override
    public TransportObject ShowAuditHas(long adminId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        AuditExample auditExample=new AuditExample();
        auditExample.createCriteria().andAuditAdminIdEqualTo(adminId).andAuditHaveNotEqualTo(0);
        List<Audit> audits=auditMapper.selectByExample(auditExample);

        if(CollectionUtils.isEmpty(audits)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Audit> result=new PageInfo<>(audits);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject ShowAuditNot(long adminId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        AuditExample auditExample=new AuditExample();
        auditExample.createCriteria().andAuditAdminIdEqualTo(adminId).andAuditHaveEqualTo(0);
        List<Audit> audits=auditMapper.selectByExample(auditExample);

        if(CollectionUtils.isEmpty(audits)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Audit> result=new PageInfo<>(audits);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject ShowResultHas(long adminId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        ResultExample resultExample=new ResultExample();
        resultExample.createCriteria().andResultAdminIdEqualTo(adminId).andResultHaveNotEqualTo(0);
        List<Result> results=resultMapper.selectByExampleWithBLOBs(resultExample);

        if(CollectionUtils.isEmpty(results)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Result> result=new PageInfo<>(results);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject ShowResultNot(long adminId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        ResultExample resultExample=new ResultExample();
        resultExample.createCriteria().andResultAdminIdEqualTo(adminId).andResultHaveEqualTo(0);
        List<Result> results=resultMapper.selectByExampleWithBLOBs(resultExample);

        if(CollectionUtils.isEmpty(results)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Result> result=new PageInfo<>(results);
        transportObject.setObject(result);
        return transportObject;
    }
}
