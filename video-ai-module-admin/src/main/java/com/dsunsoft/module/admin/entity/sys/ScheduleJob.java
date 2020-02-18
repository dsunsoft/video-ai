package com.dsunsoft.module.admin.entity.sys;

import javax.validation.constraints.NotBlank;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * 定时任务实体
 * 
 * @author ygm
 *
 */
public class ScheduleJob extends BaseEntity {
	private static final long serialVersionUID = -4520396493663016823L;
	private String id;// id
	@NotBlank(message = "任务名不能为空")
	private String name; // 任务名
	@NotBlank(message = "任务组不能为空")
	private String group; // 任务组
	@NotBlank(message = "定时规则不能为空")
	private String cronExpression; // 定时规则
	@NotBlank(message = "状态不能为空")
	private String status; // 启用状态
	private String isInfo; // 通知用户
	@NotBlank(message = "任务类不能为空")
	private String className; // 任务类
	private String description; // 描述

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsInfo() {
		return isInfo;
	}

	public void setIsInfo(String isInfo) {
		this.isInfo = isInfo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
