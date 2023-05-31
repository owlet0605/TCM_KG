package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Admin;
import com.example.tcm_kgsystem.entity.AuditExample;
import com.example.tcm_kgsystem.entity.Audit;
import com.example.tcm_kgsystem.mapper.AdminMapper;
import com.example.tcm_kgsystem.mapper.AuditMapper;
import com.example.tcm_kgsystem.entity.Result;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.entity.AdminExample;
import com.example.tcm_kgsystem.entity.ResultExample;
import com.example.tcm_kgsystem.mapper.ResultMapper;
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
public class AdminServiceImplTest  {
	@InjectMocks
	private AdminServiceImpl adminServiceImpl=new AdminServiceImpl(); 
	@Mock
	private AdminMapper adminMapper; 

	@Mock
	private AuditMapper auditMapper; 

	@Mock
	private ResultMapper resultMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AdminServiceImpl/adminLogin.json"})
 	public void adminLoginTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<Admin> adminList = JSONObject.parseArray(arg.getString("List<Admin>"),Admin.class); 
		String adminName = arg.getString("String"); 
		String password = arg.getString("String"); 
		when(adminMapper.selectByExample(any(AdminExample.class))).thenReturn(adminList);
		TransportObject result = adminServiceImpl.adminLogin(adminName,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AdminServiceImpl/ShowAuditHas.json"})
 	public void ShowAuditHasTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		List<Audit> auditList = JSONObject.parseArray(arg.getString("List<Audit>"),Audit.class); 
		when(auditMapper.selectByExample(any(AuditExample.class))).thenReturn(auditList);
		TransportObject result = adminServiceImpl.ShowAuditHas(adminId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AdminServiceImpl/ShowAuditNot.json"})
 	public void ShowAuditNotTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		List<Audit> auditList = JSONObject.parseArray(arg.getString("List<Audit>"),Audit.class); 
		when(auditMapper.selectByExample(any(AuditExample.class))).thenReturn(auditList);
		TransportObject result = adminServiceImpl.ShowAuditNot(adminId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AdminServiceImpl/ShowResultHas.json"})
 	public void ShowResultHasTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		List<Result> resultList = JSONObject.parseArray(arg.getString("List<Result>"),Result.class); 
		when(resultMapper.selectByExampleWithBLOBs(any(ResultExample.class))).thenReturn(resultList);
		TransportObject result = adminServiceImpl.ShowResultHas(adminId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AdminServiceImpl/ShowResultNot.json"})
 	public void ShowResultNotTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long adminId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		List<Result> resultList = JSONObject.parseArray(arg.getString("List<Result>"),Result.class); 
		when(resultMapper.selectByExampleWithBLOBs(any(ResultExample.class))).thenReturn(resultList);
		TransportObject result = adminServiceImpl.ShowResultNot(adminId,page);
		//todo verify the result
	}

}