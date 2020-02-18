package com.dsunsoft.common.entity.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dsunsoft.common.enums.StockChangeType;
import com.dsunsoft.common.enums.WmsBizType;

/**
 * 商品库存变动实体
 * 
 * @author ygm
 *
 */
public class GoodsStockChange implements Serializable {
	private static final long serialVersionUID = -5354206603913773656L;
	/**
	 * 仓库ID
	 */
	private Integer warehouseId;
	/**
	 * 客户ID
	 */
	private Integer sellerId;
	/**
	 * 商品库存信息
	 */
	private List<GoodsStockChangeItem> goodsStockList;
	/**
	 * 商品库存操作类型枚举
	 */
	private StockChangeType stockChangeType;

	// private WmsBizType wmsBizType;

	public GoodsStockChange() {

	}

	public GoodsStockChange(Integer sellerId, Integer warehouseId, StockChangeType stockChangeType,
			List<GoodsStockChangeItem> goodsStockList) {
		this.goodsStockList = goodsStockList;
		this.sellerId = sellerId;
		this.warehouseId = warehouseId;
		this.stockChangeType = stockChangeType;
		// this.wmsBizType = wmsBizType;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public List<GoodsStockChangeItem> getGoodsStockList() {
		return goodsStockList;
	}

	public void setGoodsStockList(List<GoodsStockChangeItem> goodsStockList) {
		this.goodsStockList = goodsStockList;
	}

	public StockChangeType getStockChangeType() {
		return stockChangeType;
	}

	public void setStockChangeType(StockChangeType stockChangeType) {
		this.stockChangeType = stockChangeType;
	}

//	public WmsBizType getWmsBizType() {
//		return wmsBizType;
//	}
//
//	public void setWmsBizType(WmsBizType wmsBizType) {
//		this.wmsBizType = wmsBizType;
//	}
}
