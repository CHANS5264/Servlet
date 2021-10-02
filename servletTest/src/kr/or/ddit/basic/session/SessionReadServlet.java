package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionReadServlet.do")
public class SessionReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/*
			- 저장된 Session 읽어오기
		1. Session객체 생성
		*/
		HttpSession session = request.getSession();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 데이터 확인하기</h2><hr>");
		
		out.println("<h3>Session 데이터 1개 확인하기</h3>");
		// 2. session객체의 getAttribute()메서드 이용하기
		// 형식) session객체변수.getAttribute("key값");
		String sessionValue = (String)session.getAttribute("testSession");
		if(sessionValue==null) {
			out.println("<h4>testSession의 세션값은 없습니다.</h4>");
		} else {
			out.println("<h4>testSession의 세션값 : " + sessionValue + "</h4>");
		}
		out.println("<hr>");
		
		out.println("<h3>전체 Session 데이터 확인하기</h3>");
		out.println("<ol>");
		// 세션의 key값들 전체 구해오기
		Enumeration<String> sessionNames = session.getAttributeNames();
		int cnt = 0;
		while(sessionNames.hasMoreElements()) {
			cnt++;
			String sessionKey = sessionNames.nextElement();	// 세션key값 1개 구하기
			out.println("<li>" + sessionKey + " : " + session.getAttribute(sessionKey) + "</li>");
		}
		
		if(cnt==0) {
			out.println("세션 데이터가 하나도 없습니다.");
		}
		out.println("</ol>");
		out.println("<a href='" + request.getContextPath() + "/basic/04/sessionTest.jsp'>시작문서로 가기</a>");
		
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}














