package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.model.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author 小宇宙
 * @date 2018年10月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
public class SuccessKilledDaoTest {
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void insertSuccessKilled() {
		int result = successKilledDao.insertSuccessKilled("1000", "13461395006");
		System.err.println(result);
	}

	@Test
	public void getSuccessKilledBy() {
		SuccessKilled model = successKilledDao.getSuccessKilledBy("1000", "13461395006");
		System.err.println(model);
	}
}
