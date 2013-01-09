import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import protocol.Base64Util;

public class CTest {

	C c;
	
	@Before
	public void setUp() {
		c = new C();
	}

	final StringBuffer var1 = new StringBuffer("This is a test \n\t\r ===+ \u2076 %$#@");
	final char[] var4 = "This is a test \n\t\r ===+ \u2076 %$#@".toCharArray();
	
//    @Test
//    public void testMethod1() {
//        StringBuffer var2 = C.m1(var1, true);
//        StringBuffer var3 = C.m2(var2, true);
//        assertEquals(var1, var3);
//    }

    @Test
    public void testMethod2() {
        StringBuilder var2 = c.m3(var1, 10);
        char[] var3 = c.m4(1, var2);
        assertArrayEquals(var4, var3);
    }

//    @Test
//    public void testMethod3() {
//        final StringBuilder var1 = new StringBuilder("ABCDEFG@@@\u3000\n\n@@..=");
//        assertNull(C.m4(C.FLAG, var1));
//    }
}
