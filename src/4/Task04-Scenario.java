//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Before;
import org.junit.Test;

public class CreditcardUtilTest {

	private Map<String, CreditcardType> map;
	private TypeValidatorUtil util;
	
	@Before
	public void setUp() {
    	map = new HashMap<String, CreditcardType>();
    	map.put("5555444455554442", CreditcardType.MASTERCARD);
//    	map.put("5555555555554444", CreditcardType.MASTERCARD);
    	map.put("378282246310005", CreditcardType.AMEX);
    	map.put("4111111111111111", CreditcardType.VISA);
    	map.put("4000080706200002", CreditcardType.VISA);
    	map.put("3528000000000007", CreditcardType.JCB);
//    	map.put("3528000000000015", CreditcardType.JCB);
    	map.put("3528000000000023", CreditcardType.JCB);
    	map.put("36666666666660", CreditcardType.DINERS);		
		
    	util = new TypeValidatorUtil();
	}
	
    @Test
    public void isValid() {    	
    	Iterator<String> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		String number = iterator.next();
    		for(CreditcardType type : CreditcardType.values()) {
 
       			boolean result = util.isCreditcardNumber(number, type);
       			assertEquals(type == map.get(number), result);       			
    		}
    	}
    	
    }
	
}
