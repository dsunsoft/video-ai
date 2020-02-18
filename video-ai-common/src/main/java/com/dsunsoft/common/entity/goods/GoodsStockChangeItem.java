package com.dsunsoft.common.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsStockChangeItem implements Serializable {
	private static final long serialVersionUID = -4746912786136363136L;
	private Integer goodsId;
	private String goodsCode;
	private BigDecimal amount;
	private Integer warehouseLocationId; // 库位id
	private String warehouseLocationCode;// 库区编码

	public GoodsStockChangeItem() {
	}

	public GoodsStockChangeItem(Integer goodsId, String goodsCode, BigDecimal amount) {
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

}
