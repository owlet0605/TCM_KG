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
public class Comment {
    private Long commentId;

    private Long commentArticleId;

    private Long commentUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;

    private String commentContext;

    private Integer commentLike;

    private Long commentTopId;

    private Long commentForId;
}