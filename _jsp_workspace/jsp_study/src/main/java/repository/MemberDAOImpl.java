package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	//sql Session 객체
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info(">>>> join check 3");
		//"MemberMapper.reg"	namespace.id 
		int isOk = sql.insert("MemberMapper.reg", mvo);
		if(isOk > 0) sql.commit();
		return isOk;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info(">>> login check 3");
		
		return sql.selectOne("MemberMapper.login", mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info(">>> lastLogin check 3");
		int isOk = sql.update("MemberMapper.last", id);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info(">>> selectAll check 3");
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public MemberVO selectOne(String id) {
		log.info(">>> selectOne check 3");
		return sql.selectOne("MemberMapper.select", id);
	}

	@Override
	public int update(MemberVO mvo) {
		log.info(">>> update check 3");
		int isOk = sql.update("MemberMapper.update", mvo);
		//update, insert, delete는 commit 필요
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int delete(String id) {
		log.info(">>> delete check 3");
		int isOk = sql.delete("MemberMapper.del", id);
		if(isOk > 0) sql.commit();
		return isOk;
	}
	
	//메서드 처리
	
}
