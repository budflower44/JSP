package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.FileRemoveHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
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
	private String savePath; //파일 저장 경로를 저장하는 변수
	
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
				//파일을 업로드할 물리적인 경로 설정
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath); //iO import
				log.info("저장위치 >>> {} "+savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(); //common import
				fileItemFactory.setRepository(fileDir); //저장할 위치를 file 객체로 지정 / 파일 객체로 만들어서 넣어줘야함
				fileItemFactory.setSizeThreshold(1024*1024*3); //파일 저장을 위한 임시 메모리 용량 설정 : byte 단위
				
				//미리 보드 객체 설정
				BoardVO bvo = new BoardVO();
				
				//multipart/form-data 형식으로 넘어온 request 객체를 다루기 쉽게 변환해주는 역할
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory); //common 버전
				
				//request로 들어온 아이들을 FileItem 객체의 List 형식으로 들어옴
				List<FileItem> itemList = fileUpload.parseRequest(request);
				for(FileItem item : itemList) {
					switch(item.getFieldName()) { //byte 단위로 쪼개져 있기 때문에 인코딩을 다시해서 가져오기
					case "title" : 
						bvo.setTitle(item.getString("utf-8"));
						break;
					case "writer" : 
						bvo.setWriter(item.getString("utf-8"));
						break;
					case "content" : 
						bvo.setContent(item.getString("utf-8"));
						break;
					case "image_file" : 
						//이미지 있는지 체크
						if(item.getSize() > 0) { //데이터의 크기를 바이트 단위로 리턴 / 크기가 0보다 크면 이미지 파일 존재
							String fileName = item.getName() //경로를 포함한 이름 ~~~~/dog.jpg
									.substring(item.getName().lastIndexOf(File.separator)+1); //이름만 분리
							//File.separator : 파일 경로 기호를 저장
							//시스템의 시간을 이용하여 파일 구분  시간_dog.jpg
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFilePath = new File(fileDir+File.separator+fileName);
							log.info("uploadFilePath >>> {} "+uploadFilePath.toString());
							
							//저장
							try {
								item.write(uploadFilePath); //자바 객체를 디스크에 쓰기
								bvo.setImageFile(fileName); //bvo에 저장할 값
								
								//썸네일 작업 : 리스트 페이지에서 트래픽 과다 사용 방지
								Thumbnails.of(uploadFilePath).size(75, 75) //pixel 기준
									.toFile(new File(fileDir+File.separator+"_th_"+fileName));
								
							} catch (Exception e) {
								e.printStackTrace();
								log.info(">>> file writer on disk error");
							}
							
						}
						break;
					}
				}
				
				isOk = bsv.insert(bvo);
				log.info(">>> insert bvo >>> {}"+bvo);
				log.info("board insert >>>> {} "+(isOk>0?"OK":"Fail"));
				
				//목적지 주소
				destPage = "/index.jsp";
				
				//file 추가 안했을 때 코드
				//jsp에서 가져온 title, writer, content 꺼내오기
