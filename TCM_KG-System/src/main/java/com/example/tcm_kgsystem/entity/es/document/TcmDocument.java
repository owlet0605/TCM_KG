package com.example.tcm_kgsystem.entity.es.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "tcm",createIndex = true)
public class TcmDocument {
    @Id
    @Field(type = FieldType.Long)
    private long id;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmNameZh;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmPinyin;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmInductive;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmTaste;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmAlias;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmDistribution;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmProduce;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmNote;
    @Field(type=FieldType.Text, analyzer = "ik_smart")
    private String tcmFunction;
}
