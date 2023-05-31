package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.ChatLink;
import com.example.tcm_kgsystem.entity.ChatLinkExample;
import com.example.tcm_kgsystem.entity.ChatMessage;
import com.example.tcm_kgsystem.entity.ChatMessageExample;
import com.example.tcm_kgsystem.mapper.ChatLinkMapper;
import com.example.tcm_kgsystem.mapper.ChatMessageMapper;
import com.example.tcm_kgsystem.service.ChatService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatLinkMapper chatLinkMapper;
    @Autowired
    ChatMessageMapper chatMessageMapper;

    @Override
    public TransportObject showChatLinks(long userId) {
        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.setOrderByClause("chat_link_last_time desc");
        ChatLinkExample.Criteria criteria2=chatLinkExample.createCriteria();
        criteria2.andToUserIdEqualTo(userId);

        ChatLinkExample.Criteria criteria1=chatLinkExample.createCriteria();
        criteria1.andFromUserIdEqualTo(userId);
        chatLinkExample.or(criteria1);
        List<ChatLink> chatLinks=chatLinkMapper.selectByExample(chatLinkExample);

        if(CollectionUtils.isEmpty(chatLinks)){
            TransportObject transportObject=new TransportObject(400,"empty",null);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(200,"ok",chatLinks);
            return transportObject;
        }
    }

    @Override
    public TransportObject showChatMessages(long chatLinkId) {
        ChatMessageExample chatMessageExample=new ChatMessageExample();
        chatMessageExample.setOrderByClause("chat_message_time asc");
        chatMessageExample.createCriteria().andChatLinkIdEqualTo(chatLinkId);
        List<ChatMessage> chatMessages=chatMessageMapper.selectByExample(chatMessageExample);

        if(CollectionUtils.isEmpty(chatMessages)){
            TransportObject transportObject=new TransportObject(400,"empty",null);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(200,"ok",chatMessages);
            return transportObject;
        }
    }

    @Override
    public TransportObject linkOn(long fromUserId, long toUserId) {
        System.out.println(fromUserId);
        System.out.println(toUserId);
        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.createCriteria().andFromUserIdEqualTo(fromUserId).andToUserIdEqualTo(toUserId);
        List<ChatLink> chatLinks=chatLinkMapper.selectByExample(chatLinkExample);
        System.out.println(chatLinks);

        ChatLinkExample chatLinkExample2=new ChatLinkExample();
        chatLinkExample2.createCriteria().andFromUserIdEqualTo(toUserId).andToUserIdEqualTo(fromUserId);
        List<ChatLink> chatLinks1=chatLinkMapper.selectByExample(chatLinkExample2);
        System.out.println(chatLinks1);

        if(CollectionUtils.isEmpty(chatLinks)&&CollectionUtils.isEmpty(chatLinks1)){
            Date time=new Date();
            ChatLink chatLink =new ChatLink((long)0,fromUserId,toUserId,time,time,1,0,0,1,0);
            chatLinkMapper.insert(chatLink);
            ChatLinkExample chatLinkExample1=new ChatLinkExample();
            chatLinkExample1.createCriteria().andFromUserIdEqualTo(fromUserId).andToUserIdEqualTo(toUserId);
            ChatLink chatLink1=chatLinkMapper.selectByExample(chatLinkExample1).get(0);
            TransportObject transportObject=new TransportObject(200,"ok",chatLink1.getChatLinkId());
            return transportObject;
        }
        else{
            if(CollectionUtils.isEmpty(chatLinks)){
                TransportObject transportObject=new TransportObject(200,"ok",chatLinks1.get(0).getChatLinkId());
                return transportObject;
            }
            else{
                TransportObject transportObject=new TransportObject(200,"ok",chatLinks.get(0).getChatLinkId());
                return transportObject;
            }
        }
    }


    @Override
    public TransportObject saveMessage(ChatMessage chatMessage) {
        Date time =new Date();
        chatMessage.setChatMessageTime(time);

        ChatMessageExample chatMessageExample=new ChatMessageExample();
        chatMessageExample.createCriteria().andChatLinkIdEqualTo(chatMessage.getChatLinkId()).andChatMessageLatestEqualTo(1);
        List<ChatMessage> chatMessages=chatMessageMapper.selectByExample(chatMessageExample);
        if(!CollectionUtils.isEmpty(chatMessages)){
            ChatMessage chatMessage1=chatMessages.get(0);
            chatMessage1.setChatMessageLatest(0);
            chatMessageMapper.updateByPrimaryKey(chatMessage1);
        }

        chatMessageMapper.insert(chatMessage);

        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.createCriteria().andChatLinkIdEqualTo(chatMessage.getChatLinkId());
        ChatLink chatLink=chatLinkMapper.selectByExample(chatLinkExample).get(0);
        if(chatLink.getFromUserId().equals(chatMessage.getToUserId())){
            if(chatLink.getFromWindow()==0){
                chatLink.setFromUnread(chatLink.getFromUnread()+1);
            }
        }
        else{
            if(chatLink.getToWindow()==0){
                chatLink.setToUnread(chatLink.getToUnread()+1);
            }
        }
        chatLinkMapper.updateByPrimaryKey(chatLink);

        ChatMessageExample chatMessageExample1=new ChatMessageExample();
        chatMessageExample1.createCriteria().andChatLinkIdEqualTo(chatMessage.getChatLinkId()).andChatMessageLatestEqualTo(1);
        ChatMessage result=chatMessageMapper.selectByExample(chatMessageExample1).get(0);
        TransportObject transportObject=new TransportObject(200,"ok",result);
        return transportObject;
    }

    @Override
    public TransportObject getRecentChatRecords(long chatLinkId) {
        ChatMessageExample chatMessageExample=new ChatMessageExample();
        chatMessageExample.createCriteria().andChatMessageLatestEqualTo(1).andChatLinkIdEqualTo(chatLinkId);
        List<ChatMessage> chatMessages=chatMessageMapper.selectByExample(chatMessageExample);
        if(CollectionUtils.isEmpty(chatMessages)){
            TransportObject transportObject=new TransportObject(400,"ok",null);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(200,"ok",chatMessages.get(0));
            return transportObject;
        }

    }

    @Override
    public TransportObject updateWindows(long userId, long chatLinkId) {
        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.createCriteria().andChatLinkIdEqualTo(chatLinkId);
        ChatLink chatLink=chatLinkMapper.selectByExample(chatLinkExample).get(0);
        if(chatLink.getFromUserId()==userId){
            chatLink.setFromWindow(1);
        }
        else{
            chatLink.setToWindow(1);
        }
        chatLinkMapper.updateByPrimaryKey(chatLink);
        TransportObject transportObject=new TransportObject(200,"ok",chatLink);
        return transportObject;
    }

    @Override
    public TransportObject getUnreadTotalNumber(long userId) {
        int unread=0;
        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.createCriteria().andFromUnreadGreaterThan(0).andFromUserIdEqualTo(userId);
        List<ChatLink> chatLinks=chatLinkMapper.selectByExample(chatLinkExample);

        ChatLinkExample chatLinkExample1=new ChatLinkExample();
        chatLinkExample1.createCriteria().andToUnreadGreaterThan(0).andToUserIdEqualTo(userId);
        List<ChatLink> chatLinks1=chatLinkMapper.selectByExample(chatLinkExample);

        Iterator<ChatLink> chatLinkIterator=chatLinks.iterator();
        while (chatLinkIterator.hasNext()){
            ChatLink chatLink=chatLinkIterator.next();
            unread+=chatLink.getFromUnread();
        }

        Iterator<ChatLink> chatLinkIterator1=chatLinks1.iterator();
        while (chatLinkIterator1.hasNext()){
            ChatLink chatLink=chatLinkIterator1.next();
            unread+=chatLink.getToUnread();
        }

        TransportObject transportObject=new TransportObject(200,"ok",unread);
        return transportObject;
    }

    @Override
    public TransportObject resetWindows(long userId) {
        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.createCriteria().andFromUserIdEqualTo(userId).andFromWindowEqualTo(1);
        List<ChatLink> chatLinks=chatLinkMapper.selectByExample(chatLinkExample);

        ChatLinkExample chatLinkExample1=new ChatLinkExample();
        chatLinkExample1.createCriteria().andToUserIdEqualTo(userId).andToWindowEqualTo(1);
        List<ChatLink> chatLinks1=chatLinkMapper.selectByExample(chatLinkExample1);

        Iterator<ChatLink> chatLinkIterator=chatLinks.iterator();
        while (chatLinkIterator.hasNext()){
            ChatLink chatLink=chatLinkIterator.next();
            chatLink.setFromWindow(0);
            chatLinkMapper.updateByPrimaryKey(chatLink);
        }

        Iterator<ChatLink> chatLinkIterator1=chatLinks1.iterator();
        while (chatLinkIterator1.hasNext()){
            ChatLink chatLink=chatLinkIterator1.next();
            chatLink.setToWindow(0);
            chatLinkMapper.updateByPrimaryKey(chatLink);
        }

        TransportObject transportObject=new TransportObject(200,"ok",null);
        return transportObject;
    }

    @Override
    public TransportObject getUnreadList(long userId) {
        ChatLinkExample chatLinkExample=new ChatLinkExample();
        chatLinkExample.createCriteria().andFromUnreadGreaterThan(0).andFromUserIdEqualTo(userId);
        List<ChatLink> chatLinks=chatLinkMapper.selectByExample(chatLinkExample);

        ChatLinkExample chatLinkExample1=new ChatLinkExample();
        chatLinkExample1.createCriteria().andToUnreadGreaterThan(0).andToUserIdEqualTo(userId);
        List<ChatLink> chatLinks1=chatLinkMapper.selectByExample(chatLinkExample);

        chatLinks.addAll(chatLinks1);

        TransportObject transportObject=new TransportObject(200,"ok",chatLinks);
        return transportObject;
    }
}
