package com.dsunsoft.module.admin.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsunsoft.common.util.BeanCopierUtils;
import com.dsunsoft.common.util.IdWorker;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.DictValueMapper;
import com.dsunsoft.module.admin.dto.DictValueDto;
import com.dsunsoft.module.admin.entity.sys.DictSelectValue;
import com.dsunsoft.module.admin.entity.sys.DictValue;
import com.dsunsoft.module.admin.service.sys.DictValueService;

@Service
public class DictValueServiceImpl extends BaseServiceImpl<DictValueMapper, DictValue, String>
		implements DictValueService {

	@Autowired
	private DictValueMapper dictValueMapper;

	@Transactional
	@Override
	public void deleteByLogic(DictValue dictValue) throws Exception {
		dictValueMapper.deleteByLogic(dictValue);

	}

	@Transactional
	@Override
	public void save(DictValueDto dictValueDto) throws Exception {
		DictValue dictValue = new DictValue();
		BeanCopierUtils.copy(dictValueDto, dictValue);
		// 先看看数据库有没有该id,有修改，没有添加
		DictValue DictValue2 = dictValueMapper.getById(dictValueDto.getId());
		if (null == DictValue2) {
			dictValue.setId(IdWorker.getUuid());
			mapper.insert(dictValue);
		} else {
			mapper.update(dictValue);
		}
	}

	@Override
	public List<DictSelectValue> getDictValues(DictSelectValue dictSelectValue) {
		return dictValueMapper.getDictValues(dictSelectValue);
	}

	@Override
	public void delete(DictValue dictValue) {
		mapper.delete(dictValue);
	}

}
