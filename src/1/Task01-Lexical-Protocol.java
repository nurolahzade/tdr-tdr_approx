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

//    @Test
//    public void testMethod1() {
//        final String var1 = "--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---";
//        String var2 = C.m1(var1);
//        String var3 = C.m2(var2);
//        assertEquals(var1, var3);
//    }

    @Test
    public void testMethod2() {
        final byte[] var1 = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".getBytes();
        String var2 = c.m3(var1);
        byte[] var3 = c.m4(var2);
        assertEquals(var1.length, var3.length);
        for(int i=0; i<var1.length; i++) {
            assertEquals(var1[i], var3[i]);
        }
    }

    @Test
    public void testMethod3() {
        final String var1 = "ABCDEFG@@@\u3000\n\n@@..=";
        assertNull(c.m4(var1));
    }
}
