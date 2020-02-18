package com.dsunsoft.common.exception;

/**
 * 奇门错误异常
 * 
 * @author yangm
 *
 */
public class QimenException extends Exception {
	private static final long serialVersionUID = 1L;

	private int code;

	public QimenException(String message) {
		super(message);
	}

	public QimenException(int code, String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
