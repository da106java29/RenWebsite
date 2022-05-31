package idv.ren.serializable.bean;

import java.io.Serializable;

public class Animal_Bean implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	private String animal1;
	private String animal2;
	
	public Animal_Bean(String animal1, String Animal2) {
		this.animal1 = animal1;
		this.animal2 = Animal2;
	}
	
	public String getAnimal1() {
		return animal1;
	}
	public void setAnimal1(String animal1) {
		this.animal1 = animal1;
	}
	public String getAnimal2() {
		return animal2;
	}
	public void setAnimal2(String animal2) {
		this.animal2 = animal2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The " + animal1 + " so Cute, But the " + animal2 + " look terrible.";
	}
}
