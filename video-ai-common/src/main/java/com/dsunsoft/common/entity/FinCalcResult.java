package com.dsunsoft.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 财务计算结果
 * 
 * @author ygm
 *
 */
public class FinCalcResult implements Serializable {
	private static final long serialVersionUID = 2906265967899674282L;

	/**
	 * 是否正确
	 */
	private Boolean success;

	/**
	 * 金额
	 */
	private BigDecimal money;

	/**
	 * 插入明细sql
	 */
	private List<String> detailSqls;

	/**
	 * 消息
	 */
	private String message;

	public FinCalcResult() {
		this.money = BigDecimal.ZERO;
		this.message = "";
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public List<String> getDetailSqls() {
		return detailSqls;
	}

	public void setDetailSqls(List<String> detailSqls) {
		this.detailSqls = detailSqls;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
