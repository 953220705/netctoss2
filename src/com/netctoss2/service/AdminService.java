/**
 * 
 */
package com.netctoss2.service;

import java.util.List;


import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;

/**
 * 管理员表的业务层
 * @author Administrator
 *
 */
public interface AdminService {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin);
	/**
	 * 修改以管理员信息
	 * @param admin
	 * @return
	 */
	public boolean updateAdmin(Admin admin);
	/**
	 * 修改管理员密码
	 * @param admin
	 * @return
	 */
	public boolean updateAdminPsw(Admin admin);
	/**
	 * 查询某一页管理员信息
	 * @param admin
	 * @return
	 */
	public List<Admin> getPageAdmin(int sIndex,int length,Role role,Permissions per);
	/**
	 * 添加管理员信息
	 * @param admin
	 * @return
	 */
	public boolean addAdmin(Admin admin);
	/**
	 * 查询管理员信息
	 * @param admin
	 * @return
	 */
	public Admin getAdminInfo(Admin admin);
	/**
	 * 管理管理员信息
	 * @param admin
	 * @return
	 */
	public boolean manageAdmin(Admin admin);
	/**
	 * 删除角色信息
	 * @param admin
	 * @return
	 */
	public boolean delAdmin(Admin admin);
	/**
	 * 重置管理员密码
	 * @param admin
	 * @return
	 */
	public boolean resetAdminPsw(List<Admin> la);
}
