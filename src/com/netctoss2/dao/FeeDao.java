/**
 * 
 */
package com.netctoss2.dao;

import java.util.List;
import java.util.Map;

import com.netctoss2.entity.Fee;

/**
 * 资费表的数据控制层
 * @author Administrator
 *
 */
public interface FeeDao {
	/**
	 * 查询某一页信息
	 * @param map
	 * @return
	 */
	public List<Fee> selPageFee(Map map);
	/**
	 * 添加资费
	 * @param fee
	 * @return
	 */
	public int insertFee(Fee fee);
	/**
	 * 查询资费
	 * @param fee
	 * @return
	 */
	public Fee selFee(Fee fee);
	/**
	 * 修改资费
	 * @param fee
	 * @return
	 */
	public int updateFee(Fee fee);
	/**
	 * 修改 资费状态
	 * @param fee
	 * @return
	 */
	public int updateFeeState(Fee fee);
	/**
	 * 删除资费
	 * @param fee
	 * @return
	 */
	public int delFee(Fee fee);
	/**
	 * 查询所有资费
	 * @return
	 */
	public List<Fee> selAllFee();
}
