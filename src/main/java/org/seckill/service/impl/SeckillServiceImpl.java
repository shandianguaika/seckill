package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.common.enums.Enums;
import org.common.exception.RepeatKillException;
import org.common.exception.SeckillCloseException;
import org.common.exception.SeckillException;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Expose;
import org.seckill.dto.SeckillExecution;
import org.seckill.model.Seckill;
import org.seckill.model.SuccessKilled;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author 小宇宙
 * @date 2018年10月28日
 */
@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private SeckillDao seckillDao;
	
	@Resource
	private SuccessKilledDao successKilledDao;
	
	//盐值，用来混淆加密信息
	private String slat = "qweqwe1212334,,llasd[[]";
	@RequestMapping(value="",method=RequestMethod.POST,consumes= {""})
	
	@Override
	public List<Seckill> getAll() {
		// TODO Auto-generated method stub
		return seckillDao.queryAll(0, 100);
	}

	@Override
	public Seckill getSeckill(String seckillId) {
		// TODO Auto-generated method stub
		return seckillDao.querySeckill(seckillId);
	}

	@Override
	public Expose getSeckillUrl(String seckillId) {
		// TODO Auto-generated method stub
		Seckill model = seckillDao.querySeckill(seckillId);
		if(model == null) {
			return new Expose(false, seckillId);
		}
		Date startTime = model.getStartTime();
		Date endTime = model.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() > startTime.getTime() && nowTime.getTime() < endTime.getTime()) {
			String md5 = setMd5(seckillId);
			return new Expose(true, md5, seckillId, nowTime, startTime, endTime);
			//return new Expose(true, md5, seckillId);
		}
		return new Expose(false, seckillId);
	}

	private String setMd5(String seckillId) {
		String base = seckillId + slat;
		//spring工具类用来生产MD5
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	@Override
	@Transactional
	public SeckillExecution executeSeckill(String seckillId, String userPhone, String md5)
			throws SeckillCloseException, RepeatKillException, SeckillException {
		// TODO Auto-generated method stub
		if (md5 == null || md5.trim().equals("") || !md5.equals(setMd5(seckillId))) {
			throw new SeckillException("链接错误！");
		}
		try {
			//秒杀行为，对库存进行更新以及新增购买成功明细
			int result = seckillDao.reduceNumber(seckillId, new Date());
			if (result <= 0) {
				throw new SeckillCloseException("秒杀结束");
			} else {
				int insert = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insert <= 0) {
					throw new RepeatKillException("重复秒杀");
				} else {
					SuccessKilled successKilled = successKilledDao.getSuccessKilledBy(seckillId, userPhone);
					return new SeckillExecution(seckillId, Enums.SUCCESS, successKilled);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw new SeckillException("秒杀失败的错误信息：" + e.getMessage());
		}
		
	}

}
