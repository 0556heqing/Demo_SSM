package com.heqing.ssm.base;

import java.util.List;

public interface BaseService<T> {

	/**
	 * 保存实体
	 * @param entity 实体
	 */
	void save(T entity);
	
	/**
	 * 保存多个实体
	 * @param listEntity 多个实体
	 */
	void saveBatch(List<T> listEntity);
	
	/**
	 * 根据ID删除实体
	 * @param id  实体ID
	 */
	void delete(Long id);
	
	/**
	 * 根据多个ID删除多个实体
	 * @param ids  多个ID
	 */
	void deleteBatch(Long[] ids);

	/**
	 * 更新实体
	 * @param entity 实体
	 */
	void update(T entity);

	/**
	 * 更新多个实体
	 * @param listEntity 多个实体
	 */
	void updateBatch(List<T> listEntity);

	/**
	 * 查询实体，如果id为null，则返回null，并不会抛异常。
	 * @param id 实体ID
	 * @return T 实体
	 */
	T getById(Long id);

	/**
	 * 根据多个ID查询实体
	 * @param ids 多个实体ID集合
	 * @return List<T> 多个实体集合
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 * @return List<T> 多个实体集合
	 */
	List<T> findAll();

	/**
	 * 查询所有
	 * @param entity 实体:做条件查询使用
	 * @return List<T> 多个实体集合
	 */
	List<T> findAll(T entity);
	
	/**
	 * 公共的查询分页信息的方法
	 * @param pageNum 哪一页
	 * @param pageSize 一个几条信息
	 * @return List<T> 多个实体集合
	 */
	List<T> getPageBean(int pageNum, int pageSize);

	/**
	 * 公共的查询分页信息的方法
	 * @param entity 实体:做条件查询使用
	 * @param pageNum 哪一页
	 * @param pageSize 一个几条信息
	 * @return List<T> 多个实体集合
	 */
	List<T> getPageBean(T entity, int pageNum, int pageSize);
}