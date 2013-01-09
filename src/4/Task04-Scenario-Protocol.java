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
    	map.put("5555444455554442", CreditcardType.getMasterCard());
//    	map.put("5555555555554444", CreditcardType.MASTERCARD);
    	map.put("378282246310005", CreditcardType.getAmex());
    	map.put("4111111111111111", CreditcardType.getVisa());
    	map.put("4000080706200002", CreditcardType.getVisa());
    	map.put("3528000000000007", CreditcardType.getJCB());
//    	map.put("3528000000000015", CreditcardType.JCB);
    	map.put("3528000000000023", CreditcardType.getJCB());
    	map.put("36666666666660", CreditcardType.getDiners());				
	}
	
    @Test
    public void isValid() {    	
    	Iterator<String> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		String number = iterator.next();
    		for(CreditcardType type : CreditcardType.getAll()) {
 
    	    	util = new TypeValidatorUtil(type);
       			boolean result = util.isCreditcardNumber(number);
   
       			assertEquals(type == map.get(number), result);
    		}
    	}
    	
    }
	
}
