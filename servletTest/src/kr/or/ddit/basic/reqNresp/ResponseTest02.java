package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
		- redirect
			=> 다른 페이지로 넘어가도록 한다. (이 때 직접 파라미터를 넘길 수 없다.)
			=> 응답할 때 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당 URL로 이동하는 방식이다.
			=> 이 이동방식은 무조건 GET방식으로 요청하기 때문에 URL의 길이에 제한이 있다.
			
			=> 호출하는 곳에서 사용하던 request, response를 유지하지 못하고 
				새로운 request와 response가 매개변수에 전달된다.
	*/	
		request.setCharacterEncoding("utf-8");
		
		//forward방식
		//request.setAttribute("tel", "010-9999-8888");
		
		// 파라미터로 넘어오는 값을 구한다.
		String userName = request.getParameter("username");
		
		// 형식) sendRedirect("전체URL주소");
		// response.sendRedirect(request.getContentType() + "/ResponseRedirectTest.do");
		
		// 새로운 페이지에 데이터를 넘겨주려면 URL주소 뒤에 물음표(?)를 붙이고
		// '변수=값&변수2=값2&변수3=값3'와 같은 형식으로 데이터를 구성해서 보내야한다.
		response.setCharacterEncoding("utf-8");
		userName = URLEncoder.encode(userName, "utf-8");
		response.sendRedirect(request.getContextPath() + "/ResponseRedirectTest.do?username=" + userName + "&tel=010-9999-8888");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
