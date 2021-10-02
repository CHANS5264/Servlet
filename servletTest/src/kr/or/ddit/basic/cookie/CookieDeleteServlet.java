package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieDeleteServlet.do")
public class CookieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 정보 삭제하기
		// 1. 쿠키 데이터의 삭제는 쿠키의 남은 수명(유지시간)을 0으로 설정하는 방법을 사용한다.
		//	  - 방법1) 삭제하려는 쿠키 정보를 찾아서 그 쿠키의 유지시간을 0으로 설정한 후 다시 addCookie()로 추가하면 된다.
		//	  - 방법2) '쿠키변수'가 같은 쿠키객체를 생성한 후 이 쿠키의 유지시간을 0으로 설정한 후 추가한다.
		//	형식) Cookie 쿠키변수 = new Cookie('쿠키변수', '쿠키값');
		//	형식) 쿠키변수.setMaxAge(시간);	==> 이 '시간'값을 0으로 주면 된다.
		
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie삭제</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Cookie 데이터 삭제하기</h2>");
		
		if(cookieArr == null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");			
		}else {
			// 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다.
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();	// 쿠키 변수 구하기
				if("gender".equals(name)) {	// 삭제할 쿠키 변수를 찾는다.
					/*
					// 방법1
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					*/
					
					// 방법2
					Cookie delCookie = new Cookie(name, "test");
					delCookie.setMaxAge(0);
					response.addCookie(delCookie);
					
					
				}
								
			}
		}
		
		out.println("<a href='" + request.getContextPath() + "/basic/03/cookieTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
