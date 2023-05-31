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
public class History {
    private Long historyId;

    private Long historyArticleId;

    private Long historyUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date historyTime;
}