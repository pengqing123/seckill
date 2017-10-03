package com.wen.seckill.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.wen.seckill.dao.SeckillDao;
import com.wen.seckill.dao.SuccessKilledDao;
import com.wen.seckill.dto.Exposer;
import com.wen.seckill.dto.SeckillExecution;
import com.wen.seckill.enums.SeckillStatEnum;
import com.wen.seckill.exception.RepeatKillException;
import com.wen.seckill.exception.SeckillCloseException;
import com.wen.seckill.exception.SeckillException;
import com.wen.seckill.model.Seckill;
import com.wen.seckill.model.SuccessKilled;
import com.wen.seckill.service.SeckillService;
@Service("seckillService")
public class SeckillServiceImpl implements  SeckillService{
    private Logger logger = (Logger) LoggerFactory.getLogger(SeckillServiceImpl.class);
	@Resource(name="seckillDao")
	private SeckillDao seckillDao;
	@Resource(name="successKilledDao")
	private	SuccessKilledDao successKilledDao;
	public final String slat="dfaf23asascxcaser23ads";
	/**
	 * 查询所有秒杀的记录
	 * @return 
	 */
	public List<Seckill> getSeckillList(){
		return seckillDao.queryAll();
	}
	/**
	 * 查询耽搁秒杀
	 */
	public Seckill getSeckillById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}
	/**
	 * 秒杀借口 秒杀开启时输出地址否则输出系统时间和接口时间
	 */
	public Exposer  exportSeckillUrl(long seckillId) {
		Seckill seckill=seckillDao.queryById(seckillId);
		if(seckill==null) {
			return new Exposer(false,seckillId);
		}else {
			Date startTime=seckill.getStartTime();
			Date endTime=seckill.getEndTime();
			Date nowTime=new Date();
			if(nowTime.getTime()<startTime.getTime()||nowTime.getTime()>endTime.getTime()) {
				return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
			}else {
				String md5=getMD5(seckillId);
				return new Exposer(true,md5,seckillId);
			} 
		}
			
	}
	/**
	 * 执行秒杀
	 */
	@Transactional
	public SeckillExecution  executeSeckill(long seckillId,long userPhone ,String md5)
	throws SeckillException,RepeatKillException,SeckillCloseException{
		if(md5==null||!md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		//执行秒杀
		Date nowTime=new Date();
		try {
			int updateCount=seckillDao.reduceNumber(seckillId, nowTime);
			if(updateCount<=0) {
				//没有更新dao
				//throw new SeckillCloseException("seckill id closed");
				return new SeckillExecution(seckillId,SeckillStatEnum.FAIL_Kill);
			}else {
				//减库存成功
				//记录购买行为
				int insertCount=successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if(insertCount<=0) {
					//重复秒杀
					//throw new RepeatKillException("seckill id repeated");
					return new SeckillExecution(seckillId,SeckillStatEnum.REPEAT_KILL);
				}else {
					
					SuccessKilled success=successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,success);
				}
			}	
		}catch(Exception e) {
			e.printStackTrace();
			throw new SeckillException("seckill inner error"+e.getMessage());
		}
		
	}
	private String getMD5(long seckillId) {
		String base=seckillId+"/"+slat;
		String md5=DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
}
