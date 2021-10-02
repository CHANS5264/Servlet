package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/JSONTest.do")
public class JSONTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//응답을 json으로 보내기
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");	//***이 부분 중요 확인 잘하기
		
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();	//JSON 라이브러리(Gson)객체 생성
		String jsonData = null;
		
		switch(choice) {
			case "str":
				String str = "안녕하세요.";
				jsonData = gson.toJson(str);	//데이터를 JSON 형태의 문자열로 변환한다.
				break;
			case "array":
				int[] arr = new int[] {10, 20, 30, 40, 50};
				jsonData = gson.toJson(arr);
				break;
			case "obj":	//SampleVO 클래스를 만들어서 사용한다.
				SampleVO sample = new SampleVO();
				sample.setId(100);
				sample.setName("홍길동");
				
				jsonData = gson.toJson(sample);
				break;
			case "list":
				List<SampleVO> samList = new ArrayList<SampleVO>();
				samList.add(new SampleVO(1000, "일지매"));
				samList.add(new SampleVO(2000, "홍길동"));
				samList.add(new SampleVO(3000, "성춘향"));
				samList.add(new SampleVO(4000, "강감찬"));

				jsonData = gson.toJson(samList);
				break;
			case "map":
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", "강감찬");
				map.put("tel", "010-1234-5678");
				map.put("addr", "대전");
				
				jsonData = gson.toJson(map);
				break;
		}
		
		//변환된 JSON 구조의 문자열을 출력해본다.
		System.out.println(choice + " : " + jsonData);
		
		//만들어진 JSON 문자열을 응답 데이터로 보내준다.
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

