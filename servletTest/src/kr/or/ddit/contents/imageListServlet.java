package kr.or.ddit.contents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/imageList")
public class imageListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String mime = "image/png";
      response.setContentType(mime);
      String id = request.getParameter("image");
      System.out.println(id);
      String source = "d:/contents/"+ id;
      
      File srcFile = new File(source);
      FileInputStream fis = new FileInputStream(srcFile);
      OutputStream os = response.getOutputStream();
      byte[] buffer = new byte[1024];
      int pointer = -1;
      
      while((pointer = fis.read(buffer))!= -1){
         os.write(buffer, 0, pointer);
      }
      
      fis.close();
      os.close();

   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}