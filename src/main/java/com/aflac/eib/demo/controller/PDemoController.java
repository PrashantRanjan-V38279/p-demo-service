package com.aflac.eib.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aflac.eib.canonical.v2020.apispecific.aflaccanonicalspayload.AflacCanonicalsPayloadVO;
import com.aflac.eib.demo.dataparser.PDemoControllerParser;
import com.aflac.eib.demo.service.PDemoService;
import com.aflac.eib.lib.constants.CoreConstants;
import com.aflac.eib.lib.exception.custom.base.ApplicationException;
import com.aflac.eib.lib.message.http.ApplicationMessageType;
import com.aflac.eib.lib.message.http.response.ResponseMessageUtility;
import com.aflac.eib.lib.model.http.response.GeneralResponse;
import com.aflac.eib.lib.model.selectioncriteria.ConditionGroup;
import com.aflac.eib.lib.util.HealthCheckUtility;
@Validated
@SuppressWarnings({"squid:S1452"})
@RestController
@RequestMapping("/v1/")
public class PDemoController {

	@Autowired
	private PDemoService pDemoService;

	@Autowired
	private ResponseMessageUtility responseMessageUtility;

	@Autowired
	private HealthCheckUtility healthCheckUtility;

	@Autowired
	private PDemoControllerParser pDemoControllerParser;

	
	/**
	 * This method will be used for health check of service
	 * 
	 * @param httpRequest
	 * @return
	 */
	@GetMapping(path = "/health", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GeneralResponse<?>> getHealthCheck(HttpServletRequest httpRequest) {

		return healthCheckUtility.doHealthCheck(httpRequest);
	}

}
