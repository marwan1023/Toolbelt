package generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Generator extends HttpServlet { 
  /**
     * 
     */
    private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {
    // reading the user input
//    String color= request.getParameter("color");    
//    PrintWriter out = response.getWriter();
//    out.println (
//      "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
//      "<html> \n" +
//        "<head> \n" +
//          "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=ISO-8859-1\"> \n" +
//          "<title> My first jsp  </title> \n" +
//        "</head> \n" +
//        "<body> \n" +
//          "<font size=\"12px\" color=\"" + color + "\">" +
//            "Hello World" +
//          "</font> \n" +
//        "</body> \n" +
//      "</html>" 
//    );  
    
   
    
    // obtains ServletContext
    ServletContext context = getServletContext();
     
    // gets MIME type of the file
//    String mimeType = context.getMimeType(filePath);
//    if (mimeType == null) {        
//        // set to binary type if MIME mapping not found
//        mimeType = "application/octet-stream";
//    }
//    System.out.println("MIME type: " + mimeType);
     
    // modifies response
    //response.setContentType(mimeType);
    //response.setContentLength((int) downloadFile.length());
     
    // forces download
    String headerKey = "Content-Disposition";
    String headerValue = String.format("attachment; filename=\"%s\"", "Test.xml");
    response.setHeader(headerKey, headerValue);
    
    OutputStream outStream = response.getOutputStream();
    String helloTest = "Hello";
    outStream.write(helloTest.getBytes());
    
//    FileInputStream in = new FileInputStream("Test.xml");
//    byte[] buffer = new byte[4096];
//    int length;
//    while ((length = in.read(buffer)) > 0){
//        outStream.write(buffer, 0, length);
//    }
//    in.close();
    //outStream.flush();
    outStream.close();
    
    
    
  }  
}
