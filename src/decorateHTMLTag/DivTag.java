package decorateHTMLTag;

//concrete div tag
public class DivTag extends HTMLTag {
	private String text;
	private String name = null;
	private String id = null;
	
	//only receives basic text with no name or id attributes
	public DivTag(String text) {
		this(text,null,null);
	}
	
	// Constructor with a flag to differentiate between name and id
    public DivTag(String text, String nameOrID, boolean isName) {
        this.text = text;
        if (isName) {
            this.name = nameOrID;
        } else {
            this.id = nameOrID;
        }
    }
    
	public DivTag(String text,String name, String id) {
		this.text = text;
		this.name = name;
		this.id = id;
	}
	
	public String getHTMLTag() {
		StringBuilder str = new StringBuilder();
        str.append("<div");
        //since it allows for blank spaces, we test if String = ""
        if(id != null &&!id.equals("")) {
            str.append(" id=\"").append(id).append("\"");
        }
        if(name != null && !name.equals("")) {
            str.append(" name=\"").append(name).append("\"");
        }
        str.append(">");
        if (text != null && !text.isEmpty()) {
            str.append(text);
        }
        str.append("</div>");
        return str.toString();
	}
}
