package decorateHTMLTag;

public class StrongDecoratorTag extends TagDecorator {
private HTMLTag htmlTag;
	
	//receives an HTML tag of any type to decorate
	public StrongDecoratorTag(HTMLTag htmlTag) {
		if(htmlTag == null) {
			throw new NullPointerException();
		}
		this.htmlTag = htmlTag;
	}
	
	/**@return decorated HTML Tag */
	@Override
	public String getHTMLTag() {
		return "<strong>" + htmlTag.getHTMLTag() + "</strong>";
	}
}
