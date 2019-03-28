package com.holidu.interview.assignment.tree.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.holidu.interview.assignment.constants.FieldNameConstants;
import com.holidu.interview.assignment.tree.model.Tree;

/**
 * 
 * Service class for get common name
 * 
 * @author lahirua
 *
 */
@Service
@PropertySource(value = { "classpath:${ENV:}/environment.properties" })
public class TreeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeService.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${TREE_DATA_PULL_URL}")
    private String treeDataPullUrl;

    /**
     * Get count recurent values
     * 
     * @return
     */
    public Map<String, Integer> getTree(Map<String, BigDecimal> inputParams) throws Exception{
	
	LOGGER.info("Start Calling Data pull URL");
	
	ResponseEntity<List<Tree>> response = restTemplate.exchange(treeDataPullUrl, HttpMethod.GET, null,
		new ParameterizedTypeReference<List<Tree>>() {
		});
	
	LOGGER.info("End of Calling Data pull URL");
	
	List<Tree> trees = response.getBody();
	
	List<String> commonNameValues = new ArrayList<>();

	for (Tree tree : trees) {
	    
	    BigDecimal radius = tree.getStumDiam().divide(new BigDecimal(2));
	    
	    if(inputParams.get(FieldNameConstants.RADIUS).compareTo(radius) >= 0 
		    && inputParams.get(FieldNameConstants.X_COORDINATE).compareTo(tree.getxSp()) >=0
		    && inputParams.get(FieldNameConstants.Y_COORDINATE).compareTo(tree.getySp()) >=0
		    && tree.getSpcCommon() != null) {
        		
        		commonNameValues.add(tree.getSpcCommon());
	    }
	}

	return getCountOfRecurrnetValues(commonNameValues);
	
	
    }

    /**
     * Get the count of recurrent values in the list
     * 
     * @param treeValues
     *                       List of common name
     * 
     * @return
     */
    private Map<String, Integer> getCountOfRecurrnetValues(List<String> treeValues) {

	Map<String, Integer> commonNameRecurrentCount = new HashMap<>();

	for (String value : treeValues) {

	    commonNameRecurrentCount.put(value, Collections.frequency(treeValues, value));
	}

	LOGGER.info("Returning the Response");

	return commonNameRecurrentCount;
    }

}
