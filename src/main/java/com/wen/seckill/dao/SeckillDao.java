package com.wen.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wen.seckill.model.Seckill;
@Mapper
public interface SeckillDao {
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响的行数大于1 则表示更新库存成功
	 */
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	/**
	 * 根据id  查询秒杀对象
	 * @param seckillId
	 * @return 
	 */
	Seckill queryById(@Param("seckillId")long seckillId);
	/**
	 * 获取秒杀列表
	 */
	List<Seckill> queryAll(); 
}
