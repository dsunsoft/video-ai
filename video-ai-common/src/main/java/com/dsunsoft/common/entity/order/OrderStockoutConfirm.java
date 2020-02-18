package com.dsunsoft.common.entity.order;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 订单出库确认实体
 * 
 * @author ygm
 *
 */
@Data
public class OrderStockoutConfirm implements Serializable {
	private static final long serialVersionUID = 8873287371083005100L;
	private String orderId;
	private String orderNo;
	private String logisticsOrderId;
	private String logisticsNo;
	private Integer logisticsCompanyId;
	private String logisticsCompanyCode;
	private Integer warehouseId;
	private String userId;
	private Boolean isShuadan;//是否刷单
	/**
	 * erp仓库编码
	 */
	private String erpWarehouseCode;
	/**
	 * 订单编号
	 */
	private String deliveryCode;
	/**
	 * 仓库出库单编码
	 */
	private String outWarehouseCode;
	/**
	 * 奇门业务类型
	 */
	private String bizOrderType;
}
