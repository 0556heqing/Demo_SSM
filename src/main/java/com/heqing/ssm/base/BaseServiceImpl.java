package com.heqing.ssm.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	@CacheEvict(value="data", allEntries = true)  
	public void save(T entity) {
		baseDao.save(entity);
	}
	
	@CacheEvict(value="data", allEntries = true)  
	public void saveBatch(List<T> listEntity) {
		baseDao.saveBatch(listEntity);
	}

	@CacheEvict(value="data", allEntries = true)
	public void delete(Long id) {
		baseDao.delete(id);
	}

	@CacheEvict(value="data", allEntries = true) 
	public void deleteBatch(Long[] ids) {
		baseDao.deleteBatch(ids);
	}

	@CacheEvict(value="data", allEntries = true)    
	public void update(T entity) {
		baseDao.update(entity);
	}

	@CacheEvict(value="data", allEntries = true)  
	public void updateBatch(List<T> listEntity) {
		for(T entity : listEntity)
			baseDao.update(entity);
	}

	@Cacheable(value="data", key="#root.targetClass+#root.methodName") 
	public T getById(Long id) {
		return baseDao.getById(id);
	}

	@Cacheable(value="data", key="#root.targetClass+#root.methodName") 
	public List<T> getByIds(Long[] ids) {
		return baseDao.getByIds(ids);
	}

	@Cacheable(value="data", key="#root.targetClass+#root.methodName") 
	public List<T> findAll() {
		return findAll(null);
	}

	@Cacheable(value="data", key="#root.targetClass+#root.methodName") 
	public List<T> findAll(T entity) {
		return baseDao.findAll(entity);
	}

	@Cacheable(value="data", key="#root.targetClass+#root.methodName") 
	public List<T> getPageBean(int pageNum, int pageSize) {
		return getPageBean(null, pageNum, pageSize);
	}

	@Cacheable(value="data", key="#root.targetClass+#root.methodName") 
	public List<T> getPageBean(T entity, int pageNum, int pageSize) {
		return baseDao.getPageBean(entity, pageNum, pageSize);
	}
}
