package com.wen.seckill.service;

import java.util.List;

import com.wen.seckill.dto.Exposer;
import com.wen.seckill.dto.SeckillExecution;
import com.wen.seckill.exception.RepeatKillException;
import com.wen.seckill.exception.SeckillCloseException;
import com.wen.seckill.exception.SeckillException;
import com.wen.seckill.model.Seckill;

public interface SeckillService {
	/**
	 * 查询所有秒杀的记录
	 * @return 
	 */
	public List<Seckill> getSeckillList();
	/**
	 * 查询耽搁秒杀
	 */
	public Seckill getSeckillById(long seckillId);
	/**
	 * 秒杀借口 秒杀开启时输出地址否则输出系统时间和接口时间
	 */
	public Exposer  exportSeckillUrl(long seckillId);
	/**
	 * 执行秒杀
	 */
	SeckillExecution  executeSeckill(long seckillId,long userPhone ,String md5)
	throws SeckillException,RepeatKillException,SeckillCloseException;
	/**
	 * 存储过程秒杀
	 */
	SeckillExecution  executeSeckillProcedure(long seckillId,long userPhone ,String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;
			
}
