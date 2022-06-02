package idv.ren.serializable.bean;

import idv.ren.serializable.interfaces.MyDao_Face;

public class Value_DAO implements MyDao_Face{

	private String name;
	
	private String value;
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
