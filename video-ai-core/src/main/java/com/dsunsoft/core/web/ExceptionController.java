package com.dsunsoft.core.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.common.exception.BizException;

/**
 * 统一异常处理
 * 
 * @author ygm
 *
 */
@ControllerAdvice
public class ExceptionController {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	// @ExceptionHandler(value = Exception.class) 不写具体的异常类型,所有异常都走这个方法

	/***
	 * Exception 异常处理
	 * 
	 * @param request
	 * @param response
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler
	public ResponseResult<String> errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		if (e instanceof BizException) {
			logger.error("业务错误信息：", e);
			BizException bizEx = (BizException) e;
			if (bizEx.getErrors() != null && bizEx.getErrors().size() > 0) {
				return new ResponseResult<String>(ResponseCode.FAILURE, bizEx.getErrors());
			} else {
				return new ResponseResult<String>(ResponseCode.FAILURE, null, e.getMessage());
			}
		} else if (e instanceof MethodArgumentNotValidException) {
			logger.error("参数验证信息：", e);
			List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
			String errMsg = fieldErrors.stream().map(p -> p.getDefaultMessage()).collect(Collectors.joining(","));
			return new ResponseResult<String>(ResponseCode.FAILURE, null, errMsg);
		} else {
			logger.error("系统错误信息：", e);
			return new ResponseResult<String>(ResponseCode.SYSTEM_ERROR, null, ResponseCode.SYSTEM_ERROR.getMessage());
		}
	}
}
