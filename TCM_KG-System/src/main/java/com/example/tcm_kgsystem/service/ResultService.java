package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.Result;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface ResultService {
    TransportObject resultInsert(Result result);

    TransportObject showDetail(long resultId);

    TransportObject resultIt(long resultId);
}
