package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectAll();

	BoardVO selecOne(int bno);

	int readCountUpdate(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	List<BoardVO> mylist(String writer);

}
