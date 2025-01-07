package decorateHTMLTag;

public class InputTag extends HTMLTag {
	private String text;
	private String type = null;
	private String onclick = null; //chose event to be an onclick
	private String value = null;
	private String name = null;
	private String id = null;
	
	//only receives basic text with no name, id or type attributes
	public InputTag(String text) {
		this(text,null,null,null,null,null);
	}
    
	public InputTag(String text,String name, String id,String type,String onclick,String value) {
		this.text = text;
		this.name = name;
		this.id = id;
		this.type = type;
		this.onclick = onclick;
		this.value = value;
	}
	
	public String getHTMLTag() {
		//will add each attribute that's not null to the StringBuilder
		StringBuilder str = new StringBuilder();
        str.append("<input");
        //since it allows for blank spaces, we test if String = ""
        if(type != null && !type.equals("")) {
            str.append(" type=\"").append(type).append("\"");
        }
        if(id != null &&!id.equals("")) {
            str.append(" id=\"").append(id).append("\"");
        }
        if(name != null && !name.equals("")) {
            str.append(" name=\"").append(name).append("\"");
        }
        if(value != null && !value.equals("")) {
            str.append(" value=\"").append(value).append("\"");
        }
        if(onclick != null && !onclick .equals("")) {
            str.append(" onclick=\"").append(onclick).append("\"");
        }
        str.append(">");
        if (text != null && !text.isEmpty()) {
            str.append(text);
        }
        str.append("</input>");
        return str.toString();
    }
}
