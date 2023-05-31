package com.example.tcm_kgsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    private Long likeId;

    private Long likeArticleId;

    private Long likeUserId;

    private String likeType;

    private Long likeCommentId;

    private Date likeTime;
}