package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.service.AuditService;
import com.example.tcm_kgsystem.entity.Audit;
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
public class AuditControllerTest  {
	@InjectMocks
	private AuditController auditController=new AuditController(); 
	@Mock
	private AuditService auditService; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AuditController/auditShow.json"})
 	public void auditShowTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Audit audit = JSONObject.parseObject(arg.getString("Audit"),Audit.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(auditService.auditShow(any(long.class))).thenReturn(transportObject);
		TransportObject result = auditController.auditShow(audit);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AuditController/auditAgree.json"})
 	public void auditAgreeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Audit audit = JSONObject.parseObject(arg.getString("Audit"),Audit.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(auditService.auditAgree(any(long.class))).thenReturn(transportObject);
		TransportObject result = auditController.auditAgree(audit);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/AuditController/auditRefuse.json"})
 	public void auditRefuseTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Audit audit = JSONObject.parseObject(arg.getString("Audit"),Audit.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(auditService.auditRefuse(any(long.class))).thenReturn(transportObject);
		TransportObject result = auditController.auditRefuse(audit);
		//todo verify the result
	}

}