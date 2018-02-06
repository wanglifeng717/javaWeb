package com.tongji.download.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("application/x-msdownload"); 
		
		String fileName = "文件下载.pptx";
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		
		OutputStream out = response.getOutputStream();
		String pptFileName = "C:\\Users\\mdm\\Desktop\\ss.png";
		
		InputStream in = new FileInputStream(pptFileName);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		in.close();
		//out是关不了的，因为是给用户的
	}
	

}