//				String title = request.getParameter("title");
//				String writer = request.getParameter("writer");
//				String content = request.getParameter("content");
//				log.info(">>>> insert check 1");
//				
//				BoardVO bvo = new BoardVO(title, writer, content);
//				log.info("insert bvo >>> {}"+bvo);
//				
//				//만들어진 객체 bvo를 DB에 저장
//				isOk = bsv.insert(bvo);
//				log.info("board insert >>>> {} "+(isOk>0?"OK":"Fail"));
//				
//				//목적지 주소
//				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("insert Error");
			}
			
			break;
		
		case "list" : 
			try {
				log.info("list check 1");
				//페이지네이션
				PagingVO pgvo = new PagingVO(); //1/10/0
				log.info("pgvo >>"+pgvo);
				//검색
				if(request.getParameter("pageNo") != null) {
					int pageNo = Integer.parseInt(request.getParameter("pageNo"));
					int qty = Integer.parseInt(request.getParameter("qty"));
					String type = request.getParameter("type");
					String keyword = request.getParameter("keyword");
					log.info(">>>> pageNo/qty/type/keyword "+pageNo+" / "+qty+" / "+type+" / "+keyword);
					pgvo = new PagingVO(pageNo, qty, type, keyword);
				}
				
				//검색어를 반영한 리스트
				List<BoardVO> list = bsv.getList(pgvo);
				log.info("list >>>> {} "+list);
				request.setAttribute("list", list);
				
				//검색한 값의 게시글 카운트
				int totalCount = bsv.getTotalCount(pgvo); //DB에서 전체 게시글 수 가져오기
				log.info("totalCount >>>> {} "+totalCount);
				PagingHandler ph = new PagingHandler(pgvo, totalCount);
				log.info("startpage / endPage "+ph.getStartPage()+ph.getEndPage());
				request.setAttribute("ph", ph);
				
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
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(3*1024*1024);
				
				BoardVO bvo = new BoardVO();
				
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				
				List<FileItem> itemList = fileUpload.parseRequest(request);
				String old_file = null;
				
				for(FileItem item : itemList) {
					switch(item.getFieldName()) {
					case "bno" : 
						bvo.setBno(Integer.parseInt(item.getString("utf-8")));
						break;
					case "title" : 
						bvo.setTitle(item.getString("utf-8"));
						break;
					case "content" : 
						bvo.setContent(item.getString("utf-8"));
						break;
					case "image_file" : 
						//이전 그림파일의 보관용
						old_file = item.getString("utf-8");
						break;
					case "new_file" : 
						//새로운 파일은 등록이 될 수도 있고, 안될 수도 있음
						if(item.getSize() > 0) {
							//새로운 등록 파일이 있다면...
							if(old_file != null) { //이전 파일이 있을 경우
								//old_file 삭제 작업
								//파일 삭제 핸들러를 통해서 파일 삭제 작업 진행
								FileRemoveHandler fileHandler = new FileRemoveHandler();
								isOk = fileHandler.deleteFile(old_file, savePath);
								log.info("FileRemoveHandler remove >>>> "+((isOk>0)?"OK":"Fail"));
							}
							//새로운 파일에 대한 객체 작업
							String fileName = item.getName()
									.substring(item.getName().lastIndexOf(File.separator)+1);
							log.info("new File Name >> {} "+fileName);
							
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFilePath = new File(fileDir+File.separator+fileName);
							
							try {
								item.write(uploadFilePath);
								bvo.setImageFile(fileName);
								//썸네일 작업
								Thumbnails.of(uploadFilePath).size(75, 75)
								.toFile(new File(fileDir+File.separator+"_th_"+fileName));
								
							} catch (Exception e) {
								e.printStackTrace();
								log.info("File Writer Update error");
							}
							
						}else {
							//기존 파일은 있지만, 새로운 이미지 파일이 없다면...
							bvo.setImageFile(old_file); //기존 객체를 bvo에 담기
						}
						break;
					}
				}
				
				isOk = bsv.edit(bvo);
				log.info("edit >> {} "+(isOk>0?"OK":"Fail"));
				destPage = "list";
				
				//file 업로드가 없을 경우 insert 구문
//				int bno = Integer.parseInt(request.getParameter("bno"));
//				String title = request.getParameter("title");
//				String content = request.getParameter("content");
//				log.info("edit check 1");
//				BoardVO bvo = new BoardVO(bno, title, content);
//				isOk = bsv.edit(bvo);
//				log.info("edit >> {} "+(isOk>0?"OK":"Fail"));
//				destPage = "list";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("edit error");
			}
			break;
		case "remove" : 
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("remove check 1");
				//댓글, 파일도 같이 삭제
				
				//파일 삭제
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				
				BoardVO bvo = bsv.getDetail(bno);
				
				String imageFileName = bvo.getImageFile();
				String savePath = getServletContext().getRealPath("/_fileUpload");
				if(imageFileName != null) {
					FileRemoveHandler fileRemoveHandler = new FileRemoveHandler();
					int isDel = fileRemoveHandler.deleteFile(imageFileName, savePath);
					log.info("isDel >>> "+((isDel>0)?"OK":"Fail"));
				}
				
				//댓글 삭제 (service에서 직접처리
				
				//보드 삭제
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
