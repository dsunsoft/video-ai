package com.dsunsoft.common.enums;

/**
 * @ClassName: TradePlatform
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum TradePlatform {
	/*
	 * 订单来源平台编码(TB=淘宝、TM=天猫、JD=京东、DD=当当、PP=拍拍、YX= 易讯、 EBAY=ebay、QQ=QQ网购、
	 * AMAZON=亚马逊、SN=苏宁、GM=国美、WPH=唯品会、JM=聚美、LF=乐蜂 、MGJ=蘑菇街、 JS=聚尚、PX=拍鞋、YT=银泰、
	 * YHD=1号店、VANCL=凡客、YL=邮乐、YG=优购、1688=阿 里巴巴、POS=POS门店、 MIA=蜜芽、OTHER=其他(只传英文编码))
	 */
	淘宝(1, "TB"), 天猫(1, "TM"), 京东(2, "JD"), 亚马逊(3, "AMAZON"), 苏宁(4, "SN"), 拼多多(5, "PDD"), 其他(50, "OTHER");

	private Integer value;
	private String code;

	TradePlatform(Integer value, String code) {
		this.value = value;
		this.code = code;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @Title: getByCode
	 */
	public static TradePlatform getByCode(String code) {
		code = code.toUpperCase();
		for (TradePlatform item : TradePlatform.values()) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * @Title: getByValue
	 */
	public static TradePlatform getByValue(Integer value) {
		for (TradePlatform item : TradePlatform.values()) {
			if (item.getValue() == value) {
				return item;
			}
		}
		return null;
	}

}
