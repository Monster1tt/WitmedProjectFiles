package com.wler.witmed.service;

import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.pojo.system.entity.AllergyRiskLevel;

import java.util.List;

/**
 * <b>系统功能-个体过敏危险等级业务层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public interface AllergyRiskLevelService {
	/**
	 * <b>分页查询</b>
	 *
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<AllergyRiskLevel> getPageByQuery(AllergyRiskLevel query, PageVO<AllergyRiskLevel> pageVO) throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<AllergyRiskLevel> getListByQuery(AllergyRiskLevel query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean save(AllergyRiskLevel entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean update(AllergyRiskLevel entity) throws Exception;

	/**
	 * <b>根据 ID 查询对象</b>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	AllergyRiskLevel getById(String id) throws Exception;

	/**
	 * <b>根据编码查询对象</b>
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	AllergyRiskLevel getByCode(String code) throws Exception;
}
