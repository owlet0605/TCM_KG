package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Admin;
import com.example.tcm_kgsystem.service.AdminService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    TransportObject adminLogin(Admin admin){
        return adminService.adminLogin(admin.getAdminName(),admin.getAdminPassword());
    }

    @RequestMapping("/auditsHas")
    TransportObject ShowAuditHas(@RequestParam long adminId, @RequestParam int page){
        return adminService.ShowAuditHas(adminId, page);
    }

    @RequestMapping("/auditsNot")
    TransportObject ShowAuditNot(@RequestParam long adminId, @RequestParam int page){
        return adminService.ShowAuditNot(adminId, page);
    }

    @RequestMapping("/resultsHas")
    TransportObject ShowResultHas(@RequestParam long adminId, @RequestParam int page){
        return  adminService.ShowResultHas(adminId, page);
    }

    @RequestMapping("/resultsNot")
    TransportObject ShowResultNot(@RequestParam long adminId, @RequestParam int page){
        return  adminService.ShowResultNot(adminId, page);
    }
}
