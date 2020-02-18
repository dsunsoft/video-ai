package com.dsunsoft.module.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.module.admin.dto.DictTypeDto;
import com.dsunsoft.module.admin.dto.DictTypeSearchDto;
import com.dsunsoft.module.admin.dto.DictValueDto;
import com.dsunsoft.module.admin.entity.sys.DictSelectValue;
import com.dsunsoft.module.admin.entity.sys.DictType;
import com.dsunsoft.module.admin.entity.sys.DictValue;
import com.dsunsoft.module.admin.service.sys.DictTypeService;
import com.dsunsoft.module.admin.service.sys.DictValueService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("字典信息")
@RestController
@RequestMapping("/video-ai/sysDict")
public class SysDictController {
	@Autowired
	private DictTypeService dictTypeService;
	@Autowired
	private DictValueService dictValueService;

	@GetMapping("/getType/{id}")
	@ApiOperation(value = "获取单个字典类型信息", notes = "获取单个字典类型信息")
	public ResponseResult<DictType> getById(@PathVariable String id) {
		DictType dictType = dictTypeService.getById(id);
		return new ResponseResult<>(ResponseCode.SUCCESS, dictType);
	}

	@PostMapping("/getType")
	@ApiOperation(value = "获取字典类型信息列表", notes = "获取字典类型信息列表")
	public ResponseResult<PageInfo<DictType>> getList(@RequestBody DictTypeSearchDto dictTypeSearchDto) {
		PageInfo<DictType> pageList = dictTypeService.findPageList(dictTypeSearchDto.getPageIndex(),
				dictTypeSearchDto.getPageSize(), dictTypeSearchDto);
		return new ResponseResult<>(ResponseCode.SUCCESS, pageList);
	}

	@PostMapping("/saveType")
	@ApiOperation(value = "保存字典类型信息", notes = "保存字典类型信息")
	public ResponseResult<String> save(@RequestBody @Validated DictTypeDto dictTypeDto) throws Exception {
		dictTypeService.save(dictTypeDto);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@DeleteMapping("/deleteType/{id}")
	@ApiOperation(value = "删除字典类型信息", notes = "删除字典类型信息")
	public ResponseResult<String> delete(@PathVariable String id) throws Exception {
		DictType dictType = dictTypeService.getById(id);
		if (null == dictType) {
			return new ResponseResult<String>().failure("该字典类型不存在");
		}
		dictTypeService.delete(dictType);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@GetMapping("/getValue/{id}")
	@ApiOperation(value = "获取单个字典类型键值信息", notes = "获取单个字典类型键值信息")
	public ResponseResult<DictValue> get(@PathVariable String id) {
		DictValue dictValue = dictValueService.getById(id);
		return new ResponseResult<>(ResponseCode.SUCCESS, dictValue);
	}

	@GetMapping("/listValue/{id}")
	@ApiOperation(value = "获取字典类型键值信息", notes = "获取字典类型键值信息")
	public ResponseResult<List<DictValue>> getList(@PathVariable String id) {
		DictValue dictValue = new DictValue();
		dictValue.setDictTypeId(id);
		List<DictValue> list = dictValueService.findList(dictValue);
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}

	@DeleteMapping("/deleteValue/{id}")
	@ApiOperation(value = "删除字典类型键值信息", notes = "删除字典类型键值信息")
	public ResponseResult<String> deleteDValue(@PathVariable String id) throws Exception {
		dictValueService.delete(new DictValue(id));
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/saveValue")
	@ApiOperation(value = "保存字典键值信息", notes = "保存字典键值信息")
	public ResponseResult<String> save(@RequestBody @Validated DictValueDto dictValueDto) throws Exception {
		dictValueService.save(dictValueDto);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/getDictValues")
	@ApiOperation(value = "根据字典类型或者ID获取下拉框", notes = "根据字典类型或者ID获取下拉框")
	public ResponseResult<List<DictSelectValue>> getDictValues(@RequestBody DictSelectValue dictSelectValue)
			throws Exception {
		List<DictSelectValue> list = dictValueService.getDictValues(dictSelectValue);
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}

}
