package com.dsunsoft.module.admin.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.admin.dto.AreaSearchDto;
import com.dsunsoft.module.admin.entity.sys.Area;

public interface AreaMapper extends BaseMapper<Area, String> {

	List<Area> getChinaAreaList();

	List<NgSelect> getProvinceList();

	List<NgSelect> getData(AreaSearchDto dto);

	List<String> getNameByProvinceOrCity(@Param(value = "provinceId") String provinceId,
			@Param(value = "cityId") String cityId);
}
