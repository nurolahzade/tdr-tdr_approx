import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import protocol.Base64Util;

public class Base64UtilTest {

	Base64Util util;
	
	@Before
	public void setUp() {
		util = new Base64Util();
	}

//	@Test
//    public void testEncodeString() {
////        final String text = "--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---";
//    	final String text = "This is a test \n\t\r ===+ \u2076 %$#@";
//        String base64 = Base64Util.encodeString(text);
//        String restore = Base64Util.decodeString(base64);
//        assertEquals(text, restore);
//    }

    @Test
    public void testEncode() {
//        final byte[] data = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".getBytes();
        final byte[] data = "This is a test \n\t\r ===+ \u2076 %$#@".getBytes();
        String base64 = util.encode(data);
        byte[] restore = util.decode(base64);
//        assertEquals(data.length, restore.length);
//        for(int i=0; i<data.length; i++) {
//            assertEquals(data[i], restore[i]);
//        }
        assertArrayEquals(data, restore);
    }

//    @Test
//    public void testDecodeBadBase64() {
//        final String base64 = "ABCDEFG@@@\u3000\n\n@@..=";
//        assertNull(Base64Util.decode(base64));
//    }
}
