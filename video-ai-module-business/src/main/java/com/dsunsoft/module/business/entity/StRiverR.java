package com.dsunsoft.module.business.entity;
import	java.math.BigDecimal;

import com.dsunsoft.core.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class StRiverR extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String stcd;

    private String stnm;

    private Date tm;

    private BigDecimal z;

    private BigDecimal q;

    private BigDecimal xsa;

    private BigDecimal xsavv;

    private BigDecimal xsmxv;

    private String flwchrcd;

    private String wptn;

    private String msqmt;

    private String msamt;

    private String msvmt;


}
