package org.seckill.model;

public class SuccessKilled {

	private String seckillId;	//秒杀商品id
	private String userPhone;	//用户手机号
	private String state;		//状态标识：-1 无效，0秒杀成功，1 已付款
	private String createTime;	//创建时间
	
	public String getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + "]";
	}
	
}
