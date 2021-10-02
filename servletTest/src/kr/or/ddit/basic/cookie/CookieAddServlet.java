package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieAddServlet.do")
public class CookieAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Cookie 정보 저장하는 방법
		// 1. Cookie객체를 생성한다. ==> '쿠키변수'와 '쿠키값'을 문자열로 지정한다.
		//	형식) Cookie cookie변수 = new Cookie('쿠키변수', '쿠키값'); 
		// '쿠키값'이 한글일 경우에는 URLEncoder.encode()메서드로 인코딩한 후 저장한다.
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		//Cookie ageCookie = new Cookie("age", "26");
		Cookie ageCookie = new Cookie("age", String.valueOf(26));
		Cookie genderCookie = new Cookie("gender", "Male");
		
		// 2. 쿠키 속성 설정
		// nameCookie.setPath("적용경로");		// 지정한 경로와 그 하위 경로에서 사용 가능하다.
		//									==> 생략하면 쿠키를 설정할 당시의 경로가 설정된다.
		// nameCookie.setMaxAge(유지시간);		// 단위 : 초 
		//									==> (-1 : 브라우저가 종료될때까지 유지된다.)
		//									==> 0 : 즉시 쿠키가 삭제된다.
		// nameCookie.setDomain("적용도메인명");
		//		==> 예) ".ddit.or.kr" ==> www.ddit.or.kr, mail.ddit.or.kr, ...
		// nameCookie.setSecure(보안여부);	// (적용:true, 미적용:false)
		
		System.out.println("path : " + nameCookie.getPath());
		System.out.println("MaxAge : " + nameCookie.getMaxAge());
		System.out.println("Domain : " + nameCookie.getDomain());
		
		// ....
		
		// 3. response객체를 이용해서 쿠키를 웹브라우저로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		// 형식) response.addCookie(1번에서 만든 쿠키변수);
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie 데이터가 저장되었습니다.</h2><br>");
		out.println("<a href='" + request.getContextPath() + "/basic/03/cookieTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		out.println();
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



















