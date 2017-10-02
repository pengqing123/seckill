package com.wen.test.dao;


import javax.annotation.Resource;

import org.junit.Test;

import com.wen.seckill.dao.SuccessKilledDao;
import com.wen.seckill.model.SuccessKilled;
import com.wen.test.BaseTest;

public class SuccessKilledDaoTest extends BaseTest {

	@Resource
	private SuccessKilledDao successKilledDao;

	@Test
	public void testInsertSuccessKilled() throws Exception {
		long id = 1001;
		long phone = 13631231234L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount=" + insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() throws Exception {
		long id = 1001;
		long phone = 13631231234L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
	}

}
