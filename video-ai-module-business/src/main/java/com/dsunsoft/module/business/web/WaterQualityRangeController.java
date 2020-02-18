package com.dsunsoft.module.business.web;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.module.business.dto.WaterQualityRangeSearchDto;
import com.dsunsoft.module.business.entity.WaterQualityRange;
import com.dsunsoft.module.business.service.WaterQualityRangeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(value = "水质指标正常范围")
@RestController
@RequestMapping(value = "/video-ai/waterQualityRange")
public class WaterQualityRangeController {

	@Autowired
	private WaterQualityRangeService waterQualityRangeService;

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping("/{id}")
	public ResponseResult<WaterQualityRange> getObject(@ApiParam @PathVariable String id) {
		WaterQualityRange waterQualityRange = waterQualityRangeService.getById(id);
		if (waterQualityRange == null) {
			return new ResponseResult<>(ResponseCode.SUCCESS, waterQualityRange);
		}
		return new ResponseResult<>(ResponseCode.SUCCESS, waterQualityRange);
	}

	@PostMapping
	public ResponseResult<Boolean> add(@RequestBody @Validated WaterQualityRange t) throws Exception {
		t.setId(UUID.randomUUID().toString());
		Boolean bl = waterQualityRangeService.insert(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	@PostMapping(value = "page")
	public ResponseResult<PageInfo<WaterQualityRange>> getPage(@ApiParam @RequestBody WaterQualityRangeSearchDto param) throws Exception {
		PageInfo<WaterQualityRange> page = waterQualityRangeService.findPageList(param.getPageIndex(), param.getPageSize(), param);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping
	public ResponseResult<Boolean> update(@RequestBody WaterQualityRange t) throws Exception {
		boolean bl = waterQualityRangeService.update(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping
	public ResponseResult<Boolean> delete(@RequestBody WaterQualityRange t) throws BizException {
		boolean bl = waterQualityRangeService.deleteById(t.getId());
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}
}
