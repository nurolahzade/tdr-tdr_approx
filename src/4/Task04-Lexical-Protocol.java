//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Test;

public class CTest {

    @Test
    public void m1() {
    	
    	Map<String, A> var1 = new HashMap<String, A>();
    	var1.put("5555444455554442", A.getT1());
    	var1.put("5555555555554444", A.getT1());
    	var1.put("378282246310005", A.getT2());
    	var1.put("4111111111111111", A.getT3());
    	var1.put("3528000000000007", A.getT4());
    	var1.put("3528000000000015", A.getT4());
    	var1.put("3528000000000023", A.getT4());
    	var1.put("36666666666660", A.getT5());
    	
    	for(String var2 : var1.keySet()) {
    		for(A var3 : A.m2()) {
 
       			String var4 = var2 + " : " + var3 + " : ";
     			C c = new C(var3);
       			boolean var5 = c.m3(var2);
   
     			if(var3.equals(var1.m4(var2))) {
    				assertTrue(var4 + "false", var5);
    			} else {
    				assertFalse(var4 + "true", var5);    				
    			}

    		}
    	}
    	
    }
	
}
