package decorateHTMLTag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestHTag {
    @Test
    void TestHTagWithTextOnly() {
        HTag hTag = new HTag("H tag text", 1);
        assertEquals("<h1>H tag text</h1>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithInvalidTagNumberLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HTag("Invalid Tag", 0);
        });
    }

    @Test
    void TestHTagWithInvalidTagNumberHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HTag("Invalid Tag", 7);
        });
    }

    @Test
    void TestHTagWithNameAttribute() {
        HTag hTag = new HTag("H with Name", "nameValue", true, 2);
        assertEquals("<h2 name=\"nameValue\">H with Name</h2>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithIDAttribute() {
        HTag hTag = new HTag("H with ID", "idValue", false, 3);
        assertEquals("<h3 id=\"idValue\">H with ID</h3>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithNameAndIDAttributes() {
        HTag hTag = new HTag("H tag with both Attributes", "nameValue", "idValue", 4);
        assertEquals("<h4 id=\"idValue\" name=\"nameValue\">H tag with both Attributes</h4>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithEmptyText() {
        HTag hTag = new HTag("", "nameValue", "idValue", 5);
        assertEquals("<h5 id=\"idValue\" name=\"nameValue\"></h5>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithNullText() {
        HTag hTag = new HTag(null, "nameValue", "idValue", 6);
        assertEquals("<h6 id=\"idValue\" name=\"nameValue\"></h6>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithEmptyAttributes() {
        HTag hTag = new HTag("H text", "", "", 1);
        assertEquals("<h1>H text</h1>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithNullAttributes() {
        HTag hTag = new HTag("H text", null, null, 2);
        assertEquals("<h2>H text</h2>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithAllEmpty() {
        HTag hTag = new HTag("", "", "", 3);
        assertEquals("<h3></h3>", hTag.getHTMLTag());
    }

    @Test
    void TestHTagWithAllNull() {
        HTag hTag = new HTag(null, null, null, 4);
        assertEquals("<h4></h4>", hTag.getHTMLTag());
    }
}
