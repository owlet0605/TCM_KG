package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Admin;
import com.example.tcm_kgsystem.service.AdminService;
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
public class AdminControllerTest  {
	@InjectMocks
	private AdminController adminController=new AdminController(); 
	@Mock
	private AdminService adminService; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AdminController/adminLogin.json"})
 	public void adminLoginTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Admin admin = JSONObject.parseObject(arg.getString("Admin"),Admin.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(adminService.adminLogin(any(String.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = adminController.adminLogin(admin);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AdminController/ShowAuditHas.json"})
 	public void ShowAuditHasTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(adminService.ShowAuditHas(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = adminController.ShowAuditHas(adminId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AdminController/ShowAuditNot.json"})
 	public void ShowAuditNotTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(adminService.ShowAuditNot(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = adminController.ShowAuditNot(adminId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AdminController/ShowResultHas.json"})
 	public void ShowResultHasTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(adminService.ShowResultHas(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = adminController.ShowResultHas(adminId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AdminController/ShowResultNot.json"})
 	public void ShowResultNotTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(adminService.ShowResultNot(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = adminController.ShowResultNot(adminId,page);
		//todo verify the result
	}

}