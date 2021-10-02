package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청하면 무조건 로그인 폼으로 이동하기
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		System.out.println(userId);
		System.out.println(userPass);
		
		session.setAttribute("id", userId);
		
		if(userId!=null && userPass!=null) {
			if("admin".equals(userId) && "1234".equals(userPass)) {
				session.setAttribute("log", "ok");
				response.sendRedirect(request.getContextPath() + "/basic/04/sessoinLogin.jsp");
			}else {
				response.sendRedirect(request.getContextPath() + "/basic/04/sessoinLogin.jsp");
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}





















