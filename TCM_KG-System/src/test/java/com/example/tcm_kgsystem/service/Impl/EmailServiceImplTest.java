package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Email;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.mapper.EmailMapper;
import com.example.tcm_kgsystem.entity.UserExample;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.mapper.UserMapper;
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
public class EmailServiceImplTest  {
	@InjectMocks
	private EmailServiceImpl emailServiceImpl=new EmailServiceImpl(); 
	@Mock
	private EmailMapper emailMapper; 

	@Mock
	private UserMapper userMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/EmailServiceImpl/confirmEmailLink.json"})
 	public void confirmEmailLinkTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Email email = JSONObject.parseObject(arg.getString("Email"),Email.class); 
		int intArg = arg.getInteger("int"); 
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		String email1 = arg.getString("String");
		String key = arg.getString("String"); 
		when(emailMapper.selectByPrimaryKey(any(String.class))).thenReturn(email);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = emailServiceImpl.confirmEmailLink(email1,key);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/EmailServiceImpl/confirmEmailLink1.json"})
	public void confirmEmailLinkTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Email email = JSONObject.parseObject(arg.getString("Email"),Email.class);
		int intArg = arg.getInteger("int");
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String email1 = arg.getString("String");
		String key = arg.getString("String");
		when(emailMapper.selectByPrimaryKey(any(String.class))).thenReturn(email);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = emailServiceImpl.confirmEmailLink(email1,key);
		//todo verify the result
	}


	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/EmailServiceImpl/confirmEmailCode.json"})
 	public void confirmEmailCodeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Email email = JSONObject.parseObject(arg.getString("Email"),Email.class); 
		int intArg = arg.getInteger("int"); 
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		String code = arg.getString("String"); 
		String email1 = arg.getString("String");
		when(emailMapper.selectByPrimaryKey(any(String.class))).thenReturn(email);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = emailServiceImpl.confirmEmailCode(email1,code);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/EmailServiceImpl/confirmEmailCode1.json"})
	public void confirmEmailCodeTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Email email = JSONObject.parseObject(arg.getString("Email"),Email.class);
		int intArg = arg.getInteger("int");
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String code = arg.getString("String");
		String email1 = arg.getString("String");
		when(emailMapper.selectByPrimaryKey(any(String.class))).thenReturn(email);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = emailServiceImpl.confirmEmailCode(email1,code);
		//todo verify the result
	}


}