package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Collect;
import com.example.tcm_kgsystem.service.CollectService;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
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
public class CollectControllerTest  {
	@InjectMocks
	private CollectController collectController=new CollectController(); 
	@Mock
	private CollectService collectService; 

	@Mock
	private ArticleMapper articleMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CollectController/byArticle.json"})
 	public void byArticleTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Collect collect = JSONObject.parseObject(arg.getString("Collect"),Collect.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(collectService.CollectByArticle(any(long.class),any(long.class))).thenReturn(transportObject);
		TransportObject result = collectController.byArticle(collect);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CollectController/delete.json"})
 	public void deleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Collect collect = JSONObject.parseObject(arg.getString("Collect"),Collect.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(collectService.CollectDelete(any(Collect.class))).thenReturn(transportObject);
		TransportObject result = collectController.delete(collect);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CollectController/ShowAll.json"})
 	public void ShowAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(collectService.ShowAll(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = collectController.ShowAll(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CollectController/collectIf.json"})
 	public void collectIfTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Collect collect = JSONObject.parseObject(arg.getString("Collect"),Collect.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(collectService.articleCollectIf(any(long.class),any(long.class))).thenReturn(transportObject);
		TransportObject result = collectController.collectIf(collect);
		//todo verify the result
	}

}