package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponseForwardTest.do")
public class ResponseForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 전달되는 문자열 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 데이터 구하기
		String userName = request.getParameter("username");
		
		// setAttribute()메서드로 보낸 데이터 구하기
		String tel = (String)request.getAttribute("tel");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Response Forward방식 연습</title></head><body>");
		out.println("<h2>Response Forward 결과</h2><hr>");
		out.println("<hr>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름(username)</td>");
		out.println("<td>" + userName + "</td></tr>");
		out.println("<tr><td>전화번호(tel)</td>");
		out.println("<td>" + tel + "</td></tr>");
		out.println("</table>");
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}















