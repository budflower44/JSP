package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//로그 기록 객체 생성
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	//jsp에서 받은 요청을 처리, 처리결과를 다른 jsp로 보내는 역할을 하는 객체
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	
	//controller <-> service
	private BoardService bsv;

    public BoardController() {
        // 생성자
    	bsv = new BoardServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 메서드 처리 구문 시작
		//매개변수의 객체 인코딩 설정
		request.setCharacterEncoding("UTF-8"); //요청
		response.setCharacterEncoding("UTF-8"); //응답
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI(); //jsp에서 오는 요청 주소를 받는 설정
		log.info(uri);
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(path);
		
		switch(path) {
		case "write" : 
			destPage = "/board/write.jsp";
			break;
		case "insert" : 
			try {
				//jsp에서 가져온 title, writer, content 꺼내오기
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				log.info(">>>> insert check 1");
				
				BoardVO bvo = new BoardVO(title, writer, content);
				log.info("insert bvo >>> {}"+bvo);
				
				//만들어진 객체 bvo를 DB에 저장
				isOk = bsv.insert(bvo);
				log.info("board insert >>>> {} "+(isOk>0?"OK":"Fail"));
				
				//목적지 주소
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("insert Error");
			}
			
			break;
		
		case "list" : 
			try {
				log.info("list check 1");
				List<BoardVO> list = bsv.getList();
				log.info("list >>>> {} "+list);
				request.setAttribute("list", list);
				destPage = "/board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("list error");
			}
			break;
		case "detail" : 
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("detail check 1");
				BoardVO bvo = bsv.getDetail(bno);
				log.info("detail bvo >>>> {} "+bvo);
				request.setAttribute("bvo", bvo);
				destPage = "/board/detail.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail error");
			}
			break;
		case "modify" : 
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("modify check 1");
				BoardVO bvo = bsv.getDetail(bno);
				log.info("detail bvo >>>> {} "+bvo);
				request.setAttribute("bvo", bvo);
				destPage = "/board/modify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("modify error");
			}
			break;
		case "edit" : 
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				log.info("edit check 1");
				BoardVO bvo = new BoardVO(bno, title, content);
				isOk = bsv.edit(bvo);
				log.info("edit >> {} "+(isOk>0?"OK":"Fail"));
				destPage = "list";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("edit error");
			}
			break;
		case "remove" : 
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("remove check 1");
				isOk = bsv.remove(bno);
				log.info("remove >> {} "+(isOk>0?"성공":"실패"));
				destPage = "list";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("remove error");
			}
			break;
			
		case "mylist" : 
			try {
				String writer = request.getParameter("id");
				log.info("mylist check 1");
				List<BoardVO> list1 = bsv.mylist(writer);
				log.info("list mvo >>>> {} "+list1);
				request.setAttribute("list", list1);
				
				destPage="/board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("mylist error");
			}
			break;
			
		}
		
		//목적지 주소로 데이터를 전달(RequestDispatcher)
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response); //요청에 필요한 객체를 가지고 경로로 전송
		
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get으로 오는 요청 처리
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post로 오는 요청 처리
		service(request, response);
	}

}
