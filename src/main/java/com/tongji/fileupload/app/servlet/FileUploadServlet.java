package com.tongji.fileupload.app.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.tongji.fileupload.app.beans.FileUploadBean;
import com.tongji.fileupload.app.db.UploadFileDao;
import com.tongji.fileupload.app.exception.InvalidExtNameException;
import com.tongji.fileupload.app.utils.FileUploadAppProperties;
import com.tongji.fileupload.app.utils.FileUtils;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//临时文件储存的地址
	private static final String TEMP_DIR="d:\\tempDirectory";
	//服务器上文件的位置，特别注意下，\\ 而不是//
	private static final String FILE_PATH="d:\\files";
	//数据库连接的对象
	private UploadFileDao dao = new UploadFileDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.支持中文
		request.setCharacterEncoding("utf-8");
		//如果成功指向一个地方，如果不成指向另外一个地方。
		String path=null;
		
		//获取ServletFileUpload对象
		ServletFileUpload upload = getServletFileUpload();
		try {
			//吧需要上传的FileItem都放入到Map中
			//键：文件的待存放的路径，值：对应的FileItem对象
			Map<String, FileItem> uploadFiles = new HashMap<String,FileItem>();
			
			//解析请求，得到FileItem的集合
			List<FileItem> items = upload.parseRequest(request);
			
			//1.构建FileUploadBean 的集合，同时填充uploadFiles
			List<FileUploadBean> beans = buildFileUploadBeans(items,uploadFiles);
			//2.校验拓展名
			validateExtName(beans);
			//3.校验文件大小，在解析时，已经校验了，我们只需要通过异常得到结果
			
			//4.进行文件的上传操作
			upload(uploadFiles);
			//5.吧上传的信息保存到数据库中
			saveBeans(beans);
			//6.删除临时文件夹里面的临时文件
			FileUtils.delAllFile(TEMP_DIR);
			path = "/app/success.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "/app/upload.jsp";
			request.setAttribute("message", e.getMessage());
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		/*String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		
		System.out.println(exts);
		System.out.println(fileMaxSize);
		System.err.println(totalFileMaxSize);*/
		
		
	}

	/**功能：
	 * 吧bean 对象保存到数据库中
	 */
	private void saveBeans(List<FileUploadBean> beans) {
		dao.save(beans);
		
	}

	/**功能：
	 * 校验拓展名,只要有一个文件拓展不合法，就全部不合法
	 * @param beans
	 */
	private void validateExtName(List<FileUploadBean> beans) {

		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		List<String> extList = Arrays.asList(exts.split(","));
		
		for(FileUploadBean bean:beans) {
			String fileName = bean.getFileName();
			//从后边取，因为11.woeo.txt 模式存在
			String extName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			if(! extList.contains(extName)) {
				throw new InvalidExtNameException(fileName+"文件拓展不正确");
			}
		}
		
	}

	/**功能：
	 *  文件上传前的准备工作. 得到 filePath 和 InputStream
	 * @param uploadFiles
	 * @throws IOException 
	 */
	private void upload(Map<String, FileItem> uploadFiles) throws IOException {
		for(Map.Entry<String, FileItem> uploadFile:uploadFiles.entrySet()) {
			String filePath = uploadFile.getKey();
			FileItem item = uploadFile.getValue();
			
			upload(filePath,item.getInputStream());
		}
	}

	/**功能：
	 *   真正的上次传函数
	 *   文件上传的 IO 方法.
	 * @param filePath
	 * @param inputStream
	 * @throws IOException 
	 */
	private void upload(String filePath, InputStream inputStream) throws IOException {
		OutputStream outputStream = new FileOutputStream(filePath);
		byte[] buffer = new byte[1024];
		int len = 0;
		
		while((len=inputStream.read(buffer))!=-1) {
			outputStream.write(buffer, 0, len);
		}
		
		inputStream.close();
		outputStream.close();
		System.out.println("上传成功: "+filePath);
		
		
	}

	/**功能：
	 * 利用传入的 FileItem 的集合, 构建 FileUploadBean 的集合, 同时填充 uploadFiles
	 * 
	 * FileUploadBean 对象封装了: id, fileName, filePath, fileDesc
	 * uploadFiles: Map<String, FileItem> 类型, 存放文件域类型的  FileItem. 键: 待保存的文件的名字 ,值: FileItem 对象
	 * 
	 * 构建过程:
	 * 1. 对传入 FileItem 的集合进行遍历. 得到 desc 的那个 Map. 键: desc 的 fieldName(desc1, desc2 ...). 
	 * 值: desc 的那个输入的文本值
	 * 
	 * 2. 对传入 FileItem 的集合进行遍历. 得到文件域的那些 FileItem 对象, 构建对应的 key (desc1 ....) 来获取其 desc.
	 * 构建的 FileUploadBean 对象, 
	 * 从1中的map中得到当前FileItem对应的那个desc 使用fileName后面的数字去匹配。并填充 beans 和 uploadFiles
	 * @param items
	 * @param uploadFiles
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) throws UnsupportedEncodingException {
		List<FileUploadBean> beans = new ArrayList<>();
		
		Map<String, String> descs = new HashMap<>();
		//先把desc保存起来
		for(FileItem item:items) {
			if(item.isFormField()) {
				//这个传值utf-8很关键。不然存进数据库是乱码
				descs.put(item.getFieldName(), item.getString("UTF-8"));
			}
		}
		
		for(FileItem item:items) {
			if(!item.isFormField()) {
				String fieldName = item.getFieldName();
				//通过fieldName后面的序号去获取，desc注释
				String index = fieldName.substring(fieldName.length()-1);
				
				
				String fileName = item.getName();
				String fileDesc = descs.get("desc"+index);
				String filePath = getFilePath(fileName);
				
				FileUploadBean bean = new FileUploadBean( fileName, filePath, fileDesc);
				beans.add(bean);
				uploadFiles.put(filePath, item);
			}
		}
		
				
		return beans;
	}

	/**功能：
	 * 
	 *    根据跟定的文件名构建一个随机的文件名
	 * 1. 构建的文件的文件名的扩展名和给定的文件的扩展名一致
	 * 2. 利用 ServletContext 的 getRealPath 方法获取的绝对路径
	 * 3. 利用了 Random 和 当前的系统时间构建随机的文件的名字
	 * @return
	 */
	private String getFilePath(String fileName) {
		//获取拓展名
		String extName = fileName.substring(fileName.lastIndexOf("."));
		//System.out.println("extName:"+extName);
		Random random = new Random();
		int randomNumber = random.nextInt(1000000);
		String filePath = FILE_PATH+"\\"+System.currentTimeMillis()+randomNumber+extName;
		//如果还是放在服务器上 filePath = 
		//FILE_PATH="/WEB-INF/files"
		//getServletContext().getRealPath(FILE_PATH)+....
		//System.out.println("filePath:"+filePath);
		return filePath;
	}

	/**功能：
	 * 构建ServletFileUpload对象
	 * 从配置文件中读取部分属性，用户配置约束
	 * 该方法代码来源于文档
	 * 具体内容可以参见文件上传helloworld那个例子。
	 * @return
	 */
	private ServletFileUpload getServletFileUpload() {
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File(TEMP_DIR);
		factory.setRepository(tempDirectory);

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
		upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
		
		return upload;
	}

}
