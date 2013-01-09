import static org.junit.Assert.*;

import org.junit.Test;

public class CTest {

	final StringBuffer var1 = new StringBuffer("--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---");
	final char[] var4 = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".toCharArray();
	
    @Test
    public void testMethod1() {
        StringBuffer var2 = C.m1(var1, true);
        StringBuffer var3 = C.m2(var2, true);
        assertEquals(var1, var3);
    }

    @Test
    public void testMethod2() {
        StringBuilder var2 = C.m3(var1, 10);
        char[] var3 = C.m4(1, var2);
        assertArrayEquals(var4, var3);
    }

    @Test
    public void testMethod3() {
        final StringBuilder var1 = new StringBuilder("ABCDEFG@@@\u3000\n\n@@..=");
        assertNull(C.m4(C.FLAG, var1));
    }
}
