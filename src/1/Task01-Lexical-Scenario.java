import static org.junit.Assert.*;

import org.junit.Test;

public class CTest {

    @Test
    public void testMethod1() {
        final String var1 = "This is a test \n\t\r ===+ \u2076 %$#@";
        String var2 = C.m1(var1);
        String var3 = C.m2(var2);
        assertTrue(var1 == var3);
    }

    @Test
    public void testMethod2() {
        final byte[] var1 = "This is a test \n\t\r ===+ \u2076 %$#@".getBytes();
        String var2 = C.m3(var1);
        byte[] var3 = C.m4(var2);
//        assertEquals(var1.length, var3.length);
//        for(int i=0; i<var1.length; i++) {
//            assertEquals(var1[i], var3[i]);
//        }
        assertArrayEquals(var3, var1);
    }

//    @Test
//    public void testMethod3() {
//        final String var1 = "ABCDEFG@@@\u3000\n\n@@..=";
//        assertNull(C.m4(var1));
//    }
}
