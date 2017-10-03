package com.wen.seckill.dto;

import com.wen.seckill.enums.SeckillStatEnum;
import com.wen.seckill.model.SuccessKilled;

public class SeckillExecution {
	private long SeckillId;
	//秒杀状态
	private int state;
	private  String stateInfo;
	private SuccessKilled successKilled;
	
	public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
		super();
		SeckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStateInfo();
	}
	public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
		super();
		SeckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStateInfo();
		this.successKilled = successKilled;
	}
	public long getSeckillId() {
		return SeckillId;
	}
	public void setSeckillId(long seckillId) {
		SeckillId = seckillId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
	
}
