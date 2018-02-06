package com.tongji.upload.app.listener;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tongji.fileupload.app.utils.FileUploadAppProperties;

/**
 * Application Lifecycle Listener implementation class FileUploadAppListener
 *
 */
public class FileUploadAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FileUploadAppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }

	/**
     * 在开始的listener中读取配置文件，吧信息存进我们定义的对象中。这个对象是单例的。
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/upload.properties");
         
         Properties properties = new Properties();
         
         try {
			properties.load(inputStream);
			
			for(Map.Entry<Object,Object > prop:properties.entrySet()) {
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				
				FileUploadAppProperties.getInstance().addProperty(propertyName, propertyValue);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
	
}
