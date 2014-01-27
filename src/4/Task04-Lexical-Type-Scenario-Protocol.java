//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

//import java.util.HashMap;
//import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Before;
import org.junit.Test;

public class CTest {
	
	private SomeSortOfCollection<X, A> var1;
	private C c;
	
	@Before
	public void setUp() {    	
    	SomeSortOfCollection<X, A> var1 = new SomeSortOfCollectionImplementation<X, A>();
    	var1.put(new X("5555444455554442"), A.getT1());
    	var1.put(new X("5555555555554444"), A.getT1());
    	var1.put(new X("378282246310005"), A.getT2());
    	var1.put(new X("4111111111111111"), A.getT3());
    	var1.put(new X("3528000000000007"), A.getT4());
    	var1.put(new X("3528000000000015"), A.getT4());
    	var1.put(new X("3528000000000023"), A.getT4());
    	var1.put(new X("36666666666660"), A.getT5());		
	}
	
    @Test
    public void m1() {    	
    	Iterator<X> iterator = var1.keySet().iterator();
    	while(iterator.hasNext()) {
    		X var2 = iterator.next();
    		for(A var3 : A.m2()) {
    	    	
    	    	c = CFactory.makeC(var3); 
       			int var5 = c.m3(var2, C.FLAG, true);   
       			assertTrue((var3 == var1.get(var2)) == var5 > 0);       			
    		}
    	}
    	
    }
	
}
