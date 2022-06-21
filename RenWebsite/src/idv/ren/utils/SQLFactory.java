package idv.ren.utils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaxxer.hikari.HikariDataSource;

public class SQLFactory {
	
	
	@Autowired
	HikariDataSource hkProxy;
	
	@Test
	public void dataSourceTest() {
		System.out.println("ClassName = " + hkProxy.getDataSourceClassName());
		System.out.println("JdbcUrl = " + hkProxy.getJdbcUrl());
		System.out.println("Password = " + hkProxy.getPassword());
		System.out.println("Username = " + hkProxy.getUsername());
	}

}
