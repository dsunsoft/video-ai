package com.dsunsoft.module.admin.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.dsunsoft.common.entity.ng.NgCascader;
import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.core.web.BaseController;
import com.dsunsoft.module.admin.dto.AreaSearchDto;
import com.dsunsoft.module.admin.entity.sys.Area;
import com.dsunsoft.module.admin.entity.sys.AreaTree;
import com.dsunsoft.module.admin.service.sys.AreaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "行政区划")
@RequestMapping(value = "/video-ai/sysArea")
public class SysAreaController extends BaseController {
	@Autowired
	private AreaService areaService;

	@GetMapping("/getCascader")
	@ApiOperation(value = "获取省市区级联数据", notes = "获取省市区级联数据")
	public ResponseResult<List<NgCascader>> getCascaderList() {
		List<NgCascader> list = areaService.getCascaderList();
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}

	@ApiOperation(value = "获取树形表格数据", notes = "获取树形表格数据")
	@PostMapping(value = "page")
	public ResponseResult<List<AreaTree>> getPage(@ApiParam @RequestBody Area param) throws Exception {
		List<AreaTree> list = areaService.selectListTree(param);
		return new ResponseResult<List<AreaTree>>(ResponseCode.SUCCESS, list);
	}

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Area> getObject(@ApiParam @PathVariable String id) {
		Area area = areaService.getById(id);
		if (area == null) {
			return new ResponseEntity<>(area, HttpStatus.NO_CONTENT);
		}
		if (area.getType().equals("1")) {
			area.setParentName("国家");
		}
		return new ResponseEntity<>(area, HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseResult<Boolean> add(@RequestBody @Validated Area t) throws Exception {
		t.setId(UUID.randomUUID().toString());
		Boolean bl = areaService.insert(t);
		return new ResponseResult<Boolean>(ResponseCode.SUCCESS, bl);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping(value = "")
	public ResponseResult<Boolean> update(@ApiParam @RequestBody Area t) throws Exception {
		Boolean bl = areaService.update(t);
		return new ResponseResult<Boolean>(ResponseCode.SUCCESS, bl);
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping(value = "")
	public ResponseResult<Boolean> delete(@ApiParam @RequestBody Area t) throws Exception {
		Boolean bl = areaService.deleteById(t.getId());
		return new ResponseResult<Boolean>(ResponseCode.SUCCESS, bl);
	}

	@GetMapping("/getProvinces")
	@ApiOperation(value = "获取省份数据", notes = "获取省份数据")
	public ResponseResult<List<NgSelect>> getProvinceList() {
		List<NgSelect> list = areaService.getProvinceList();
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}

	@PostMapping("/getData")
	@ApiOperation(value = "获取数据", notes = "获取数据")
	public ResponseResult<List<NgSelect>> getProvinceList(@RequestBody AreaSearchDto dto) {
		List<NgSelect> list = areaService.getData(dto);
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}
}
