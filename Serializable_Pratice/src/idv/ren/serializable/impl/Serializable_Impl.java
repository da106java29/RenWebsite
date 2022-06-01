package idv.ren.serializable.impl;

import java.io.Serializable;

import idv.ren.serializable.interfaces.Serializable_Interface;

public class Serializable_Impl implements Serializable_Interface{
	
	@Override
	public boolean isSerializable(Object obj) {
		
		if(obj instanceof Serializable) {
			System.out.println("This impl, The obj implments Serializable!!");
			return true;
		}else {
			System.out.println("This impl, The obj Not Implements Serializable!!");
			return false;
		}
		
	}
	
}
