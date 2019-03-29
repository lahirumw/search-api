package com.holidu.interview.tree;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.holidu.interview.tree.controller.TreeControllerTest;
import com.holidu.interview.tree.service.TreeServiceTest;

/**
 * Unit Test Suit
 * @author lahirua
 *
 */
@RunWith(Suite.class)
@SuiteClasses({TreeControllerTest.class, TreeServiceTest.class})
public class AppTest {
    
    @BeforeClass
    public static void startup() {
	System.out.println("UNIT TEST STARTING UP");
    }

    @AfterClass
    public static void tearDown() {
	System.out.println("UNIT TEST COMPLETION");
    }

}
