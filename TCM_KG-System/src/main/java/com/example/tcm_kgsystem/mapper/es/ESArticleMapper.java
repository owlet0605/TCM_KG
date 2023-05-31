package com.example.tcm_kgsystem.mapper.es;

import com.example.tcm_kgsystem.entity.es.document.ArticleDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ESArticleMapper extends ElasticsearchRepository<ArticleDocument, Long> {

    @Query("{\"multi_match\":{\"query\":\"?0\", \"fields\":[ \"title\", \"context\" ]}}")
    SearchHits<ArticleDocument> find(String keyword);
}
