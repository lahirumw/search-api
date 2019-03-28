package com.holidu.interview.assignment.tree.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.holidu.interview.assignment.constants.FieldNameConstants;
import com.holidu.interview.assignment.tree.service.TreeService;
import com.holidu.interview.assignment.utils.ConversionUtils;

/**
 * Controller class for get common name
 * @author lahirua
 *
 */

@RestController
@RequestMapping("/v1/trees")
public class TreeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TreeController.class);
    
    @Autowired
    private TreeService searchService;
    
    
    @GetMapping(value = "/common-name",  produces=MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Integer> getCommonName(@RequestParam(value = "cartesianPoint", required = true) Collection<String> cartesianPoint, 
	    @RequestParam(value = "radius", required = true) String radius) throws Exception {
	
	LOGGER.info("GET Common Name : {}, {}" , cartesianPoint,radius);
	
	return searchService.getTree(inputValueConvertion(new ArrayList<String>(cartesianPoint),radius));
    }
    
    /**
     * 
     * @param cartesianPoint
     * @param radius
     * @throws Exception
     */
    private Map<String, BigDecimal> inputValueConvertion(ArrayList<String> cartesianPoint, String radius) throws Exception {
	
	Map<String, BigDecimal> inputParams = new HashMap<>();
	
	if(cartesianPoint != null && cartesianPoint.size() == 2) {
	    
	    inputParams.put(FieldNameConstants.X_COORDINATE, ConversionUtils.inputConversion(cartesianPoint.get(0)));
	    inputParams.put(FieldNameConstants.Y_COORDINATE, ConversionUtils.inputConversion(cartesianPoint.get(1)));
	   
	}else {
	    //exception
	}
	
	if(radius != null) {
	    inputParams.put(FieldNameConstants.RADIUS, ConversionUtils.inputConversion(radius));
	    
	}else {
	    //exception
	}
	
	return inputParams;
    }

}
