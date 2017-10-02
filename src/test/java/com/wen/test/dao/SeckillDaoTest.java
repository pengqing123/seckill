package com.wen.test.dao;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.wen.seckill.dao.SeckillDao;
import com.wen.seckill.model.Seckill;
import com.wen.test.BaseTest;

public class SeckillDaoTest extends BaseTest {

	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testQueryById()  {
		long id = 1000;
		try {
			Seckill seckill = seckillDao.queryById(id);
			System.out.println(seckill.getName());
			System.out.println(seckill);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testReduceNumber() throws Exception {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount=" + updateCount);
	}
	@Test
	public void testQueryAll() throws Exception  {
		List<Seckill> seckills = seckillDao.queryAll();
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
	}

	

}
