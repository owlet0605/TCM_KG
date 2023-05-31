package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.web.multipart.MultipartFile;


public interface ArticleService {
    TransportObject articlePublish(Article article, String key);

    TransportObject articleView(long userId, long articleId);

    TransportObject articleDelete(long articleId);

    TransportObject userShowArticle(long userId, int page);

    TransportObject articleSelect(String str, int page);

    TransportObject articleRecommend(long userId);

    TransportObject hotArticles();

    TransportObject articleGet(long articleId);

    TransportObject articleSearchOnUser(long userId, String str, int page);

    TransportObject searchAll(int page);

    TransportObject changeArticleAudit(long articleId, int articleAudit);

    TransportObject articleUploadImg(MultipartFile file, String key);

    TransportObject showHistory(long userId, int page);

    TransportObject tihuan();
}