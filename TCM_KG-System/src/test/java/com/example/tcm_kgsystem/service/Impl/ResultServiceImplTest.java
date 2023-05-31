package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Admin;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.AdminMapper;
import com.example.tcm_kgsystem.entity.Result;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.entity.AdminExample;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.mapper.ResultMapper;
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
public class ResultServiceImplTest  {
	@InjectMocks
	private ResultServiceImpl resultServiceImpl=new ResultServiceImpl(); 
	@Mock
	private ResultMapper resultMapper; 

	@Mock
	private UserMapper userMapper; 

	@Mock
	private AdminMapper adminMapper; 

	@Mock
	private ArticleMapper articleMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ResultServiceImpl/resultInsert.json"})
 	public void resultInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int"); 
		List<Admin> adminList = JSONObject.parseArray(arg.getString("List<Admin>"),Admin.class); 
		Result result1 = JSONObject.parseObject(arg.getString("Result"),Result.class);
		when(resultMapper.insert(any(Result.class))).thenReturn(intArg);
		when(adminMapper.selectByExample(any(AdminExample.class))).thenReturn(adminList);
		TransportObject result = resultServiceImpl.resultInsert(result1);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ResultServiceImpl/showDetail.json"})
 	public void showDetailTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long resultId = arg.getLong("long"); 
		Result result1 = JSONObject.parseObject(arg.getString("Result"),Result.class);
		when(resultMapper.selectByPrimaryKey(any(Long.class))).thenReturn(result1);
		TransportObject result = resultServiceImpl.showDetail(resultId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ResultServiceImpl/resultIt.json"})
 	public void resultItTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long resultId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		List<Admin> adminList = JSONObject.parseArray(arg.getString("List<Admin>"),Admin.class); 
		Result result1 = JSONObject.parseObject(arg.getString("Result"),Result.class);
		when(resultMapper.selectByPrimaryKey(any(Long.class))).thenReturn(result1);
		when(resultMapper.updateByPrimaryKey(any(Result.class))).thenReturn(intArg);
		when(adminMapper.selectByExample(any(AdminExample.class))).thenReturn(adminList);
		when(adminMapper.updateByPrimaryKey(any(Admin.class))).thenReturn(intArg0);
		TransportObject result = resultServiceImpl.resultIt(resultId);
		//todo verify the result
	}

}