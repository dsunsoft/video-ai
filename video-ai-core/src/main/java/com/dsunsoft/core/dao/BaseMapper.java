package com.dsunsoft.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * BaseMapper
 * 
 * @author ygm
 *
 * @param <TEntity>
 *            Entity
 * @param <TId>
 *            Id
 */
public interface BaseMapper<TEntity extends BaseEntity, TId> {
	/**
	 * 新增
	 *
	 * @param id
	 * @return
	 */
	int insert(TEntity entity);

	/**
	 * 修改
	 *
	 * @param id
	 * @return
	 */
	int update(TEntity entity);

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	int deleteById(TId id);

	/**
	 * 逻辑删除
	 * 
	 * @param entity
	 * @return
	 */
	int deleteByLogic(TEntity entity);

	/**
	 * 获取单条数据
	 *
	 * @param id
	 * @return
	 */
	TEntity getById(TId id);

	/**
	 * 查询数据列表
	 * 
	 * @param obj
	 * @return
	 */
	List<TEntity> findList(Object obj);

	@Select("${sql}")
	List<Object> execSelectSql(@Param(value = "sql") String sql);

	@Update("${sql}")
	void execUpdateSql(@Param(value = "sql") String sql);

	@Insert("${sql}")
	void execInsertSql(@Param(value = "sql") String sql);

	@Delete("${sql}")
	void execDeleteSql(@Param(value = "sql") String sql);
}
