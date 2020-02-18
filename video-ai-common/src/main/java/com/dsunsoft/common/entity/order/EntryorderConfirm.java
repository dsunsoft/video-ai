package com.dsunsoft.common.entity.order;

import java.io.Serializable;

import com.dsunsoft.common.enums.EntryorderType;

import lombok.Data;

/**
 * 入库确认实体
 * 
 * @author ygm
 *
 */
@Data
public class EntryorderConfirm implements Serializable {
	private static final long serialVersionUID = -8391782380557733531L;
	
	private EntryorderType orderType;
}
