package com.aflac.eib.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

import com.aflac.eib.canonical.v2020.apispecific.aflaccanonicalspayload.AflacCanonicalsPayloadVO;
import com.aflac.eib.demo.controller.PDemoController;
import com.aflac.eib.demo.dataparser.PDemoControllerParser;
import com.aflac.eib.demo.service.PDemoService;
import com.aflac.eib.lib.message.http.response.ResponseMessageUtility;
import com.aflac.eib.lib.model.http.response.GeneralResponse;
import com.aflac.eib.lib.model.http.response.Metadata;
import com.aflac.eib.lib.model.http.response.PaginationInfo;
import com.aflac.eib.lib.util.HealthCheckUtility;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PDemoController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class PdemoControllerTest {

	@Autowired(required = true)
	MockMvc mockMvc;

	@MockBean
	private PDemoService pDemoService;

	@MockBean
	private HealthCheckUtility healthCheckUtility;
	
	@MockBean
	private ResponseMessageUtility responseMessageUtility;

	@MockBean
	private PDemoControllerParser pDemoControllerParser;

	@Mock
	MultiValueMap<String, String> queryParams;

	@Mock
	AflacCanonicalsPayloadVO canonicalResponse;
	
	@Mock
	GeneralResponse<AflacCanonicalsPayloadVO> response;
	
	@Mock
	Metadata responseMetadata;
	
	@Mock
	PaginationInfo responsePagination;

	@Mock
	ResponseEntity<GeneralResponse<?>> generalresponse;
	
	@Before
	public void setup() {

		ResponseEntity<GeneralResponse<AflacCanonicalsPayloadVO>> resEntity = new ResponseEntity<GeneralResponse<AflacCanonicalsPayloadVO>>(
				new GeneralResponse<AflacCanonicalsPayloadVO>(), HttpStatus.OK);
		
		Mockito.when(responseMessageUtility.prepareGeneralResponse(any(HttpStatus.class),any(), anyString(), anyString(),
				 anyString(), any(AflacCanonicalsPayloadVO.class),any(PaginationInfo.class))).thenReturn(resEntity);
	}

	@Test
	public void healthCheckTest() throws Exception {
		Mockito.when(healthCheckUtility.doHealthCheck(any(HttpServletRequest.class))).thenReturn(generalresponse);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/health")
				.contentType(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());

	}

	
}