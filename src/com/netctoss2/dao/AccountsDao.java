/**
 * 
 */
package com.netctoss2.dao;

import java.util.List;
import java.util.Map;

import com.netctoss2.entity.Accounts;
import com.netctoss2.entity.Services;

/**
 * 账务帐号数据控制层
 * @author Administrator
 *
 */
public interface AccountsDao {
	/**
	 * 显示一页账务帐号
	 * @param map
	 * @return
	 */
	public List<Accounts> selAccounts(Map map);
	/**
	 * 添加账务帐号
	 * @param acc
	 * @return
	 */
	public int insertAccounts(Accounts acc);
	/**
	 * 根据账务id查询账务账号
	 * @param acc
	 * @return
	 */
	public Accounts selAccByID(Accounts acc);
	/**
	 * 根据条件查询账务账号
	 * @param map
	 * @return
	 */
	public List<Accounts> selAccByCondition(Map map);
	/**
	 * 修改账务账号状态
	 * @param acc
	 * @return
	 */
	public int updateAccState(Accounts acc);
	/**
	 * 修改账务账号信息
	 * @param acc
	 * @return
	 */
	public int updateAcc(Accounts acc);
	/**
	 * 修改所属业务账号状态
	 * @param ser
	 * @return
	 */
	public int updateSerState(Services ser);
	/**
	 * 查询所属业务账号
	 * @param acc
	 * @return
	 */
	public List<Services> selAccOfSer(Accounts acc);
}
