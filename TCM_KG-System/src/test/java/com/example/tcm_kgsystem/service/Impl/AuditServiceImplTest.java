package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.mapper.ArticleTypeMapper;
import com.example.tcm_kgsystem.entity.Audit;
import com.example.tcm_kgsystem.mapper.AuditMapper;
import com.example.tcm_kgsystem.mapper.AdminMapper;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.entity.Admin;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
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
public class AuditServiceImplTest  {
	@InjectMocks
	private AuditServiceImpl auditServiceImpl=new AuditServiceImpl(); 
	@Mock
	private AuditMapper auditMapper; 

	@Mock
	private ArticleMapper articleMapper; 

	@Mock
	private UserMapper userMapper; 

	@Mock
	private AdminMapper adminMapper; 

	@Mock
	private ArticleTypeMapper articleTypeMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AuditServiceImpl/auditShow.json"})
 	public void auditShowTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Audit audit = JSONObject.parseObject(arg.getString("Audit"),Audit.class); 
		long auditId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		when(auditMapper.selectByPrimaryKey(any(Long.class))).thenReturn(audit);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		TransportObject result = auditServiceImpl.auditShow(auditId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AuditServiceImpl/auditAgree.json"})
 	public void auditAgreeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Audit audit = JSONObject.parseObject(arg.getString("Audit"),Audit.class); 
		long auditId = arg.getLong("long"); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		int intArg1 = arg.getInteger("int"); 
		Admin admin = JSONObject.parseObject(arg.getString("Admin"),Admin.class); 
		ArticleType articleType = JSONObject.parseObject(arg.getString("ArticleType"),ArticleType.class); 
		when(auditMapper.selectByPrimaryKey(any(Long.class))).thenReturn(audit);
		when(auditMapper.updateByPrimaryKey(any(Audit.class))).thenReturn(intArg);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg0);
		when(adminMapper.selectByPrimaryKey(any(Long.class))).thenReturn(admin);
		when(adminMapper.updateByPrimaryKey(any(Admin.class))).thenReturn(intArg1);
		when(articleTypeMapper.selectByPrimaryKey(any(Long.class))).thenReturn(articleType);
		TransportObject result = auditServiceImpl.auditAgree(auditId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/AuditServiceImpl/auditRefuse.json"})
 	public void auditRefuseTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Audit audit = JSONObject.parseObject(arg.getString("Audit"),Audit.class); 
		long auditId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		Article article = JSONObject.parseObject(arg.getString("Article"),Article.class); 
		int intArg = arg.getInteger("int"); 
		int intArg0 = arg.getInteger("int"); 
		int intArg1 = arg.getInteger("int"); 
		Admin admin = JSONObject.parseObject(arg.getString("Admin"),Admin.class); 
		when(auditMapper.selectByPrimaryKey(any(Long.class))).thenReturn(audit);
		when(auditMapper.updateByPrimaryKey(any(Audit.class))).thenReturn(intArg);
		when(articleMapper.selectByPrimaryKey(any(Long.class))).thenReturn(article);
		when(articleMapper.updateByPrimaryKey(any(Article.class))).thenReturn(intArg0);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(adminMapper.selectByPrimaryKey(any(Long.class))).thenReturn(admin);
		when(adminMapper.updateByPrimaryKey(any(Admin.class))).thenReturn(intArg1);
		TransportObject result = auditServiceImpl.auditRefuse(auditId);
		//todo verify the result
	}

}