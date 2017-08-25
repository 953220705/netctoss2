/**
 * 
 */
package com.netctoss2.dao;

import java.util.List;

import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;

/**
 * 权限表的数据控制层
 * @author Administrator
 *
 */
public interface PermissionsDao {
	/**
	 * 查询某管理员权限
	 * @param admin
	 * @return
	 */
	public List<Permissions> selAdminOfPer(Admin admin);
	/**
	 * 查询某角色的权限
	 * @param role
	 * @return
	 */
	public List<Permissions> selRoleOfPer(Role role);
	/**
	 * 查询所有权限信息
	 * @return
	 */
	public List<Permissions> selAllPer();
}
