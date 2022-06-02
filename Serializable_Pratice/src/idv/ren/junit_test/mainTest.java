package idv.ren.junit_test;

import idv.ren.serializable.bean.Key_DAO;
import idv.ren.serializable.bean.Value_DAO;
import idv.ren.serializable.utils.DAOUtils;

public class mainTest{
	
	public static void main(String[] args) {
		
		Key_DAO vo1 = new Key_DAO();
		vo1.setName("AAPlE");
		vo1.setValue("2");
		
		Value_DAO vo2 = new Value_DAO();
		vo2.setName("Banana");
		vo2.setValue("5");
		
		DAOUtils.getName(vo1);
		DAOUtils.getName(vo2);
		
	}

}
