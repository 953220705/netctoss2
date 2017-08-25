/**

 * 
 */
package com.netctoss2.entity;

import java.util.List;

/**
 * 权限表的实体类
 * @author Administrator
 *
 */
public class Role {
	private String role_id;
	private String role_name;
	private List<Permissions> lpe;
	private String per;
	/**
	 * @param roleID
	 * @param roleName
	 */
	public Role(String roleID, String roleName) {
		super();
		this.role_id = roleID;
		this.role_name = roleName;
	}
	/**
	 * 
	 */
	public Role() {
		super();
	}
	
	/**
	 * @param roleID
	 */
	public Role(String roleID) {
		super();
		this.role_id = roleID;
	}
	/**
	 * 获取权限id
	 * @return the roleID
	 */
	public String getRoleID() {
		return role_id;
	}
	/**
	 * 设置权限id
	 * @param roleID the roleID to set
	 */
	public void setRoleID(String roleID) {
		this.role_id = roleID;
	}
	/**
	 * 获取权限名
	 * @return the roleName
	 */
	public String getRoleName() {
		return role_name;
	}
	/**
	 * 设置权限名
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.role_name = roleName;
	}
	/**
	 * 获取权限列表
	 * @return the lpe
	 */
	public List<Permissions> getLpe() {
		return lpe;
	}
	/**
	 * 设置权限列表
	 * @param lpe the lpe to set
	 */
	public void setLpe(List<Permissions> lpe) {
		this.lpe = lpe;
		StringBuffer per = new StringBuffer();
		for(Permissions p:lpe){
			per.append(p.getPerName()+" , ");
		}
		this.setPer(per.delete(per.length()-2, per.length()-1)+"");
		//this.setPer(per+"");
	}
	/**
	 * 获取权限显示
	 * @return the per
	 */
	public String getPer() {
		return per;
	}
	/**
	 * 设置权限显示
	 * @param per the per to set
	 */
	public void setPer(String per) {
		this.per = per;
	}
	
	
}
