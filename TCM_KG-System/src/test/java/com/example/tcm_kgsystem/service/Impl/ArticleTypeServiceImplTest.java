package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.mapper.ArticleTypeMapper;
import com.example.tcm_kgsystem.entity.ArticleTypeExample;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleExample;
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
public class ArticleTypeServiceImplTest  {
	@InjectMocks
	private ArticleTypeServiceImpl articleTypeServiceImpl=new ArticleTypeServiceImpl(); 
	@Mock
	private ArticleMapper articleMapper; 

	@Mock
	private ArticleTypeMapper articleTypeMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/ShowAllArticle.json"})
 	public void ShowAllArticleTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleTypeId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(articleMapper.selectByExampleWithBLOBs(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = articleTypeServiceImpl.ShowAllArticle(articleTypeId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/getArticleType.json"})
 	public void getArticleTypeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleTypeId = arg.getLong("long"); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeMapper.selectByPrimaryKey(any(Long.class))).thenReturn(articleType);
		TransportObject result = articleTypeServiceImpl.getArticleType(articleTypeId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/findAll.json"})
 	public void findAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<ArticleType> articleTypeList = JSONObject.parseArray(arg.getString("List<ArticleType>"),ArticleType.class); 
		when(articleTypeMapper.selectByExample(any(ArticleTypeExample.class))).thenReturn(articleTypeList);
		TransportObject result = articleTypeServiceImpl.findAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/findAllNonPage.json"})
 	public void findAllNonPageTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<ArticleType> articleTypeList = JSONObject.parseArray(arg.getString("List<ArticleType>"),ArticleType.class); 
		when(articleTypeMapper.selectByExample(any(ArticleTypeExample.class))).thenReturn(articleTypeList);
		TransportObject result = articleTypeServiceImpl.findAllNonPage();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/articleTypeInsert.json"})
 	public void articleTypeInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int"); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeMapper.insert(any(ArticleType.class))).thenReturn(intArg);
		TransportObject result = articleTypeServiceImpl.articleTypeInsert(articleType);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/articleTypeChange.json"})
 	public void articleTypeChangeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeMapper.selectByPrimaryKey(any(Long.class))).thenReturn(articleType);
		TransportObject result = articleTypeServiceImpl.articleTypeChange(articleType);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleTypeServiceImpl/articleTypeDelete.json"})
 	public void articleTypeDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleTypeId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeMapper.selectByPrimaryKey(any(Long.class))).thenReturn(articleType);
		when(articleTypeMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		TransportObject result = articleTypeServiceImpl.articleTypeDelete(articleTypeId);
		//todo verify the result
	}

}