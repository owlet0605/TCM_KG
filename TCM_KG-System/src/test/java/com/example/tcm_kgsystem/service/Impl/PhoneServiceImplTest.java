package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Phone;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.tcm_kgsystem.mapper.PhoneMapper;
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
public class PhoneServiceImplTest  {
	@InjectMocks
	private PhoneServiceImpl phoneServiceImpl=new PhoneServiceImpl(); 
	@Mock
	private PhoneMapper phoneMapper; 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/service/Impl/PhoneServiceImpl/confirmPhoneCode.json"})
 	public void confirmPhoneCodeTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		Phone phone = JSONObject.parseObject(arg.getString("Phone"),Phone.class); 
		String code = arg.getString("String"); 
		String phone1 = arg.getString("String");
		when(phoneMapper.selectByPrimaryKey(any(String.class))).thenReturn(phone);
		TransportObject result = phoneServiceImpl.confirmPhoneCode(phone1,code);
		//todo verify the result
	}

}