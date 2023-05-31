package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.mapper.LikeMapper;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.entity.LikeExample;
import com.example.tcm_kgsystem.entity.Like;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.CommentMapper;
import com.example.tcm_kgsystem.entity.Article;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.entity.Comment;
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
public class LikeServiceImplTest  {
	@InjectMocks
	private LikeServiceImpl likeServiceImpl=new LikeServiceImpl(); 
	@Mock
	private ArticleMapper articleMapper; 

	@Mock
	private LikeMapper likeMapper; 

	@Mock
	private UserMapper userMapper; 

	@Mock
	private CommentMapper commentMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeAdd.json"})
 	public void LikeAddTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(likeMapper.insert(any(Like.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeAdd(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeAdd1.json"})
	public void LikeAddTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(likeMapper.insert(any(Like.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeAdd(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeAdd2.json"})
	public void LikeAddTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(likeMapper.insert(any(Like.class))).thenReturn(intArg);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeAdd(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeDelete.json"})
 	public void LikeDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		int intArg1 = arg.getInteger("int"); 
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		when(likeMapper.deleteByExample(any(LikeExample.class))).thenReturn(intArg0);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg1);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeDelete(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeDelete1.json"})
	public void LikeDeleteTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		when(likeMapper.deleteByExample(any(LikeExample.class))).thenReturn(intArg0);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg1);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeDelete(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeDelete2.json"})
	public void LikeDeleteTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		when(likeMapper.deleteByExample(any(LikeExample.class))).thenReturn(intArg0);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg1);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeDelete(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeDelete4.json"})
	public void LikeDeleteTest4(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		when(likeMapper.deleteByExample(any(LikeExample.class))).thenReturn(intArg0);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg1);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeDelete(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/LikeDelete3.json"})
	public void LikeDeleteTest3(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int intArg = arg.getInteger("int");
		int intArg0 = arg.getInteger("int");
		int intArg1 = arg.getInteger("int");
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		when(likeMapper.deleteByExample(any(LikeExample.class))).thenReturn(intArg0);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg1);
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		TransportObject result = likeServiceImpl.LikeDelete(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/ShowAll.json"})
 	public void ShowAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int page = arg.getInteger("int"); 
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class); 
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		TransportObject result = likeServiceImpl.ShowAll(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/ShowAll1.json"})
	public void ShowAllTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class);
		int page = arg.getInteger("int");
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		TransportObject result = likeServiceImpl.ShowAll(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/likeIf.json"})
 	public void likeIfTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class); 
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class); 
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		TransportObject result = likeServiceImpl.likeIf(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/likeIf1.json"})
	public void likeIfTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		TransportObject result = likeServiceImpl.likeIf(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/likeIf2.json"})
	public void likeIfTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		TransportObject result = likeServiceImpl.likeIf(like);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/LikeServiceImpl/likeIf3.json"})
	public void likeIfTest3(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Like like = JSONObject.parseObject(arg.getString("Like"),Like.class);
		List<Like> likeList = JSONObject.parseArray(arg.getString("List<Like>"),Like.class);
		when(likeMapper.selectByExample(any(LikeExample.class))).thenReturn(likeList);
		TransportObject result = likeServiceImpl.likeIf(like);
		//todo verify the result
	}

}