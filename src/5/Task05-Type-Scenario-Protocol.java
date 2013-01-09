import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringBagTest {

	private StringBag sb;
	
	@Before
	public void setUp() {
        sb = new StringBag(StringBag.FLAG);		
	}

        @Test
        public void testSizeAndAdd() {
                assertEquals(0, sb.size());
                assertTrue(sb.empty());
                sb.add(new StringBuffer("Some string"));
                assertFalse(sb.empty());
                assertEquals(1, sb.size());
                sb.add(new StringBuffer("Another"), 5);
                assertEquals(6, sb.size());
//                sb.add(new StringBuffer("Li"));
//                assertEquals(3, sb.size());
//                sb.add(new StringBuffer("Kim"));
//                assertEquals(4, sb.size());
                sb.clear();
                assertEquals(0, sb.size());                
        }

//        @Test
//        public void testOccurencesOf() {
//                sb.add(new StringBuffer("Marlene"));
//                sb.add(new StringBuffer("Eric"));
//                sb.add(new StringBuffer("Marlene"));
//                sb.add(new StringBuffer("Eric"));
//                sb.add(new StringBuffer("Marlene"));
//                sb.add(new StringBuffer("James"));
//                // This code was refactored to a loop (now we know there are 333 "A"'s)
//                for (short count = 1; count <= 333; count++)
//                        sb.add(new StringBuffer("A"));
//                assertEquals(339, sb.size());
//                assertEquals(3, sb.occurencesOf(new StringBuffer("Marlene"), StringBag.CASE_SENSITIVE));
//                assertEquals(2, sb.occurencesOf(new StringBuffer("Eric"), StringBag.CASE_INSENSITIVE));
//                assertEquals(0, sb.occurencesOf(new StringBuffer("Not here"), StringBag.CASE_INSENSITIVE));
//                assertEquals(333, sb.occurencesOf(new StringBuffer("A"), StringBag.CASE_SENSITIVE));
//        }

        @Test
        public void testToString() {
                assertEquals("[]", sb.toString());
                sb.add(new StringBuffer("Al"));
                assertEquals("[Al]", sb.toString());
                sb.add(new StringBuffer("Jo"));
                assertEquals("[Al, Jo]", sb.toString());
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Cy"));
                sb.add(new StringBuffer("Ed"));
                assertEquals("[Al, Jo, Li, Cy, Ed]", sb.toString());
        }

        @Test
        public void testRemoveWhenEmpty() {
                assertEquals(0, sb.remove(new StringBuffer("not here")));
                assertEquals("[]", sb.toString());
        }

        @Test
        public void testRemoveWhenOnlyOne() {
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Cy"));
                sb.add(new StringBuffer("Ed"));
                assertEquals(0, sb.remove(new StringBuffer("Li")));
                assertEquals("[Cy, Ed]", sb.toString());
        }

//        @Test
//        public void testRemoveWhenMoreThanOne() {
//                sb.add(new StringBuffer("Li"));
//                sb.add(new StringBuffer("Cy"));
//                sb.add(new StringBuffer("Li"));
//                sb.add(new StringBuffer("Ed"));
//                sb.add(new StringBuffer("Li"));
//                assertEquals(2, sb.remove(new StringBuffer("Li")));
//                assertEquals("[Cy, Li, Ed, Li]", sb.toString());
//                assertEquals(1, sb.remove(new StringBuffer("Li")));
//                assertEquals("[Cy, Ed, Li]", sb.toString());
//                assertEquals(0, sb.remove(new StringBuffer("Li")));
//                assertEquals("[Cy, Ed]", sb.toString());
//                assertEquals(0, sb.remove(new StringBuffer("Li")));
//                assertEquals("[Cy, Ed]", sb.toString());
//        }
//
//        @Test
//        public void testRemoveUntilEmpty() {
//                sb.add(new StringBuffer("Li"));
//                sb.add(new StringBuffer("Cy"));
//                sb.add(new StringBuffer("Ed"));
//                sb.remove(new StringBuffer("Li"));
//                assertEquals("[Cy, Ed]", sb.toString());
//                sb.remove(new StringBuffer("Cy"));
//                assertEquals("[Ed]", sb.toString());
//                sb.remove(new StringBuffer("Ed"));
//                assertEquals("[]", sb.toString());
//                assertEquals(0, sb.remove(new StringBuffer("Ed")));
//                assertEquals("[]", sb.toString());
//        }
//
//        @Test
//        public void testRemoveWhenNotHere() {
//                sb.add(new StringBuffer("Li"));
//                sb.add(new StringBuffer("Cy"));
//                sb.add(new StringBuffer("Ed"));
//                assertEquals(0, sb.remove(new StringBuffer("Not here")));
//                assertEquals("[Li, Cy, Ed]", sb.toString());
//        }

}
