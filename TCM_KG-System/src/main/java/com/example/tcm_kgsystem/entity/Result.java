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
public class Result {
    private Long resultId;

    private Long resultAdminId;

    private Long resultUserId;

    private String resultType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date resultTime;

    private Integer resultHave;

    private Long resultObjectId;

    private String resultObject;

    private String resultReason;
}