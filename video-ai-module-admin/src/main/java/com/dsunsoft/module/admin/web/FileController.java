package com.dsunsoft.module.admin.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dsunsoft.common.entity.ResponseCode;
import com.dsunsoft.common.entity.ResponseResult;
import com.dsunsoft.core.config.UploadConfig;
import com.dsunsoft.core.entity.FileEntity;
import com.dsunsoft.core.web.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("上传文件")
@RestController
@RequestMapping("/video-ai/file")
public class FileController extends BaseController {
	@Autowired
	private UploadConfig uploadConfig;

	@PostMapping("/upload")
	@ApiOperation(value = "上传文件", notes = "上传文件")
	public ResponseResult<Object> upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseResult<Object>().failure("上传文件不能为空");
		}
		// 文件重命名
		String fileType = FilenameUtils.getExtension(file.getOriginalFilename());
		String fileName = UUID.randomUUID().toString();
		String filePath = uploadConfig.getPath() + fileName + "." + fileType;
		String relativeUrl =  uploadConfig.getRelativeUrl() + fileName + "." + fileType;
		FileEntity fileEntity = new FileEntity();
        fileEntity.setFilePath(filePath);
        fileEntity.setFileType(fileType);
        fileEntity.setRelativeUrl(relativeUrl);
		// TODO 按不同功能存放
		try {
			file.transferTo(new File(filePath));
		} catch (IOException e) {
			logger.error("文件上传失败,路径:{},错误信息:{}", filePath, e.getMessage());
			return new ResponseResult<Object>().failure("上传失败");
		}
		return new ResponseResult<>(ResponseCode.SUCCESS,fileEntity);
	}

	@PostMapping("/multiUpload")
	@ApiOperation(value = "上传多个文件", notes = "上传多个文件")
	public ResponseResult<Object> multiUpload(MultipartHttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		if (null == files || files.size() == 0) {
			return new ResponseResult<Object>().failure("上传文件不能为空");
		}
		List<FileEntity> fileList = new ArrayList<>();
		boolean isSuccess = true;
		for (MultipartFile file : files) {
			// 文件重命名
		    String fileType = FilenameUtils.getExtension(file.getOriginalFilename());
	        String fileName = UUID.randomUUID().toString();
	        String filePath = uploadConfig.getPath() + fileName + "." + fileType;
	        String relativeUrl =  uploadConfig.getRelativeUrl() + fileName + "." + fileType;
	        FileEntity fileEntity = new FileEntity();
	        fileEntity.setFilePath(filePath);
	        fileEntity.setFileType(fileType);
	        fileEntity.setRelativeUrl(relativeUrl);
			fileList.add(fileEntity);
			// TODO 按不同功能存放
			try {
				file.transferTo(new File(filePath));
			} catch (IOException e) {
				isSuccess = false;
				logger.error("文件上传失败,路径:{},错误信息:{}", filePath, e.getMessage());
				break;
			}
		}
		if (!isSuccess) {
			return new ResponseResult<Object>().failure("文件上传失败");
		}
		return new ResponseResult<>(ResponseCode.SUCCESS,fileList);
	}

	@PostMapping("/download")
	@ApiOperation(value = "下载文件", notes = "下载文件")
	public void download() {

	}
}
