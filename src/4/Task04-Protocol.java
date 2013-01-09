//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Test;

public class CreditcardUtilTest {

    @Test
    public void isValid() {
    	
    	Map<String, CreditcardType> map = new HashMap<String, CreditcardType>();
    	map.put("5555444455554442", CreditcardType.getMasterCard());
    	map.put("5555555555554444", CreditcardType.getMasterCard());
    	map.put("378282246310005", CreditcardType.getAmex());
    	map.put("4111111111111111", CreditcardType.getVisa());
    	map.put("3528000000000007", CreditcardType.getJCB());
    	map.put("3528000000000015", CreditcardType.getJCB());
    	map.put("3528000000000023", CreditcardType.getJCB());
    	map.put("36666666666660", CreditcardType.getDiners());
    	
    	for(String number : map.keySet()) {
    		for(CreditcardType type : CreditcardType.getAll()) {
 
       			String message = number + " : " + type + " : ";
     			TypeValidatorUtil util = new TypeValidatorUtil(type);
       			boolean result = util.isCreditcardNumber(number);
   
     			if(type.equals(map.get(number))) {
    				assertTrue(message + "false", result);
    			} else {
    				assertFalse(message + "true", result);    				
    			}

    		}
    	}
    	
    }
	
}
