package org.seckill.dto;

import java.util.Date;

/**
 * 暴露秒杀地址信息
 * @author 小宇宙
 * @date 2018年10月28日
 */
public class Expose {

	//是否开启秒杀
	private boolean exposed;
	
	//加密的秒杀接口地址
	private String md5;
	
	//秒杀商品id
	private String seckillId;
	
	//系统当前时间
	private Date now;
	
	//秒杀开启时间
	private Date start;
	
	//秒杀结束时间
	private Date end;

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Expose(boolean exposed, String seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public Expose(boolean exposed, String md5, String seckillId) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Expose(boolean exposed, String seckillId, Date now, Date start, Date end) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Expose(boolean exposed, String md5, String seckillId, Date now, Date start, Date end) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Expose() {
		super();
	}

	@Override
	public String toString() {
		return "Expose [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
				+ start + ", end=" + end + "]";
	}
}
