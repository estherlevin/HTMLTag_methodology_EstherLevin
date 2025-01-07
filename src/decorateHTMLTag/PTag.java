package decorateHTMLTag;

public class PTag extends HTMLTag {
	private String text;
	private String name = null;
	private String id = null;
	
	//only receives basic text with no name or id attributes
	public PTag(String text) {
		this(text,null,null);
	}
	
	// Constructor with a flag to differentiate between name and id
    public PTag(String text, String nameOrID, boolean isName) {
    	//determining if it is a name or an id (since both are type String)
        this.text = text;
        if (isName) {
            this.name = nameOrID;
        } else {
            this.id = nameOrID;
        }
    }
    
	public PTag(String text,String name, String id) {
		this.text = text;
		this.name = name;
		this.id = id;
	}
	
	public String getHTMLTag() {
		StringBuilder str = new StringBuilder();
        str.append("<p");
        //adding attributes if there is
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
        str.append("</p>");
        return str.toString();
	}
}
