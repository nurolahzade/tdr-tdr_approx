//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

//import java.util.HashMap;
//import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Before;
import org.junit.Test;

public class CTest {
	
	private SomeSortOfCollection<StringBuffer, A> var1;
	private C c;
	
	@Before
	public void setUp() {    	
    	SomeSortOfCollection<StringBuffer, A> var1 = new SomeSortOfCollectionImplementation<StringBuffer, A>();
    	var1.put(new StringBuffer("5555444455554442"), A.getT1());
    	var1.put(new StringBuffer("5555555555554444"), A.getT1());
    	var1.put(new StringBuffer("378282246310005"), A.getT2());
    	var1.put(new StringBuffer("4111111111111111"), A.getT3());
    	var1.put(new StringBuffer("3528000000000007"), A.getT4());
    	var1.put(new StringBuffer("3528000000000015"), A.getT4());
    	var1.put(new StringBuffer("3528000000000023"), A.getT4());
    	var1.put(new StringBuffer("36666666666660"), A.getT5());		
	}
	
    @Test
    public void m1() {    	
    	Iterator<StringBuffer> iterator = var1.keySet().iterator();
    	while(iterator.hasNext()) {
    		StringBuffer var2 = iterator.next();
    		for(A var3 : A.m2()) {
    	    	
    	    	c = CFactory.makeC(var3); 
       			int var5 = c.m3(var2, C.FLAG, true);   
       			assertEquals(var3 == var1.get(var2), var5 > 0);       			
    		}
    	}
    	
    }
	
}
