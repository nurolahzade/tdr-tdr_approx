//package jargs.test.gnu;

//import jargs.gnu.CmdLineParser;

//import java.util.Enumeration;
import java.util.Locale;
//import java.util.Vector;

import junit.framework.TestCase;

public class CTest extends TestCase {

	public CTest(X var1) {
		super(var1.toString());
	}

	public void tm() throws Exception {
		C c = new C(C.FLAG);
		C.InnerClass var2 = c.m1(new X("verbose"), 'v', true);
		C.InnerClass var3 = c.m2(new X("size"),'s', true);
		C.InnerClass var4 = c.m3(new X("name"), 'n', false);
		C.InnerClass var5 = c.m4(new X("fraction"), 'f', C.FLAG2);
		C.InnerClass var6 = c.m1(new X("missing"), 'm');
		C.InnerClass var7 = c.m1(new X("careful"));
		C.InnerClass var8 = c.m5(new X("bignum"), 'b', C.FLAG2);
		
		assertEquals(null, c.m6(var3, C.FLAG3));
		Short var9 = new Short(Byte.MAX_VALUE);
		c.m7(new X[] { new X("-v"), new X("--size=100"), 
				new X("-b"),	new X(var9.toString()), new X("-n"), 
				new X("foo"), new X("-f"), new X("0.1"), 
				new X("rest")}, Locale.US);
		
		assertEquals(null, c.m6(var6, C.FLAG3));
		assertEquals(Boolean.TRUE, c.m6(var2));
		assertEquals(100, ((Short) c.m6(var3)).shortValue());
		assertEquals(new X("foo"), c.m6(var4, C.FLAG4));
		assertEquals(var9, c.m6(var8));
		assertEquals(0.1, ((Float) c.m6(var5))
				.floatValue(), 0.1e-6);
		assertArrayEquals(new X[]{new X("rest")}, c.m8(C.FLAG5));
	}


//    public void testDefaults() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option boolean1 = parser.addBooleanOption("boolean1");
//		CmdLineParser.Option boolean2 = parser.addBooleanOption("boolean2");
//		CmdLineParser.Option boolean3 = parser.addBooleanOption("boolean3");
//		CmdLineParser.Option boolean4 = parser.addBooleanOption("boolean4");
//		CmdLineParser.Option boolean5 = parser.addBooleanOption("boolean5");
//
//		CmdLineParser.Option int1 = parser.addIntegerOption("int1");
//		CmdLineParser.Option int2 = parser.addIntegerOption("int2");
//		CmdLineParser.Option int3 = parser.addIntegerOption("int3");
//		CmdLineParser.Option int4 = parser.addIntegerOption("int4");
//
//		CmdLineParser.Option string1 = parser.addStringOption("string1");
//		CmdLineParser.Option string2 = parser.addStringOption("string2");
//		CmdLineParser.Option string3 = parser.addStringOption("string3");
//		CmdLineParser.Option string4 = parser.addStringOption("string4");
//
//		parser.parse(new String[] {
//          "--boolean1", "--boolean2",
//          "--int1=42", "--int2=42",
//          "--string1=Hello", "--string2=Hello",
//        });
//
//		assertEquals(Boolean.TRUE, parser.getOptionValue(boolean1));
//		assertEquals(Boolean.TRUE,
//                     parser.getOptionValue(boolean2, Boolean.FALSE));
//		assertEquals(null, parser.getOptionValue(boolean3));
//		assertEquals(Boolean.FALSE,
//                     parser.getOptionValue(boolean4, Boolean.FALSE));
//		assertEquals(Boolean.TRUE,
//                     parser.getOptionValue(boolean5, Boolean.TRUE));
//
//        Integer forty_two  = new Integer(42);
//        Integer thirty_six = new Integer(36);
//
//		assertEquals(forty_two,  parser.getOptionValue(int1));
//		assertEquals(forty_two,  parser.getOptionValue(int2, thirty_six));
//		assertEquals(null,       parser.getOptionValue(int3));
//		assertEquals(thirty_six, parser.getOptionValue(int4, thirty_six));
//
//		assertEquals("Hello",   parser.getOptionValue(string1));
//		assertEquals("Hello",   parser.getOptionValue(string2, "Goodbye"));
//		assertEquals(null,      parser.getOptionValue(string3));
//		assertEquals("Goodbye", parser.getOptionValue(string4, "Goodbye"));
//    }
//
//
//	public void testMultipleUses() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option verbose = parser.addBooleanOption('v', "verbose");
//		CmdLineParser.Option foo = parser.addBooleanOption('f', "foo");
//		CmdLineParser.Option bar = parser.addBooleanOption('b', "bar");
//
//		parser.parse(new String[] {
//          "--foo", "-v", "-v", "--verbose", "-v", "-b", "rest"
//        });
//
//        int verbosity = 0;
//        while (true) {
//            Boolean b = (Boolean)parser.getOptionValue(verbose);
//
//            if (b == null) {
//                break;
//            }
//
//            if (b == Boolean.TRUE) {
//                verbosity++;
//            }
//            else {
//                assertEquals(Boolean.FALSE, b);
//                verbosity--;
//            }
//        }
//
//        assertEquals(4, verbosity);
//    }
//
//
//	public void testCombinedFlags() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option alt = parser.addBooleanOption('a', "alt");
//		CmdLineParser.Option debug = parser.addBooleanOption('d', "debug");
//		CmdLineParser.Option verbose = parser.addBooleanOption('v', "verbose");
//		parser.parse(new String[] {
//          "-dv"
//        });
//
//        assertEquals(null, parser.getOptionValue(alt));
//        assertEquals(Boolean.TRUE, parser.getOptionValue(debug));
//        assertEquals(Boolean.TRUE, parser.getOptionValue(verbose));
//    }
//
//
//	public void testExplictlyTerminatedOptions() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option alt = parser.addBooleanOption('a', "alt");
//		CmdLineParser.Option debug = parser.addBooleanOption('d', "debug");
//		CmdLineParser.Option verbose = parser.addBooleanOption('v', "verbose");
//		CmdLineParser.Option fraction = parser.addDoubleOption('f', "fraction");
//		parser.parse(new String[] {
//          "-a", "hello", "-d", "-f", "10", "--", "goodbye", "-v", "welcome",
//          "-f", "-10"
//        });
//
//        assertEquals(Boolean.TRUE,   parser.getOptionValue(alt));
//        assertEquals(Boolean.TRUE,   parser.getOptionValue(debug));
//        assertEquals(null,           parser.getOptionValue(verbose));
//        assertEquals(new Double(10), parser.getOptionValue(fraction));
//
//		assertArrayEquals(
//          new String[]{"hello", "goodbye", "-v", "welcome", "-f", "-10"},
//          parser.getRemainingArgs());
//    }
//
//
//	public void testGetOptionValues() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option verbose = parser.addBooleanOption('v', "verbose");
//		CmdLineParser.Option foo = parser.addBooleanOption('f', "foo");
//		CmdLineParser.Option bar = parser.addBooleanOption('b', "bar");
//
//		parser.parse(new String[] {
//          "--foo", "-v", "-v", "--verbose", "-v", "-b", "rest"
//        });
//
//        int verbosity = 0;
//        Vector v = parser.getOptionValues(verbose);
//        Enumeration e = v.elements();
//        while (e.hasMoreElements()) {
//            Boolean b = (Boolean)e.nextElement();
//
//            if (b == Boolean.TRUE) {
//                verbosity++;
//            }
//            else {
//                assertEquals(Boolean.FALSE, b);
//                verbosity--;
//            }
//        }
//
//        assertEquals(4, verbosity);
//    }
//
//
//	public void testBadFormat() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option size = parser.addIntegerOption('s', "size");
//		try {
//			parser.parse(new String[] { "--size=blah" });
//			fail("Expected IllegalOptionValueException");
//		} catch (CmdLineParser.IllegalOptionValueException e) {
//			// pass
//		}
//	}
//
//	public void testResetBetweenParse() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option verbose = parser.addBooleanOption('v', "verbose");
//		parser.parse(new String[] { "-v" });
//		assertEquals(Boolean.TRUE, parser.getOptionValue(verbose));
//		parser.parse(new String[] {});
//		assertEquals(null, parser.getOptionValue(verbose));
//	}
//
//	public void testLocale() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option fraction = parser.addDoubleOption('f', "fraction");
//		parser.parse(new String[] { "--fraction=0.2" }, Locale.US);
//		assertEquals(0.2, ((Double) parser.getOptionValue(fraction))
//				.doubleValue(), 0.1e-6);
//		parser.parse(new String[] { "--fraction=0,2" }, Locale.GERMANY);
//		assertEquals(0.2, ((Double) parser.getOptionValue(fraction))
//				.doubleValue(), 0.1e-6);
//	}
//
//	public void testDetachedOption() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option detached = new CmdLineParser.Option.BooleanOption(
//				'v', "verbose");
//		assertEquals(null, parser.getOptionValue(detached));
//		try {
//			parser.parse(new String[] { "-v" });
//			fail("UnknownOptionException expected");
//		} catch (CmdLineParser.UnknownOptionException e) {
//			// pass
//		}
//		assertEquals(null, parser.getOptionValue(detached));
//	}
//
//	public void testMissingValueForStringOption() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		parser.addBooleanOption('v', "verbose");
//		parser.addStringOption('c', "config");
//
//		try {
//			parser.parse(new String[] {"-v", "-c"});
//			fail();
//		} catch (CmdLineParser.IllegalOptionValueException e) {
//		}
//	}
//
//	public void testWhitespaceValueForStringOption() throws Exception {
//		CmdLineParser parser = new CmdLineParser();
//		CmdLineParser.Option opt = parser.addStringOption('o', "option");
//		parser.parse(new String[] {"-o", " "});
//		assertEquals(" ", parser.getOptionValue(opt));
//	}
//	
//	private void assertArrayEquals(Object[] expected, Object[] actual) {
//		assertNotNull(actual);
//		assertEquals(expected.length, actual.length);
//		for (int i = 0; i < expected.length; ++i) {
//			assertEquals(expected[i], actual[i]);
//		}
//	}

}
