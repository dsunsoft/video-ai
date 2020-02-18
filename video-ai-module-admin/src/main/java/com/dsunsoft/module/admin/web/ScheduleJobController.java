package com.dsunsoft.module.admin.web;

import java.util.List;

import org.quartz.CronExpression;
import org.quartz.SchedulerException;
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
import com.dsunsoft.module.admin.dto.ScheduleJobSearchDto;
import com.dsunsoft.module.admin.entity.sys.ScheduleJob;
import com.dsunsoft.module.admin.service.sys.ScheduleJobService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 定时任务
 * 
 * @author ygm
 *
 */
@Api("定时任务")
@RestController
@RequestMapping("/video-ai/scheduleJob")
public class ScheduleJobController {
	@Autowired
	private ScheduleJobService scheduleJobService;

	@GetMapping("/get/{id}")
	@ApiOperation(value = "获取单个定时任务", notes = "获取单个定时任务")
	public ResponseResult<ScheduleJob> getById(@PathVariable String id) {
		ScheduleJob scheduleJob = scheduleJobService.getById(id);
		return new ResponseResult<>(ResponseCode.SUCCESS, scheduleJob);
	}

	@PostMapping("/get")
	@ApiOperation(value = "获取定时任务列表", notes = "获取定时任务列表")
	public ResponseResult<PageInfo<ScheduleJob>> getList(@RequestBody ScheduleJobSearchDto dto) {
		PageInfo<ScheduleJob> page = scheduleJobService.findPageList(dto.getPageIndex(), dto.getPageSize(), dto);
		return new ResponseResult<>(ResponseCode.SUCCESS, page);
	}

	@PostMapping("/save")
	@ApiOperation(value = "保存定时任务", notes = "保存定时任务")
	public ResponseResult<String> save(@RequestBody @Validated ScheduleJob scheduleJob) throws Exception {
		// 验证cron表达式
		if (!CronExpression.isValidExpression(scheduleJob.getCronExpression())) {
			return new ResponseResult<String>().failure("cron表达式不正确");
		}
		scheduleJobService.save(scheduleJob);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除定时任务", notes = "删除定时任务")
	public ResponseResult<String> delete(@PathVariable String id) throws SchedulerException {
		ScheduleJob scheduleJob = scheduleJobService.getById(id);
		if (null == scheduleJob) {
			return new ResponseResult<String>().failure("该定时任务不存在");
		}
		scheduleJobService.delete(scheduleJob);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/startNow")
	@ApiOperation(value = "立即执行定时任务", notes = "立即执行定时任务")
	public ResponseResult<String> startNow(String id) throws SchedulerException {
		ScheduleJob scheduleJob = scheduleJobService.getById(id);
		if (null == scheduleJob) {
			return new ResponseResult<String>().failure("该定时任务不存在");
		}
		scheduleJobService.startNowJob(scheduleJob);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/pause")
	@ApiOperation(value = "暂停定时任务", notes = "暂停定时任务")
	public ResponseResult<String> pause(String id) throws SchedulerException {
		ScheduleJob scheduleJob = scheduleJobService.getById(id);
		if (null == scheduleJob) {
			return new ResponseResult<String>().failure("该定时任务不存在");
		}
		scheduleJobService.pauseJob(scheduleJob);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}

	@PostMapping("/resume")
	@ApiOperation(value = "恢复定时任务", notes = "恢复定时任务")
	public ResponseResult<String> resume(String id) throws SchedulerException {
		ScheduleJob scheduleJob = scheduleJobService.getById(id);
		if (null == scheduleJob) {
			return new ResponseResult<String>().failure("该定时任务不存在");
		}
		scheduleJobService.resumeJob(scheduleJob);
		return new ResponseResult<>(ResponseCode.SUCCESS);
	}
}
