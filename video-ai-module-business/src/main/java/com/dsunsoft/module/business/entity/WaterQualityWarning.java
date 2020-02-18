package com.dsunsoft.module.business.entity;

import java.util.Date;

import com.dsunsoft.core.entity.BaseEntity;
import lombok.Data;

@Data
public class WaterQualityWarning extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = -2361546346393003160L;
    
           /**
      * 主键
      **/
      private String id; 
           /**
      * 指标编码
      **/
      private String code; 
           /**
      * 指标名称
      **/
      private String name; 
           /**
      * 指标单位
      **/
      private String unit; 
           /**
      * 数据时间
      **/
      private Date time; 
           /**
      * 数据值
      **/
      private String value; 

        
}