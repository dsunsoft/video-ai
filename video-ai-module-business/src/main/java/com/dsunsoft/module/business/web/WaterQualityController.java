package com.dsunsoft.module.business.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.module.business.dto.WaterQualitySearchDto;
import com.dsunsoft.module.business.entity.Device;
import com.dsunsoft.module.business.entity.WaterQuality;
import com.dsunsoft.module.business.service.WaterQualityService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "水质实时数据")
@RestController
@RequestMapping(value = "/video-ai/waterQuality")
public class WaterQualityController {

	@Autowired
	private WaterQualityService waterQualityService;

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping("/{id}")
	public ResponseResult<WaterQuality> getObject(@ApiParam @PathVariable String id) {
		WaterQuality waterQuality = waterQualityService.getById(id);
		if (waterQuality == null) {
			return new ResponseResult<>(ResponseCode.SUCCESS, waterQuality);
		}
		return new ResponseResult<>(ResponseCode.SUCCESS, waterQuality);
	}

	@PostMapping
	public ResponseResult<Boolean> add(@RequestBody @Validated WaterQuality t) throws Exception {
		t.setId(UUID.randomUUID().toString());
		Boolean bl = waterQualityService.insert(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	@PostMapping(value = "page")
	public ResponseResult<PageInfo<WaterQuality>> getPage(@ApiParam @RequestBody WaterQualitySearchDto param) throws Exception {
		PageInfo<WaterQuality> page = waterQualityService.findPageList(param.getPageIndex(), param.getPageSize(), param);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}
	
	@ApiOperation(value = "获取数据", notes = "获取数据")
	@PostMapping(value = "findList")
	public ResponseResult<List<WaterQuality>> findList(@ApiParam @RequestBody WaterQualitySearchDto param) throws Exception {
		List<WaterQuality> list = waterQualityService.findList(param);
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}
	
	@ApiOperation(value = "获取各设备的最新数据", notes = "获取各设备的最新数据")
	@PostMapping(value = "getLastDataList")
	public ResponseResult<List<WaterQuality>> getLastDataList(@ApiParam @RequestBody WaterQualitySearchDto param) throws Exception {
		List<WaterQuality> list = waterQualityService.getLastDataList(param);
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping
	public ResponseResult<Boolean> update(@RequestBody WaterQuality t) throws Exception {
		boolean bl = waterQualityService.update(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping
	public ResponseResult<Boolean> delete(@RequestBody WaterQuality t) throws BizException {
		boolean bl = waterQualityService.deleteById(t.getId());
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}
}
