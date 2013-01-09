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
public class CTest {

	private C c;
	private StringBuffer[] var1;
	private StringBuffer[] var2;

	public CTest () {
    	var1 = new StringBuffer[] {new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 '"), 
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or TRUE"),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 #"),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 \""),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 --"),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ")};
    	var2 = new StringBuffer[] {new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 "),
    			new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ")};
    }

    @BeforeClass
    public static void jum1() throws Exception {
    }

    @AfterClass
    public static void jum2() throws Exception {
    }

    @Before
    public void jum3() throws Exception {
        c = C.m1();
    }

    @After
    public void jum4() throws Exception {
    	c = null;
    }
    
    @Test
    public void tm() {
//        System.out.println("filter");
        for (int i = 0; i < var1.length; ++i) {
            assertEquals(var2[i], c.m2(var1[i]));
        }
    }

//    @Test
//    public void tm1() {
////        System.out.println("filter");
//        StringBuffer var1 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 '");
//        C var2 = C.m1();
//        StringBuffer var3 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer var4 = var2.m2(true, 1, var1);
//        assertEquals(var3, var4);
//
//    } /* Test of filter method, of class SQLInjectionFilterManager. */
//
//        @Test
//    public void tm2() {
////        System.out.println("filter");
//        StringBuffer var1 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or TRUE");
//        C var2 = C.m1();
//        StringBuffer var3 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ");
//        StringBuffer var4 = var2.m2(false, 1, var1);
//        //assertEquals(expResult, result);
//
//    }
//
//    @Test
//    public void tm3() {
////        System.out.println("filter");
//        StringBuffer var1 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 #");
//        C var2 = C.m1();
//        StringBuffer var3 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer var4 = var2.m2(false, 3, var1);
//        assertEquals(var3, var4);
//
//    }
//
//    @Test
//    public void tm4() {
////        System.out.println("filter");
//        StringBuffer var1 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 \"");
//        C var2 = C.m1();
//        StringBuffer var3 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer var4 = var2.m2(true, var1);
//        assertEquals(var3, var4);
//
//    }
//
//    @Test
//    public void tm5() {
////        System.out.println("filter");
//        StringBuffer var1 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 --");
//        C var2 = C.m1();
//        StringBuffer var3 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        StringBuffer var4 = var2.m2(false, SomeType.FLAG, var1);
//        assertEquals(var3, var4);
//
//    }
//
//
//    public void tm6() {
////        System.out.println("filter");
//        StringBuffer var1 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 ");
//        C var2 = C.m1();
//        StringBuffer var3 = new StringBuffer("SELECT * FROM ITEM WHERE ID = 1 or ");
//        StringBuffer var4 = var2.m2(true, var1);
//        assertEquals(var3, var4);
//
//    }
}