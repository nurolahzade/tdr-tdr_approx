//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import java.util.HashMap;
//import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Test;

public class CreditcardUtilTest {

    @Test
    public void isValid() {
    	
    	SomeSortOfCollection<X, CreditcardType> map = new SomeSortOfCollectionImplementation<X, CreditcardType>();
    	map.put(new X("5555444455554442"), CreditcardType.MASTERCARD);
    	map.put(new X("5555555555554444"), CreditcardType.MASTERCARD);
    	map.put(new X("378282246310005"), CreditcardType.AMEX);
    	map.put(new X("4111111111111111"), CreditcardType.VISA);
    	map.put(new X("3528000000000007"), CreditcardType.JCB);
    	map.put(new X("3528000000000015"), CreditcardType.JCB);
    	map.put(new X("3528000000000023"), CreditcardType.JCB);
    	map.put(new X("36666666666660"), CreditcardType.DINERS);
    	
    	for(X number : map.keySet()) {
    		for(CreditcardType type : CreditcardType.values()) {
 
       			String message = number + " : " + type + " : ";
     			TypeValidatorUtil util = TypeValidatorFactory.makeTypeValidatorUtil();
       			int result = util.isCreditcardNumber(number, type, CreditCardType.FLAG, true);
   
     			if(type == map.get(number)) {
    				assertTrue(message + "false", result > 0);
    			} else {
    				assertFalse(message + "true", result > 0);
    			}

    		}
    	}
    	
    }
	
}
