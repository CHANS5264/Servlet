package kr.or.ddit.basic.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
		- forward
			=> 특정 서블릿에 대한 요청을 다른 서블릿이나 JSP로 제어를 넘겨준다.
			   (이때 request, response 파라미터는 넘겨준다.)
			=> URL주소는 처음 요청할 때의 값으로 바뀌지 않으며, redirect보다 성능이 좋다.
			   (Server의 내부에서만 접근이 가능하다.)
			  
	*/	
		// forward로 이동하는 문서에 데이터 넘겨주기
		// request객체의 setAttribute()메서드로 데이터를 셋팅하여 보내고
		// 받는 쪽에서 getAttribute()메서드로 데이터를 읽어온다.
		
		//request.getParameter("username");
		// 형식) setAttribute("키값", 데이터값);	// 키값 : 문자열, 데이터값 : 자바의 모든데이터
		request.setAttribute("tel", "010-1234-5678");
		
		// forward방식 처리하기
		// 형식) getRequestDispatcher("ContextPath 이후의 경로를 기술한다.");
		//		원래 URL : "/servletTest/ResponseForwardTest.do"
		//		forward방식에 사용하는 URL = "/ResponseForwardTest.do" 
		RequestDispatcher rd = request.getRequestDispatcher("/ResponseForwardTest.do");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
