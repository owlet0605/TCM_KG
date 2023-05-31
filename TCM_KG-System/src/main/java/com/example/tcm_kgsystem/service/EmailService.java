package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.transport.TransportObject;

public interface EmailService {
    TransportObject userEmailLink(String toEmail);

    TransportObject confirmEmailLink(String email, String key);

    TransportObject userEmailCode(String toEmail);

    TransportObject confirmEmailCode(String email, String code);
}
