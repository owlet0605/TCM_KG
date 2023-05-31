package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.es.document.ArticleDocument;
import org.springframework.data.elasticsearch.core.query.MoreLikeThisQuery;
import com.example.tcm_kgsystem.entity.CollectExample;
import com.example.tcm_kgsystem.mapper.CollectMapper;
import com.example.tcm_kgsystem.entity.History;
import org.springframework.web.multipart.MultipartFile;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import com.example.tcm_kgsystem.entity.ArticleExample;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.entity.Collect;
import com.example.tcm_kgsystem.entity.LikeExample;
import com.example.tcm_kgsystem.entity.Like;
import com.example.tcm_kgsystem.mapper.es.ESArticleMapper;
import com.example.tcm_kgsystem.mapper.LikeMapper;
import org.springframework.data.elasticsearch.core.SearchHits;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.mapper.ArticleTypeMapper;
import com.example.tcm_kgsystem.entity.Audit;
import com.example.tcm_kgsystem.mapper.AuditMapper;
import com.example.tcm_kgsystem.mapper.AdminMapper;
import com.util.TestUtils;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.entity.Admin;
import com.example.tcm_kgsystem.entity.HistoryExample;
import java.lang.Class;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.HistoryMapper;
import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.mapper.UserMapper;
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
public class ArticleServiceImplTest  {
	@InjectMocks
	private ArticleServiceImpl articleServiceImpl=new ArticleServiceImpl(); 
	@Mock
	private ArticleMapper articleMapper; 

	@Mock
	private ArticleTypeMapper articleTypeMapper; 

	@Mock
	private AuditMapper auditMapper; 

	@Mock
	private UserMapper userMapper; 

	@Mock
	private ESArticleMapper esArticleMapper; 

	@Mock
	private AdminMapper adminMapper; 

	@Mock
	private HistoryMapper historyMapper; 

	@Mock
	private LikeMapper likeMapper; 

	@Mock
	private CollectMapper collectMapper; 

	@Mock
	private ESUtil esUtil; 

	@Mock
	private ElasticsearchRestTemplate elasticsearchRestTemplate; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleView.json"})
 	public void articleViewTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long"); 
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		int intArg1 = arg.getInteger("int"); 
		List<History> historyList = JSONObject.parseArray(arg.getString("List<History>"),History.class); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg0);
		when(historyMapper.selectByExample(any(HistoryExample.class))).thenReturn(historyList);
		when(historyMapper.insert(any(History.class))).thenReturn(intArg1);
		TransportObject result = articleServiceImpl.articleView(userId,articleId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleView1.json"})
	public void articleViewTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long");
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<History> historyList = JSONObject.parseArray(arg.getString("List<History>"),History.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg0);
		when(historyMapper.selectByExample(any(HistoryExample.class))).thenReturn(historyList);
		when(historyMapper.insert(any(History.class))).thenReturn(intArg1);
		TransportObject result = articleServiceImpl.articleView(userId,articleId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleDelete.json"})
 	public void articleDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg0);
		TransportObject result = articleServiceImpl.articleDelete(articleId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleDelete1.json"})
	public void articleDeleteTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg0);
		TransportObject result = articleServiceImpl.articleDelete(articleId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/userShowArticle.json"})
 	public void userShowArticleTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(articleMapper.selectByExampleWithBLOBs(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = articleServiceImpl.userShowArticle(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/userShowArticle1.json"})
	public void userShowArticleTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		int page = arg.getInteger("int");
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class);
		when(articleMapper.selectByExampleWithBLOBs(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = articleServiceImpl.userShowArticle(userId,page);
		//todo verify the result
	}






	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleGet.json"})
 	public void articleGetTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		TransportObject result = articleServiceImpl.articleGet(articleId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleGet1.json"})
	public void articleGetTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long");
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		TransportObject result = articleServiceImpl.articleGet(articleId);
		//todo verify the result
	}



	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/searchAll.json"})
 	public void searchAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(articleMapper.selectByExampleWithBLOBs(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = articleServiceImpl.searchAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/searchAll1.json"})
	public void searchAllTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class);
		when(articleMapper.selectByExampleWithBLOBs(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = articleServiceImpl.searchAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/changeArticleAudit.json"})
 	public void changeArticleAuditTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		int articleAudit = arg.getInteger("int"); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		TransportObject result = articleServiceImpl.changeArticleAudit(articleId,articleAudit);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/changeArticleAudit1.json"})
	public void changeArticleAuditTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleId = arg.getLong("long");
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int articleAudit = arg.getInteger("int");
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		TransportObject result = articleServiceImpl.changeArticleAudit(articleId,articleAudit);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/articleUploadImg.json"})
 	public void articleUploadImgTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		MultipartFile file = JSONObject.parseObject(arg.getString("MultipartFile"),MultipartFile.class); 
		String key = arg.getString("String"); 
		TransportObject result = articleServiceImpl.articleUploadImg(file,key);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/showHistory.json"})
 	public void showHistoryTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int page = arg.getInteger("int"); 
		List<History> historyList = JSONObject.parseArray(arg.getString("List<History>"),History.class); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(historyMapper.selectByExample(any(HistoryExample.class))).thenReturn(historyList);
		TransportObject result = articleServiceImpl.showHistory(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/showHistory1.json"})
	public void showHistoryTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int page = arg.getInteger("int");
		List<History> historyList = JSONObject.parseArray(arg.getString("List<History>"),History.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(historyMapper.selectByExample(any(HistoryExample.class))).thenReturn(historyList);
		TransportObject result = articleServiceImpl.showHistory(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/ArticleServiceImpl/tihuan.json"})
 	public void tihuanTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(articleMapper.selectByExampleWithBLOBs(any(ArticleExample.class))).thenReturn(articleList);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		TransportObject result = articleServiceImpl.tihuan();
		//todo verify the result
	}

}