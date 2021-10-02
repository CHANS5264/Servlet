package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 이 예제는 애노테이션(@WebServlet)을 이용해서 Servlet을 설정하여 처리하는 예제
 * 애노테이션은 Servlet버전 3.0이상에서 사용할 수 있다.
 */

/*
	@WebServlet 애너테이션의 속성들
	1. name : 서블릿의 이름을 설정한다. (기본값: 빈문자열(""))
	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.(기본값: 빈 배열({}))
			예) 패턴이 1개일 경우 ==> urlPatterns="/url패턴1" 또는 urlPatterns={"/url패턴1"}
			예) 패턴이 2개이상일 경우 ==> urlPatterns={"/url패턴1", "/url패턴2", ....}
	3. value : urlPatterns와 동일한 기능을 한다.
	4. description : 주석(설명글)을 설정한다.
	
*/
@WebServlet(description = "이 서블릿에 대한 설명글 (생략 가능)", urlPatterns = { "/servletTest02.do" })
public class ServletTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// doGet()메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// PrintWriter객체 생성
		PrintWriter out = response.getWriter();
		
		// 처리한 내용 출력하기
		// 방법2) print()메서드 또는 println()메서드를 이용한다.
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>두번째 Servlet연습</title></head>");
		out.println("<body>");
		
		out.println("<h1 style='text-align:center; color:red;'>");
		out.println("이것은 두번째 Servlet예제입니다. 애너테이션을 이용해서 처리했습니다.");
		out.println("서버의 ContextPath : " + request.getContextPath());
		out.println("</h1>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	
	// doPost()메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}













