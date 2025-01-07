package decorateHTMLTag;

public class HTag extends HTMLTag {
	private String text;
	private String name = null;
	private String id = null;
	private int tagNum;
	
	//only receives basic text with no name or id attributes
	public HTag(String text,int tagNum) {
		this(text,null,null,tagNum);
	}
	
	// Constructor with a flag to differentiate between name and id
    public HTag(String text, String nameOrID, boolean isName, int tagNum) {
        this.text = text;
    	//determining if it is a name or an id (since both are type String)
        if (isName) {
            this.name = nameOrID; 
        } else {
            this.id = nameOrID;
        }
        //making sure the tag is only 1 - 6
        if(tagNum < 1 || tagNum > 6) {
			throw new IllegalArgumentException();
		}
		this.tagNum = tagNum;
    }
    
	public HTag(String text,String name, String id, int tagNum) {
		if(tagNum < 1 || tagNum > 6) {
			throw new IllegalArgumentException();
		}
		this.tagNum = tagNum;
		this.text = text;
		this.name = name;
		this.id = id;
	}
	
	public String getHTMLTag() {
		StringBuilder str = new StringBuilder();
        str.append("<h" + tagNum);
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
        str.append("</h" + tagNum + ">");
        return str.toString();
	}
}
