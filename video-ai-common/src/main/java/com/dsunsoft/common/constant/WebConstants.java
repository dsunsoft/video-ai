package com.dsunsoft.common.constant;

/**
 * web常量
 * 
 * @author ygm
 *
 */
public class WebConstants {
	/** 超级管理员角色id */
	public static final String ROLE_SUPER_ADMIN = "1";
	/* 订单前缀 序列 */
	public static final String SEQ_ORDER = "XS";
	/* order_pick 序列 */
	public static final String SEQ_ORDER_PICK = "PH";
	/* order_return 序列 */
	public static final String SEQ_ORDER_RETURN = "TH";
	/* order_return 序列 */
	public static final String SEQ_ORDER_RETURN_JD = "JD";
	/* wh_in_warehouse 序列 */
	public static final String SEQ_WH_IN_WAREHOUSE = "RK";
	/* wh_out_warehouse 序列 */
	public static final String SEQ_WH_OUT_WAREHOUSE = "CK";
	/* wh_call_out 序列 */
	public static final String SEQ_WH_CALL_OUT = "DB";
	/* 日常快递 序列 */
	public static final String SEQ_ORDER_DAILY = "RC";
	/* wh_goods_inventory_list 序列 */
	public static final String SEQ_WH_GOODS_INVENTORY_LIST = "PD";
	/* wh_goods_check 序列 */
	public static final String SEQ_WH_GOODS_CHECK = "PDMX";
	/* wh_goods_check_list 序列 */
	public static final String SEQ_WH_GOODS_CHECK_LIST = "PD";
	/* wh_package_in 序列 */
	public static final String SEQ_WH_PACKAGE_IN = "BCRK";
	/* wh_package_out 序列 */
	public static final String SEQ_WH_PACKAGE_OUT = "BCCK";
	/* wh_return_quality_check 序列 */
	public static final String SEQ_WH_RETURN_QUALITY_CHECK = "QC";
	/* wh_location_change 序列 */
	public static final String SEQ_WH_LOCATION_CHANGE = "LC";
	/* 快递前缀 序列 */
	public static final String SEQ_LOGSTIC_ORDER = "KD";
	/* mongodb 订单配货表 */
	public static final String MONGO_ORDER_PICK = "order_pick";
	/* mongodb 快递追踪表 */
	public static final String MONGO_LOGISTICS_TRACE = "logistics_trace";
	/* mongodb 快递打印模板表 */
	public static final String MONGO_LOGISTICS_TEMPLATE = "logistics_template";
	/* mongodb 快递单号表 */
	public static final String MONGO_LOGISTICS_NO_LIST = "logistics_no_list";
	/* 是=1 字符串 */
	public static final String YES_STR = "1";
	/* 否=0 字符串 */
	public static final String NO_STR = "0";
	/* 是=1 整型 */
	public static final Integer YES_INT = 1;
	/* 否=0 整型 */
	public static final Integer NO_INT = 0;
	/* 中国系统行政区划id */
	public static final String AREA_CHIND_ID = "a9beb8c645ff448d89e71f96dc97bc09";
	/** admin 用户id */
	public static final String ADMIN_USER_ID = "1";
	/** 润氏客户id */
	public static final Integer SELLER_ID_RUNSHI = 14;
	/** 智雅金蝶id */
	public static final Integer SELLER_ID_ZY_GY = 21;
	/** 默认页数 */
	public static final int PAGE_INDEX = 1;
	/** 默认分页大小 */
	public static final int PAGE_SIZE = 20;
	/** 桑夏用户id */
	public static final String SANGXIA_USER_ID = "92cb93ce-3565-4673-8060-332749e6c33a";

	/** 财务服务费(订单处理费)id */
	public static final Integer FIN_ORDER_PROCESS_SUBJECT_ID = 1;
	/** 财务快递费id */
	public static final Integer FIN_LOGISTICS_SUBJECT_ID = 3;
	// 财务收入sql条件
	public static final String FIN_CONDITION_WAREHOUSE_ID = "{warehouseId}";
	public static final String FIN_CONDITION_SELLER_ID = "{sellerId}";
	public static final String FIN_CONDITION_BEGIN_DATE = "{beginDate}";
	public static final String FIN_CONDITION_END_DATE = "{endDate}";
	public static final String FIN_CONDITION_LOGISTICS_COMPANY = "{logisticsCompanyId}";
	public static final String FIN_CONDITION_ADDRESS = "{addressCondition}";
}
