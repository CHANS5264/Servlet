package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImlp;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("mem_id");
		String memPass = request.getParameter("mem_pass");
		String memName = request.getParameter("mem_name");
		String memTel = request.getParameter("mem_tel");
		String memAddr = request.getParameter("mem_addr");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		IMemberService service = MemberServiceImlp.getInstance();
		
		int cnt = service.insertMember(memVo);
		
		// insert작업 완료 후 List로 가기
		response.sendRedirect(request.getContextPath() + "/member/memberList.do");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
