import static org.junit.Assert.*;

import org.junit.Test;

public class Base64UtilTest {

	final StringBuffer text = new StringBuffer("--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---");
    final char[] data = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".toCharArray();
	
    @Test
    public void testEncodeString() {        
        StringBuffer base64 = Base64Util.encodeString(new StringBuilder(text), true);
        StringBuffer restore = Base64Util.decodeString(base64, true);
        assertEquals(text, restore);
    }

    @Test
    public void testEncode() {
        StringBuffer base64 = Base64Util.encode(data, 10);
        char[] restore = Base64Util.decode(1, base64);
//        assertEquals(data.length, restore.length);
//        for(short i=0; i<data.length; i++) {
//            assertEquals(data[i], restore[i]);
//        }
        assertArrayEquals(data, restore);
    }

    @Test
    public void testDecodeBadBase64() {
        final StringBuilder base64 = new StringBuilder("ABCDEFG@@@\u3000\n\n@@..=");
        assertNull(Base64Util.decode(Base64Util.FLAG, new StringBuilder(base64)));
    }
}
