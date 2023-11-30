package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO check(MemberVO mvo);

	List<MemberVO> selectAll();

	int update(MemberVO mvo);

	int lastUpdate(String id);

	MemberVO selectOne(String id);

	int delete(String id);


}
