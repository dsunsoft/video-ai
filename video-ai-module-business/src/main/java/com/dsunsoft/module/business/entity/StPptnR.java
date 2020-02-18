package com.dsunsoft.module.business.entity;

import com.dsunsoft.core.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StPptnR extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String stcd;

    private String stnm;

    private Date tm;

    private BigDecimal drp;

    private BigDecimal intv;

    private BigDecimal pdr;

    private BigDecimal dyp;

    private String wth;

    private BigDecimal dy;




}
