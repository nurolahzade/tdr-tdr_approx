//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

//import java.util.HashMap;
//import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Before;
import org.junit.Test;

public class CreditcardUtilTest {

	private SomeSortOfCollection<X, CreditcardType> map;
	private TypeValidatorUtil util;
	
	@Before
	public void setUp() {
    	map = new SomeSortOfCollectionImplementation<X, CreditcardType>();
    	map.put(new X("5555444455554442"), CreditcardType.MASTERCARD);
//    	map.put(new X("5555555555554444"), CreditcardType.MASTERCARD);
    	map.put(new X("378282246310005"), CreditcardType.AMEX);
    	map.put(new X("4111111111111111"), CreditcardType.VISA);
    	map.put(new X("3528000000000007"), CreditcardType.JCB);
//    	map.put(new X("3528000000000015"), CreditcardType.JCB);
    	map.put(new X("3528000000000023"), CreditcardType.JCB);
    	map.put(new X("36666666666660"), CreditcardType.DINERS);
    	
    	util = TypeValidatorFactory.makeTypeValidatorUtil();
	}
	
    @Test
    public void isValid() {    	
    	Iterator<X> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		X number = iterator.next();
    		for(CreditcardType type : CreditcardType.values()) {
 
       			int result = util.isCreditcardNumber(number, type, CreditCardType.FLAG, true);
       			assertTrue((type == map.get(number)) == (result > 0));
    		}
    	}
    	
    }
	
}
