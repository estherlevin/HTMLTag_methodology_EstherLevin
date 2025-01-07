package decorateHTMLTag;

public class IDecoratorTag extends TagDecorator {
private HTMLTag htmlTag;
	
	//receives an HTML tag of any type to decorate
	public IDecoratorTag(HTMLTag htmlTag) {
		if(htmlTag == null) {
			throw new NullPointerException();
		}
		this.htmlTag = htmlTag;
	}
	
	/**@return decorated HTML Tag */
	@Override
	public String getHTMLTag() {
		return "<i>" + htmlTag.getHTMLTag() + "</i>";
	}
}
