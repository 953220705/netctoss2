/**
 * 
 */
package com.netctoss2.dao;

import java.util.List;
import java.util.Map;

import com.netctoss2.entity.Services;

/**
 * 业务账号表的数据控制层
 * @author Administrator
 *
 */
public interface ServicesDao {
	/**
	 * 查询一页业务账号
	 * @param map
	 * @return
	 */
	public List<Services> selPageServices(Map map);
	/**
	 * 添加业务账号
	 * @param ser
	 * @return
	 */
	public int insertSer(Services ser);
	/**
	 * 根据业务id查询业务账号
	 * @param ser
	 * @return
	 */
	public Services selSerByID(Services ser);
	/**
	 * 修改业务账号
	 * @param ser
	 * @return
	 */
	public int updateSer(Services ser);
	/**
	 * 修改业务账号状态
	 * @param ser
	 * @return
	 */
	public int updateSerState(Services ser);
}
