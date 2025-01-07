package decorateHTMLTag;

//abstract class and method ensures every decorator returns the full tag with it's add ons
public abstract class TagDecorator extends HTMLTag {
	public abstract String getHTMLTag();
}
