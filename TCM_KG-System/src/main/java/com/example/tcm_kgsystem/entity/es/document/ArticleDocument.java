package com.example.tcm_kgsystem.entity.es.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "article",createIndex = true)
public class ArticleDocument {
    @Id
    @Field(type = FieldType.Long)
    private long id;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String title;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String context;
    @Field(type=FieldType.Date)
    private Date time;
    @Field(type=FieldType.Long)
    private long userId;
}
