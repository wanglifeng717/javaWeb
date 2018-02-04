/**
* Title: Authority.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Feb 2, 2018
* @version 1.0
*/
package com.tongji.authority;

/**  
* Title: Authority 
* Description:  
* @author mdm(computer in lab)  
* @date Feb 2, 2018  
*/
public class Authority {

	//显示到桌面上的权限的名字
	private String displayName;
	//权限对应的URL地址，理论是上是多对多，但是为了简化，这里就是一对一例如 Article-1 -> /article-1.jsp
	private String url;
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Authority [displayName=" + displayName + ", url=" + url + "]";
	}
	public Authority(String displayName, String url) {
		super();
		this.displayName = displayName;
		this.url = url;
	}
	public String getDisplayName() {
		return displayName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
