package com.netctoss2.service;

import java.util.List;

import com.netctoss2.entity.Permissions;

public interface PermissionsService {
	/**
	 * 获取所有权限
	 * @return
	 */
	public List<Permissions> getAllPermissions();
}
