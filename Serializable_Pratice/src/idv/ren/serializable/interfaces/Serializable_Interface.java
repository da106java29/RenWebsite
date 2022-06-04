package idv.ren.serializable.interfaces;

import java.io.Serializable;

public abstract interface Serializable_Interface {
	
	default public boolean isSerializable(Object obj) {
		
		if(obj instanceof Serializable) {
			System.out.println("This's default interface, The obj implments Serializable!!");
			return true;
		}else {
			System.out.println("This's default interface, The obj Not Implements Serializable!!");
			return false;
		}
		
	};
	
}
