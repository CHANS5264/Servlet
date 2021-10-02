package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/UplodFileList.do")
public class UplodFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = "d:/d_other/uploadFiles";
		
		File fileUploadDir = new File(uploadPath);
		// 저장될 폴더가 없으면 새로 생성한다.
		if(!fileUploadDir.exists()) {
			fileUploadDir.mkdir();
		}
		
		// 파일이 저장된 폴더에 있는 파일 전체 목록을 구해와서 List에 담아준다.
		File[] allFiles = fileUploadDir.listFiles();
		List<UploadDetail> fileList = new ArrayList<UploadDetail>();
		
		for(File file : allFiles) {
			if(file.isFile()) {
				UploadDetail detail = new UploadDetail();
				detail.setFileName(file.getName());
				detail.setFileSize((long)Math.ceil(file.length() / 1024.0));
				detail.setUploadStatus("Seccess");
				fileList.add(detail);
			}
			
		}
		
		request.setAttribute("uploadFiles", fileList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/basic/fileupload/allFiles.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
