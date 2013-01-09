import static org.junit.Assert.*;

import org.junit.Test;

public class Base64UtilTest {

	final StringBuilder text = new StringBuilder("This is a test \n\t\r ===+ \u2076 %$#@");
    final char[] data = "This is a test \n\t\r ===+ \u2076 %$#@".toCharArray();

	@Test
    public void testEncodeString() {
//        final String text = "--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---";
        StringBuilder base64 = Base64Util.encodeString(text, true);
        StringBuilder restore = Base64Util.decodeString(base64, true);
        assertEquals(text, restore);
    }

    @Test
    public void testEncode() {
//        final byte[] data = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".getBytes();
        StringBuilder base64 = Base64Util.encode(data, 10);
        char[] restore = Base64Util.decode(1, base64);
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
