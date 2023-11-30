package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	//로그 객체
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	//DB 연결
	private SqlSession sql;
	//isOk
	private int isOk;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info(">>>> insert check 3");
		isOk = sql.insert("MemberMapper.add", mvo);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public MemberVO check(MemberVO mvo) {
		log.info(">>>> login check check 3");
		return sql.selectOne("MemberMapper.login", mvo);
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info(">>>> selectAll check 3");
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public int update(MemberVO mvo) {
		log.info(">>>> update check 3");
		isOk = sql.update("MemberMapper.up", mvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int lastUpdate(String id) {
		log.info(">>>> lastUpdate check 3");
		isOk = sql.update("MemberMapper.last", id);
		if(isOk > 0) sql.commit();
		return isOk;
	}

	@Override
	public MemberVO selectOne(String id) {
		log.info(">>>> selectOne check 3");
		return sql.selectOne("MemberMapper.one", id);
	}

	@Override
	public int delete(String id) {
		log.info(">>>> delete check 3");
		isOk = sql.delete("MemberMapper.del", id);
		if(isOk>0) sql.commit();
		return isOk;
	}

	
	
}
