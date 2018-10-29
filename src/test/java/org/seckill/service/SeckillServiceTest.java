package org.seckill.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Expose;
import org.seckill.dto.SeckillExecution;
import org.seckill.model.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * service与dao层的集成测试
 * @author 小宇宙
 * @date 2018年10月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-dao.xml","classpath:spring-service.xml"})
public class SeckillServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private SeckillService seckillService;
	
	//@Test
	public void getAll() {
		List<Seckill> seckills = seckillService.getAll();
		for(Seckill model : seckills) {
			System.err.println(model);
			System.out.println("-------------------");
			logger.info(model.toString());
		}
		logger.info("list={}",seckills);
	}
	//@Test
	public void getSeckill() {
		Seckill model = seckillService.getSeckill("1000");
		logger.info("model={}",model);
	}
	
	//@Test
	public void getSeckillUrl() {
		Expose model = seckillService.getSeckillUrl("1000");
		System.err.println(model);
	}
	//md5:415244459c9debfb1d5fa9cb10eaeddc
	@Test
	public void executeSeckill() {
		SeckillExecution model = seckillService.executeSeckill("1000", "13461395007", "415244459c9debfb1d5fa9cb10eaeddc");
		System.err.println(model);
	}
}
