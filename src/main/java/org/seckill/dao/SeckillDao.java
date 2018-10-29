package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.model.Seckill;
/**
 * 
 * @author 小宇宙
 * @date 2018年10月28日
 */
public interface SeckillDao {

	/**
	 * 根据id进行减库存操作
	 * @param seckillId
	 * @return
	 */
	public int reduceNumber(@Param("seckillId")String seckillId,@Param("killTime")Date killTime);
	
	/**
	 * 根据id查询秒杀商品对象
	 * @param seckillId
	 * @return
	 */
	public Seckill querySeckill(@Param("seckillId")String seckillId);
	
	/**
	 * 查询秒杀商品列表
	 * @param off
	 * @param limit
	 * @return
	 */
	public List<Seckill> queryAll(@Param("off")int off,@Param("limit")int limit);
}
