package com.dsunsoft.module.business.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexRequestDto implements Serializable {

    private static final long serialVersionUID = -288818673639556071L;

    private String deviceId;

    private String code;

}
