package main.java.utils;

import java.util.ArrayList;
import java.util.List;

public class DataWebElement {
	
	private String id = null;
	private String width = null;
	private String marginLeft = null;
	private String perspectiveOrigin = null;
	private String breakpointValue = null;
	private String allCSSValues = null;
	private ArrayList<String> cssArr = null;
	
	public DataWebElement() {
		//initialize
		id = "";
		width = "";
		marginLeft = "";
		perspectiveOrigin = "";
		breakpointValue = "";
		allCSSValues = "";
		cssArr = new ArrayList<String>();
		
	}
	
	//setters
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
	
	public void setAllCssValues(String allCSSValues) {
		this.allCSSValues = allCSSValues;
	}
	
	//getters
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
	
	public String getAllCSSValues() {
		return this.allCSSValues;
	}
	
	//util to split string for css and set it in hash-map
	public void setCssArray() {
		if(allCSSValues.isEmpty()) {
			System.out.println("Error: Css Values not found for element with id:"+id);
		}
		else
		{
			String[] temp = allCSSValues.split("\\n");
			for(String s : temp)
				cssArr.add(s);
		}
	}
	
	public void setCssArrayList(List<String> cssList) {
		if(cssList.isEmpty() || allCSSValues.isEmpty()) {
			System.out.println("Error: Css Values not set correctly");
		}
		else
		{
			String[] temp = allCSSValues.split("\\n");
			for(int i = 0; i<cssList.size();i++) {
				for(String s : temp) {
					if(s.contains(cssList.get(i))) {
						cssArr.add(s);
					}
				}
			}
		}
	}
	
	public ArrayList<String> getCssArray(){
		return this.cssArr;
	}

}
