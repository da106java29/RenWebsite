package idv.export.po;

import java.util.ArrayList;

public class SubContext_VO {
	
	//Web Context SubTitle
	private String subTitle;
	
	//Web Context a herf name and url
	private ArrayList<Url_Bean> urlBeanList;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public ArrayList<Url_Bean> getSubContextList() {
		return urlBeanList;
	}

	public void setSubContextList(ArrayList<Url_Bean> urlBeanList) {
		this.urlBeanList = urlBeanList;
	}
	
	

}
