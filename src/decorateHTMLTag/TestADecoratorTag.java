package decorateHTMLTag;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestADecoratorTag {
	private HTMLTag pTag = new PTag("hello world");
	
	@Test
	void TestTagWorksWithNoHrefAdded() {
		TagDecorator aTag = new ADecoratorTag(pTag);
		assertEquals("<a><p>hello world</p></a>",aTag.getHTMLTag());
	}
	
	@Test
	void TestTagWorksWithHrefAdded() {
		TagDecorator aTag = new ADecoratorTag(pTag,"touro.com");
		assertEquals("<a href=\"touro.com\"><p>hello world</p></a>",aTag.getHTMLTag());
	}
}
