package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.transport.TransportObject;

public interface PhoneService {
    TransportObject sendPhoneCode(String toPhone);

    TransportObject confirmPhoneCode(String phone, String code);
}
