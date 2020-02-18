package com.dsunsoft.core.entity;

import java.util.ArrayList;

import lombok.Data;

/**
 * 树节点实体类
 * @author zb
 */
@Data
public class NzTree {

    /**
     * 标题
     */
    private String title;
    
    /**
     * 整个树范围内的所有节点的 key 值不能重复且不为空！
     */
    private String key;
    /**
     * 节点前的图标，与 nzShowIcon 组合使用
     */
    private String icon;
    
    /**
     * 子节点
     */
    private ArrayList<NzTree> children = new ArrayList<NzTree>();
    /**
     * 设置为叶子节点(叶子节点不可被拖拽模式放置)
     */
    private Boolean isLeaf = false;
    /**
     * 设置节点是否展开(叶子节点无效)
     */
    private Boolean expanded;
    
    /**
     * 设置节点 Checkbox 是否选中
     */
    private Boolean checked = false;;
    /**
     * 设置节点本身是否选中
     */
    private Boolean selected = false;
    /**
     * 设置节点是否可被选中
     */
    private Boolean selectable = true;
    /**
     * 设置是否禁用节点(不可进行任何操作)
     */
    private Boolean disabled = false;
    /**
     * 设置节点禁用 Checkbox
     */
    private Boolean disableCheckbox = false;
    /**
     * 自定义数据,可通过 NzTreeNode 的 origin 字段获取
     */
    private Object origin;
    
}
