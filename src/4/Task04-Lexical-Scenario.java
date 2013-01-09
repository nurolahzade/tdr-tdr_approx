//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Before;
import org.junit.Test;

public class CTest {

	private Map<String, A> var1;
	private C c;
	
	@Before
	public void setUp() {
    	var1 = new HashMap<String, A>();
    	var1.put("5555444455554442", A.T1);
//    	var1.put("5555555555554444", A.T1);
    	var1.put("378282246310005", A.T2);
    	var1.put("4111111111111111", A.T3);
    	var1.put("4000080706200002", A.T3);
    	var1.put("3528000000000007", A.T4);
//    	var1.put("3528000000000015", A.T4);
    	var1.put("3528000000000023", A.T4);
    	var1.put("36666666666660", A.T5);		
		
    	c = new C();
	}
	
    @Test
    public void m1() {
    	Iterator<String> iterator = var1.keySet().iterator();
    	while(iterator.hasNext()) {
    		String var2 = iterator.next(); 
    		for(A var3 : A.m2()) {
 
       			boolean var5 = c.m3(var2, var3);
       			assertEquals(var3 == var1.m4(var2), var5);
    		}
    	}
    	
    }
	
}
