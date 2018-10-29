package org.seckill.dto;

import org.common.enums.Enums;
import org.seckill.model.SuccessKilled;
/**
 * 秒杀返回数据信息
 * @author 小宇宙
 * @date 2018年10月28日
 */
public class SeckillExecution {

	private String seckillId;
	
	//秒杀状态
	private int state;
	
	//秒杀信息
	private String stateInfo;
	
	//秒杀成功数据
	private SuccessKilled successKilled;

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public SeckillExecution(String seckillId, Enums seckillEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = seckillEnum.getIndex();
		this.stateInfo = seckillEnum.getInfo();
		this.successKilled = successKilled;
	}
}
