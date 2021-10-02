package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//String fi = request.getParameter("num1");
		//String se = request.getParameter("num2");
		//int first = Integer.parseInt(fi);
		//int second = Integer.parseInt(se);
		
		// form에서 보내온 값을 받는다.
		int first = Integer.parseInt(request.getParameter("num1"));
		int second = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
		
		// 계산 결과가 저장될 변수 선언 
		double result = 0;
		boolean calcOk = true;	// 계산 성공 여부를 저장하는 변수 선언
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body><h2>RequestTest02 결과 </h2>");
		
		switch(op) {
			case "+" : result = first + second; break;
			case "-" : result = first - second; break;
			case "*" : result = first * second; break;
			case "/" : 
				if(second!=0) {
					result = (double) first / second;
				}else {
					calcOk = false;
				}
				break;
			case "%" : 
				if(second!=0) {
					result = first % second;
				}else {
					calcOk = false;
				}
				break;
		}
		
//		if(op.equals("+")) {
//			result = first + second;
//		}else if(op.equals("-")) {
//			result = first - second;
//		}else if(op.equals("*")) {
//			result = first * second;
//		}else if(op.equals("/")) {
//			result = (double) first / second;
//		}else if(op.equals("%")) {
//			result = first % second;
//		}
//		out.println("<p>첫번째 입력 값 : " + first + "</p>");
//		out.println("<p>두번째 입력 값 : " + second + "</p>");
//		out.println("<p>결과값 : " + result + "</p>");
		
		out.printf("%d %s %d = ", first, op, second);
		if(calcOk==true) {
			out.println(result);
		}else {
			out.println("계산불능(0으로 나누기)");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
