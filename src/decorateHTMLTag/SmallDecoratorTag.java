package decorateHTMLTag;

public class SmallDecoratorTag extends TagDecorator {
private HTMLTag htmlTag;
	
	//receives an HTML tag of any type to decorate
	public SmallDecoratorTag(HTMLTag htmlTag) {
		if(htmlTag == null) {
			throw new NullPointerException();
		}
		this.htmlTag = htmlTag;
	}
	
	/**@return decorated HTML Tag */
	@Override
	public String getHTMLTag() {
		return "<small>" + htmlTag.getHTMLTag() + "</small>";
	}
}
