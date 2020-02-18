package com.dsunsoft.module.business.web;

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
import com.dsunsoft.module.business.dto.VideoStationSearchDto;
import com.dsunsoft.module.business.entity.VideoStation;
import com.dsunsoft.module.business.service.VideoStationService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "乐橙云视频信息")
@RestController
@RequestMapping(value = "/video-ai/videoStation")
public class VideoStationController {

	@Autowired
	private VideoStationService videoStationService;

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping("/{id}")
	public ResponseResult<VideoStation> getObject(@ApiParam @PathVariable String id) {
		VideoStation videoStation = videoStationService.getById(id);
		if (videoStation == null) {
			return new ResponseResult<>(ResponseCode.SUCCESS, videoStation);
		}
		return new ResponseResult<>(ResponseCode.SUCCESS, videoStation);
	}

	@PostMapping
	public ResponseResult<Boolean> add(@RequestBody @Validated VideoStation t) throws Exception {
		t.setId(UUID.randomUUID().toString());
		Boolean bl = videoStationService.insert(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	@PostMapping(value = "page")
	public ResponseResult<PageInfo<VideoStation>> getPage(@ApiParam @RequestBody VideoStationSearchDto param) throws Exception {
		PageInfo<VideoStation> page = videoStationService.findPageList(param.getPageIndex(), param.getPageSize(), param);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping
	public ResponseResult<Boolean> update(@RequestBody VideoStation t) throws Exception {
		boolean bl = videoStationService.update(t);
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping
	public ResponseResult<Boolean> delete(@RequestBody VideoStation t) throws BizException {
		boolean bl = videoStationService.deleteById(t.getId());
		if(bl) {
			return new ResponseResult<>(ResponseCode.SUCCESS);
		}
		else {
			return new ResponseResult<>(ResponseCode.FAILURE);
		}
	}
}
