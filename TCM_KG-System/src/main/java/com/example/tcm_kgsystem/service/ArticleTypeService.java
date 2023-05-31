package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface ArticleTypeService {
    TransportObject ShowAllArticle(long articleTypeId, int page);

    TransportObject getArticleType(long articleTypeId);

    TransportObject findAll(int page);

    TransportObject findAllNonPage();

    TransportObject articleTypeInsert(ArticleType articleType);

    TransportObject articleTypeChange(ArticleType articleType);

    TransportObject articleTypeDelete(long articleTypeId);
}
