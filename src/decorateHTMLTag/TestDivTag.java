package decorateHTMLTag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestDivTag {

    @Test
    void TestDivTagWithTextOnly() {
        DivTag divTag = new DivTag("This is a div");
        assertEquals("<div>This is a div</div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithNameAttribute() {
        DivTag divTag = new DivTag("This is a named div", "divName", true);
        assertEquals("<div name=\"divName\">This is a named div</div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithIDAttribute() {
        DivTag divTag = new DivTag("This is an ID div", "divID", false);
        assertEquals("<div id=\"divID\">This is an ID div</div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithNameAndIDAttributes() {
        DivTag divTag = new DivTag("This is a div with both attributes", "divName", "divID");
        assertEquals("<div id=\"divID\" name=\"divName\">This is a div with both attributes</div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithEmptyText() {
        DivTag divTag = new DivTag("", "divName", "divID");
        assertEquals("<div id=\"divID\" name=\"divName\"></div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithNullText() {
        DivTag divTag = new DivTag(null, "divName", "divID");
        assertEquals("<div id=\"divID\" name=\"divName\"></div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithEmptyAttributes() {
        DivTag divTag = new DivTag("This is a div", "", "");
        assertEquals("<div>This is a div</div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithNullAttributes() {
        DivTag divTag = new DivTag("This is a div", null, null);
        assertEquals("<div>This is a div</div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithAllEmpty() {
        DivTag divTag = new DivTag("", "", "");
        assertEquals("<div></div>", divTag.getHTMLTag());
    }

    @Test
    void TestDivTagWithAllNull() {
        DivTag divTag = new DivTag(null, null, null);
        assertEquals("<div></div>", divTag.getHTMLTag());
    }
}
