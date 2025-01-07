package decorateHTMLTag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestInputTag {

    @Test
    void TestInputTagWithTextOnly() {
        InputTag inputTag = new InputTag("Enter your name");
        assertEquals("<input>Enter your name</input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithType() {
        InputTag inputTag = new InputTag(null, null, null, "text", null, null);
        assertEquals("<input type=\"text\"></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithNameAndID() {
        InputTag inputTag = new InputTag(null, "inputName", "inputID", null, null, null);
        assertEquals("<input id=\"inputID\" name=\"inputName\"></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithValue() {
        InputTag inputTag = new InputTag(null, null, null, null, null, "submit");
        assertEquals("<input value=\"submit\"></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithOnClick() {
        InputTag inputTag = new InputTag(null, null, null, null, "alert('clicked!')", null);
        assertEquals("<input onclick=\"alert('clicked!')\"></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithAllAttributes() {
        InputTag inputTag = new InputTag("Click here", "buttonName", "buttonID", "button", "alert('clicked!')", "Click Me");
        assertEquals("<input type=\"button\" id=\"buttonID\" name=\"buttonName\" value=\"Click Me\" onclick=\"alert('clicked!')\">Click here</input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithEmptyAttributes() {
        InputTag inputTag = new InputTag(null, "", "", "", "", "");
        assertEquals("<input></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithNullAttributes() {
        InputTag inputTag = new InputTag(null, null, null, null, null, null);
        assertEquals("<input></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithEmptyText() {
        InputTag inputTag = new InputTag("", "inputName", "inputID", "text", null, null);
        assertEquals("<input type=\"text\" id=\"inputID\" name=\"inputName\"></input>", inputTag.getHTMLTag());
    }

    @Test
    void TestInputTagWithNullText() {
        InputTag inputTag = new InputTag(null, "inputName", "inputID", "text", null, null);
        assertEquals("<input type=\"text\" id=\"inputID\" name=\"inputName\"></input>", inputTag.getHTMLTag());
    }
}
