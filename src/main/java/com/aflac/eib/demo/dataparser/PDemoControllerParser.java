package com.aflac.eib.demo.dataparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.aflac.eib.lib.constants.CoreConstants;
import com.aflac.eib.lib.exception.custom.base.ApplicationException;
import com.aflac.eib.lib.model.selectioncriteria.ConditionGroup;
import com.aflac.eib.lib.util.SelectionCriteriaUtility;

@Component
public class PDemoControllerParser {
	
	@Autowired
	private SelectionCriteriaUtility selectionCriteriaUtility;

	/**
	 * This method will add all input parameter in MultiValueMap
	 * 
	 * @param selectionCriteria
	 * @param filter
	 * @param filterType
	 * @param pageNumber
	 * @param pageSize
	 * @param sortBy
	 * @param sortOrder
	 * @return
	 * @throws ApplicationException 
	 */
	public MultiValueMap<String, String> getQueryParameters(ConditionGroup conditionGroup, String filter, String filterType,
			Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) throws ApplicationException {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

		if (!StringUtils.isEmpty(conditionGroup)) {
			parameters.add(CoreConstants.QP_SELECTION_CRITERIA, selectionCriteriaUtility.toJsonString(conditionGroup));
		}
		if (!StringUtils.isEmpty(filter)) {
			parameters.add(CoreConstants.QP_FILTER, filter);
		}
		if (!StringUtils.isEmpty(filterType)) {
			parameters.add(CoreConstants.QP_FILTER_TYPE, filterType);
		}
		if (null !=pageNumber) {
			parameters.add(CoreConstants.QP_PAGE_NUMBER, pageNumber.toString());
		}
		if (null !=pageSize) {
			parameters.add(CoreConstants.QP_PAGE_SIZE, pageSize.toString());
		}
		if (!StringUtils.isEmpty(sortOrder)) {
			parameters.add(CoreConstants.QP_SORT_ORDER, sortOrder);
		}
		if (!StringUtils.isEmpty(sortBy)) {
			parameters.add(CoreConstants.QP_SORT_BY, sortBy);
		}

		return parameters;
	}
	
	/**
	 * 
	 * This method will  return ann header parameter after validation in MultiValueMap.
	 * @param aflacIdentityFields
	 * @param aflacCorrelationId
	 * @param aflacTransactionId
	 * @param aflacConsumerId
	 * @param aflacBusinessEvent
	 * @return
	 */
	public MultiValueMap<String, String> getHeaderParameters(String aflacIdentityFields,
			 String aflacConsumerId, String aflacBusinessEvent){
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		
		if (!StringUtils.isEmpty(aflacIdentityFields)) {
			parameters.add(CoreConstants.HEADER_IDENTITY_FIELDS, aflacIdentityFields);
		}
		if (!StringUtils.isEmpty(aflacConsumerId)) {
			parameters.add(CoreConstants.HEADER_CONSUMER_ID, aflacConsumerId);
		}
		if (!StringUtils.isEmpty(aflacBusinessEvent)) {
			parameters.add(CoreConstants.HEADER_BUSINESS_EVENT, aflacBusinessEvent);
		}
		
		return parameters;
	}
}
