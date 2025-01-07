package decorateHTMLTag;

//Every possible tag has a full text that will have to be returned. Abstract class allows for polymorphic behavior
public abstract class HTMLTag {
	private String text = "unknown";
	public String getHTMLTag() {
		return text;
	}	
}