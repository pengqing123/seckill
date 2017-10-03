package com.wen.seckill.dto;

/**
 * @author cxhc
 *
 */

public class Exposer {
	//是否开其秒杀
	private boolean exposed;
	
	private String md5;
	private long seckillId;
	//当前时间
	private long now;
	//开启时间
	private long start;
	//结束时间
	private long end;
	public Exposer(boolean exposed, String md5, long seckillId) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}
	public Exposer(boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}
	public Exposer(boolean exposed, long seckillId,long now, long start, long end) {
		super();
		this.exposed = exposed;
		this.now = now;
		this.seckillId=seckillId;
		this.start = start;
		this.end = end;
	}
	public boolean isExposed() {
		return exposed;
	}
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public long getNow() {
		return now;
	}
	public void setNow(long now) {
		this.now = now;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	

}