import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringBagTest {

	private StringBag sb;
	
	@Before
	public void setUp() {
        sb = new StringBag();		
	}
	
        @Test
        public void testSizeAndAdd() {
                assertEquals(0, sb.size());
                assertEquals(sb.empty(), true);
                sb.add("A string");
                assertEquals(1, sb.size());
                assertFalse(sb.empty());
                sb.add("Another");
                assertEquals(2, sb.size());
//                sb.add("Li");
//                assertEquals(3, sb.size());
//                sb.add("Kim");
//                assertEquals(4, sb.size());
        }

//        @Test
//        public void testOccurencesOf() {
//                sb.add("Marlene");
//                sb.add("Eric");
//                sb.add("Marlene");
//                sb.add("Eric");
//                sb.add("Marlene");
//                sb.add("James");
//                // This code was refactored to a loop (now we know there are 333 "A"'s)
//                for (int count = 1; count <= 333; count++)
//                        sb.add("A");
//                assertEquals(339, sb.size());
//                assertEquals(3, sb.occurencesOf("Marlene"));
//                assertEquals(2, sb.occurencesOf("Eric"));
//                assertEquals(0, sb.occurencesOf("Not here"));
//                assertEquals(333, sb.occurencesOf("A"));
//        }

        @Test
        public void testToString() {
                assertEquals("[]", sb.toString());
                sb.add("Al");
                assertEquals("[Al]", sb.toString());
                sb.add("Jo");
                assertEquals("[Al, Jo]", sb.toString());
                sb.add("Li");
                sb.add("Cy");
                sb.add("Ed");
                assertEquals("[Al, Jo, Li, Cy, Ed]", sb.toString());
        }

        @Test
        public void testRemoveWhenEmpty() {
                sb.remove("not here");
                assertEquals("[]", sb.toString());
        }

        @Test
        public void testRemoveWhenOnlyOne() {
                sb.add("Li");
                sb.add("Cy");
                sb.add("Ed");
                assertEquals(sb.remove("Li"), true);
                assertEquals("[Cy, Ed]", sb.toString());
        }

//        @Test
//        public void testRemoveWhenMoreThanOne() {
//                StringBag sb = new StringBag();
//                sb.add("Li");
//                sb.add("Cy");
//                sb.add("Li");
//                sb.add("Ed");
//                sb.add("Li");
//                assertTrue(sb.remove("Li"));
//                assertEquals("[Cy, Li, Ed, Li]", sb.toString());
//                assertTrue(sb.remove("Li"));
//                assertEquals("[Cy, Ed, Li]", sb.toString());
//                assertTrue(sb.remove("Li"));
//                assertEquals("[Cy, Ed]", sb.toString());
//                assertFalse(sb.remove("Li"));
//                assertEquals("[Cy, Ed]", sb.toString());
//        }
//
//        @Test
//        public void testRemoveUntilEmpty() {
//                StringBag sb = new StringBag();
//                sb.add("Li");
//                sb.add("Cy");
//                sb.add("Ed");
//                sb.remove("Li");
//                assertEquals("[Cy, Ed]", sb.toString());
//                sb.remove("Cy");
//                assertEquals("[Ed]", sb.toString());
//                sb.remove("Ed");
//                assertEquals("[]", sb.toString());
//                assertFalse(sb.remove("Ed"));
//                assertEquals("[]", sb.toString());
//        }
//
//        @Test
//        public void testRemoveWhenNotHere() {
//                StringBag sb = new StringBag();
//                sb.add("Li");
//                sb.add("Cy");
//                sb.add("Ed");
//                assertFalse(sb.remove("Not here"));
//                assertEquals("[Li, Cy, Ed]", sb.toString());
//        }

}
