package com.dsunsoft.module.admin.web;

import java.util.List;

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
import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.common.util.StringUtils;
import com.dsunsoft.core.util.SecurityUtils;
import com.dsunsoft.core.web.BaseController;
import com.dsunsoft.module.admin.dto.SysUserSearchDto;
import com.dsunsoft.module.admin.entity.sys.SysUser;
import com.dsunsoft.module.admin.entity.sys.SysUserRole;
import com.dsunsoft.module.admin.service.sys.SysUserService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "系统用户")
@RestController
@RequestMapping(value = "/video-ai/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	@PostMapping("/getMenu")
	@ApiOperation(value = "获取用户菜单", notes = "获取用户菜单")
	public ResponseResult<SysUser> getMenus() throws BizException {
		String userId = SecurityUtils.getCurrentUserLogin();
		if (StringUtils.isEmpty(userId)) {
			throw new BizException("未获取到用户信息,请重新登录");
		}
		SysUser user = sysUserService.getUserMenu(userId);
		return new ResponseResult<>(ResponseCode.SUCCESS, user);
	}

	@PostMapping("/logout")
	@ApiOperation(value = "注销", notes = "注销")
	public ResponseResult<String> logout() {
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@GetMapping("/get/{id}")
	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
	public ResponseEntity<SysUser> getObject(@ApiParam @PathVariable String id) {
		SysUser sysUser = sysUserService.getById(id);
		if (sysUser == null) {
			return new ResponseEntity<>(sysUser, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(sysUser, HttpStatus.OK);
	}

	@PostMapping(value = "/get")
	@ApiOperation(value = "获取分页数据", notes = "获取分页数据")
	public ResponseResult<PageInfo<SysUser>> getPage(@ApiParam @RequestBody SysUserSearchDto param) throws Exception {
		PageInfo<SysUser> page = sysUserService.findPageList(param.getPageIndex(), param.getPageSize(), param);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}

	@PutMapping("/updateRole")
	@ApiOperation(value = "修改数据", notes = "修改数据")
	public ResponseResult<String> updateRole(@RequestBody SysUser t) throws Exception {
		sysUserService.update(t);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/add")
	@ApiOperation(value = "新增用户", notes = "新增用户")
	public ResponseResult<String> add(@RequestBody @Validated SysUser t) throws Exception {
		sysUserService.insert(t);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/save")
	@ApiOperation(value = "保存用户", notes = "保存用户")
	public ResponseResult<Object> save(@RequestBody @Validated SysUser sysUser) throws Exception {
		if (!sysUserService.checkLoginName(sysUser.getOldLoginName(), sysUser.getLoginName())) {
			return new ResponseResult<>(ResponseCode.USER_EXISTS, "保存用户'" + sysUser.getLoginName() + "'失败，登录名已存在!");
		} else {
			// 如果新密码为空，则不更换密码
			if (StringUtils.isNotBlank(sysUser.getNewPassword())) {
				sysUser.setPassword(sysUserService.entryptPassword(sysUser.getNewPassword()));
			}
			Boolean bl = sysUserService.save(sysUser);
			return new ResponseResult<>(ResponseCode.SUCCESS, bl);
		}
	}

	@PutMapping
	@ApiOperation(value = "修改数据", notes = "修改数据")
	public ResponseResult<String> update(@RequestBody SysUser t) throws Exception {
		sysUserService.update(t);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@DeleteMapping
	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	public ResponseResult<String> delete(String id) throws Exception {
		sysUserService.deleteById(id);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@GetMapping(value = "get/roles")
	@ApiOperation(value = "删除数据", notes = "通过id删除数据")
	public ResponseResult<SysUser> loadRoles(@RequestBody SysUser t) {
		SysUser user = sysUserService.loadRoles(t);
		return new ResponseResult<SysUser>(ResponseCode.SUCCESS, user);
	}

	@GetMapping(value = "getSelect")
	@ApiOperation(value = "获取下拉数据", notes = "获取下拉数据")
	public ResponseResult<List<NgSelect>> getSelect() {
		List<NgSelect> list = sysUserService.getSelectByNonAdmin();
		return new ResponseResult<>(ResponseCode.SUCCESS, list);
	}
}
