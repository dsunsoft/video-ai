package com.dsunsoft.common.entity.cached;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 客户缓存信息
 * 
 * @author ygm
 *
 */
@Data
public class SellerCached implements Serializable {
	private static final long serialVersionUID = 1981624091846342779L;
	private Integer sellerId; // 客户Id
	private String sellerCode; // 客户编码
	private String sellerName; // 客户名称
	private String sellerAddress; // 地址
	private String linkman; // 联系人
	private String phone; // 电话
	private String senderLinkman;// 寄件人姓名
	private String senderPhone;// 寄件人电话
	private Integer orgId;// 所属客户组id
	private String orgName;// 所属客户组名称
	private Integer isReturnStock;

}
