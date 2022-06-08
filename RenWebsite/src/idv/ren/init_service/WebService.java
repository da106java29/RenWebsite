package idv.ren.init_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.ren.entity.Member;
import idv.ren.repository.MemberRepository;

@Service
public class WebService {
	
	@Autowired
	private MemberRepository memberRS;
	
	public void show() {
		System.out.println("Show XXXXXXXX");
		
		List<Member> list = new ArrayList<Member>();
		list = memberRS.findAll();
		
		for(Member member : list) {
			System.out.println("Member UUID: " + member.getUUID());
			System.out.println("Member ID: " + member.getId());
			System.out.println("Member Pwd: " + member.getPwd());
		}
	}
	
	
	
}
