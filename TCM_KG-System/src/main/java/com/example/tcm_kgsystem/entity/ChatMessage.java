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
public class ChatMessage {
    private Long chatMessageId;

    private Long chatLinkId;

    private String chatMessageContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chatMessageTime;

    private String chatMessageType;

    private Integer chatMessageLatest;

    private Long fromUserId;

    private Long toUserId;
}