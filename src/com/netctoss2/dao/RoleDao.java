/**
 * 
 */
package com.netctoss2.dao;

import java.util.List;
import java.util.Map;

import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Role;

/**
 * 管理员角色表的数据控制层
 * @author Administrator
 *
 */
public interface RoleDao {
	/**
	 * 查询某管理员角色
	 * @param role
	 * @return
	 */
	public Role selAdminOfRole(Admin admin);
	/**
	 * 显示一页角色信息
	 * @param map
	 * @return
	 */
	public List<Role> selPageRole(Map map);
	/**
	 * 修改角色姓名
	 * @param role
	 * @return
	 */
	public int updateRoleName(Role role);
	/**
	 * 删除某角色的权限
	 * @param role
	 * @return
	 */
	public int delRoleOfPer(Role role);
	/**
	 * 添加角色权限
	 * @param role
	 * @return
	 */
	public int insertRoleOfPer(Role role);
	/**
	 * 查询角色信息
	 * @param role
	 * @return
	 */
	public Role selRole(Role role);
	/**
	 * 添加角色信息
	 * @param role
	 * @return
	 */
	public int insertRole(Role role);
	/**
	 * 删除角色信息
	 * @param role
	 * @return
	 */
	public int delRole(Role role);
	/**
	 * 查询所有角色信息
	 * @return
	 */
	public List<Role> selAllRole();
}
