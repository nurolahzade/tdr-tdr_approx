//package jp.co.iret.suz.s2.validator.util;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

//import java.util.HashMap;
//import java.util.Map;

//import jp.co.iret.suz.s2.validator.type.CreditcardType;

import org.junit.Before;
import org.junit.Test;

public class CreditcardUtilTest {

	private SomeSortOfCollection<StringBuffer, CreditcardType> map;
	private TypeValidatorUtil util;
	
	@Before
	public void setUp() {
    	map = new SomeSortOfCollectionImplementation<StringBuffer, CreditcardType>();
    	map.put(new StringBuffer("5555444455554442"), CreditcardType.getMasterCard());
//    	map.put(new StringBuffer("5555555555554444"), CreditcardType.MASTERCARD);
    	map.put(new StringBuffer("378282246310005"), CreditcardType.getAmex());
    	map.put(new StringBuffer("4111111111111111"), CreditcardType.getVisa());
    	map.put(new StringBuffer("3528000000000007"), CreditcardType.getJCB());
//    	map.put(new StringBuffer("3528000000000015"), CreditcardType.JCB);
    	map.put(new StringBuffer("3528000000000023"), CreditcardType.getJCB());
    	map.put(new StringBuffer("36666666666660"), CreditcardType.getDiners());    	
	}
	
    @Test
    public void isValid() {    	
    	Iterator<StringBuffer> iterator = map.keySet().iterator();
    	while(iterator.hasNext()) {
    		StringBuffer number = iterator.next();
    		for(CreditcardType type : CreditcardType.getAll()) {
    	    	util = TypeValidatorFactory.makeTypeValidatorUtil(type);
       			int result = util.isCreditcardNumber(number, CreditCardType.FLAG, true);
       			assertEquals(type == map.get(number), result > 0);
    		}
    	}
    	
    }
	
}
