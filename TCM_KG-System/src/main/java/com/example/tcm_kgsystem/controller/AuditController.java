package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Audit;
import com.example.tcm_kgsystem.service.AuditService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    @Autowired
    AuditService auditService;

    @RequestMapping("/detail")
    TransportObject auditShow(Audit audit){
        return auditService.auditShow(audit.getAuditId());
    }

    @RequestMapping("/agree")
    TransportObject auditAgree(Audit audit){
        return auditService.auditAgree(audit.getAuditId());
    }

    @RequestMapping("/refuse")
    TransportObject auditRefuse(Audit audit){
        return auditService.auditRefuse(audit.getAuditId());
    }
}
