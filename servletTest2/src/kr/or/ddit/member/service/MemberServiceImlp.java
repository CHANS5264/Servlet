package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImlp implements IMemberService{
	private IMemberDao dao;	 // DAO객체가 저장될 변수 선언
	
	private static MemberServiceImlp service;
	
	// 생성자
	private MemberServiceImlp() {
		//dao = new MemberDaoImpl(); // DAO객체 생성
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImlp getInstance(){
		if(service == null) service = new MemberServiceImlp();
		
		return service;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

	@Override
	public MemberVO getMember(String memId) {
		return null;
	}
	
}
