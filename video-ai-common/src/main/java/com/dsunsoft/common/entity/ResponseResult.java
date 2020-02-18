package com.dsunsoft.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 统一返回实体
 * 
 * @author ygm
 *
 * @param <T>
 */
public class ResponseResult<T> implements Serializable {
	private static final long serialVersionUID = 4299612208796466215L;

	/** 返回代码 */
	private int code;
	/** 返回数据 */
	private T data;
	/** 返回消息 */
	private String message;
	/** 错误信息 */
	private List<ResponseError> errors;

	public ResponseResult() {
	}

	public ResponseResult(ResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}

	public ResponseResult(ResponseCode responseCode, T data) {
		this.data = data;
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}

	public ResponseResult(ResponseCode responseCode, T data, String message) {
		this.data = data;
		this.code = responseCode.getCode();
		this.message = message;
	}

	public ResponseResult(List<ResponseError> errors) {
		this.code = ResponseCode.FAILURE.getCode();
		this.errors = errors;
	}

	public ResponseResult(ResponseCode responseCode, List<ResponseError> errors) {
		this.code = responseCode.getCode();
		this.errors = errors;
	}

	public ResponseResult<T> success(String message) {
		this.code = ResponseCode.SUCCESS.getCode();
		this.message = message;
		return this;
	}

	public ResponseResult<T> failure(String message) {
		this.code = ResponseCode.FAILURE.getCode();
		this.message = message;
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public List<ResponseError> getErrors() {
		return errors;
	}

	public void setErrors(List<ResponseError> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ResponseResult [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
