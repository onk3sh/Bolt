package main.java.utils;

public class DataWebElement {
	
	private String id = null;
	private String width = null;
	private String marginLeft = null;
	private String perspectiveOrigin = null;
	private String breakpointValue = null;
	
	public DataWebElement() {
		//initialize
		id = "";
		width = "";
		marginLeft = "";
		perspectiveOrigin = "";
		breakpointValue = "";
		
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setWidth(String width) {
		this.width = width;
	}
	
	public void setMarginLeft(String marginLeft) {
		this.marginLeft = marginLeft;
	}
	
	public void setPerspectiveOrigin(String perspectiveOrigin) {
		this.perspectiveOrigin = perspectiveOrigin;
	}
	
	public void setBP(String breakpointValue) {
		this.breakpointValue = breakpointValue;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getWidth() {
		return this.width;
	}
	
	public String getMarginLeft() {
		return this.marginLeft;
	}
	
	public String getPerspectiveOrigin() {
		return this.perspectiveOrigin;
	}
	
	public String getBP() {
		return this.breakpointValue;
	}

}
