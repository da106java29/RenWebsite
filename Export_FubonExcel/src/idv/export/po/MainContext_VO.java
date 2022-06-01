package idv.export.po;

import java.util.ArrayList;

public class MainContext_VO {
	
	private String bigTitle;
	
	private ArrayList<SubContext_VO> subList;

	public String getBigTitle() {
		return bigTitle;
	}

	public void setBigTitle(String bigTitle) {
		this.bigTitle = bigTitle;
	}

	public ArrayList<SubContext_VO> getSubList() {
		return subList;
	}

	public void setSubList(ArrayList<SubContext_VO> subList) {
		this.subList = subList;
	}

}
