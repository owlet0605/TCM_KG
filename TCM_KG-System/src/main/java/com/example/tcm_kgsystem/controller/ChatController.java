package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.ChatLink;
import com.example.tcm_kgsystem.entity.ChatMessage;
import com.example.tcm_kgsystem.service.ChatService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping("/links")
    TransportObject showChatLinks(ChatLink chatLink) {
        return chatService.showChatLinks(chatLink.getFromUserId());
    }

    @RequestMapping("/messages")
    TransportObject showChatMessages(ChatLink chatLink){
        return chatService.showChatMessages(chatLink.getChatLinkId());
    }

    @RequestMapping("/on")
    TransportObject linkOn(ChatLink chatLink){
        return chatService.linkOn(chatLink.getFromUserId(), chatLink.getToUserId());
    }

    @RequestMapping("/send")
    public TransportObject sendChatMessage(ChatMessage message) {
        return chatService.saveMessage(message);
    }

    @RequestMapping("/lastedMessage")
    TransportObject getRecentChatRecords(ChatLink chatLink){
        return chatService.getRecentChatRecords(chatLink.getChatLinkId());
    }

    @RequestMapping("/update")
    TransportObject updateWindows(ChatLink chatLink){
        return chatService.updateWindows(chatLink.getFromUserId(), chatLink.getChatLinkId());
    }

    @RequestMapping("/unreadNumber")
    TransportObject getUnreadTotalNumber(ChatLink chatLink){
        return chatService.getUnreadTotalNumber(chatLink.getToUserId());
    }

    @RequestMapping("/reset")
    TransportObject resetWindows(ChatLink chatLink){
        return chatService.resetWindows(chatLink.getFromUserId());
    }

    @RequestMapping("/unreadList")
    TransportObject getUnreadList(ChatLink chatLink){
        return chatService.getUnreadList(chatLink.getFromUserId());
    }
}
