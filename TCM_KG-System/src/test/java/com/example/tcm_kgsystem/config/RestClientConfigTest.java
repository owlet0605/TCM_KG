package com.example.tcm_kgsystem.config;

import org.elasticsearch.client.RestHighLevelClient;
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
public class RestClientConfigTest  {
	@InjectMocks
	private RestClientConfig restClientConfig=new RestClientConfig(); 
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@ValueSource(strings = {"/com/example/tcm_kgsystem/config/RestClientConfig/elasticsearchClient.json"})
 	public void elasticsearchClientTest(String str) {
		JSONObject arg= TestUtils.getTestArg(str);
		RestHighLevelClient result = restClientConfig.elasticsearchClient();
		//todo verify the result
	}

}