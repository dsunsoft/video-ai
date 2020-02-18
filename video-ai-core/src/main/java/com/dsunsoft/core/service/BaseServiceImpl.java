package com.dsunsoft.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.core.entity.BaseEntity;

/**
 * Service基类
 * 
 * @author ygm
 *
 * @param <TMapper>
 *            Mapper
 * @param <TEntity>
 *            Entity
 * @param <TId>
 *            Id
 */
public class BaseServiceImpl<TMapper extends BaseMapper<TEntity, TId>, TEntity extends BaseEntity, TId>
		implements BaseService<TEntity, TId> {
	protected static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	/**
	 * 持久层对象
	 */
	@Autowired
	protected TMapper mapper;

	/**
	 * 获取单条数据
	 *
	 * @param entity
	 */
	@Override
	public TEntity getById(TId id) {
		return mapper.getById(id);
	}

	/**
	 * 新增数据
	 *
	 * @param entity
	 */
	@Transactional
	@Override
	public boolean insert(TEntity entity) {
		return mapper.insert(entity) > 0;
	}

	/**
	 * 修改数据
	 *
	 * @param entity
	 */
	@Transactional
	@Override
	public boolean update(TEntity entity) {
		return mapper.update(entity) > 0;
	}

	/**
	 * 删除数据
	 *
	 * @param entity
	 */
	@Transactional
	@Override
	public boolean deleteById(TId id) {
		return mapper.deleteById(id) > 0;
	}

	/**
	 * 获取列表数据
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public List<TEntity> findList(Object entity) {
		return mapper.findList(entity);
	}

	/**
	 * 分页获取列表数据
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param obj
	 * @return
	 */
	@Override
	public PageInfo<TEntity> findPageList(Integer pageIndex, Integer pageSize, Object entity) {
		PageHelper.startPage(pageIndex, pageSize);
		List<TEntity> list = mapper.findList(entity);
		return new PageInfo<>(list);
	}

	/**
	 * 动态sql
	 *
	 * @param sql
	 */
	public List<Object> executeSelectSql(String sql) {
		return mapper.execSelectSql(sql);
	}

	public void executeInsertSql(String sql) {
		mapper.execInsertSql(sql);
	}

	public void executeUpdateSql(String sql) {
		mapper.execUpdateSql(sql);
	}

	public void executeDeleteSql(String sql) {
		mapper.execDeleteSql(sql);
	}
}