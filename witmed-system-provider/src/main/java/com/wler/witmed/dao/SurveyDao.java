package com.wler.witmed.dao;

import com.wler.witmed.pojo.system.entity.Survey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能-观察方法数据持久层接口</b>
 *
 * @author Monster
 * @verion 1.0.0
 */
@Repository
public interface SurveyDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Survey> findListByQuery(Survey query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(Survey entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(Survey entity) throws Exception;
}
