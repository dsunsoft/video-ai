package com.dsunsoft.module.business.web;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.module.business.dto.WaterQualityWarningSearchDto;
import com.dsunsoft.module.business.entity.WaterQualityWarning;
import com.dsunsoft.module.business.service.WaterQualityWarningService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(value = "水质超指标预警详细记录")
@RestController
@RequestMapping(value = "/video-ai/waterQualityWarning")
public class WaterQualityWarningController {

	@Autowired
	private WaterQualityWarningService waterQualityWarningService;

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping("/{id}")
	public ResponseResult<WaterQualityWarning> getObject(@ApiParam @PathVariable String id) {
		WaterQualityWarning waterQualityWarning = waterQualityWarningService.getById(id);
		if (waterQualityWarning == null) {
			return new ResponseResult<>(ResponseCode.SUCCESS, waterQualityWarning);
		}
		return new ResponseResult<>(ResponseCode.SUCCESS, waterQualityWarning);
	}

	@PostMapping
	public ResponseResult<Boolean> add(@RequestBody @Validated WaterQualityWarning t) throws Exception {
		t.setId(UUID.randomUUID().toString());
		Boolean bl = waterQualityWarningService.insert(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	@PostMapping(value = "page")
	public ResponseResult<PageInfo<WaterQualityWarning>> getPage(@ApiParam @RequestBody WaterQualityWarningSearchDto param) throws Exception {
		PageInfo<WaterQualityWarning> page = waterQualityWarningService.findPageList(param.getPageIndex(), param.getPageSize(), param);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping
	public ResponseResult<Boolean> update(@RequestBody WaterQualityWarning t) throws Exception {
		boolean bl = waterQualityWarningService.update(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping
	public ResponseResult<Boolean> delete(@RequestBody WaterQualityWarning t) throws BizException {
		boolean bl = waterQualityWarningService.deleteById(t.getId());
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}
}
