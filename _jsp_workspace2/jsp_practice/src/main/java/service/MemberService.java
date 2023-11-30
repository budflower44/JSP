package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int insert(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	List<MemberVO> selectAll();

	int modify(MemberVO mvo);

	int lastLogin(String id);

	MemberVO detail(String id);

	int remove(String id);


}
