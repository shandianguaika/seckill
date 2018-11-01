package org.seckill.model;

import java.util.Date;

public class Seckill {

	private String seckill_id;	//商品库存id
	private String name;		//商品名称	
	private int number;			//库存数量
	private Date startTime;		//秒杀开启时间
	private Date endTime;		//秒杀结束时间
	private String createTime;	//创建时间
	private String createBy;	//创建人
	
	public String getSeckill_id() { 
		return seckill_id;
	}
	public void setSeckill_id(String seckill_id) {
		this.seckill_id = seckill_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Override
	public String toString() {
		return "Seckill [seckill_id=" + seckill_id + ", name=" + name + ", number=" + number + ", startTime="
				+ startTime + ", endTime=" + endTime + ", createTime=" + createTime + ", createBy=" + createBy + "]";
	}

}
