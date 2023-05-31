package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.service.CommentService;
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
public class CommentControllerTest  {
	@InjectMocks
	private CommentController commentController=new CommentController(); 
	@Mock
	private CommentService commentService; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CommentController/insert.json"})
 	public void insertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(commentService.commentInsert(any(Comment.class))).thenReturn(transportObject);
		TransportObject result = commentController.insert(comment);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CommentController/delete.json"})
 	public void deleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(commentService.commentDelete(any(Comment.class))).thenReturn(transportObject);
		TransportObject result = commentController.delete(comment);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CommentController/ShowAllComment.json"})
 	public void ShowAllCommentTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(commentService.ShowAllComment(any(Comment.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = commentController.ShowAllComment(comment,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CommentController/ShowAllCommentOfTopComment.json"})
 	public void ShowAllCommentOfTopCommentTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(commentService.ShowAllCommentOfTopComment(any(Comment.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = commentController.ShowAllCommentOfTopComment(comment,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/CommentController/getComment.json"})
 	public void getCommentTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Comment comment = JSONObject.parseObject(arg.getString("Comment"),Comment.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(commentService.getComment(any(long.class))).thenReturn(transportObject);
		TransportObject result = commentController.getComment(comment);
		//todo verify the result
	}

}