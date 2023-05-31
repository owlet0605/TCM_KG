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
public class Collect {
    private Long collectId;

    private Long collectArticleId;

    private Long collectUserId;

    private Date collectTime;
}