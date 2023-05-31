package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.service.ArticleTypeService;
import com.example.tcm_kgsystem.service.ArticleService;
import com.example.tcm_kgsystem.entity.History;
import org.springframework.web.multipart.MultipartFile;
import com.example.tcm_kgsystem.transport.FileToUser;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import com.example.tcm_kgsystem.entity.Article;
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
public class ArticleControllerTest  {
	@InjectMocks
	private ArticleController articleController=new ArticleController(); 
	@Mock
	private ArticleTypeService articleTypeService; 

	@Mock
	private ArticleService articleService; 

	@Mock
	private ESUtil esUtil; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/showAllArticle.json"})
 	public void showAllArticleTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long articleTypeId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleTypeService.ShowAllArticle(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.showAllArticle(articleTypeId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/getArticleType.json"})
 	public void getArticleTypeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeService.getArticleType(any(long.class))).thenReturn(transportObject);
		TransportObject result = articleController.getArticleType(articleType);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/showArticles.json"})
 	public void showArticlesTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.userShowArticle(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.showArticles(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articlePublish.json"})
 	public void articlePublishTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		String key = arg.getString("String"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articlePublish(any(Article.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = articleController.articlePublish(article,key);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleView.json"})
 	public void articleViewTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		History history = JSONObject.parseObject(arg.getString("History"),History.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleView(any(long.class),any(long.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleView(history);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleDelete.json"})
 	public void articleDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleDelete(any(long.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleDelete(article);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleSelect.json"})
 	public void articleSelectTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		String str1 = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleSelect(any(String.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleSelect(str1,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleRecommend.json"})
 	public void articleRecommendTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleRecommend(any(long.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleRecommend(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/hotArticles.json"})
 	public void hotArticlesTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.hotArticles()).thenReturn(transportObject);
		TransportObject result = articleController.hotArticles();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleGet.json"})
 	public void articleGetTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleGet(any(long.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleGet(article);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleSearchOnUser.json"})
 	public void articleSearchOnUserTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		String str1 = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleSearchOnUser(any(long.class),any(String.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleSearchOnUser(userId,str1,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/searchAll.json"})
 	public void searchAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.searchAll(any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.searchAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/findAllType.json"})
 	public void findAllTypeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleTypeService.findAll(any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.findAllType(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/changeArticleAudit.json"})
 	public void changeArticleAuditTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.changeArticleAudit(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.changeArticleAudit(article);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleTypeInsert.json"})
 	public void articleTypeInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeService.articleTypeInsert(any(ArticleType.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleTypeInsert(articleType);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleTypeDelete.json"})
 	public void articleTypeDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeService.articleTypeDelete(any(long.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleTypeDelete(articleType);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleTypeChange.json"})
 	public void articleTypeChangeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(articleTypeService.articleTypeChange(any(ArticleType.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleTypeChange(articleType);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/build.json"})
 	public void buildTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(esUtil.buildArticle()).thenReturn(transportObject);
		TransportObject result = articleController.build();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/delete.json"})
 	public void deleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(esUtil.deleteAllArticle()).thenReturn(transportObject);
		TransportObject result = articleController.delete();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/search.json"})
 	public void searchTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(esUtil.searchAllArticle()).thenReturn(transportObject);
		TransportObject result = articleController.search();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/articleUpdateImg.json"})
 	public void articleUpdateImgTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		FileToUser ftu = JSONObject.parseObject(arg.getString("FileToUser"),FileToUser.class); 
		String key = arg.getString("String"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.articleUploadImg(any(MultipartFile.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = articleController.articleUpdateImg(ftu,key);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/showHistory.json"})
 	public void showHistoryTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.showHistory(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = articleController.showHistory(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/getTypeAllNonPage.json"})
 	public void getTypeAllNonPageTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleTypeService.findAllNonPage()).thenReturn(transportObject);
		TransportObject result = articleController.getTypeAllNonPage();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/ArticleController/tihuan.json"})
 	public void tihuanTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(articleService.tihuan()).thenReturn(transportObject);
		TransportObject result = articleController.tihuan();
		//todo verify the result
	}

}