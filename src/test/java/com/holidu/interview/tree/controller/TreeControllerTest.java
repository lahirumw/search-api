package com.holidu.interview.tree.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.holidu.interview.assignment.tree.controller.TreeController;
import com.holidu.interview.assignment.tree.service.TreeService;

@RunWith(MockitoJUnitRunner.class)
public class TreeControllerTest {
    
    @InjectMocks
    private TreeController treeController = new TreeController();
    
    @Mock
    private TreeService treeService;
    
    @Test
    public void getCommonNameTest() throws Exception {
	
	Map<String, Integer> response = new HashMap<>();
	response.put("red maple", 30);
	
	Mockito.when(treeService.getTree(Mockito.anyMap())).thenReturn(response);
	
	List<String> cartisen = new ArrayList<>();
	cartisen.add("1");
	cartisen.add("2");
	
	Map<String, Integer> result = treeController.getCommonName(cartisen, "20");
	
	Assert.assertNotNull(result);
	Assert.assertEquals(response.get("red maple"), result.get("red maple"));
    }

}
