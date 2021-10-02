package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServlet.do")
public class cookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		if(cookies!=null) {
			for(Cookie cookie : cookies) { 
				String name = cookie.getName();
				if("count".equals(name)) {
//					Cookie delCookie = new Cookie("count", "0");
//					delCookie.setMaxAge(0);
//					response.addCookie(delCookie);
					
					cookie.setMaxAge(0);	// 유지시간을 0으로 셋팅한 후
					response.addCookie(cookie); // 추가한다.
					
				}
			}
		}
		out.println("<html><head><meta charset='utf-8'><title>Cookie삭제</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Cookie Count 데이터 삭제하기</h2>");
		
		/*
		 * if(cookies == null || cookies.length==0) {
		 * out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>"); }else { // 2. 쿠키 배열에서 해당 쿠키 정보를
		 * 구해온다. for(Cookie cookie : cookies) { //String name = cookie.getValue(); // 쿠키
		 * 변수 구하기 if(!("count".equals(0))) { // 삭제할 쿠키 변수를 찾는다.
		 * 
		 * // 방법1 cookie.setMaxAge(0); response.addCookie(cookie);
		 * 
		 * 
		 * // 방법2 Cookie delCookie = new Cookie(name, "test"); delCookie.setMaxAge(0);
		 * response.addCookie(delCookie);
		 * 
		 * 
		 * }
		 * 
		 * } }
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
