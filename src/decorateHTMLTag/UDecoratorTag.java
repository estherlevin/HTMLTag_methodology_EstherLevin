package decorateHTMLTag;

public class UDecoratorTag extends TagDecorator{
private HTMLTag htmlTag;
	
	//receives an HTML tag of any type to decorate
	public UDecoratorTag(HTMLTag htmlTag) {
		if(htmlTag == null) {
			throw new NullPointerException();
		}
		this.htmlTag = htmlTag;
	}
	
	/**@return decorated HTML Tag */
	@Override
	public String getHTMLTag() {
		return "<u>" + htmlTag.getHTMLTag() + "</u>";
	}
}
