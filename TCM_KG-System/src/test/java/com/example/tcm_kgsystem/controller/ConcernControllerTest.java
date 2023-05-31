package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Concern;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.service.ConcernService;
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
public class ConcernControllerTest  {
	@InjectMocks
	private ConcernController concernController=new ConcernController(); 
	@Mock
	private ConcernService concernService; 

	@Mock
	private ArticleMapper articleMapper; 

	@Mock
	private UserMapper userMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ConcernController/byUser.json"})
 	public void byUserTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Concern concern = JSONObject.parseObject(arg.getString("Concern"),Concern.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(concernService.ConcernByUser(any(User.class),any(User.class))).thenReturn(transportObject);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = concernController.byUser(concern);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ConcernController/delete.json"})
 	public void deleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Concern concern = JSONObject.parseObject(arg.getString("Concern"),Concern.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(concernService.ConcernDelete(any(User.class),any(User.class))).thenReturn(transportObject);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = concernController.delete(concern);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ConcernController/concernIf.json"})
 	public void concernIfTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Concern concern = JSONObject.parseObject(arg.getString("Concern"),Concern.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(concernService.ConcernIf(any(User.class),any(User.class))).thenReturn(transportObject);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = concernController.concernIf(concern);
		//todo verify the result
	}

}