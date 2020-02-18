package com.dsunsoft.module.admin.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsunsoft.common.util.BeanCopierUtils;
import com.dsunsoft.common.util.IdWorker;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.DictTypeMapper;
import com.dsunsoft.module.admin.dao.sys.DictValueMapper;
import com.dsunsoft.module.admin.dto.DictTypeDto;
import com.dsunsoft.module.admin.entity.sys.DictType;
import com.dsunsoft.module.admin.entity.sys.DictValue;
import com.dsunsoft.module.admin.service.sys.DictTypeService;

@Service
public class DictTypeServiceImpl extends BaseServiceImpl<DictTypeMapper, DictType, String>
implements  DictTypeService {
	@Autowired
	private DictTypeMapper  dictTypeMapper;
	
	@Autowired
	private DictValueMapper  dictValueMapper;
	
	@Transactional
	@Override
	public void save(DictTypeDto dictTypeDto) throws Exception {
		DictType dictType = new DictType();
		BeanCopierUtils.copy(dictTypeDto, dictType);
		//先看看数据库有没有该id,有修改，没有添加
		DictType dictType2  = dictTypeMapper.getById(dictTypeDto.getId());
          if(null==dictType2){
              dictType.setId(IdWorker.getUuid());
        	  mapper.insert(dictType);
          }else{
        	  mapper.update(dictType);
          }		
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(DictType dictType) throws Exception {
		dictTypeMapper.deleteById(dictType.getId());
		DictValue dictValue = new DictValue();
		dictValue.setDictTypeId(dictType.getId());
		dictValueMapper.delete(dictValue);
	}

}
