package com.wler.witmed.dao;

import com.wler.witmed.pojo.system.entity.IllnessType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能-疾病类型数据持久层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Repository
public interface IllnessTypeDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<IllnessType> findListByQuery(IllnessType query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(IllnessType entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(IllnessType entity) throws Exception;
}
