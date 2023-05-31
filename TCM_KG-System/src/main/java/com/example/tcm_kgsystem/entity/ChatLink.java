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
public class ChatLink {
    private Long chatLinkId;

    private Long fromUserId;

    private Long toUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chatLinkTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chatLinkLastTime;

    private Integer fromWindow;

    private Integer toWindow;

    private Integer fromUnread;

    private Integer chatLinkStatus;

    private Integer toUnread;
}