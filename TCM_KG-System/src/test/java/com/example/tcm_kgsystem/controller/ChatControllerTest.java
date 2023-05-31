package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.ChatLink;
import com.example.tcm_kgsystem.service.ChatService;
import com.example.tcm_kgsystem.entity.ChatMessage;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
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
public class ChatControllerTest  {
	@InjectMocks
	private ChatController chatController=new ChatController(); 
	@Mock
	private ChatService chatService; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/showChatLinks.json"})
 	public void showChatLinksTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.showChatLinks(any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.showChatLinks(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/showChatMessages.json"})
 	public void showChatMessagesTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.showChatMessages(any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.showChatMessages(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/linkOn.json"})
 	public void linkOnTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.linkOn(any(long.class),any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.linkOn(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/sendChatMessage.json"})
 	public void sendChatMessageTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatMessage message = JSONObject.parseObject(arg.getString("ChatMessage"),ChatMessage.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.saveMessage(any(ChatMessage.class))).thenReturn(transportObject);
		TransportObject result = chatController.sendChatMessage(message);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/getRecentChatRecords.json"})
 	public void getRecentChatRecordsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.getRecentChatRecords(any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.getRecentChatRecords(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/updateWindows.json"})
 	public void updateWindowsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.updateWindows(any(long.class),any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.updateWindows(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/getUnreadTotalNumber.json"})
 	public void getUnreadTotalNumberTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.getUnreadTotalNumber(any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.getUnreadTotalNumber(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/resetWindows.json"})
 	public void resetWindowsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.resetWindows(any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.resetWindows(chatLink);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ChatController/getUnreadList.json"})
 	public void getUnreadListTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ChatLink chatLink = JSONObject.parseObject(arg.getString("ChatLink"),ChatLink.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(chatService.getUnreadList(any(long.class))).thenReturn(transportObject);
		TransportObject result = chatController.getUnreadList(chatLink);
		//todo verify the result
	}

}