package com.example.tcm_kgsystem.service.Util;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.Tcm;
import com.example.tcm_kgsystem.entity.TcmWithBLOBs;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.stereotype.Service;

public interface ESUtil {
    TransportObject buildArticle();

    TransportObject buildTcm();

    TransportObject deleteAllArticle();

    TransportObject searchAllArticle();

    TransportObject deleteAllTcm();

    TransportObject searchAllTcm();

    void addArticle(Article article);

    void addTcm(TcmWithBLOBs tcm);

    void deleteArticle(Article article);

    void deleteTcm(TcmWithBLOBs tcm);

    void changeArticle(Article article);

    void changeTcm(TcmWithBLOBs tcm);
}
