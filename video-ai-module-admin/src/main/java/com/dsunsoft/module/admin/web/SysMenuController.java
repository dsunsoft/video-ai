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
import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.web.BaseController;
import com.dsunsoft.module.admin.entity.sys.SysMenu;
import com.dsunsoft.module.admin.entity.sys.SysMenuTree;
import com.dsunsoft.module.admin.service.sys.SysMenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by x on 2018-7-13
 */
@Api(value = "系统菜单")
@RestController
@RequestMapping(value = "/video-ai/sysMenu")
public class SysMenuController extends BaseController {

	@Autowired
	private SysMenuService sysMenuService;

	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	@GetMapping(value = "/{id}")
	public ResponseEntity<SysMenu> getObject(@ApiParam @PathVariable String id) {
		SysMenu sysMenu = sysMenuService.getById(id);
		if (sysMenu == null) {
			return new ResponseEntity<>(sysMenu, HttpStatus.NO_CONTENT);
		}
		if (sysMenu.getLevel() == 1) {
			sysMenu.setPname("功能菜单");
		}
		return new ResponseEntity<>(sysMenu, HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseResult<Boolean> add(@RequestBody @Validated SysMenu t) throws Exception {
		t.setMenuId(UUID.randomUUID().toString());
		Boolean bl = sysMenuService.insert(t);
		return new ResponseResult<Boolean>(ResponseCode.SUCCESS,bl);
	}

	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	@PostMapping(value = "page")
	public ResponseResult<List<SysMenuTree>> getPage(@ApiParam @RequestBody SysMenu param) throws Exception {
		List<SysMenuTree> list = sysMenuService.selectListTree(param);
		return new ResponseResult<List<SysMenuTree>>(ResponseCode.SUCCESS, list);
	}

	@ApiOperation(value = "获取所有数据", notes = "获取所有数据")
	@GetMapping(value = "getAll")
	public ResponseResult<List<SysMenu>> getAll(@ApiParam @RequestBody SysMenu param) {
		List<SysMenu> list = sysMenuService.findList(param);
		return new ResponseResult<List<SysMenu>>(ResponseCode.SUCCESS, list);
	}

	@ApiOperation(value = "修改数据", notes = "修改数据")
	@PutMapping(value = "")
	public ResponseResult<Boolean> update(@ApiParam @RequestBody SysMenu t) throws Exception {
		Boolean bl = sysMenuService.update(t);
		return new ResponseResult<Boolean>(ResponseCode.SUCCESS,bl);
	}

	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	@DeleteMapping(value = "")
	public ResponseResult<Boolean> delete(@ApiParam @RequestBody SysMenu t) throws Exception {
		Boolean bl = sysMenuService.deleteById(t.getMenuId());
		return new ResponseResult<Boolean>(ResponseCode.SUCCESS,bl);
	}

	@ApiOperation(value = "获取所有数据", notes = "获取所有数据")
	@PostMapping(value = "getTree")
	public ResponseResult<List<NzTree>> getTree(@ApiParam @RequestBody SysMenu param) {
		List<NzTree> list = sysMenuService.selectNzTree(param);
		return new ResponseResult<List<NzTree>>(ResponseCode.SUCCESS, list);
	}
}
