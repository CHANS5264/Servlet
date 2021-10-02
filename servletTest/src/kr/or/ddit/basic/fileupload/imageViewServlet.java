package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images/imagesView.do")
public class imageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("fileName");
		String imagePath = "d:/d_other/uploadFiles";
		String filePath = imagePath + File.separator + fileName;
		
		File file = new File(filePath);
		
		OutputStream out = null;
		FileInputStream fin = null;
		
		if(file.exists()) {
			try {
				// 출력용 스트림 객체 생성 ==> Response객체 이용
				out = response.getOutputStream();
				
				// 파일 입력용 스트림 객체 생성
				fin = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int len = -1;
				
				// byte 배영을 이용해서 파일 내용을 읽어와 출력용 스트림 객체로 출력한다.
				while((len = fin.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				out.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류" + e.getMessage());
			} finally {
				if(fin != null) fin.close();
				if(out != null) out.close();
			}
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
