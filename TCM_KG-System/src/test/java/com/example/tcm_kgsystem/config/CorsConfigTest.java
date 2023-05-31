package com.example.tcm_kgsystem.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import com.util.TestUtils;
import org.junit.jupiter.params.provider.ValueSource;
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
public class CorsConfigTest  {
	@InjectMocks
	private CorsConfig corsConfig=new CorsConfig(); 
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/config/CorsConfig/addCorsMappings.json"})
 	public void addCorsMappingsTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		CorsRegistry registry = JSONObject.parseObject(arg.getString("CorsRegistry"),CorsRegistry.class); 
		corsConfig.addCorsMappings(registry);
		//todo verify the result
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/config/CorsConfig/addResourceHandlers.json"})
 	public void addResourceHandlersTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		ResourceHandlerRegistry registry = JSONObject.parseObject(arg.getString("ResourceHandlerRegistry"),ResourceHandlerRegistry.class); 
		corsConfig.addResourceHandlers(registry);
		//todo verify the result
	}

}