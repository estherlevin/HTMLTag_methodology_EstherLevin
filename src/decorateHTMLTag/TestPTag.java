package decorateHTMLTag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPTag {
	//doesn't use a @BeforeEach since testing different types of the same tag (diff attributes included)
	@org.junit.Test
    void TestPTagWithTextOnly() {
        PTag pTag = new PTag("hello world");
        assertEquals("<p>hello world</p>", pTag.getHTMLTag());
    }

    @Test
    void TestPTagWithNameAttribute() {
        PTag pTag = new PTag("hello world", "nameValue", true);
        assertEquals("<p name=\"nameValue\">hello world</p>", pTag.getHTMLTag());
    }

    @Test
    void TestPTagWithIDAttribute() {
        PTag pTag = new PTag("hello world", "idValue", false);
        assertEquals("<p id=\"idValue\">hello world</p>", pTag.getHTMLTag());
    } 

    @Test
    void TestPTagWithNameAndIDAttributes() {
        PTag pTag = new PTag("hello world", "nameValue", "idValue");
        assertEquals("<p id=\"idValue\" name=\"nameValue\">hello world</p>", pTag.getHTMLTag());
    }

    @Test
    void TestPTagWithEmptyText() {
        PTag pTag = new PTag("", "nameValue", "idValue");
        assertEquals("<p id=\"idValue\" name=\"nameValue\"></p>", pTag.getHTMLTag());
    }

    @Test
    void TestPTagWithNullText() {
        PTag pTag = new PTag(null, "nameValue", "idValue");
        assertEquals("<p id=\"idValue\" name=\"nameValue\"></p>", pTag.getHTMLTag());
    }
}

