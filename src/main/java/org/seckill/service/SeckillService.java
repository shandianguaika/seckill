package org.seckill.service;

import java.util.List;

import org.common.exception.RepeatKillException;
import org.common.exception.SeckillCloseException;
import org.common.exception.SeckillException;
import org.seckill.dto.Expose;
import org.seckill.dto.SeckillExecution;
import org.seckill.model.Seckill;

/**
 * 
 * @author 小宇宙
 * @date 2018年10月28日
 */
public interface SeckillService {

	/**
	 *   获取秒杀列表
	 * @return
	 */
	public List<Seckill> getAll();
	
	/**
	 * 获取单个秒杀商品信息
	 * @param seckillId
	 * @return
	 */
	public Seckill getSeckill(String seckillId);
	
	/**
	 * 秒杀是否开启
	 * @param seckillId
	 * @return
	 */
	public Expose getSeckillUrl(String seckillId);
	
	/**
	 *  执行秒杀操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	public SeckillExecution executeSeckill(String seckillId, String userPhone, String md5)
			throws SeckillCloseException, RepeatKillException, SeckillException;
}
