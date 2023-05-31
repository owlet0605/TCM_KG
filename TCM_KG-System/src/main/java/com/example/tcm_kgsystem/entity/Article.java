package com.example.tcm_kgsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long articleId;

    private Long articleUserId;

    private Long articleTypeId;

    private String articleTitle;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleTime;

    private Integer articleView;

    private Integer articleComment;

    private Integer articleLike;

    private Integer articleCollect;

    private Integer articleAudit;

    private String articleTag;

    private String articleContext;


}