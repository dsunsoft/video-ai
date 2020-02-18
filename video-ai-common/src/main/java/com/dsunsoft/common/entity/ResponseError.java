package com.dsunsoft.common.entity;

import java.io.Serializable;

/**
 * 错误信息
 * 
 * @author ygm
 *
 */
public class ResponseError implements Serializable {
	private static final long serialVersionUID = 855108604043616220L;
	
	/** 关键字(单号,编码等) */
	private String key;
	/** 消息 */
	private String message;

	public ResponseError() {
	}

	public ResponseError(String key, String message) {
		this.key = key;
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
