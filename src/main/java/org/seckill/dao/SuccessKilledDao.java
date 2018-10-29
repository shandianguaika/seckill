package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.model.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * 插入一条成功购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	public int insertSuccessKilled(@Param("seckillId")String seckillId,@Param("userPhone")String userPhone);
	
	/**
	 * 查询一条购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	public SuccessKilled getSuccessKilledBy(@Param("seckillId")String seckillId,@Param("userPhone")String userPhone);

}
