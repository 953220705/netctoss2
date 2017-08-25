/**
 * 
 */
package com.netctoss2.entity;

import java.sql.Timestamp;




import java.util.Date;


import java.util.List;

/**
 * 管理员表的实体类
 * @author Administrator
 *
 */
public class Admin {
	//定义实体类属性
	private String admin_id;
	private String admin_name;
	private String admin_log;
	private String admin_psw;
	private String admin_photo;
	private String admin_phone;
	private String admin_email;
	private Date powertime;
	private Date cretime;
	private List<Role> lro;
	private String role;
	private String oneRole;
	private List<Permissions> lpe;
	private String per;
	/**
	 * @param adminID
	 * @param adminName
	 * @param adminLog
	 * @param adminPsw
	 * @param adminPhoto
	 * @param adminPhone
	 * @param adminEmail
	 * @param roleTime
	 */
	public Admin(String adminID, String adminName, String adminLog, String adminPsw, String adminPhoto,
			String adminPhone, String adminEmail, Date roleTime) {
		super();
		this.admin_id = adminID;
		this.admin_name = adminName;
		this.admin_log = adminLog;
		this.admin_psw = adminPsw;
		this.admin_photo = adminPhoto;
		this.admin_phone = adminPhone;
		this.admin_email = adminEmail;
		this.powertime = roleTime;
	}
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	/**
	 * 获取管理员id
	 * @return the adminID
	 */
	public String getAdminID() {
		return admin_id;
	}
	/**设置管理员id
	 * @param adminID the adminID to set
	 */
	public void setAdminID(String adminID) {
		this.admin_id = adminID;
	}
	/**
	 * 获取管理员姓名
	 * @return the adminName
	 */
	public String getAdminName() {
		return admin_name;
	}
	/**设置管理员姓名
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.admin_name = adminName;
	}
	/**获取管理员登录名
	 * @return the adminLog
	 */
	public String getAdminLog() {
		return admin_log;
	}
	/**设置管理员登录名
	 * @param adminLog the adminLog to set
	 */
	public void setAdminLog(String adminLog) {
		this.admin_log = adminLog;
	}
	/**
	 * 获取管理员密码
	 * @return the adminPsw
	 */
	public String getAdminPsw() {
		return admin_psw;
	}
	/**
	 * 设置管理员密码
	 * @param adminPsw the adminPsw to set
	 */
	public void setAdminPsw(String adminPsw) {
		this.admin_psw = adminPsw;
	}
	/**
	 * 获取管理员照片
	 * @return the adminPhoto
	 */
	public String getAdminPhoto() {
		return admin_photo;
	}
	/**
	 * 设置管理员照片
	 * @param adminPhoto the adminPhoto to set
	 */
	public void setAdminPhoto(String adminPhoto) {
		this.admin_photo = adminPhoto;
	}
	/**
	 * 获取管理员电话
	 * @return the adminPhone
	 */
	public String getAdminPhone() {
		return admin_phone;
	}
	/**
	 * 设置管理员电话
	 * @param adminPhone the adminPhone to set
	 */
	public void setAdminPhone(String adminPhone) {
		this.admin_phone = adminPhone;
	}
	/**
	 * 获取管理员email
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return admin_email;
	}
	/**
	 * 设置管理员电话
	 * @param adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.admin_email = adminEmail;
	}
	/**
	 * 获取授权日期
	 * @return the roleTime
	 */
	public Date getPowerTime() {
		return powertime;
	}
	/**
	 * 设置授权日期
	 * @param roleTime the roleTime to set
	 */
	public void setPowerTime(Date roleTime) {
		this.powertime = roleTime;
	}
	/**
	 * 获取管理员角色
	 * @return the lro
	 */
	public List<Role> getLro() {
		return lro;
	}
	/**
	 * 设置管理员角色
	 * @param lro the lro to set
	 */
	public void setLro(List<Role> lro) {
		this.lro = lro;
		StringBuffer role = new StringBuffer("");
		this.setOneRole(lro.get(0).getRoleName());
		for(Role r:lro){
			role.append(r.getRoleName()+" , ");
		}
		this.setRole(role.delete(role.length()-2,role.length()-1)+"");
	}
	/**
	 * 获取管理员权限
	 * @return the lpe
	 */
	public List<Permissions> getLpe() {
		return lpe;
	}
	/**
	 * 设置管理员权限
	 * @param lpe the lpe to set
	 */
	public void setLpe(List<Permissions> lpe) {
		this.lpe = lpe;
		StringBuffer per = new StringBuffer("");
		for(Permissions p:lpe){
			per.append(p.getPerName()+" , ");
		}
		this.setPer(per.delete(per.length()-2,per.length()-1)+"");
	}
	/**
	 * 获取创建日期
	 * @return the creTime
	 */
	public Date getCreTime() {
		return cretime;
	}
	/**
	 * 设置创建日期
	 * @param creTime the creTime to set
	 */
	public void setCreTime(Date creTime) {
		this.cretime = creTime;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the per
	 */
	public String getPer() {
		return per;
	}
	/**
	 * @param per the per to set
	 */
	public void setPer(String per) {
		this.per = per;
	}
	/**
	 * 获取一个显示角色名
	 * @return the oneRole
	 */
	public String getOneRole() {
		return oneRole;
	}
	/**
	 * 设置一个显示角色名
	 * @param oneRole the oneRole to set
	 */
	public void setOneRole(String oneRole) {
		this.oneRole = oneRole;
	}
	
}
