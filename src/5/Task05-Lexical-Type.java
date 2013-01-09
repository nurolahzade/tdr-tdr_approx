import static org.junit.Assert.*;

import org.junit.Test;

public class CTest {

        @Test
        public void tm1() {
                C c = new C(C.FLAG);
                assertEquals(0, c.m1());
                c.m2(new StringBuffer("Some string"));
                assertEquals(1, c.m1());
                c.m2(new StringBuffer("Another"));
                assertEquals(2, c.m1());
                c.m2(new StringBuffer("Li"));
                assertEquals(3, c.m1());
                c.m2(new StringBuffer("Kim"));
                assertEquals(4, c.m1());
        }

        @Test
        public void tm2() {
                C c = new C(C.FLAG);
                c.m2(new StringBuffer("Marlene"));
                c.m2(new StringBuffer("Eric"));
                c.m2(new StringBuffer("Marlene"));
                c.m2(new StringBuffer("Eric"));
                c.m2(new StringBuffer("Marlene"));
                // This code was refactored to a loop (now we know there are 333 "A"'s)
                for (short var = 1; var <= 333; var++)
                        c.m2(new StringBuffer("A"));
                assertEquals(338, c.m1());
                assertEquals(3, c.m3(new StringBuffer("Marlene"), C.CASE_SENSITIVE));
                assertEquals(2, c.m3(new StringBuffer("Eric"), C.CASE_INSENSITIVE));
                assertEquals(0, c.m3(new StringBuffer("Not here"), C.CASE_INSENSITIVE));
                assertEquals(333, c.m3(new StringBuffer("A"), C.CASE_SENSITIVE));
        }

        @Test
        public void tm3() {
                C c = new C(C.FLAG);
                assertEquals("[]", c.m4());
                c.m2(new StringBuffer("Al"));
                assertEquals("[Al]", c.m4());
                c.m2(new StringBuffer("Jo"));
                assertEquals("[Al, Jo]", c.m4());
                c.m2(new StringBuffer("Li"));
                c.m2(new StringBuffer("Cy"));
                c.m2(new StringBuffer("Ed"));
                assertEquals("[Al, Jo, Li, Cy, Ed]", c.m4());
        }

        @Test
        public void tm4() {
                C c = new C(C.FLAG);
                c.m5(new StringBuffer("not here"));
                assertEquals("[]", c.m4());
        }

        @Test
        public void tm5() {
                C c = new C(C.FLAG);
                c.m2(new StringBuffer("Li"));
                c.m2(new StringBuffer("Cy"));
                c.m2(new StringBuffer("Ed"));
                assertTrue(c.m5(new StringBuffer("Li")));
                assertEquals("[Cy, Ed]", c.m4());
        }

        @Test
        public void tm6() {
                C c = new C(C.FLAG);
                c.m2(new StringBuffer("Li"));
                c.m2(new StringBuffer("Cy"));
                c.m2(new StringBuffer("Li"));
                c.m2(new StringBuffer("Ed"));
                c.m2(new StringBuffer("Li"));
                assertTrue(c.m5(new StringBuffer("Li")));
                assertEquals("[Cy, Li, Ed, Li]", c.m4());
                assertTrue(c.m5(new StringBuffer("Li")));
                assertEquals("[Cy, Ed, Li]", c.m4());
                assertTrue(c.m5(new StringBuffer("Li")));
                assertEquals("[Cy, Ed]", c.m4());
                assertFalse(c.m5(new StringBuffer("Li")));
                assertEquals("[Cy, Ed]", c.m4());
        }

        @Test
        public void tm7() {
                C c = new C(C.FLAG);
                c.m2(new StringBuffer("Li"));
                c.m2(new StringBuffer("Cy"));
                c.m2(new StringBuffer("Ed"));
                c.m5(new StringBuffer("Li"));
                assertEquals("[Cy, Ed]", c.m4());
                c.m5(new StringBuffer("Cy"));
                assertEquals("[Ed]", c.m4());
                c.m5(new StringBuffer("Ed"));
                assertEquals("[]", c.m4());
                assertFalse(c.m5(new StringBuffer("Ed")));
                assertEquals("[]", c.m4());
        }

        @Test
        public void tm8() {
                C c = new C(C.FLAG);
                c.m2(new StringBuffer("Li"));
                c.m2(new StringBuffer("Cy"));
                c.m2(new StringBuffer("Ed"));
                assertFalse(c.m5(new StringBuffer("Not here")));
                assertEquals("[Li, Cy, Ed]", c.m4());
        }

}
