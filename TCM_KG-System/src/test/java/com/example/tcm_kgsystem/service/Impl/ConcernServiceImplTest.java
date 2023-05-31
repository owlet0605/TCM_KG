package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.entity.Concern;
import com.example.tcm_kgsystem.mapper.ConcernMapper;
import com.example.tcm_kgsystem.entity.ConcernExample;
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
public class ConcernServiceImplTest  {
	@InjectMocks
	private ConcernServiceImpl concernServiceImpl=new ConcernServiceImpl(); 
	@Mock
	private ConcernMapper concernMapper; 

	@Mock
	private UserMapper userMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ConcernServiceImpl/ConcernByUser.json"})
 	public void ConcernByUserTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user1 = JSONObject.parseObject(arg.getString("User"),User.class); 
		User user2 = JSONObject.parseObject(arg.getString("User"),User.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		when(concernMapper.insert(any(Concern.class))).thenReturn(intArg);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg0);
		TransportObject result = concernServiceImpl.ConcernByUser(user1,user2);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ConcernServiceImpl/ConcernDelete.json"})
 	public void ConcernDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user1 = JSONObject.parseObject(arg.getString("User"),User.class); 
		User user2 = JSONObject.parseObject(arg.getString("User"),User.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		List<Concern> concernList = JSONObject.parseArray(arg.getString("List<Concern>"),Concern.class); 
		when(concernMapper.selectByExample(any(ConcernExample.class))).thenReturn(concernList);
		when(concernMapper.deleteByExample(any(ConcernExample.class))).thenReturn(intArg);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg0);
		TransportObject result = concernServiceImpl.ConcernDelete(user1,user2);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ConcernServiceImpl/ConcernIf.json"})
 	public void ConcernIfTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user1 = JSONObject.parseObject(arg.getString("User"),User.class); 
		User user2 = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<Concern> concernList = JSONObject.parseArray(arg.getString("List<Concern>"),Concern.class); 
		when(concernMapper.selectByExample(any(ConcernExample.class))).thenReturn(concernList);
		TransportObject result = concernServiceImpl.ConcernIf(user1,user2);
		//todo verify the result
	}

}