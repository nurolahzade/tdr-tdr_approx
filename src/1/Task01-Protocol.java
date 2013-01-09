import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Base64UtilTest {
	
	Base64Util util;
	
	@Before
	public void setUp() {
		util = new Base64Util();
	}

//    @Test
//    public void testEncodeString() {
//        final String text = "--- abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz ---";
//        String base64 = util.encodeString(text);
//        String restore = util.decodeString(base64);
//        assertEquals(text, restore);
//    }

    @Test
    public void testEncode() {
        final byte[] data = "abcdefg \r\n hijklmn \t opqrst \u3000 uvwxyz".getBytes();
        String base64 = util.encode(data);
        byte[] restore = util.decode(base64);
        assertEquals(data.length, restore.length);
        for(int i=0; i<data.length; i++) {
            assertEquals(data[i], restore[i]);
        }
    }

    @Test
    public void testDecodeBadBase64() {
        final String base64 = "ABCDEFG@@@\u3000\n\n@@..=";
        assertNull(util.decode(base64));
    }
}
