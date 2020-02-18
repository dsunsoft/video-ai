package com.dsunsoft.module.business.dto;

import com.dsunsoft.core.entity.BaseSearchDto;
import lombok.Data;

import java.util.Date;

@Data
public class StPptnRSearchDto extends BaseSearchDto {

    private static final long serialVersionUID = 1L;

    private String stcd;

    private String stnm;

    private Date tm;

    private Date startTime;

    private Date endTime;
}
