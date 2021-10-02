package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	서블릿의 동작 방식에 대하여 
	1) 사용자(클라이언트)가 URL을 입력하면 HTTP Request를 Servlet Container로 전송(요청)한다.
	2) 컨테이너는 web.xml에 정의된 URL패턴을 확인하여 어느 서블릿을 통해서 처리할지를 검색한다.
		(이 때 해당 서블릿이 로딩이 안되어 있는 상태면 로딩을 하고 init()메서드를 호출한다.)
		(Servlet3.0이상에서는 애노테이션(@WebServlet)으로 설정 가능하다.)
	3) Servlet Container는 요청을 처리할 개별 쓰레드 객체를 생성하여 해당 서블릿객체의 service()메서드를 호출한다.
	   (이 때 HttpRequest 및 HttpResponse 객체를 생성하여 파라미터로 넘겨준다.)
	4) service()메서드는 요청 메서드 타입을 체크하여 적절한 메서드를 호출한다. (doGet, doPost, doPut, doDelete등)
	5) 요청 처리가 완료되면 HttpRequest 및 HttpResponse객체는 소멸된다.
	6) 컨테이너로부터 서블릿이 제거되는 경우에는 destroy()메서드가 호출된다.
*/

// Servlet의 LifeCycle
@WebServlet("/servletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
    public void init() throws ServletException {
		System.out.println("Servlet : " + this.getServletName() + "에서 init()메서드 호출..."); // 서버의 콘솔창
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()메서드 시작...");
		
		// GET방식과 POST방식에 맞는 메서드 호출하기
		// 방법1) 부모 객체인 HttpServlet객체의 service()메서드로 위임해서 처리하기
		//super.service(req, resp);
		
		// 방법2) 클라이언트의 전송 방식(GET, POST등)을 구분해서 직접 메서드 호출하기
		String method = req.getMethod();
		System.out.println("method = " + method);
		
		if("GET".equals(method)) {
			this.doGet(req, resp);
		}else if("POST".equals(method)) {
			this.doPost(req, resp);
		}
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.append("<html><head><meta charset='utf-8'></head>"
				+ "<body><h1>doGet()메서드의 처리 내용!!</h1></body></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>"
				+ "<body><h1>doPost()메서드의 처리 내용~~</h1></body></html>");
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet : " + this.getServletName() + "에서 destroy()메서드 호출...");
	}
}














