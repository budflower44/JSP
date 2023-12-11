package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info(">>>> insert check 3");
		int isOk = sql.insert("BoardMapper.add", bvo);
		if(isOk>0) { sql.commit(); }
		return isOk;
	}

	@Override
	public List<BoardVO> selectAll(PagingVO pgvo) {
		log.info(">>>> selectAll check 3");
		return sql.selectList("BoardMapper.list", pgvo);
	}

	@Override
	public BoardVO selecOne(int bno) {
		log.info(">>>> selectOne check 3");
		return sql.selectOne("BoardMapper.one", bno);
	}

	@Override
	public int readCountUpdate(int bno) {
		log.info(">>>> readCountUpdate check 3");
		int isOk = sql.update("BoardMapper.read", bno);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public int update(BoardVO bvo) {
		log.info(">>>> update check 3");
		int isOk = sql.update("BoardMapper.up", bvo);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info(">>>> delete check 3");
		int isOk = sql.delete("BoardMapper.del", bno);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public List<BoardVO> mylist(String writer) {
		log.info(">>>> mylist check 3");
		return sql.selectList("BoardMapper.mylist", writer);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		log.info(">>>> getTotalCount check 3");
		return sql.selectOne("BoardMapper.cnt", pgvo);
	}
	
}
