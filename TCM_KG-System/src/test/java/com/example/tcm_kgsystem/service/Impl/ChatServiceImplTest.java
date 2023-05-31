package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.mapper.ChatMessageMapper;
import com.example.tcm_kgsystem.entity.ChatLinkExample;
import com.example.tcm_kgsystem.entity.ChatMessageExample;
import com.example.tcm_kgsystem.entity.ChatLink;
import com.example.tcm_kgsystem.entity.ChatMessage;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.mapper.ChatLinkMapper;
import com.example.tcm_kgsystem.transport.TransportObject;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ChatServiceImplTest  {
	@InjectMocks
	private ChatServiceImpl chatServiceImpl=new ChatServiceImpl(); 
	@Mock
	private ChatLinkMapper chatLinkMapper; 

	@Mock
	private ChatMessageMapper chatMessageMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/showChatLinks.json"})
 	public void showChatLinksTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		TransportObject result = chatServiceImpl.showChatLinks(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/showChatLinks1.json"})
	public void showChatLinksTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class);
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		TransportObject result = chatServiceImpl.showChatLinks(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/showChatMessages.json"})
 	public void showChatMessagesTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long chatLinkId = arg.getLong("long"); 
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class); 
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		TransportObject result = chatServiceImpl.showChatMessages(chatLinkId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/showChatMessages1.json"})
	public void showChatMessagesTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long chatLinkId = arg.getLong("long");
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class);
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		TransportObject result = chatServiceImpl.showChatMessages(chatLinkId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/linkOn.json"})
 	public void linkOnTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long fromUserId = arg.getLong("long"); 
		long toUserId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.insert(any(ChatLink.class))).thenReturn(intArg);
		TransportObject result = chatServiceImpl.linkOn(fromUserId,toUserId);
		//todo verify the result
	}



	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/saveMessage.json"})
 	public void saveMessageTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatMessage chatMessage = JSONObject.parseObject(arg.getString("ChatMessage"),ChatMessage.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		int intArg1 = arg.getInteger("int"); 
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.updateByPrimaryKey(any(ChatLink.class))).thenReturn(intArg);
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		when(chatMessageMapper.updateByPrimaryKey(any(ChatMessage.class))).thenReturn(intArg0);
		when(chatMessageMapper.insert(any(ChatMessage.class))).thenReturn(intArg1);
		TransportObject result = chatServiceImpl.saveMessage(chatMessage);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/saveMessage1.json"})
	public void saveMessageTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatMessage chatMessage = JSONObject.parseObject(arg.getString("ChatMessage"),ChatMessage.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class);
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class);
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.updateByPrimaryKey(any(ChatLink.class))).thenReturn(intArg);
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		when(chatMessageMapper.updateByPrimaryKey(any(ChatMessage.class))).thenReturn(intArg0);
		when(chatMessageMapper.insert(any(ChatMessage.class))).thenReturn(intArg1);
		TransportObject result = chatServiceImpl.saveMessage(chatMessage);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/saveMessage2.json"})
	public void saveMessageTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatMessage chatMessage = JSONObject.parseObject(arg.getString("ChatMessage"),ChatMessage.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class);
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class);
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.updateByPrimaryKey(any(ChatLink.class))).thenReturn(intArg);
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		when(chatMessageMapper.updateByPrimaryKey(any(ChatMessage.class))).thenReturn(intArg0);
		when(chatMessageMapper.insert(any(ChatMessage.class))).thenReturn(intArg1);
		TransportObject result = chatServiceImpl.saveMessage(chatMessage);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/getRecentChatRecords.json"})
 	public void getRecentChatRecordsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long chatLinkId = arg.getLong("long"); 
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class); 
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		TransportObject result = chatServiceImpl.getRecentChatRecords(chatLinkId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/getRecentChatRecords1.json"})
	public void getRecentChatRecordsTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long chatLinkId = arg.getLong("long");
		List<ChatMessage> chatMessageList = JSONObject.parseArray(arg.getString("List<ChatMessage>"),ChatMessage.class);
		when(chatMessageMapper.selectByExample(any(ChatMessageExample.class))).thenReturn(chatMessageList);
		TransportObject result = chatServiceImpl.getRecentChatRecords(chatLinkId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/updateWindows.json"})
 	public void updateWindowsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long chatLinkId = arg.getLong("long"); 
		long userId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.updateByPrimaryKey(any(ChatLink.class))).thenReturn(intArg);
		TransportObject result = chatServiceImpl.updateWindows(userId,chatLinkId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/updateWindows1.json"})
	public void updateWindowsTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long chatLinkId = arg.getLong("long");
		long userId = arg.getLong("long");
		int intArg = arg.getInteger("int");
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class);
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.updateByPrimaryKey(any(ChatLink.class))).thenReturn(intArg);
		TransportObject result = chatServiceImpl.updateWindows(userId,chatLinkId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/getUnreadTotalNumber.json"})
 	public void getUnreadTotalNumberTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		TransportObject result = chatServiceImpl.getUnreadTotalNumber(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/resetWindows.json"})
 	public void resetWindowsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		when(chatLinkMapper.updateByPrimaryKey(any(ChatLink.class))).thenReturn(intArg);
		TransportObject result = chatServiceImpl.resetWindows(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ChatServiceImpl/getUnreadList.json"})
 	public void getUnreadListTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		List<ChatLink> chatLinkList = JSONObject.parseArray(arg.getString("List<ChatLink>"),ChatLink.class); 
		when(chatLinkMapper.selectByExample(any(ChatLinkExample.class))).thenReturn(chatLinkList);
		TransportObject result = chatServiceImpl.getUnreadList(userId);
		//todo verify the result
	}

}