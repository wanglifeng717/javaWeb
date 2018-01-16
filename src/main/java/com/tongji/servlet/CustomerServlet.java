package com.tongji.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tongji.dao.CriteriaCustomer;
import com.tongji.dao.CustomerDAO;
import com.tongji.dao.impl.CustomerDAOJdbcImpl;
import com.tongji.domain.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//通过DAO进行增删改查的操作。
	private CustomerDAO customerDAO =new CustomerDAOJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1,servletPath.indexOf("."));
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			//如果没有那个方法，就从定向到一个错误页面
			response.sendRedirect("error.jsp");
			
		}
	}
	
	

	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String idStr = request.getParameter("id");
		//这里id=0和放在try里面是很有必要的，一旦你传的id=cc 出现异常，不会执行删除操作,直接转发到原来的界面了，没问题。
		int id=0;
		try {
			id = Integer.parseInt(idStr);
			customerDAO.delete(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		//重定向到查询界面，重新查出里面还有什么记录
		response.sendRedirect("query.do");
		
	}

	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name=request.getParameter("name");
		String phone = request.getParameter("phone");
		String address=request.getParameter("address");
		
		CriteriaCustomer criteriaCustomer = new CriteriaCustomer(name, address, phone);
		
		//1.调用customerDAO的getAll（）方法，得到customers的集合
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(criteriaCustomer);
		//2.把customer的集合放到request中
		request.setAttribute("customers", customers);
		//3.转发页面到index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	/**功能：
	 * 
	 * @param request
	 * @param response
	 */
	private void addCustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("add...");
		
	}

}
