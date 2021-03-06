/*
 * SQLInjectionFilterManagerTest.java
 * JUnit 4.x based test
 *
 * Created on August 29, 2007, 10:29 PM
 */

//package com.abbhsoft.sqlInjectionFilter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shannan
 */
public class SQLInjectionFilterManagerTest {

	private SQLInjectionFilterManager instance;
	private StringBuffer[] filterString;
	private StringBuffer[] expResult;
	
    public SQLInjectionFilterManagerTest () {
    	filterString = new StringBuffer[] {new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 '"), 
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or TRUE"),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 #"),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 \""),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 --"),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ")};
    	expResult = new StringBuffer[] {new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ")};
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    	instance = null;
    }
    
    @Test
    public void filter() {
        System.out.println("filter");
        for (int i = 0; i < filterString.length; ++i) {
            assertTrue(expResult[i].equals(instance.filter(filterString[i])));
        }
    }    

//    @Test
//    public void filter1() {
////        System.out.println("filter");
//        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 '");
//        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance(true);
//        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer result = instance.filter(true, 1, filterString);
//        assertEquals(expResult, result);
//
//    } /* Test of filter method, of class SQLInjectionFilterManager. */
//
//        @Test
//    public void filter2() {
////        System.out.println("filter");
//        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or TRUE");
//        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance(true);
//        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ");
//        StringBuffer result = instance.filter(false, 1, filterString);
//        //assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void filter3() {
////        System.out.println("filter");
//        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 #");
//        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance(true);
//        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer result = instance.filter(false, 3, filterString);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void filter4() {
////        System.out.println("filter");
//        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 \"");
//        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance(true);
//        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer result = instance.filter(true, filterString);
//        assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void filter5() {
////        System.out.println("filter");
//        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 --");
//        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance(true);
//        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer result = instance.filter(false, SomeType.FLAG, filterString);
//        assertEquals(expResult, result);
//
//    }
//
//
//    public void filter6() {
////        System.out.println("filter");
//        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        SQLInjectionFilterManager instance = SQLInjectionFilterManager.getInstance(true);
//        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ");
//        StringBuffer result = instance.filter(true, filterString);
//        assertEquals(expResult, result);
//
//    }
}