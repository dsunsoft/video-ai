package com.dsunsoft.common.exception;

import java.util.List;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseError;

/**
 * 业务错误异常
 * 
 * @author yangm
 *
 */
public class BizException extends Exception {
	private static final long serialVersionUID = 1L;

	private int code;

	private List<ResponseError> errors;

	public BizException(String message) {
		super(message);
	}

	public BizException(ResponseCode responseCode, String message) {
		super(message);
		this.code = responseCode.getCode();
	}

	public BizException(ResponseCode responseCode, List<ResponseError> errors) {
		super(errors.toString());
		this.code = responseCode.getCode();
		this.setErrors(errors);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<ResponseError> getErrors() {
		return errors;
	}

	public void setErrors(List<ResponseError> errors) {
		this.errors = errors;
	}

}
