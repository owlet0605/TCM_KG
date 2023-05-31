package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.User;
import org.springframework.web.multipart.MultipartFile;
import com.example.tcm_kgsystem.entity.Concern;
import com.example.tcm_kgsystem.mapper.ConcernMapper;
import com.example.tcm_kgsystem.entity.UserExample;
import com.example.tcm_kgsystem.entity.ConcernExample;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.mapper.UserMapper;
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
public class UserServiceImplTest  {
	@InjectMocks
	private UserServiceImpl userServiceImpl=new UserServiceImpl(); 
	@Mock
	private UserMapper userMapper; 

	@Mock
	private ConcernMapper concernMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userLogin.json"})
 	public void userLoginTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		String password = arg.getString("String"); 
		String userName = arg.getString("String"); 
		String email = arg.getString("String"); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userLogin(userName,email,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userLogin1.json"})
	public void userLoginTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String password = arg.getString("String");
		String userName = arg.getString("String");
		String email = arg.getString("String");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userLogin(userName,email,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userLogin2.json"})
	public void userLoginTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String password = arg.getString("String");
		String userName = arg.getString("String");
		String email = arg.getString("String");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userLogin(userName,email,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userLogin3.json"})
	public void userLoginTest3(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String password = arg.getString("String");
		String userName = arg.getString("String");
		String email = arg.getString("String");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userLogin(userName,email,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userRegister.json"})
 	public void userRegisterTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userRegister(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userRegister1.json"})
	public void userRegisterTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userRegister(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userRegister2.json"})
	public void userRegisterTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userRegister(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userRegister3.json"})
	public void userRegisterTest3(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userRegister(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userRegister4.json"})
	public void userRegisterTest4(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.userRegister(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userDelete.json"})
 	public void userDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userDelete(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userDelete1.json"})
	public void userDeleteTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		int intArg = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.deleteByPrimaryKey(any(Long.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userDelete(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/GetUserByName.json"})
 	public void GetUserByNameTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		String userName = arg.getString("String"); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.GetUserByName(userName);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/GetUserByName1.json"})
	public void GetUserByNameTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String userName = arg.getString("String");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.GetUserByName(userName);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/GetUserByName2.json"})
	public void GetUserByNameTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String userName = arg.getString("String");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.GetUserByName(userName);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/GetUser.json"})
 	public void GetUserTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = userServiceImpl.GetUser(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/GetUser1.json"})
	public void GetUserTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = userServiceImpl.GetUser(userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePwd.json"})
 	public void userChangePwdTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		String password = arg.getString("String"); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePwd(userId,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePwd1.json"})
	public void userChangePwdTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		String password = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePwd(userId,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePwd3.json"})
	public void userChangePwdTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		String password = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePwd(userId,password);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/TheOldPwdConfirm.json"})
 	public void TheOldPwdConfirmTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		String oldPwd = arg.getString("String"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = userServiceImpl.TheOldPwdConfirm(userId,oldPwd);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/TheOldPwdConfirm1.json"})
	public void TheOldPwdConfirmTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		String oldPwd = arg.getString("String");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = userServiceImpl.TheOldPwdConfirm(userId,oldPwd);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/TheOldPwdConfirm2.json"})
	public void TheOldPwdConfirmTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		String oldPwd = arg.getString("String");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		TransportObject result = userServiceImpl.TheOldPwdConfirm(userId,oldPwd);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeInformation.json"})
 	public void userChangeInformationTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeInformation(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeInformation1.json"})
	public void userChangeInformationTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeInformation(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeEmail.json"})
 	public void userChangeEmailTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		String email = arg.getString("String"); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeEmail(userId,email);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeEmail1.json"})
	public void userChangeEmailTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String email = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeEmail(userId,email);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeEmail2.json"})
	public void userChangeEmailTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String email = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeEmail(userId,email);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeEmail3.json"})
	public void userChangeEmailTest3(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String email = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeEmail(userId,email);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePhone.json"})
 	public void userChangePhoneTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		String phone = arg.getString("String"); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePhone(userId,phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePhone1.json"})
	public void userChangePhoneTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String phone = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePhone(userId,phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePhone2.json"})
	public void userChangePhoneTest2(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String phone = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePhone(userId,phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePhone3.json"})
	public void userChangePhoneTest3(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String phone = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePhone(userId,phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePhone4.json"})
	public void userChangePhoneTest4(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String phone = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePhone(userId,phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangePhone5.json"})
	public void userChangePhoneTest5(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class);
		String phone = arg.getString("String");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangePhone(userId,phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userChangeImage.json"})
 	public void userChangeImageTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		MultipartFile file = JSONObject.parseObject(arg.getString("MultipartFile"),MultipartFile.class); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.userChangeImage(file,userId);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userShowConcern.json"})
 	public void userShowConcernTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<Concern> concernList = JSONObject.parseArray(arg.getString("List<Concern>"),Concern.class); 
		int page = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(concernMapper.selectByExample(any(ConcernExample.class))).thenReturn(concernList);
		TransportObject result = userServiceImpl.userShowConcern(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userShowConcern1.json"})
	public void userShowConcernTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<Concern> concernList = JSONObject.parseArray(arg.getString("List<Concern>"),Concern.class);
		int page = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(concernMapper.selectByExample(any(ConcernExample.class))).thenReturn(concernList);
		TransportObject result = userServiceImpl.userShowConcern(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userShowFans.json"})
 	public void userShowFansTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		List<Concern> concernList = JSONObject.parseArray(arg.getString("List<Concern>"),Concern.class); 
		int page = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(concernMapper.selectByExample(any(ConcernExample.class))).thenReturn(concernList);
		TransportObject result = userServiceImpl.userShowFans(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/userShowFans1.json"})
	public void userShowFansTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		List<Concern> concernList = JSONObject.parseArray(arg.getString("List<Concern>"),Concern.class);
		int page = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(concernMapper.selectByExample(any(ConcernExample.class))).thenReturn(concernList);
		TransportObject result = userServiceImpl.userShowFans(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/showAll.json"})
 	public void showAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		List<User> userList = JSONObject.parseArray(arg.getString("List<User>"),User.class); 
		int page = arg.getInteger("int"); 
		when(userMapper.selectByExample(any(UserExample.class))).thenReturn(userList);
		TransportObject result = userServiceImpl.showAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/changeUserStatus.json"})
 	public void changeUserStatusTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		int userStatus = arg.getInteger("int"); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.changeUserStatus(userId,userStatus);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/changeUserStatus1.json"})
	public void changeUserStatusTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		int userStatus = arg.getInteger("int");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.changeUserStatus(userId,userStatus);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/changeUserSecurity.json"})
 	public void changeUserSecurityTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		int userSecurity = arg.getInteger("int"); 
		int intArg = arg.getInteger("int"); 
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.changeUserSecurity(userId,userSecurity);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/UserServiceImpl/changeUserSecurity1.json"})
	public void changeUserSecurityTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long");
		User user = JSONObject.parseObject(arg.getString("User"),User.class);
		int userSecurity = arg.getInteger("int");
		int intArg = arg.getInteger("int");
		when(userMapper.selectByPrimaryKey(any(Long.class))).thenReturn(user);
		when(userMapper.updateByPrimaryKey(any(User.class))).thenReturn(intArg);
		TransportObject result = userServiceImpl.changeUserSecurity(userId,userSecurity);
		//todo verify the result
	}

}