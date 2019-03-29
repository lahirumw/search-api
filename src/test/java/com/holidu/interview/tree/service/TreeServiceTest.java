package com.holidu.interview.tree.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.holidu.interview.assignment.tree.model.Tree;
import com.holidu.interview.assignment.tree.service.TreeService;

@RunWith(MockitoJUnitRunner.class)
public class TreeServiceTest {

    @InjectMocks
    private TreeService treeService = new TreeService();

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getTreeTest() throws Exception {

	ReflectionTestUtils.setField(treeService, "treeDataPullUrl",
		"https://data.cityofnewyork.us/resource/nwxe-4ae8.json");

	List<Tree> trees = new ArrayList<>();

	Tree t1 = new Tree();
	t1.setTreeId("1");
	t1.setSpcCommon("aa");
	t1.setStumDiam(new BigDecimal(10));
	t1.setxSp(new BigDecimal(4));
	t1.setySp(new BigDecimal(4));

	Tree t2 = new Tree();
	t2.setTreeId("2");
	t2.setSpcCommon("aa");
	t2.setStumDiam(new BigDecimal(10));
	t2.setxSp(new BigDecimal(4));
	t2.setySp(new BigDecimal(4));

	trees.add(t1);
	trees.add(t2);

	ResponseEntity<List<Tree>> response = new ResponseEntity<List<Tree>>(HttpStatus.OK);
	
	//System.out.println(response.getBody().get(0).getSpcCommon());
	Mockito.when(restTemplate.exchange(Matchers.eq("https://data.cityofnewyork.us/resource/nwxe-4ae8.json"),
	        Matchers.eq(HttpMethod.GET), 
		Matchers.<HttpEntity<List<Tree>>>any(), 
		Matchers.<ParameterizedTypeReference<List<Tree>>>any())).thenReturn(response);
	
	Map<String, BigDecimal> map = new HashMap<>();
	map.put("x", new BigDecimal(1));
	map.put("y", new BigDecimal(1));
	map.put("radious", new BigDecimal(1));

	Map<String, Integer> result = treeService.getTree(map);

	Assert.assertNotNull(result);
    }

}
