package decorateHTMLTag;

public class ADecoratorTag extends TagDecorator{
	private HTMLTag htmlTag;
	private String href;
	
	//receives an HTML tag of any type to decorate with no href
	public ADecoratorTag(HTMLTag htmlTag) {
		this(htmlTag,null);
	}
	
	//tag includes an href attribute
	public ADecoratorTag(HTMLTag htmlTag, String href) {
		if(htmlTag == null) {
			throw new NullPointerException();
		}
		this.htmlTag = htmlTag;
		this.href = href;
	}
	
	/**@return fully decorated HTML Tag */
	@Override
	public String getHTMLTag() {
		//tag includes href attribute
		if(href != null && !href.equals("")) {
			return "<a href=\"" + href +"\">" + htmlTag.getHTMLTag() + "</a>";
		}
		return "<a>" + htmlTag.getHTMLTag() + "</a>";
	}
}
