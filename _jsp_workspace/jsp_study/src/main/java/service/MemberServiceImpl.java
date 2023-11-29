package service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	
	//로그 객체
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	private MemberDAO mdao; //repository => interface로 생성
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info(">>> join check 2");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info(">>> login check 2");
		return mdao.login(mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info(">>> lastLogin check 2");
		return mdao.lastLogin(id);
	}

	@Override
	public List<MemberVO> getList() {
		log.info(">>> getList check 2");
		return mdao.selectAll();
	}

	@Override
	public MemberVO detail(String id) {
		log.info(">>> detail check 2");
		return mdao.selectOne(id);
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info(">>>> modify check 2");
		return mdao.update(mvo);
	}

	@Override
	public int remove(String id) {
		log.info(">>>> remove check 2");
		return mdao.delete(id);
	}
	
	
}
