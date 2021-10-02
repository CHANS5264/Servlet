package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// Request객체 관련 예제
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//POST방식으로 전달되는 문자 인코딩 방식 설정
	    request.setCharacterEncoding("utf-8");
		
		
		// 클라이언트가 요청할때 보낸 데이터를 받아서 처리해보자.
		//		==> 이때 받아온 데이터는 기본적으로 문자열이다.
		
		// 1. getParameter("파라미터명") ==> 해당 '파라미터명'에 설정되어 온 '값'을 가져온다.
		//				==> 이 때 설정하는 '파라미터명'은 보통 form태그 안에 만들어진 태그의 name속성값을 지정한다.
		//				==> 같은 '파라미터명'이 1개일 경우에 사용한다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		// 2. getParameterValues("파라미터명") ==> '파라미터명'이 같은 것이 여러개일 경우에 사용한다.
		//			==> 가져오는 '값'의 자료형은 'String[]'이다.
		
		// getParameterValues()메서드를 이용해서  name속성이 'hobby'인 체크박스 값들 읽어오기
		// 선택한 자료가 하나도 없으면 null이 저장된다.
		String[] hobbies = request.getParameterValues("hobby");
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body> <h2>Request객체 테스트 결과</h2>");
		out.println("<hr>");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		out.println("<tr><td>직 업</td>");
		out.println("<td>" + job + "</td></tr>");
		
		out.println("<tr><td>취 미</td>");
		out.println("<td>");
		
		// 반복문을 사용해서 배열 데이터를 처리한다.
		if(hobbies != null) {	// 선택한 자료가 하나도 없으면 null이 저장된다.
			for(int i=0; i<hobbies.length; i++) {
				out.println(hobbies[i] + "<br>");		
			}
			out.println("<hr>");
			
			// 향상된 for문...
			for(String hobby : hobbies) {
				out.println(hobby + "<br>");
			}
		}
		out.println("</td></tr>");
		out.println("</table>");
		
		// getParameterNames()메서드 ==> 전송된 모든 파라미터명을 Enumeration<String>객체에 담아서 반환한다.
		out.println("<h2>request 테스트 결과 - getParameterNames()메서드 </h2>");
		out.println("<ul>");
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			out.println("<li>" + name + "</li>");
		}
		out.println("</ul><hr>");
		
		// getParameterMap()메서드 ==> 전송된 모든 파라미터를 Map객체에 담아서 반환한다.
		//		==> 이 Map객체의 key값은 '파라미터명'이며 자료형은 String형이고,
		//		==>			 value값은 해당 파라미터의 '값'이 되고 자료형은 'String[]'이 된다.
		out.println("<h2>request 테스트 결과 - getParameterMap()메서드</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>파라미터 name</td><td>파라미터 value</td></tr>");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		
		// Map의 key값 개수만큼 반복 처리
		for(String key : paramMap.keySet()) {
			out.println("<tr><td>" + key + "</td><td>");
			String[] paramValues = paramMap.get(key);	// 파라미터 value값 구하기
			
			if(paramValues==null || paramValues.length == 0) {
				continue;
			}else if(paramValues.length == 1) {	// 파라미터 배열이 아닌 경우
				out.println(paramValues[0]);
			}else {	// 파라미터가 배열인 경우...
				for(int i=0; i<paramValues.length; i++) {
					if(i>0) out.println(",");
					out.println(paramValues[i]);
				}
				
			}
			out.println("</td></tr>");
		}
		
		out.println("</table>");
		
		out.println("<hr>");	
		out.println("<h2>request 테스트 결과 - 기타 메서드들</h2>");
		out.println("<ol>");
		out.println("<li>클라이언트의 IP주소 : " + request.getRemoteAddr() + "</li>");
		out.println("<li>요청 method : " + request.getMethod() + "</li>");
		out.println("<li>ContextPath : " + request.getContextPath() + "</li>");
		out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
		out.println("<li>URL 정보 : " + request.getRequestURL() + "</li>");
		out.println("<li>URI 정보 : " + request.getRequestURI() + "</li>");
		out.println("</ol>");
		out.println("");
		
		
		
		out.println("</body>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
















