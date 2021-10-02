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


@WebServlet("/CookieReadServlet.do")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 정보 읽어오기
		// 1. 전체 쿠키정보를 request객체를 통해서 가져온다. ==> 이 때 가져온 쿠키 정보들은 배열에 저장된다.
		//	형식) Cookie[] 쿠키배열변수 = request.getCookies();
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie읽기</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Cookie 데이터 확인하기</h2>");
		if(cookieArr == null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");			
		}else {
			// 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다.
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();	// '쿠키변수'명 가져오기
				//String value = cookie.getValue(); // '쿠키값' 가져오기 --> 한글이 아닌경우에는 가능하지만 한글은 글자가 깨진다.
				// String value = cookie.getValue();
				// 한글로 저장된 쿠키값이 있으면 읽어온 값을 디코딩해서 사용
				String value = URLDecoder.decode(cookie.getValue(), "utf-8");
				out.println("쿠키변수 : " + name + "<br>");
				out.println("쿠키값 : " + value + "<hr>");
			}
		}
		
		out.println("<a href='" + request.getContextPath() + "/basic/03/cookieTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
