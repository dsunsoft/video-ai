package com.dsunsoft.module.business.entity;

import com.dsunsoft.core.entity.BaseEntity;
import lombok.Data;

@Data
public class WaterQualityRange extends BaseEntity {
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
      * 指标正常范围类型（1：含有最大值，2：含有最小值，3：区间内【有最小值，也有最大值】 ，4：其他【特殊计算，比如水温】）
      **/
      private Integer rangeType;
      /**
      * 报警数
      */
      private Integer warningCount;
           /**
      * 最大值
      **/
      private String max; 
           /**
      * 最小值
      **/
      private String min; 
           /**
      * 其他
      **/
      private String other; 

        
}