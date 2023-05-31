package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Phone;
import com.example.tcm_kgsystem.entity.Email;
import com.example.tcm_kgsystem.service.PhoneService;
import com.example.tcm_kgsystem.transport.loginInfo;
import com.example.tcm_kgsystem.entity.User;
import org.springframework.web.multipart.MultipartFile;
import com.example.tcm_kgsystem.transport.FileToUser;
import com.example.tcm_kgsystem.service.UserService;
import com.example.tcm_kgsystem.service.EmailService;
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
public class UserControllerTest  {
	@InjectMocks
	private UserController userController=new UserController(); 
	@Mock
	private UserService userService; 

	@Mock
	private EmailService emailService; 

	@Mock
	private PhoneService phoneService; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/userLogin.json"})
 	public void userLoginTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		loginInfo info = JSONObject.parseObject(arg.getString("loginInfo"),loginInfo.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userLogin(any(String.class),any(String.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.userLogin(info);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/userLogin1.json"})
	public void userLoginTest1(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		loginInfo info = JSONObject.parseObject(arg.getString("loginInfo"),loginInfo.class);
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class);
		when(userService.userLogin(any(String.class),any(String.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.userLogin(info);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/userRegister.json"})
 	public void userRegisterTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userRegister(any(User.class))).thenReturn(transportObject);
		TransportObject result = userController.userRegister(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/userDelete.json"})
 	public void userDeleteTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userDelete(any(long.class))).thenReturn(transportObject);
		TransportObject result = userController.userDelete(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/GetUserByName.json"})
 	public void GetUserByNameTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.GetUserByName(any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.GetUserByName(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/GetUser.json"})
 	public void GetUserTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.GetUser(any(long.class))).thenReturn(transportObject);
		TransportObject result = userController.GetUser(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ChangePwd.json"})
 	public void ChangePwdTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userChangePwd(any(long.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.ChangePwd(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ConfirmPwd.json"})
 	public void ConfirmPwdTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.TheOldPwdConfirm(any(long.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.ConfirmPwd(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ChangeInformation.json"})
 	public void ChangeInformationTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userChangeInformation(any(User.class))).thenReturn(transportObject);
		TransportObject result = userController.ChangeInformation(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ChangeImg.json"})
 	public void ChangeImgTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		FileToUser ftu = JSONObject.parseObject(arg.getString("FileToUser"),FileToUser.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userChangeImage(any(MultipartFile.class),any(long.class))).thenReturn(transportObject);
		TransportObject result = userController.ChangeImg(ftu);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ChangeEmail.json"})
 	public void ChangeEmailTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userChangeEmail(any(long.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.ChangeEmail(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ChangePhone.json"})
 	public void ChangePhoneTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userChangePhone(any(long.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.ChangePhone(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/SendEmail.json"})
 	public void SendEmailTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Email email = JSONObject.parseObject(arg.getString("Email"),Email.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(emailService.userEmailCode(any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.SendEmail(email);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ConfirmEmail.json"})
 	public void ConfirmEmailTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Email email = JSONObject.parseObject(arg.getString("Email"),Email.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(emailService.confirmEmailCode(any(String.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.ConfirmEmail(email);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/SendPhone.json"})
 	public void SendPhoneTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Phone phone = JSONObject.parseObject(arg.getString("Phone"),Phone.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(phoneService.sendPhoneCode(any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.SendPhone(phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ConfirmPhone.json"})
 	public void ConfirmPhoneTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Phone phone = JSONObject.parseObject(arg.getString("Phone"),Phone.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(phoneService.confirmPhoneCode(any(String.class),any(String.class))).thenReturn(transportObject);
		TransportObject result = userController.ConfirmPhone(phone);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ShowConcerns.json"})
 	public void ShowConcernsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userShowConcern(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = userController.ShowConcerns(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/ShowFans.json"})
 	public void ShowFansTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		long userId = arg.getLong("long"); 
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.userShowFans(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = userController.ShowFans(userId,page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/showAll.json"})
 	public void showAllTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		int page = arg.getInteger("int"); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.showAll(any(int.class))).thenReturn(transportObject);
		TransportObject result = userController.showAll(page);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/changeUserStatus.json"})
 	public void changeUserStatusTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.changeUserStatus(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = userController.changeUserStatus(user);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/controller/UserController/changeUserSecurity.json"})
 	public void changeUserSecurityTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		User user = JSONObject.parseObject(arg.getString("User"),User.class); 
		TransportObject transportObject = JSONObject.parseObject(arg.getString("TransportObject"),TransportObject.class); 
		when(userService.changeUserSecurity(any(long.class),any(int.class))).thenReturn(transportObject);
		TransportObject result = userController.changeUserSecurity(user);
		//todo verify the result
	}

}