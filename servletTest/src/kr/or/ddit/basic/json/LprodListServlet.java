package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import util.DBUtil3;

/**
 * Servlet implementation class LprodListServlet
 */
@WebServlet("/lprod/LprodList.do")
public class LprodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<LprodVO> lprodList = new ArrayList<LprodVO>();
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from lprod";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			// 반복문 안에서는 가져온 데이터를 VO에 매핑하고 이 VO를 List에 추가한다.
			while(rs.next()){
				LprodVO lvo = new LprodVO();
				
				lvo.setLprod_id(rs.getInt("LPROD_ID"));
				lvo.setLprod_nm(rs.getString("LPROD_NM"));
				lvo.setLprod_gu(rs.getString("LPROD_GU"));
				
				lprodList.add(lvo);
			}
			
		} catch (SQLException e) {
			lprodList = null;
			e.printStackTrace();
		} finally {
			if(rs!=null) try{ rs.close(); }catch(SQLException e){}
			if(stmt!=null) try{ stmt.close(); }catch(SQLException e){}
			if(conn!=null) try{ conn.close(); }catch(SQLException e){}
		}
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json); charset=utf-8");
		
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(lprodList);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		out.flush();
				
		out.close();
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
