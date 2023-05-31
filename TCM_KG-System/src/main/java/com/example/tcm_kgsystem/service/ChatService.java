package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.ChatMessage;
import com.example.tcm_kgsystem.transport.TransportObject;


public interface ChatService {
    TransportObject showChatLinks(long userId);

    TransportObject showChatMessages(long chatLinkId);

    TransportObject linkOn(long fromUserId, long toUserId);

    TransportObject saveMessage(ChatMessage chatMessage);

    TransportObject getRecentChatRecords(long chatLinkId);

    TransportObject updateWindows(long userId, long chatLinkId);

    TransportObject getUnreadTotalNumber(long userId);

    TransportObject resetWindows(long userId);

    TransportObject getUnreadList(long userId);

}


