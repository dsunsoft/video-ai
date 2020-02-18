package com.dsunsoft.common.entity;

import java.io.Serializable;

/***
 * 消息队列同步处理返回结果
 * 
 * @author ygm
 *
 */
public class MqSyncResult<T> implements Serializable {
	private static final long serialVersionUID = -3321923499043070800L;
	/**
	 * 是否正确
	 */
	private boolean success;
	/**
	 * 数据
	 */
	private T data;
	/**
	 * 消息
	 */
	private String message;

	public MqSyncResult() {
		this.success = true;
	}

	public MqSyncResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
