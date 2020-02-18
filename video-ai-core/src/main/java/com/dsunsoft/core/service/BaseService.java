package com.dsunsoft.core.service;

import java.util.List;

import com.dsunsoft.core.entity.BaseEntity;
import com.github.pagehelper.PageInfo;

/**
 * BaseService
 * 
 * @author ygm
 *
 * @param <TEntity>
 * @param <TId>
 * @param <T>
 */
public interface BaseService<TEntity extends BaseEntity, TId> {
	TEntity getById(TId id);

	boolean insert(TEntity entity);

	boolean update(TEntity entity);

	boolean deleteById(TId id);

	List<TEntity> findList(Object entity);

	PageInfo<TEntity> findPageList(Integer pageIndex, Integer pageSize, Object entity);
}
