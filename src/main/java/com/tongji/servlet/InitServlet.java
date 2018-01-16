package com.tongji.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongji.dao.factory.CustomerDAOFactory;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public void init() {
    	
    	//默认是jdbc
       CustomerDAOFactory.getInstance().setType("jdbc");
     //读取类路径下的 switch.properties 文件
       InputStream inputStream =
    		   getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
       Properties properties=new Properties();
       
       try {
			properties.load(inputStream);
			//获取 switch.properties 的 type 属性值
			String type = properties.getProperty("type");
			//赋给了 CustomerDAOFactory 的 type 属性值
			CustomerDAOFactory.getInstance().setType(type);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
       
       
    }

	

}
