package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	int lastLogin(String id);

	List<MemberVO> selectAll();

	MemberVO selectOne(String id);

	int update(MemberVO mvo);

	int delete(String id);

}
