package com.example.tcm_kgsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleType {
    private Long articleTypeId;

    private String articleTypeTag;

    private Integer articleTypeNum;

    private String articleTypeDescribe;
}