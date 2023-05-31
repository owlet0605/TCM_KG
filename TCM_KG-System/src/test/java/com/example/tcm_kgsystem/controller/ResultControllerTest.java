package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.service.ResultService;
import com.example.tcm_kgsystem.entity.Result;
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
public class ResultControllerTest  {
	@InjectMocks
	private ResultController resultController=new ResultController(); 
	@Mock
	private ResultService resultService; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ResultController/resultInsert.json"})
 	public void resultInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		Result result = JSONObject.parseObject(arg.getString("Result"),Result.class); 
		when(resultService.resultInsert(any(Result.class))).thenReturn(transportObject);
		TransportObject result1 = resultController.resultInsert(result);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ResultController/ShowResult.json"})
 	public void ShowResultTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		Result result = JSONObject.parseObject(arg.getString("Result"),Result.class); 
		when(resultService.showDetail(any(long.class))).thenReturn(transportObject);
		TransportObject result1 = resultController.ShowResult(result);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ResultController/resultIt.json"})
 	public void resultItTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		Result result = JSONObject.parseObject(arg.getString("Result"),Result.class); 
		when(resultService.resultIt(any(long.class))).thenReturn(transportObject);
		TransportObject result1 = resultController.resultIt(result);
		//todo verify the result
	}

}