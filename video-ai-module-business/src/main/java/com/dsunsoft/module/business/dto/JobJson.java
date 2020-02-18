package com.dsunsoft.module.business.dto;

import java.io.Serializable;


/**
 * 乐橙云直播地址接口返回job 直播计划时间
 * @author zb
 * @date 创建时间：2019年12月18日 下午5:05:14
 */
public class JobJson implements Serializable {

	private static final long serialVersionUID = 1623039293608457532L;
	
	private String period;
	
	private Boolean status;
	
	private String beginTime;
	
	private String endTime;

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}


	/**
	 * @return the beginTime
	 */
	public String getBeginTime() {
		return beginTime;
	}
	


	/**
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	


	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	

	
	
}
