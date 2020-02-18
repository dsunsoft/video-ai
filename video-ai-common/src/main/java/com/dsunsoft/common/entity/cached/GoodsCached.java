package com.dsunsoft.common.entity.cached;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品缓存信息
 * 
 * @author ygm
 *
 */
public class GoodsCached implements Serializable {
	private static final long serialVersionUID = -2009823301559138060L;
	private Integer goodsId;
	private String goodsCode;
	private String goodsName;
	private String goodsModel;
	private Integer goodsTypeId;
	private BigDecimal goodsLong;
	private BigDecimal goodsWidth;
	private BigDecimal goodsHeigh;
	private BigDecimal goodsVolume;
	private BigDecimal goodsWeight;

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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsModel() {
		return goodsModel;
	}

	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public BigDecimal getGoodsLong() {
		return goodsLong;
	}

	public void setGoodsLong(BigDecimal goodsLong) {
		this.goodsLong = goodsLong;
	}

	public BigDecimal getGoodsWidth() {
		return goodsWidth;
	}

	public void setGoodsWidth(BigDecimal goodsWidth) {
		this.goodsWidth = goodsWidth;
	}

	public BigDecimal getGoodsHeigh() {
		return goodsHeigh;
	}

	public void setGoodsHeigh(BigDecimal goodsHeigh) {
		this.goodsHeigh = goodsHeigh;
	}

	public BigDecimal getGoodsVolume() {
		return goodsVolume;
	}

	public void setGoodsVolume(BigDecimal goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public BigDecimal getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(BigDecimal goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
}
