package com.dsunsoft.common.entity.cached;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 检查商品缓存库存实体
 * 
 * @author ygm
 *
 */
public class GoodsStockCachedCheck implements Serializable {
	private static final long serialVersionUID = -8698412098555046288L;
	private Integer goodsId;
	private String goodsCode;
	private BigDecimal amount;

	public GoodsStockCachedCheck() {

	}

	public GoodsStockCachedCheck(Integer goodsId, String goodsCode, BigDecimal amount) {
		this.goodsId = goodsId;
		this.goodsCode = goodsCode;
		this.amount = amount;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
