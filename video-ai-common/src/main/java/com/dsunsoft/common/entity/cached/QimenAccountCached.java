package com.dsunsoft.common.entity.cached;

import java.io.Serializable;

/**
 * 奇门账号缓存信息
 * 
 * @author ygm
 *
 */
public class QimenAccountCached implements Serializable {
	private static final long serialVersionUID = -8918223398832063545L;
	private String name; // 应用名称
	private String type; // 1 wms 2 erp
	private String appKey; // WMS、ERP系统的app key
	private String customerId; // 访问WMS、ERP系统的账号
	private Integer sellerId;// 客户id
	private String version;// 奇门版本号
	private String sellerCode;// 客户code
	private String sellerName;// 客户名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

}
