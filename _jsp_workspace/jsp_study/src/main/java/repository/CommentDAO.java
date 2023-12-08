package repository;

import java.util.List;

import domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int delete(int cno);

	int modify(CommentVO cvo);

	int removeCommentAll(int bno);

}
