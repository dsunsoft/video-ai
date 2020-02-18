package com.dsunsoft.module.business.dto;

import com.dsunsoft.core.entity.BaseSearchDto;
import lombok.Data;
import java.util.Date;

@Data
public class WaterQualityWarningSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -8053693909178470071L;
	
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

    private Date startTime;
    private Date endTime;

}