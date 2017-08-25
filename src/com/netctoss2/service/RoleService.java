/**
 * 
 */
package com.netctoss2.service;

import java.util.List;

import com.netctoss2.entity.Role;

/**
 * 角色表的业务层
 * @author Administrator
 *
 */
public interface RoleService {
	/**
	 * 查询页面所有角色信息
	 * @param sIndex
	 * @param length
	 * @return
	 */
	public List<Role> getPageRole(int sIndex,int length);
	/**
	 * 添加角色信息
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	/**
	 * 修改角色信息
	 * @return
	 */
	public boolean updateRole(Role role);
	/**
	 * 删除角色
	 * @param role
	 * @return
	 */
	public boolean delRole(Role role);
	/**
	 * 获取角色信息
	 * @param role
	 * @return
	 */
	public Role getRole(Role role);
	/**
	 * 获取所有角色信息
	 * @return
	 */
	public List<Role> getAllRole();
	/**
	 * 判断角色名是否重复
	 * @return
	 */
	public boolean validationRoleName(Role role);
}
