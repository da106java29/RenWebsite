package idv.ren.init_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariDataSource;

import idv.ren.repository.MemberRepository;

@Service
public class WebService {
	
	@Autowired(required = false)
	private MemberRepository memberRS;
	
	@Autowired
	HikariDataSource hkProxy;
	
	public void show() {
		System.out.println("Show XXXXXXXX");
		
		System.out.println("ClassName = " + hkProxy.getDriverClassName());
		System.out.println("JdbcUrl = " + hkProxy.getJdbcUrl());
		System.out.println("Password = " + hkProxy.getPassword());
		System.out.println("Username = " + hkProxy.getUsername());
		
		try {
			Connection conn = hkProxy.getConnection();
			
			String sql = "select * from member";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("id = " + rs.getString("id"));
				System.out.println("id int = " + rs.getString(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
//		List<Member> list = new ArrayList<Member>();
//		list = memberRS.findAll();
//		
//		for(Member member : list) {
//			System.out.println("Member UUID: " + member.getUUID());
//			System.out.println("Member ID: " + member.getId());
//			System.out.println("Member Pwd: " + member.getPwd());
//		}
	}
	
	
	
}
