package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.TcmWithBLOBs;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface TcmService {
    TransportObject TcmInsert(TcmWithBLOBs tcm);

    TransportObject TcmDelete(long tcmId);

    TransportObject TcmChange(TcmWithBLOBs tcm);

    TransportObject ShowAll(int page);

    TransportObject ShowByInitial(String initial, int page);

    TransportObject ShowByInductive(String inductive, int page);

    TransportObject ShowByTaste(String taste, int page);

    TransportObject ShowByProperty(String property, int page);

    TransportObject Select(String str, int page);

    TransportObject getTcm(long tcmId);
}
