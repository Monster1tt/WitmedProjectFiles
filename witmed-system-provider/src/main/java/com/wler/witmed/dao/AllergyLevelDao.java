package com.wler.witmed.dao;

import com.wler.witmed.pojo.system.entity.AllergyLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能-过敏病情状态数据持久层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Repository
public interface AllergyLevelDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<AllergyLevel> findListByQuery(AllergyLevel query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(AllergyLevel entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(AllergyLevel entity) throws Exception;
}
