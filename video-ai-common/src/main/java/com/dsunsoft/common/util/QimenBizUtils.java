package com.dsunsoft.common.util;

/**
 * 奇门业务帮助工具
 * 
 * @author ygm
 *
 */
public class QimenBizUtils {

	/**
	 * 获取入库类型 SCRK=生产入库;LYRK=领用入库;CCRK=残次品入库;CGRK=采购入库;DBRK=调拨入库;QTRK=其他入库;
	 * B2BRK=B2B入库;XNRK=虚拟入库; THRK=退货入库;HHRK=换货入库
	 * 
	 * @param type
	 * @return
	 */
	public static String getInWarehouseBizOrderType(String type) {
		if (StringUtils.isBlank(type)) {
			return "仓库入库";
		}
		String result = "";
		switch (type) {
		case "SCRK":
			result = "生产入库";
			break;
		case "LYRK":
			result = "领用入库";
			break;
		case "CCRK":
			result = "残次品入库";
			break;
		case "CGRK":
			result = "采购入库";
			break;
		case "DBRK":
			result = "调拨入库";
			break;
		case "QTRK":
			result = "其他入库";
			break;
		case "B2BRK":
			result = "B2B入库";
			break;
		case "XNRK":
			result = "虚拟入库";
			break;
		case "THRK":
			result = "退货入库";
			break;
		case "HHRK":
			result = "换货入库";
			break;
		default:
			result = type;
			break;
		}
		return result;
	}

	/**
	 * 获取出库类型 PTCK=普通出库单;DBCK=调拨出库;B2BCK=B2B出库;QTCK=其他出库;CGTH=采购退货出库单;XNCK=虚拟出库单,
	 * JITCK=唯品出库 JYCK=一般交易出库;HHCK=换货出库;BFCK=补发出库;QTCK=其他出库单
	 * 
	 * @param type
	 * @return
	 */
	public static String getOutWarehouseBizOrderType(String type) {
		if (StringUtils.isBlank(type)) {
			return "仓库出库";
		}
		String result = "";
		switch (type) {
		case "PTCK":
			result = "普通出库";
			break;
		case "DBCK":
			result = "调拨出库";
			break;
		case "JYCK":
			result = "交易出库";
			break;
		case "HHCK":
			result = "换货出库";
			break;
		case "BFCK":
			result = "补发出库";
			break;
		case "QTCK":
			result = "其他出库";
			break;
		case "B2BCK":
			result = "B2B出库";
		case "CGTH":
			result = "其他出库";
		case "XNCK":
			result = "虚拟出库单";
		case "JITCK":
			result = "唯品出库";
		default:
			break;
		}
		return result;
	}
}
