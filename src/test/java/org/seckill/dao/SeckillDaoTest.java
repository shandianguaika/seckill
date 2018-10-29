package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.model.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 首先配置spring和junit整合，junit启动时加载springIOC容器
 * @author 小宇宙
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration({"classpath:spring-dao.xml"})
public class SeckillDaoTest {
	
	//注入dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	/**
	 * 根据id进行减库存操作
	 * @param seckillId
	 * @return
	 */
	@Test
	public void reduceNumber() {
		int result = seckillDao.reduceNumber("1000", new Date());
		System.out.println(result);
	}
		
	
	/**
	 * 根据id查询秒杀商品对象
	 * @param seckillId
	 * @return
	 */
	@Test
	public void querySeckill() {
		Seckill model = seckillDao.querySeckill("1000");
		System.err.println(model.getName());
	}
	
	/**
	 * 查询秒杀商品列表
	 * @param off
	 * @param limit
	 * @return
	 */
	@Test
	public void queryAll(){
		List<Seckill> lists = seckillDao.queryAll(0, 10);
		for(Seckill model : lists) {
			System.err.println(model);
		}
	}
}

