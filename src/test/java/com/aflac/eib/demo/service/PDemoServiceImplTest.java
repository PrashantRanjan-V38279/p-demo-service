package com.aflac.eib.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.MultiValueMap;

import com.aflac.eib.canonical.v2020.apispecific.aflaccanonicalspayload.AflacCanonicalsPayloadVO;
import com.aflac.eib.demo.service.impl.PDemoServiceImpl;
import com.aflac.eib.lib.exception.custom.base.ApplicationException;
import com.aflac.eib.lib.model.http.response.GeneralResponse;
import com.aflac.eib.lib.resttemplate.RestTemplateUtility;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PDemoServiceImplTest {

	@InjectMocks
	PDemoServiceImpl pDemoServiceImpl;

	@Mock
	private RestTemplateUtility restTemplateUtility;

	@Mock
	ResponseEntity<GeneralResponse<AflacCanonicalsPayloadVO>> generalRes;

	@Mock
	GeneralResponse<AflacCanonicalsPayloadVO> midResponse;

	@Mock
	AflacCanonicalsPayloadVO finalResponse;

	@Mock
	MultiValueMap<String, String> queryParams;

	

}
