package com.aflac.eib.demo.service.impl;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.aflac.eib.canonical.v2020.apispecific.aflaccanonicalspayload.AflacCanonicalsPayloadVO;
import com.aflac.eib.demo.service.PDemoService;
import com.aflac.eib.lib.exception.custom.base.ApplicationException;
import com.aflac.eib.lib.model.http.response.GeneralResponse;
import com.aflac.eib.lib.resttemplate.RestTemplateUtility;

@SuppressWarnings({"squid:S1452","squid:S2293"})
@org.springframework.stereotype.Service
public class PDemoServiceImpl implements PDemoService {

	@Autowired
	private RestTemplateUtility restTemplateUtility;

	
	private HttpEntity<Object> getHttpHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return new HttpEntity<Object>(headers);
	}

}
