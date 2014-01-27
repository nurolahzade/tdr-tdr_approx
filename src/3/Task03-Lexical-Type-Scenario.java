/*******************************************************************************
 * Copyright (c) 2009 David Harrison.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 *
 * Contributors:
 *     David Harrison - initial API and implementation
 ******************************************************************************/
//package com.sfs;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * The Class ConvertHtmlToTextTest.
 *
 * @author David Harrison
 */
public class CTest {

    /**
     * Instantiates a new convert html to text test.
     */
    public CTest() {
    }

    /**
     * Test of convert method, of class ConvertHtmlToText.
     *
     * @throws Exception the exception
     */
    @Test
    public final void test1() throws Exception {
//        System.out.println("convert");

        C c = new C(C.FLAG);

        final X var1 = this.m1();
        final X var2 = c.m(true, m2(), 1);

        // System.out.println("Expected Result: " +
        // StringUtils.replace(expResult, "\n","~"));
        // System.out.println("Result: " + StringUtils.replace(result, "\n","~"));;

        assertTrue(var1.equals(var2));
        
        String var3 = "<html><head></head><body><p>Hello!</p></body></html>";
        String var4 = "Hello!\n";
        assertTrue(var4.equals(c.m(false, var3, 0)));        
    }

    /**
     * Gets the source.
     *
     * @return the source
     */
    private X m2() {
    	X var = new X();

        var.append("<html>");
        var.append("<head>");
        var.append("<title> favorites / bookmark title goes here </title>");
        var.append("<style type=\"text/css\">");
        var.append("body { color: purple; background-color: #d8da3d }");
        var.append("</style>");
        var.append("</head>");
        var.append("<body bgcolor=\"white\" text=\"blue\">");
        var.append("<h1>My first page </h1>");
        var.append("This is my first web page and I can say anything ");
//        var.append("I want in here.<br/>");
//        var.append("I do that by putting text or images in the body section.");
        var.append("<p>This is a test.</p>");
        var.append("<p>Where I'm typing right now :)</p>");
        var.append("<p>Some text with <a href=\"http://www.google.com\">a link</a>");
        var.append("followed by some text.</p>");
        var.append("<hr/>");
        var.append("<h3>Unordered list</h3>");
        var.append("<ul>");
        var.append("<li>Item one</li>");
        var.append("<li>Item two</li>");
        var.append("<li>Item three</li>");
        var.append("<li>Item four</li>");
        var.append("</ul>");
        var.append("<p>Good bye...</p>");
        var.append("</body>");
        var.append("</html>");

        return var;
    }

    /**
     * Gets the exp result.
     *
     * @return the exp result
     */
    private X m1() {
    	X var = new X();
        var.append("My first page \n");
        var.append("\n");
        var.append("This is my first web page and I can say anything ");
//        var.append("I want in here.\n");
//        var.append("I do that by putting text or images in the body section.\n");
        var.append("This is a test.\n");        
        var.append("Where I'm typing right now :)\n");
        var.append("\n");
        var.append("\n");
        var.append("Some text with a link [http://www.google.com] followed ");
        var.append("by some text.\n");
        var.append("\n");
        var.append("_________________________________________\n");
        var.append("\n");
        var.append("\n");
        var.append("Unordered list\n");
        var.append("\n");
        var.append("  * Item one\n");
        var.append("  * Item two\n");
        var.append("  * Item three\n");
        var.append("  * Item four\n");
        var.append("\n");
        var.append("\n");
        var.append("Good bye...");

        return var;
    }
}
