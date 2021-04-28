package com.wler.witmed.dao;

import com.wler.witmed.pojo.system.entity.Allergy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能-是否过敏数据持久层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Repository
public interface AllergyDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Allergy> findListByQuery(Allergy query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(Allergy entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(Allergy entity) throws Exception;
}
