package com.dsunsoft.module.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.module.admin.dto.SysLogSearchDto;
import com.dsunsoft.module.admin.entity.sys.SysLog;
import com.dsunsoft.module.admin.service.sys.SysLogService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author zd
 *
 */
@Api("操作日志")
@RestController
@RequestMapping("/video-ai/sysLog")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;

	@PostMapping("/get")
	@ApiOperation(value = "获取操作日志列表", notes = "获取操作日志列表")
	public ResponseResult<PageInfo<SysLog>> getList(@RequestBody SysLogSearchDto dto) {
		PageInfo<SysLog> pageList = sysLogService.findPageList(dto.getPageIndex(), dto.getPageSize(), dto);
		return new ResponseResult<>(ResponseCode.SUCCESS, pageList);
	}
	
	@PostMapping("/empty")
	@ApiOperation(value = "清空操作日志列表", notes = "清空操作日志列表")
	public ResponseResult<PageInfo<SysLog>> empty(@RequestBody SysLogSearchDto dto) {
		 sysLogService.empty();
		 return new ResponseResult<>(ResponseCode.SUCCESS);
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除操作日志列表", notes = "删除操作日志列表")
	public ResponseResult<String> delete(@PathVariable String id) throws Exception {
		sysLogService.deleteById(id);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

}
