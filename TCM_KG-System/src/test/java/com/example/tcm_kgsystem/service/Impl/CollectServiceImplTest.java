package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Collect;
import com.example.tcm_kgsystem.entity.CollectExample;
import com.example.tcm_kgsystem.mapper.CollectMapper;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleExample;
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
public class CollectServiceImplTest  {
	@InjectMocks
	private CollectServiceImpl collectServiceImpl=new CollectServiceImpl(); 
	@Mock
	private CollectMapper collectMapper; 

	@Mock
	private ArticleMapper articleMapper; 

	@Mock
	private UserMapper userMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CollectServiceImpl/CollectByArticle.json"})
 	public void CollectByArticleTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long"); 
		long userId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(collectMapper.insert(any(Collect.class))).thenReturn(intArg);
		when(articleMapper.selectByExample(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = collectServiceImpl.CollectByArticle(articleId,userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CollectServiceImpl/CollectDelete.json"})
 	public void CollectDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Collect collect = JSONObject.parseObject(arg.getString("Collect"),Collect.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		List<Collect> collectList = JSONObject.parseArray(arg.getString("List<Collect>"),Collect.class); 
		when(collectMapper.selectByExample(any(CollectExample.class))).thenReturn(collectList);
		when(collectMapper.deleteByExample(any(CollectExample.class))).thenReturn(intArg);
		when(articleMapper.selectByExample(any(ArticleExample.class))).thenReturn(articleList);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg0);
		TransportObject result = collectServiceImpl.CollectDelete(collect);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CollectServiceImpl/ShowAll.json"})
 	public void ShowAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int page = arg.getInteger("int"); 
		List<Collect> collectList = JSONObject.parseArray(arg.getString("List<Collect>"),Collect.class); 
		when(collectMapper.selectByExample(any(CollectExample.class))).thenReturn(collectList);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		TransportObject result = collectServiceImpl.ShowAll(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CollectServiceImpl/articleCollectIf.json"})
 	public void articleCollectIfTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long"); 
		long userId = arg.getLong("long"); 
		List<Collect> collectList = JSONObject.parseArray(arg.getString("List<Collect>"),Collect.class); 
		when(collectMapper.selectByExample(any(CollectExample.class))).thenReturn(collectList);
		TransportObject result = collectServiceImpl.articleCollectIf(userId,articleId);
		//todo verify the result
	}

}