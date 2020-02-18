package com.dsunsoft.module.admin.web;

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
import com.dsunsoft.core.web.BaseController;
import com.dsunsoft.module.admin.dto.SysRoleSearchDto;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.service.sys.SysRoleService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "系统角色")
@RestController
@RequestMapping(value = "/video-ai/sysRole")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping("/{id}")
	public ResponseResult<SysRole> getObject(@ApiParam @PathVariable String id) {
		SysRole sysRole = sysRoleService.getById(id);
		if (sysRole == null) {
			return new ResponseResult<>(ResponseCode.SUCCESS, sysRole);
		}
		return new ResponseResult<>(ResponseCode.SUCCESS, sysRole);
	}

	@PostMapping
	public ResponseResult<Boolean> add(@RequestBody @Validated SysRole t) throws Exception {
		t.setRoleId(UUID.randomUUID().toString());
		Boolean bl = sysRoleService.insert(t);
		return new ResponseResult<>(ResponseCode.SUCCESS,bl);
	}

	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	@PostMapping(value = "page")
	public ResponseResult<PageInfo<SysRole>> getPage(@ApiParam @RequestBody SysRoleSearchDto param) throws Exception {
		PageInfo<SysRole> page = sysRoleService.findPageList(param.getPageIndex(), param.getPageSize(), param);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping
	public ResponseResult<Boolean> update(@RequestBody SysRole t) throws Exception {
		sysRoleService.update(t);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping
	public ResponseResult<Boolean> delete(@RequestBody SysRole t) throws BizException {
		sysRoleService.delete(t);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/roleMenu")
	public ResponseResult<Boolean> roleMenu(@RequestBody @Validated SysRole t) {
		Boolean bl = sysRoleService.roleMenu(t);
		return new ResponseResult<>(ResponseCode.SUCCESS,bl);
	}
}
