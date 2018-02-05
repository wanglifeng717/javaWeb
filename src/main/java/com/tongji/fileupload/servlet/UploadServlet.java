package com.tongji.fileupload.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//1.获取请求信息,编码方式是以二进制的方式写的，所以你这样的方式获取不到。
		String file = request.getParameter("file");
		String desc =  request.getParameter("desc");
		
		System.out.println(file);//null
		System.out.println(desc);//null
		
*/	
		
		/*InputStream inputStream = request.getInputStream();
		 Reader reader = new InputStreamReader(inputStream);
		 BufferedReader bufferedReader = new BufferedReader(reader);
		 
		 String string =null;
		 
		 while((string = bufferedReader.readLine())!=null) {
			 System.out.println(string);
		 }*/
		
		//1.得到FileItem的集合items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//set factory constraints
		//设置文件大小，超过500K就写到我的临时目录里面
		factory.setSizeThreshold(1024*500);
		File tempDirectory = new File("d:\\tempDirectory");
		factory.setRepository(tempDirectory);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置文件总的大小
		upload.setFileSizeMax(1024*1024*50);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			//2.遍历items：若是一个一般的表单域，打印信息
			for(FileItem item:items) {
				if(item.isFormField()) {
					String name = item.getFieldName();
					String value= item.getString();
					
					System.out.println(name+":"+value);
							
				}
				//3.若是文件域把文件保存到d:\\files目录下。
				else {
					//文件的属性file
					String fieldName = item.getFieldName();
					//文件名
					String filedName = item.getName();
					//文件类型
					String contentType = item.getContentType();
					boolean isInMemory = item.isInMemory();
					long sizeInBytes = item.getSize();
					
					System.out.println("fieldName:"+fieldName);
					System.out.println("filedName:"+filedName);
					System.out.println("contentType:"+contentType);
					System.out.println("isInMemory:"+isInMemory);
					System.out.println("sizeInBytes:"+sizeInBytes);
					
					InputStream inputStream = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len=0;
					
					//文件上传保存的位置：
					filedName = "d:\\files\\"+filedName;
					System.out.println("保存的文件地址:"+filedName);
					
					OutputStream outputStream  = new FileOutputStream(filedName);
					
					while((len=inputStream.read(buffer))!=-1) {
						outputStream.write(buffer, 0, len);
					}
					outputStream.close();
					inputStream.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		//
		
	}

}
