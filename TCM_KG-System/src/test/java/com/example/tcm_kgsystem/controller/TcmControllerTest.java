package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.service.TcmService;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import com.example.tcm_kgsystem.entity.TcmWithBLOBs;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.entity.Tcm;
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
public class TcmControllerTest  {
	@InjectMocks
	private TcmController tcmController=new TcmController(); 
	@Mock
	private TcmService tcmService; 

	@Mock
	private ESUtil esUtil; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/tcmInsert.json"})
 	public void tcmInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.TcmInsert(any(TcmWithBLOBs.class))).thenReturn(transportObject);
		TransportObject result = tcmController.tcmInsert(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/tcmDelete.json"})
 	public void tcmDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.TcmDelete(any(long.class))).thenReturn(transportObject);
		TransportObject result = tcmController.tcmDelete(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/tcmChange.json"})
 	public void tcmChangeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.TcmChange(any(TcmWithBLOBs.class))).thenReturn(transportObject);
		TransportObject result = tcmController.tcmChange(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowAll.json"})
 	public void ShowAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		TransportObject result = tcmController.ShowAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByInitial.json"})
 	public void ShowByInitialTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		String initial = arg.getString("String"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByInitial(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByInitial(initial,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByInitial1.json"})
	public void ShowByInitialTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		String initial = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByInitial(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByInitial(initial,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByInductive.json"})
 	public void ShowByInductiveTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		String inductive = arg.getString("String"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByInductive(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByInductive(inductive,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByInductive1.json"})
	public void ShowByInductiveTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		String inductive = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByInductive(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByInductive(inductive,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByTaste.json"})
 	public void ShowByTasteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		String taste = arg.getString("String"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByTaste(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByTaste(taste,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByTaste1.json"})
	public void ShowByTasteTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		String taste = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByTaste(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByTaste(taste,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByProperty.json"})
 	public void ShowByPropertyTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		String property = arg.getString("String"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByProperty(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByProperty(property,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/ShowByProperty1.json"})
	public void ShowByPropertyTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		String property = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		TransportObject transportObject0 = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		when(tcmService.ShowAll(any(int.class))).thenReturn(transportObject);
		when(tcmService.ShowByProperty(any(String.class),any(int.class))).thenReturn(transportObject0);
		TransportObject result = tcmController.ShowByProperty(property,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/select.json"})
 	public void selectTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		String str1 = arg.getString("String");
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(tcmService.Select(any(String.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = tcmController.select(str1,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/getTcm.json"})
 	public void getTcmTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		Tcm tcm = JSONObject.parseObject(arg.getString("Tcm"),Tcm.class); 
		when(tcmService.getTcm(any(long.class))).thenReturn(transportObject);
		TransportObject result = tcmController.getTcm(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/build.json"})
 	public void buildTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(esUtil.buildTcm()).thenReturn(transportObject);
		TransportObject result = tcmController.build();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/delete.json"})
 	public void deleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(esUtil.deleteAllTcm()).thenReturn(transportObject);
		TransportObject result = tcmController.delete();
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/TcmController/search.json"})
 	public void searchTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(esUtil.searchAllTcm()).thenReturn(transportObject);
		TransportObject result = tcmController.search();
		//todo verify the result
	}

}