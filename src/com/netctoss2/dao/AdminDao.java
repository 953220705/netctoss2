/**
 * 
 */
package com.netctoss2.dao;

import java.util.List;
import java.util.Map;

import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;

/**
 * 管理员表的数据控制层
 * @author Administrator
 *
 */
public interface AdminDao {
	/**
	 * 根据用户名密码查询管理员信息
	 * @param admin
	 * @return
	 */
	public Admin adminLogin(Admin admin);
	/**
	 * 修改管理员信息
	 * @param admin
	 */
	public int updateAdmin(Admin admin);
	/**
	 * 修改管理员密码
	 * @param admin
	 * @return
	 */
	public int updateAdminPsw(Admin admin);
	/**
	 * 查询某页管理员
	 * @param map
	 * @return
	 */
	public List<Admin> selPageAdmin(Map map);
	/**
	 * 查询具有某权限的管理员
	 * @param per
	 * @return
	 */
	public List<Admin> selPerOfAdmin(Permissions per);
	/**
	 * 查询具有某角色的管理员
	 * @param role
	 * @return
	 */
	public List<Admin> selRoleOfAdmin(Role role);
	/**
	 * 增加管理员
	 * @param admin
	 * @return
	 */
	public int insertAdmin(Admin admin);
	/**
	 * 添加管理员角色
	 * @param admin
	 * @return
	 */
	public int insertAdminofRole(Admin admin);
	/**
	 * 根据管理员id查询管理员
	 * @param admin
	 * @return
	 */
	public Admin selAdminByID(Admin admin);
	/**
	 * 管理管理员信息
	 * @param admin
	 * @return
	 */
	public int manageAdminInfo(Admin admin);
	/**
	 * 删除管理员角色
	 * @param admin
	 * @return
	 */
	public int delAdminOfRole(Admin admin);
	/**
	 * 删除管理员
	 * @param admin
	 * @return
	 */
	public int delAdmin(Admin admin);
	/**
	 * 重置管理员密码
	 * @param map
	 * @return
	 */
	public int resetAdminPsw(Map map);
}
