package idv.ren.junit_test;

import java.util.logging.Filter;

import idv.ren.serializable.bean.Key_DAO;
import idv.ren.serializable.bean.Value_DAO;
import idv.ren.serializable.interfaces.MyDao_Face;
import idv.ren.serializable.utils.DAOUtils;

public class mainTest{
	
	public static void main(String[] args) {
		
		Key_DAO vo1 = new Key_DAO();
		
		Value_DAO vo2 = new Value_DAO();
		
		DAOUtils.getName(vo1);
		DAOUtils.getName(vo2);
		
	}

}
