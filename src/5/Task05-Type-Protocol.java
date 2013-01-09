import static org.junit.Assert.*;

import org.junit.Test;

public class StringBagTest {

        @Test
        public void testSizeAndAdd() {
                StringBag sb = new StringBag(StringBag.FLAG);
                assertEquals(0, sb.size());
                assertTrue(sb.empty());
                sb.add(new StringBuffer("Some string"));
                assertEquals(1, sb.size());
                assertFalse(sb.empty());
                sb.add(new StringBuffer("Another"));
                assertEquals(2, sb.size());
                sb.add(new StringBuffer("Li"));
                assertEquals(3, sb.size());
                sb.add(new StringBuffer("Kim"), 5);
                assertEquals(8, sb.size());
                sb.clear();
                assertEquals(0, sb.size());
        }

//        @Test
//        public void testOccurencesOf() {
//                StringBag sb = new StringBag(StringBag.FLAG);
//                sb.add(new StringBuffer("Marlene"));
//                sb.add(new StringBuffer("Eric"));
//                sb.add(new StringBuffer("Marlene"));
//                sb.add(new StringBuffer("Eric"));
//                sb.add(new StringBuffer("Marlene"));
//                // This code was refactored to a loop (now we know there are 333 "A"'s)
//                for (short count = 1; count <= 333; count++)
//                        sb.add(new StringBuffer("A"));
//                assertEquals(338, sb.size());
//                assertEquals(3, sb.occurencesOf(new StringBuffer("Marlene"), StringBag.CASE_SENSITIVE));
//                assertEquals(2, sb.occurencesOf(new StringBuffer("Eric"), StringBag.CASE_INSENSITIVE));
//                assertEquals(0, sb.occurencesOf(new StringBuffer("Not here"), StringBag.CASE_INSENSITIVE));
//                assertEquals(333, sb.occurencesOf(new StringBuffer("A"), StringBag.CASE_SENSITIVE));
//        }

        @Test
        public void testToString() {
                StringBag sb = new StringBag(StringBag.FLAG);
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
                StringBag sb = new StringBag(StringBag.FLAG);
                assertEquals(0, sb.remove(new StringBuffer("not here")));
                assertEquals("[]", sb.toString());
        }

        @Test
        public void testRemoveWhenOnlyOne() {
                StringBag sb = new StringBag(StringBag.FLAG);
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Cy"));
                sb.add(new StringBuffer("Ed"));
                assertEquals(0, sb.remove(new StringBuffer("Li")));
                assertEquals("[Cy, Ed]", sb.toString());
        }

        @Test
        public void testRemoveWhenMoreThanOne() {
                StringBag sb = new StringBag(StringBag.FLAG);
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Cy"));
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Ed"));
                sb.add(new StringBuffer("Li"));
                assertEquals(2, sb.remove(new StringBuffer("Li")));
                assertEquals("[Cy, Li, Ed, Li]", sb.toString());
                assertEquals(1, sb.removeAll(new StringBuffer("Li")));
                assertEquals("[Cy, Ed]", sb.toString());
        }

        @Test
        public void testRemoveUntilEmpty() {
                StringBag sb = new StringBag(StringBag.FLAG);
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Cy"));
                sb.add(new StringBuffer("Ed"));
                sb.remove(new StringBuffer("Li"));
                assertEquals("[Cy, Ed]", sb.toString());
                sb.remove(new StringBuffer("Cy"));
                assertEquals("[Ed]", sb.toString());
                sb.remove(new StringBuffer("Ed"));
                assertEquals("[]", sb.toString());
                assertEquals(0, sb.remove(new StringBuffer("Ed")));
                assertEquals("[]", sb.toString());
        }

        @Test
        public void testRemoveWhenNotHere() {
                StringBag sb = new StringBag(StringBag.FLAG);
                sb.add(new StringBuffer("Li"));
                sb.add(new StringBuffer("Cy"));
                sb.add(new StringBuffer("Ed"));
                assertEquals(0, sb.remove(new StringBuffer("Not here")));
                assertEquals("[Li, Cy, Ed]", sb.toString());
        }

}
