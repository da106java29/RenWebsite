package idv.ren.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idv.ren.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	@Override
	List<Member> findAll();
	
}
