package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.CommentExample;
import com.example.tcm_kgsystem.mapper.CommentMapper;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleExample;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
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
public class CommentServiceImplTest  {
	@InjectMocks
	private CommentServiceImpl commentServiceImpl=new CommentServiceImpl(); 
	@Mock
	private CommentMapper commentMapper; 

	@Mock
	private ArticleMapper articleMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CommentServiceImpl/commentInsert.json"})
 	public void commentInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		int intArg = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(commentMapper.insert(any(Comment.class))).thenReturn(intArg);
		when(articleMapper.selectByExample(any(ArticleExample.class))).thenReturn(articleList);
		TransportObject result = commentServiceImpl.commentInsert(comment);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CommentServiceImpl/commentDelete.json"})
 	public void commentDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		List<Article> articleList = JSONObject.parseArray(arg.getString("List<Article>"),Article.class); 
		when(commentMapper.selectByPrimaryKey(any(Long.class))).thenReturn(comment);
		when(commentMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		when(articleMapper.selectByExample(any(ArticleExample.class))).thenReturn(articleList);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg0);
		TransportObject result = commentServiceImpl.commentDelete(comment);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CommentServiceImpl/ShowAllComment.json"})
 	public void ShowAllCommentTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		int page = arg.getInteger("int"); 
		List<Comment> commentList = JSONObject.parseArray(arg.getString("List<Comment>"),Comment.class); 
		when(commentMapper.selectByExample(any(CommentExample.class))).thenReturn(commentList);
		TransportObject result = commentServiceImpl.ShowAllComment(comment,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CommentServiceImpl/ShowAllCommentOfTopComment.json"})
 	public void ShowAllCommentOfTopCommentTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		int page = arg.getInteger("int"); 
		List<Comment> commentList = JSONObject.parseArray(arg.getString("List<Comment>"),Comment.class); 
		when(commentMapper.selectByExample(any(CommentExample.class))).thenReturn(commentList);
		TransportObject result = commentServiceImpl.ShowAllCommentOfTopComment(comment,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/CommentServiceImpl/getComment.json"})
 	public void getCommentTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long commentId = arg.getLong("long"); 
		List<Comment> commentList = JSONObject.parseArray(arg.getString("List<Comment>"),Comment.class); 
		when(commentMapper.selectByExample(any(CommentExample.class))).thenReturn(commentList);
		TransportObject result = commentServiceImpl.getComment(commentId);
		//todo verify the result
	}

}