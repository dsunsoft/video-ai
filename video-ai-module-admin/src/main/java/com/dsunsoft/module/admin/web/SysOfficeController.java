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
import com.dsunsoft.module.admin.entity.sys.Office;
import com.dsunsoft.module.admin.entity.sys.OfficeTree;
import com.dsunsoft.module.admin.entity.sys.SysMenu;
import com.dsunsoft.module.admin.service.sys.OfficeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "组织机构")
@RequestMapping(value = "/video-ai/sysOffice")
public class SysOfficeController extends BaseController {
    
	@Autowired
	private OfficeService officeService;
	
	@ApiOperation(value = "获取树形表格数据", notes = "获取树形表格数据")
    @PostMapping(value = "page")
    public ResponseResult<List<OfficeTree>> getPage(@ApiParam @RequestBody Office param) throws Exception {
        List<OfficeTree> list = officeService.selectListTree(param);
        return new ResponseResult<List<OfficeTree>>(ResponseCode.SUCCESS, list);
    }
	
	@ApiOperation(value = "通过id获取数据", notes = "通过id获取数据")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Office> getObject(@ApiParam @PathVariable String id) {
	    Office area = officeService.getById(id);
        if (area == null) {
            return new ResponseEntity<>(area, HttpStatus.NO_CONTENT);
        }
        if (area.getType().equals("1")) {
            area.setParentName("机构");
        }
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseResult<Boolean> add(@RequestBody @Validated Office t) throws Exception {
        t.setId(UUID.randomUUID().toString());
        Boolean bl = officeService.insert(t);
        return new ResponseResult<Boolean>(ResponseCode.SUCCESS,bl);
    }
	
	@ApiOperation(value = "修改数据", notes = "修改数据")
    @PutMapping(value = "")
    public ResponseResult<Boolean> update(@ApiParam @RequestBody Office t) throws Exception {
        Boolean bl = officeService.update(t);
        return new ResponseResult<Boolean>(ResponseCode.SUCCESS,bl);
    }

    @ApiOperation(value = "删除数据", notes = "通过id删除数据")
    @DeleteMapping(value = "")
    public ResponseResult<Boolean> delete(@ApiParam @RequestBody Office t) throws Exception {
        Boolean bl = officeService.deleteById(t.getId());
        return new ResponseResult<Boolean>(ResponseCode.SUCCESS,bl);
    }
    
    @ApiOperation(value = "获取所有数据", notes = "获取所有数据")
    @PostMapping(value = "getTree")
    public ResponseResult<List<NzTree>> getTree(@ApiParam @RequestBody Office param) {
        List<NzTree> list = officeService.selectNzTree(param);
        return new ResponseResult<List<NzTree>>(ResponseCode.SUCCESS, list);
    }

}
