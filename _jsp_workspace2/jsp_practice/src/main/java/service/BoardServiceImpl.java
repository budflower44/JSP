package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info(">>>> insert check 2");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info(">>>> list check 2");
		return bdao.selectAll();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info(">>>> detail check 2");
		int isOk = bdao.readCountUpdate(bno);
		return bdao.selecOne(bno);
	}

	@Override
	public int edit(BoardVO bvo) {
		log.info(">>>> edit check 2");
		return bdao.update(bvo);
	}
	
}
