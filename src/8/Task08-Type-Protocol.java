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

    public SQLInjectionFilterManagerTest () {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void filter1() {
//        System.out.println("filter");
        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 '");
        SQLInjectionFilterManager instance = new SQLInjectionFilterManager(true);
        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
        assertFalse(instance.valid(filterString));
        StringBuffer result = instance.filter(true, 1, filterString);
        assertEquals(expResult, result);

    } /* Test of filter method, of class SQLInjectionFilterManager. */

        @Test
    public void filter2() {
//        System.out.println("filter");
        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or TRUE");
        SQLInjectionFilterManager instance = new SQLInjectionFilterManager(true);
        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ");
        assertFalse(instance.valid(filterString));
        StringBuffer result = instance.filter(false, 1, filterString);
        //assertEquals(expResult, result);

    }

    @Test
    public void filter3() {
//        System.out.println("filter");
        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 #");
        SQLInjectionFilterManager instance = new SQLInjectionFilterManager(true);
        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
        assertFalse(instance.valid(filterString));
        StringBuffer result = instance.filter(false, 3, filterString);
        assertEquals(expResult, result);

    }

    @Test
    public void filter4() {
//        System.out.println("filter");
        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 \"");
        SQLInjectionFilterManager instance = new SQLInjectionFilterManager(true);
        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
        assertFalse(instance.valid(filterString));
        StringBuffer result = instance.filter(true, filterString);
        assertEquals(expResult, result);

    }

    @Test
    public void filter5() {
//        System.out.println("filter");
        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 --");
        SQLInjectionFilterManager instance = new SQLInjectionFilterManager(true);
        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
        assertFalse(instance.valid(filterString));
        StringBuffer result = instance.filter(false, SomeType.FLAG, filterString);
        assertEquals(expResult, result);

    }


    public void filter6() {
//        System.out.println("filter");
        StringBuffer filterString = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
        SQLInjectionFilterManager instance = new SQLInjectionFilterManager(true);
        StringBuffer expResult = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ");
        assertFalse(instance.valid(filterString));
        StringBuffer result = instance.filter(true, filterString);
        assertEquals(expResult, result);

    }
}