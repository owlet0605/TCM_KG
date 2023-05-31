package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.transport.TransportObject;

public interface AdminService {
    TransportObject adminLogin(String adminName, String password);

    TransportObject ShowAuditHas(long adminId, int page);

    TransportObject ShowAuditNot(long adminId, int page);

    TransportObject ShowResultHas(long adminId, int page);

    TransportObject ShowResultNot(long adminId, int page);
}
