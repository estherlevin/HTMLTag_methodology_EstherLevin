package decorateHTMLTag;

public class EmDecoratorTag extends TagDecorator {
	private HTMLTag htmlTag;
	
	//receives an HTML tag of any type to decorate
	public EmDecoratorTag(HTMLTag htmlTag) {
		if(htmlTag == null) {
			throw new NullPointerException();
		}
		this.htmlTag = htmlTag;
	}
	
	/**@return decorated HTML Tag */
	@Override
	public String getHTMLTag() {
		return "<em>" + htmlTag.getHTMLTag() + "</em>";
	}
}
 