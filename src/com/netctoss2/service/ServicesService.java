/**
 * 
 */
package com.netctoss2.service;

import java.util.List;

import com.netctoss2.entity.Services;

/**
 * 业务账号的事务层
 * @author Administrator
 *
 */
public interface ServicesService {
	/**
	 * 获取一页业务账号信息
	 * @param sIndex
	 * @param length
	 * @param ser
	 * @return
	 */
	public List<Services> getPageServices(int sIndex,int length,Services ser);
	/**
	 * 添加业务账号
	 * @param ser
	 * @return
	 */
	public boolean addService(Services ser);
	/**
	 * 根据id查询业务账号
	 * @param ser
	 * @return
	 */
	public Services getServicesByID(Services ser);
	/**
	 * 修改业务账号
	 * @param ser
	 * @return
	 */
	public boolean updateSer(Services ser);
	/**
	 * 修改业务账号状态
	 * @param ser
	 * @return
	 */
	public boolean updateSerState(Services ser);
}
