package idv.ren.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idv.ren.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

}
