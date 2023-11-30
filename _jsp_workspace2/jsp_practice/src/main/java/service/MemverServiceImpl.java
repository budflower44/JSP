package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemverServiceImpl implements MemberService {
	
	//로그객체
	private static final Logger log = LoggerFactory.getLogger(MemverServiceImpl.class);
	//DAO 객체
	private MemberDAO mdao;
	
	public MemverServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	
	@Override
	public int insert(MemberVO mvo) {
		log.info(">>>> insert check 2");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info(">>>> login check 2");
		
		return mdao.check(mvo);
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info(">>>> selectAll check 2");
		return mdao.selectAll();
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info(">>>> modify check 2");
		return mdao.update(mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info(">>>> lastLogin check 2");
		return mdao.lastUpdate(id);
	}

	@Override
	public MemberVO detail(String id) {
		log.info(">>>> detail check 2");
		return mdao.selectOne(id);
	}

	@Override
	public int remove(String id) {
		log.info(">>>> remove check 2");
		return mdao.delete(id);
	}


}
