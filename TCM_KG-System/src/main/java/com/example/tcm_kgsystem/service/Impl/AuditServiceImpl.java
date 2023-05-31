package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.mapper.*;
import com.example.tcm_kgsystem.service.AuditService;
import com.example.tcm_kgsystem.service.ChatService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditMapper auditMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ArticleTypeMapper articleTypeMapper;
    @Autowired
    ChatService chatService;

    @Override
    public TransportObject auditShow(long auditId) {
        TransportObject transportObject=new TransportObject();
        Audit audit=auditMapper.selectByPrimaryKey(auditId);
        Article article=articleMapper.selectByPrimaryKey(audit.getAuditArticleId());
        if(!Objects.nonNull(article)){
            transportObject.setCode(300);
            transportObject.setMsg("null");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        transportObject.setObject(article);
        return transportObject;
    }

    @Override
    public TransportObject auditAgree(long auditId) {
        Audit audit=auditMapper.selectByPrimaryKey(auditId);
        audit.setAuditHave(1);
        auditMapper.updateByPrimaryKey(audit);
        Article article=articleMapper.selectByPrimaryKey(audit.getAuditArticleId());
        article.setArticleAudit(1);

        ArticleType articleType=articleTypeMapper.selectByPrimaryKey(article.getArticleTypeId());
        articleType.setArticleTypeNum(articleType.getArticleTypeNum()+1);

        articleMapper.updateByPrimaryKey(article);
        Admin admin=adminMapper.selectByPrimaryKey(audit.getAuditAdminId());
        admin.setAdminAudit(admin.getAdminAudit()-1);
        adminMapper.updateByPrimaryKey(admin);

        long chatLinkId= (long) chatService.linkOn((long)99999999,audit.getAuditUserId()).getObject();
        String context="您的资讯"+audit.getAuditArticleId()+"审核已通过";
        ChatMessage chatMessage=new ChatMessage((long)0,chatLinkId,context,null,"text",1,(long)99999999,audit.getAuditUserId());
        chatService.saveMessage(chatMessage);

        TransportObject transportObject=new TransportObject(200,"ok",admin);
        return transportObject;
    }

    @Override
    public TransportObject auditRefuse(long auditId) {
        Audit audit=auditMapper.selectByPrimaryKey(auditId);
        audit.setAuditHave(2);
        auditMapper.updateByPrimaryKey(audit);
        Article article=articleMapper.selectByPrimaryKey(audit.getAuditArticleId());
        article.setArticleAudit(2);
        articleMapper.updateByPrimaryKey(article);
        Admin admin=adminMapper.selectByPrimaryKey(audit.getAuditAdminId());
        admin.setAdminAudit(admin.getAdminAudit()-1);
        adminMapper.updateByPrimaryKey(admin);

        long chatLinkId= (long) chatService.linkOn((long)99999999,audit.getAuditUserId()).getObject();
        String context="您的资讯"+audit.getAuditArticleId()+"审核不通过";
        ChatMessage chatMessage=new ChatMessage((long)0,chatLinkId,context,null,"text",1,(long)99999999,audit.getAuditUserId());
        chatService.saveMessage(chatMessage);

        TransportObject transportObject=new TransportObject(200,"ok",admin);
        return transportObject;
    }
}
