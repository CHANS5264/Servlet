package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionDeleteServlet.do")
public class SessionDeleteServlet extends HttpServlet {
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
		
		// 2. session객세의 removeAtribute()메서드를 이용해서 session값 삭제하기
		//		==> 세션 자체를 삭제되지 않고 해당 세션값만 삭제된다.
		//	형식) session객체변수.removeAttribute("key값");
		//session.removeAttribute("testSession");
		
		// 3. session객체의 invalidate()메서드로 Session삭제하기
		//		==> 세션 자체가 삭제된다.
		// 	형식) session객체변수.invalidate();
		session.invalidate();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 데이터 삭제하기</h2><hr>");
		
		out.println("<a href='" + request.getContextPath() + "/basic/04/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
