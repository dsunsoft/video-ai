package com.dsunsoft.common.enums;

/**
 * 仓库单据业务类型
 * 
 * @author ygm
 *
 */
public enum WmsBizType {
	/**
	 * 发货单
	 */
	DELIVERYORDER,
	/**
	 * 入库单
	 */
	ENTRYORDER,
	/**
	 * 出库单
	 */
	STOCKOUT,
	/**
	 * 退货入库单
	 */
	RETURNORDER;
}
