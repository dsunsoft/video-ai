package com.dsunsoft.common.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品库存库位信息
 * 
 * @author ygm
 *
 */
public class GoodsLocationInfo implements Serializable {
	private static final long serialVersionUID = -9039423422270725943L;
	private Integer goodsId;
	private BigDecimal goodsAmount;
	private Integer warehouseLocationId; // 库位id
	private String warehouseLocationCode;// 库区编码

	public GoodsLocationInfo() {

	}

	public GoodsLocationInfo(Integer goodsId, Integer warehouseLocationId, String warehouseLocationCode) {
		this.goodsId = goodsId;
		this.warehouseLocationId = warehouseLocationId;
		this.warehouseLocationCode = warehouseLocationCode;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getWarehouseLocationId() {
		return warehouseLocationId;
	}

	public void setWarehouseLocationId(Integer warehouseLocationId) {
		this.warehouseLocationId = warehouseLocationId;
	}

	public String getWarehouseLocationCode() {
		return warehouseLocationCode;
	}

	public void setWarehouseLocationCode(String warehouseLocationCode) {
		this.warehouseLocationCode = warehouseLocationCode;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
}
