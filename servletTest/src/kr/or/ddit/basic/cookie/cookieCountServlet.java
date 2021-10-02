package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 카운트값은 1이 기본 
@WebServlet("/cookieCountServlet.do")
public class cookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// count라는 쿠키가 있는지 검사
		Cookie[] cookies = request.getCookies();
		int count = 0;	// 카운트값이 저장될 변수 선언
		
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();	// 쿠키변수 구하기
				if("count".equals(name)) {
					String value = cookie.getValue();	// 쿠키값(현재의 count값)
					count = Integer.parseInt(value);
				}
			}
		}
		count++;	// 카운트값 증가
		
		// 증가된 count가 저장된 cookie 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		response.addCookie(countCookie);	// 쿠키 추가
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie Count</title></head>");
		out.println("<body>");
		out.println("<h2> 방문수 : " + count + "번째 </h2><br>");
		
		/*
		 * Cookie [] cookieArray = request.getCookies(); // 브라우저에서 전달된 모든 쿠키 저장 Cookie
		 * cookie = null; int countNum = 0; String countStr = "";
		 * 
		 * if(cookieArray != null) { // 브라우저에서 전달된 쿠키정보가 있다면 for(int i = 0; i <
		 * cookieArray.length; i++) { // 전달된 모든 쿠키를 검사하며,
		 * if(cookieArray[i].getName().equals("counter")) { // “counter”란 이름의 쿠키정보를 찾아
		 * cookie = cookieArray[i]; // 저장하고 break; // for문을 빠져나간다. } } }
		 * 
		 * if(cookie != null) { // “counter”란 이름의 쿠키가 있으면 countNum =
		 * Integer.parseInt(cookie.getValue()) + 1; // 값을 정수로 변환한 다음 1 증가한 후 countStr =
		 * Integer.toString(countNum); // 다시 증가된 값을 문자열로 변환한 후
		 * cookie.setValue(countStr); // “counter”란 이름의 쿠키값을 새롭게 설정한다. } else { //
		 * “counter”란 이름의 쿠키가 없으면 cookie = new Cookie("counter", "1"); // counter란 이름으로
		 * 초기값 1인 쿠키를 생성한다. }
		 * 
		 * response.addCookie(cookie); // “counter”란 이름의 쿠키와 그 값을 클라이언트에 전달한다
		 * 
		 * out.println("방문수 : " + cookie.getValue() + "번째");
		 */
		
		
		out.println("<a href='" + request.getContextPath() +"/cookieCountServlet.do'>카운트 증가하기</a><br>");
		out.println("<a href='" + request.getContextPath() +"/basic/03/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
