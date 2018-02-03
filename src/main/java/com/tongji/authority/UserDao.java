/**
* Title: UserDao.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 2, 2018
* @version 1.0
*/
package com.tongji.authority;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
* Title: UserDao 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 2, 2018  
*/
public class UserDao {

	//这里应该是访问数据库，但是为了简化，我们直接在类里面写了,自己造数据。
	//放置用户的集合，用户里面分别有用户和权限组两个属性
	private static Map<String , User> users;
	
	private static List<Authority> authorities =null;
	
	static {
		//造几条权限数据
		authorities = new ArrayList<>();
		authorities.add(new Authority("Article-1", "/authority/article-1.jsp"));
		authorities.add(new Authority("Article-2", "/authority/article-2.jsp"));
		authorities.add(new Authority("Article-3", "/authority/article-3.jsp"));
		authorities.add(new Authority("Article-4", "/authority/article-4.jsp"));
		
		users = new HashMap<String ,User>();
		//新建用户1
		User user1= new User("AAA",authorities.subList(0, 2));
		//把用户的名字和用户添加到map集合中
		users.put("AAA", user1);
		
		User user2=new User("BBB", authorities.subList(2, 4));
		users.put("BBB", user2);
	}
	
	//取出某个用户
	User get (String username) {
		return users.get(username);
	}
	//修改权限
	void update(String username,List<Authority> authorities) {
		users.get(username).setAuthorities(authorities);
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	public List<Authority> getAuthorities(String[] urls){
		List<Authority> authorities2 = new ArrayList<>();
		//首先遍历所有的权限。然后遍历数组，看能不能匹配上，能匹配上就是我们要更新的数组。
		for(Authority authority:authorities) {
			if(urls!=null) {
				for(String url:urls) {
					if(url.equals(authority.getUrl())) {
						System.out.println(url);
						authorities2.add(authority);
					}
				}
			}
		}
		return authorities2;
	}
	
}
