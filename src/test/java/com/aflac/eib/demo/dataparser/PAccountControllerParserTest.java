package com.aflac.eib.demo.dataparser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import com.aflac.eib.demo.dataparser.PDemoControllerParser;
import com.aflac.eib.lib.exception.custom.ValidationFailedException;
import com.aflac.eib.lib.exception.custom.base.ApplicationException;
import com.aflac.eib.lib.model.selectioncriteria.ConditionGroup;
import com.aflac.eib.lib.util.SelectionCriteriaUtility;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PAccountControllerParserTest {

	@InjectMocks
	PDemoControllerParser pAccountControllerParser;
	
	@Mock
	SelectionCriteriaUtility selectionCriteriaUtility;
	
	@Mock
	ConditionGroup conditionGroup;

	String selectionCriteria = "{\"logical-operator\": \"AND\",\"conditions\": [{\"name\": \"account.id.guid\",\"values\": [\"0855Q-GM-2400\"],\"type\": \"S\",\"comparison-operator\": \"eq\"},{\"name\": \"carrier.code\",\"values\": [\"2400\"],\"type\": \"S\",\"comparison-operator\": \"eq\"}]}";

	@Before
	public void setup() {

	}


	@Test
	public void getHeaderParametersTest() {
		MultiValueMap<String, String> res =pAccountControllerParser.getHeaderParameters("aflacIdentityFields","aflacConsumerId", "aflacBusinessEvent");
		assertNotNull(res.get("aflac-consumer-id"));
	}

	@Test
	public void getQueryParametersTest() throws ApplicationException {
		MultiValueMap<String, String> res =pAccountControllerParser.getQueryParameters(conditionGroup, "filter", "filterType", 4, 5, "id", "asc");
		assertNotNull(res.get("sort-order"));
	}
	
	@Test
	public void getHeaderParametersNullTest() {
		MultiValueMap<String, String> res =pAccountControllerParser.getHeaderParameters(null,null, null);
		assertNull(res.get("aflac-consumer-id"));
	}

	@Test
	public void getQueryParametersNullTest() throws ApplicationException {
		MultiValueMap<String, String> res =pAccountControllerParser.getQueryParameters(null, null, null, 4, 5, null, null);
		assertNull(res.get("sort-order"));
		
	}

}
