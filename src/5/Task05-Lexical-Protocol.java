import static org.junit.Assert.*;

import org.junit.Test;

public class CTest {

        @Test
        public void tm1() {
                C c = new C();
                assertEquals(0, c.m1());
                assertTrue(c.empty());                
                c.m2("Some string");
                assertEquals(1, c.m1());
                assertFalse(c.empty());
                c.m2("Another");
                assertEquals(2, c.m1());
                c.m2("Li");
                assertEquals(3, c.m1());
                c.m2("Kim", 5);
                assertEquals(8, c.m1());
                c.clear();
                assertEquals(0, c.m1());                
        }

//        @Test
//        public void tm2() {
//                C c = new C();
//                c.m2("Marlene");
//                c.m2("Eric");
//                c.m2("Marlene");
//                c.m2("Eric");
//                c.m2("Marlene");
//                // This code was refactored to a loop (now we know there are 333 "A"'s)
//                for (int var = 1; var <= 333; var++)
//                        c.m2("A");
//                assertEquals(338, c.m1());
//                assertEquals(3, c.m3("Marlene"));
//                assertEquals(2, c.m3("Eric"));
//                assertEquals(0, c.m3("Not here"));
//                assertEquals(333, c.m3("A"));
//        }

        @Test
        public void tm3() {
                C c = new C();
                assertEquals("[]", c.m4());
                c.m2("Al");
                assertEquals("[Al]", c.m4());
                c.m2("Jo");
                assertEquals("[Al, Jo]", c.m4());
                c.m2("Li");
                c.m2("Cy");
                c.m2("Ed");
                assertEquals("[Al, Jo, Li, Cy, Ed]", c.m4());
        }

        @Test
        public void tm4() {
                C c = new C();
                c.m5("not here");
                assertEquals("[]", c.m4());
        }

        @Test
        public void tm5() {
                C c = new C();
                c.m2("Li");
                c.m2("Cy");
                c.m2("Ed");
                assertTrue(c.m5("Li"));
                assertEquals("[Cy, Ed]", c.m4());
        }

        @Test
        public void tm6() {
                C c = new C();
                c.m2("Li");
                c.m2("Cy");
                c.m2("Li");
                c.m2("Ed");
                c.m2("Li");
                assertTrue(c.m5("Li"));
                assertEquals("[Cy, Li, Ed, Li]", c.m4());
                assertTrue(c.removeAll("Li"));
                assertEquals("[Cy, Ed]", c.m4());
        }

        @Test
        public void tm7() {
                C c = new C();
                c.m2("Li");
                c.m2("Cy");
                c.m2("Ed");
                c.m5("Li");
                assertEquals("[Cy, Ed]", c.m4());
                c.m5("Cy");
                assertEquals("[Ed]", c.m4());
                c.m5("Ed");
                assertEquals("[]", c.m4());
                assertFalse(c.m5("Ed"));
                assertEquals("[]", c.m4());
        }

        @Test
        public void tm8() {
                C c = new C();
                c.m2("Li");
                c.m2("Cy");
                c.m2("Ed");
                assertFalse(c.m5("Not here"));
                assertEquals("[Li, Cy, Ed]", c.m4());
        }

}
