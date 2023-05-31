package com.example.tcm_kgsystem.mapper.es;

import com.example.tcm_kgsystem.entity.es.document.TcmDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESTcmMapper extends ElasticsearchRepository<TcmDocument, Long> {

    @Query("{\"multi_match\":{\"query\":\"?0\", \"fields\":[\"tcmNameZh\", \"tcmPinyin\", " +
            "\"tcmInductive\", \"tcmTaste\", \"tcmAlias\", \"tcmDistribution\"" +
            ", \"tcmProduce\", \"tcmNote\", \"tcmFunction\"]}}")
    SearchHits<TcmDocument> find(String keyword);
}
