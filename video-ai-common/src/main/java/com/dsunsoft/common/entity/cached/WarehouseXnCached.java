package com.dsunsoft.common.entity.cached;

import java.io.Serializable;

/**
 * 虚拟仓缓存信息
 * 
 * @author ygm
 *
 */
public class WarehouseXnCached implements Serializable {
	private static final long serialVersionUID = 7639783252219114958L;
	private String warehouseId; // 仓库ID
	private String warehouseCode; // 仓库编号
	private Integer wmsWarehouseId;// wms仓库id
	private String wmsWarehouseCode; // wms仓库编码
	private String warehouseName; // 仓库名称
	private String isDefective; // 是否残次

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Integer getWmsWarehouseId() {
		return wmsWarehouseId;
	}

	public void setWmsWarehouseId(Integer wmsWarehouseId) {
		this.wmsWarehouseId = wmsWarehouseId;
	}

	public String getWmsWarehouseCode() {
		return wmsWarehouseCode;
	}

	public void setWmsWarehouseCode(String wmsWarehouseCode) {
		this.wmsWarehouseCode = wmsWarehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getIsDefective() {
		return isDefective;
	}

	public void setIsDefective(String isDefective) {
		this.isDefective = isDefective;
	}

}
