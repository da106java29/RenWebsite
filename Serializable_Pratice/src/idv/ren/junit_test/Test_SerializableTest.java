package idv.ren.junit_test;

import org.junit.Test;

import idv.ren.serializable.bean.Animal_Bean;
import idv.ren.serializable.impl.DeSerializable;
import idv.ren.serializable.impl.Serializable;

public class Test_SerializableTest {

	@Test
	public void test() {
		String fileName = "D://Animal_Bean";
		
		Animal_Bean anm = new Animal_Bean("Cat", "Dragon");
		
		Serializable sl = new Serializable();
		
		sl.doSerializable(anm, fileName);
		
		DeSerializable ds = new DeSerializable();
		ds.doDeSerializable(anm, fileName);
		
	}

}
