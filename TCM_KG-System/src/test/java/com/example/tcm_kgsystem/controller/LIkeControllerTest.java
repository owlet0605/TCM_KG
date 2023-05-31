package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.service.LikeService;
import com.example.tcm_kgsystem.entity.Like;
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
public class LIkeControllerTest  {
	@InjectMocks
	private LIkeController lIkeController=new LIkeController(); 
	@Mock
	private LikeService likeService; 

	@Mock
	private ArticleMapper articleMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/LIkeController/byArticle.json"})
 	public void byArticleTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(likeService.LikeAdd(any(Like.class))).thenReturn(transportObject);
		TransportObject result = lIkeController.byArticle(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/LIkeController/delete.json"})
 	public void deleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(likeService.LikeDelete(any(Like.class))).thenReturn(transportObject);
		TransportObject result = lIkeController.delete(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/LIkeController/ShowByUser.json"})
 	public void ShowByUserTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(likeService.ShowAll(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = lIkeController.ShowByUser(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/LIkeController/likeIf.json"})
 	public void likeIfTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(likeService.likeIf(any(Like.class))).thenReturn(transportObject);
		TransportObject result = lIkeController.likeIf(like);
		//todo verify the result
	}

}