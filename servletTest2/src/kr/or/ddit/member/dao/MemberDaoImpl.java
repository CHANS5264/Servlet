package kr.or.ddit.member.dao;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.util.BuildedSqlMapClient;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao; // 1번
	private SqlMapClient smc;	// SqlMapClient객체 변수 선언
	
	// 2번 생성자
	private MemberDaoImpl(){ 
		smc = BuildedSqlMapClient.getSqlMapClient(); // SqlMapClient객체 생성
	}
	
	// 3번
	public static MemberDaoImpl getInstance(){
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		
		try {		
			Object obj = smc.insert("mymember.insertMember", memVo);
			if(obj==null){
				cnt = 1;
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}


	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("mymember.deleteMember", memId);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt;
		
		try {
			cnt = smc.update("mymember.updateMember", memVo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null;
		
		try {
			memList = smc.queryForList("mymember.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memList;	

	}

	@Override
	public int getMemberCount(String memId) {
		
		int cnt = 0;
		
		try {
			
			cnt = (int) smc.queryForObject("mymember.getMemberCount", memId);
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// Key값 정보 ==> 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터값(data)
		
		int cnt = 0;
		
		try {
			
			cnt = smc.update("mymember.updateMember2", paramMap);
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	

	@Override
	public MemberVO getMember(String memId) {
		MemberVO memVo = null;
		try {
			memVo = (MemberVO) smc.queryForObject("mymember.getMember", memId);
		} catch (Exception e) {
			memVo = null;
			e.printStackTrace();
		}
		return memVo;
	}

}








