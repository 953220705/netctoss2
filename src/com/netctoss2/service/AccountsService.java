/**
 * 
 */
package com.netctoss2.service;

import java.util.List;


import com.netctoss2.entity.Accounts;

/**
 * 账务账号表的事务层
 * @author Administrator
 *
 */
public interface AccountsService {
	/**
	 * 获取某页账务账号信息
	 * @param sIndex
	 * @param length
	 * @return
	 */
	public List<Accounts> getPageAcc(int sIndex,int length);
	/**
	 * 
	 * @param acc
	 * @return
	 */
	public boolean insertAcc(Accounts acc);
	/**
	 * 显示账务账号信息
	 * @param acc
	 * @return
	 */
	public Accounts getAccByID(Accounts acc);
	/**
	 * 查询账务帐号
	 * @param sIndex
	 * @param length
	 * @param acc
	 * @return
	 */
	public List<Accounts> getAccByCondition(int sIndex,int length,Accounts acc);
	/**
	 * 修改账务账号信息
	 * @param acc
	 * @return
	 */
	public boolean updateAcc(Accounts acc);
	/**
	 * 修改账务账号状态
	 * @param acc
	 * @return
	 */
	public boolean updateAccState(Accounts acc);
	/**
	 * 删除账务账号并记录删除时间
	 * @param acc
	 * @return
	 */
	public boolean delAcc(Accounts acc);
}
