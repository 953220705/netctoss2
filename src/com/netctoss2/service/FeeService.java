/**
 * 
 */
package com.netctoss2.service;

import java.util.List;


import com.netctoss2.entity.Fee;

/**
 * 资费的业务层
 * @author Administrator
 *
 */
public interface FeeService {
	/**
	 * 创建资费
	 * @param fee
	 * @return
	 */
	public boolean insertFee(Fee fee);
	/**
	 * 显示资费信息
	 * @param fee
	 * @return
	 */
	public List<Fee> selPageFee(int sIndex,int length,String rank, String order);
	/**
	 * 查询所有资费信息
	 * @return
	 */
	public List<Fee> selAllFee();
	/**
	 * 修改资费信息
	 * @param fee
	 * @return
	 */
	public boolean updateFee(Fee fee);
	/**
	 * 根据资费ID查询资费信息
	 * @param fee
	 * @return
	 */
	public Fee selFeeByFeeID(Fee fee);
	/**
	 * 删除资费
	 * @param fee
	 * @return
	 */
	public boolean delFee(Fee fee);
	/**
	 * 修改资费状态
	 * @param fe
	 * @return
	 */
	public boolean updateFeeState(Fee fee);
	
}
