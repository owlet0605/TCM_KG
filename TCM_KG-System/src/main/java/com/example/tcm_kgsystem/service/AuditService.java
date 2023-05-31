package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.transport.TransportObject;

public interface AuditService {
    TransportObject auditShow(long auditId);

    TransportObject auditAgree(long auditId);

    TransportObject auditRefuse(long auditId);
}
