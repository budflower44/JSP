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

import domain.MemberVO;
import service.MemberService;
import service.MemverServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//로그 객체
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	//rdp
	private RequestDispatcher rdp;
	//destpage
	private String destPage;
	//isOk
	private int isOk;
	//session
	private HttpSession ses;
	//service 연결
	private MemberService msv; //인터페이스로 생성

    public MemberController() {
    	msv = new MemverServiceImpl(); //클래스로 생성
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch(path) {
		case "join" : 
			destPage = "/member/join.jsp";
			break;
			
		case "insert" : 
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				log.info("insert check 1");
				log.info("insert  mvo >>>> {} "+mvo);
				
				isOk = msv.insert(mvo);
				log.info("insert "+((isOk>0)?"성공":"실패"));
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("insert error");
			}
			break;
			
		case "login" : 
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id, pwd);
				log.info("login check 1");
				MemberVO loginMvo = msv.login(mvo);
				log.info("login mvo >>>> {} "+mvo);
				
				if(loginMvo!=null) {
					ses = request.getSession(); //로그인한 객체가 있다면 가져오기
					ses.setAttribute("ses", loginMvo); //세션에 로그인 객체 없으면 만들기
					ses.setMaxInactiveInterval(10*60); //로그인 유지시간
				}else {
					//로그인 객체가 없다면
					request.setAttribute("msg_login", -1);
				}
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("login error");
			}
			break;
			
		case "list" : 
			List<MemberVO> list = msv.selectAll();
			log.info("list check 1");
			log.info("list >>>> {} "+list);
			ses.setAttribute("list", list);
			destPage = "/member/list.jsp";
			break;
			
		case "modify" : 
			try {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				log.info("mvo >>>> {} "+mvo);
				
				isOk = msv.modify(mvo);
				log.info("modify isOk "+((isOk>0)?"성공":"실패"));
				
				if(isOk>0) {
					request.setAttribute("msg_modify", -1);
				}
				
				ses = request.getSession();
				ses.invalidate();
				
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("modify error");
			}
			
			break;
			
		case "logout" : 
			try {
				ses = request.getSession();
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				log.info("session mvo "+mvo);
				isOk = msv.lastLogin(mvo.getId());
				log.info("lastLogin update "+((isOk>0)?"성공":"실패"));
				ses.invalidate();
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("logout error");
			}
			break;
		
		case "detail" : 
			try {
				String id = request.getParameter("id");
				log.info("detail check 1");
				MemberVO mvo = msv.detail(id);
				log.info("detail mvo >>>> {} "+mvo);
				ses.setAttribute("mvo", mvo);
				destPage = "/member/modify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail error");
			}
			break;
		case "remove" : 
			try {
				String id = request.getParameter("id");
				log.info("remove check 1 "+id);
				isOk = msv.remove(id);
				log.info("remove isOk "+((isOk>0)?"성공":"실패"));
				if(isOk>0) {
					ses.setAttribute("msg_remove", -1);					
				}
				ses.invalidate();
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("remove error");
			}
			break;
		
			
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
