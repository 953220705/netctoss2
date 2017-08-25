/**
 * 
 */
package com.netctoss2.entity;

/**
 * 角色表的实体类
 * @author Administrator
 *
 */
public class Permissions {
	private String per_id;
	private String per_name;
	private String per_url;
	private String per_css;
	/**
	 * @param perID
	 * @param perName
	 */
	public Permissions(String perID, String perName) {
		super();
		this.per_id = perID;
		this.per_name = perName;
	}
	/**
	 * 
	 */
	public Permissions() {
		super();
	}
	/**
	 * 获取角色id
	 * @return the perID
	 */
	public String getPerID() {
		return per_id;
	}
	/**
	 * 设置角色id
	 * @param perID the perID to set
	 */
	public void setPerID(String perID) {
		this.per_id = perID;
	}
	/**
	 * 获取角色名
	 * @return the perName
	 */
	public String getPerName() {
		return per_name;
	}
	/**
	 * 设置角色名
	 * @param perName the perName to set
	 */
	public void setPerName(String perName) {
		this.per_name = perName;
	}
	/**
	 * 获取url地址
	 * @return the perurl
	 */
	public String getPerurl() {
		return per_url;
	}
	/**
	 * 设置url地址
	 * @param perurl the perurl to set
	 */
	public void setPerurl(String perurl) {
		this.per_url = perurl;
	}
	/**
	 * 获取标签样式
	 * @return the percss
	 */
	public String getPercss() {
		return per_css;
	}
	/**
	 * 设置标签样式
	 * @param percss the percss to set
	 */
	public void setPercss(String percss) {
		this.per_css = percss;
	}
	
}
