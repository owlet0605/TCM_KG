package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.es.document.TcmDocument;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.MoreLikeThisQuery;
import com.example.tcm_kgsystem.entity.TcmExample;
import com.example.tcm_kgsystem.mapper.es.ESTcmMapper;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.mapper.TcmMapper;
import com.example.tcm_kgsystem.transport.TransportObject;
import java.lang.Class;
import com.example.tcm_kgsystem.entity.TcmWithBLOBs;
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
public class TcmServiceImplTest  {
	@InjectMocks
	private TcmServiceImpl tcmServiceImpl=new TcmServiceImpl(); 
	@Mock
	private TcmMapper tcmMapper; 

	@Mock
	private ESTcmMapper esTcmMapper; 

	@Mock
	private ESUtil esUtil; 

	@Mock
	private ElasticsearchRestTemplate elasticsearchRestTemplate; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmInsert.json"})
 	public void TcmInsertTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int"); 
		List<Tcm> tcmList = JSONObject.parseArray(arg.getString("List<Tcm>"),Tcm.class); 
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		when(tcmMapper.selectByExample(any(TcmExample.class))).thenReturn(tcmList);
		when(tcmMapper.insert(any(TcmWithBLOBs.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmInsert(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmInsert1.json"})
	public void TcmInsertTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int");
		List<Tcm> tcmList = JSONObject.parseArray(arg.getString("List<Tcm>"),Tcm.class);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class);
		when(tcmMapper.selectByExample(any(TcmExample.class))).thenReturn(tcmList);
		when(tcmMapper.insert(any(TcmWithBLOBs.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmInsert(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmInsert2.json"})
	public void TcmInsertTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int");
		List<Tcm> tcmList = JSONObject.parseArray(arg.getString("List<Tcm>"),Tcm.class);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class);
		when(tcmMapper.selectByExample(any(TcmExample.class))).thenReturn(tcmList);
		when(tcmMapper.insert(any(TcmWithBLOBs.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmInsert(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmDelete.json"})
 	public void TcmDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long tcmId = arg.getLong("long"); 
		int intArg = arg.getInteger("int"); 
		TcmWithBLOBs tcmWithBLOBs = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		when(tcmMapper.selectByPrimaryKey(any(Long.class))).thenReturn(tcmWithBLOBs);
		when(tcmMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmDelete(tcmId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmDelete1.json"})
	public void TcmDeleteTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long tcmId = arg.getLong("long");
		int intArg = arg.getInteger("int");
		TcmWithBLOBs tcmWithBLOBs = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class);
		when(tcmMapper.selectByPrimaryKey(any(Long.class))).thenReturn(tcmWithBLOBs);
		when(tcmMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmDelete(tcmId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmChange.json"})
 	public void TcmChangeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int"); 
		List<Tcm> tcmList = JSONObject.parseArray(arg.getString("List<Tcm>"),Tcm.class); 
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		when(tcmMapper.selectByExample(any(TcmExample.class))).thenReturn(tcmList);
		when(tcmMapper.updateByPrimaryKey(any(Tcm.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmChange(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmChange1.json"})
	public void TcmChangeTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int");
		List<Tcm> tcmList = JSONObject.parseArray(arg.getString("List<Tcm>"),Tcm.class);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class);
		when(tcmMapper.selectByExample(any(TcmExample.class))).thenReturn(tcmList);
		when(tcmMapper.updateByPrimaryKey(any(Tcm.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmChange(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/TcmChange2.json"})
	public void TcmChangeTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int intArg = arg.getInteger("int");
		List<Tcm> tcmList = JSONObject.parseArray(arg.getString("List<Tcm>"),Tcm.class);
		TcmWithBLOBs tcm = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class);
		when(tcmMapper.selectByExample(any(TcmExample.class))).thenReturn(tcmList);
		when(tcmMapper.updateByPrimaryKey(any(Tcm.class))).thenReturn(intArg);
		TransportObject result = tcmServiceImpl.TcmChange(tcm);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowAll.json"})
 	public void ShowAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class); 
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowAll1.json"})
	public void ShowAllTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class);
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByInitial.json"})
 	public void ShowByInitialTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class); 
		String initial = arg.getString("String"); 
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByInitial(initial,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByInitial1.json"})
	public void ShowByInitialTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class);
		String initial = arg.getString("String");
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByInitial(initial,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByInductive.json"})
 	public void ShowByInductiveTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class); 
		String inductive = arg.getString("String"); 
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByInductive(inductive,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByInductive1.json"})
	public void ShowByInductiveTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class);
		String inductive = arg.getString("String");
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByInductive(inductive,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByTaste.json"})
 	public void ShowByTasteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class); 
		String taste = arg.getString("String"); 
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByTaste(taste,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByTaste1.json"})
	public void ShowByTasteTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class);
		String taste = arg.getString("String");
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByTaste(taste,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByProperty.json"})
 	public void ShowByPropertyTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class); 
		String property = arg.getString("String"); 
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByProperty(property,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/ShowByProperty1.json"})
	public void ShowByPropertyTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int");
		List<TcmWithBLOBs> tcmWithBLOBsList = JSONObject.parseArray(arg.getString("List<TcmWithBLOBs>"),TcmWithBLOBs.class);
		String property = arg.getString("String");
		when(tcmMapper.selectByExampleWithBLOBs(any(TcmExample.class))).thenReturn(tcmWithBLOBsList);
		TransportObject result = tcmServiceImpl.ShowByProperty(property,page);
		//todo verify the result
	}


	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/getTcm.json"})
 	public void getTcmTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long tcmId = arg.getLong("long"); 
		TcmWithBLOBs tcmWithBLOBs = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class); 
		when(tcmMapper.selectByPrimaryKey(any(Long.class))).thenReturn(tcmWithBLOBs);
		TransportObject result = tcmServiceImpl.getTcm(tcmId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/TcmServiceImpl/getTcm1.json"})
	public void getTcmTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long tcmId = arg.getLong("long");
		TcmWithBLOBs tcmWithBLOBs = JSONObject.parseObject(arg.getString("TcmWithBLOBs"),TcmWithBLOBs.class);
		when(tcmMapper.selectByPrimaryKey(any(Long.class))).thenReturn(tcmWithBLOBs);
		TransportObject result = tcmServiceImpl.getTcm(tcmId);
		//todo verify the result
	}

}