import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Base64UtilTest {

	Base64Util util;
    final char[] data = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".toCharArray();
	
	@Before
	public void setUp() {
		util = new Base64Util();
	}	
	
//    @Test
//    public void testEncodeString() {
//        final String text = "--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---";
//        StringBuilder base64 = Base64Util.encodeString(new StringBuilder(text), true);
//        StringBuilder restore = Base64Util.decodeString(base64, true);
//        assertEquals(text, restore);
//    }

    @Test
    public void testEncode() {
        StringBuilder base64 = util.encode(data, 10);
        char[] restore = util.decode(1, base64);
//        assertEquals(data.length, restore.length);
//        for(int i=0; i<data.length; i++) {
//            assertEquals(data[i], restore[i]);
//        }
        assertArrayEquals(data, restore);
    }

//    @Test
//    public void testDecodeBadBase64() {
//        final StringBuilder base64 = new StringBuilder("ABCDEFG@@@\u3000\n\n@@..=");
//        assertNull(util.decode(Base64Util.FLAG, base64));
//    }
}
