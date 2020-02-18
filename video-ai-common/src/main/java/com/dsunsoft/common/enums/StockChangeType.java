package com.dsunsoft.common.enums;

/**
 * 库存变动类型枚举
 * 
 * @author ygm
 *
 */
public enum StockChangeType {
	/**
	 * 真实库存减库存
	 */
	DECREASE,
	/**
	 * 减少库存并减少锁定库存(例如订单发货)
	 */
	DECREASE_AND_LOCK_RELEASE,
	/**
	 * 真实库存添加库存
	 */
	INCREASE,
	/**
	 * 增加库存并增加锁定库存(例如取消出库记账)
	 */
	INCREASE_AND_LOCK,
	/**
	 * 锁定库存
	 */
	LOCK,
	/**
	 * 释放锁定库存
	 */
	LOCK_RELEASE;
}
