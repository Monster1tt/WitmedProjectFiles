package com.wler.witmed.service;

import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.pojo.system.entity.Position;

import java.util.List;

/**
 * <b>系统功能-医生职位业务层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public interface PositionService {
	/**
	 * <b>分页查询</b>
	 *
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<Position> getPageByQuery(Position query, PageVO<Position> pageVO) throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Position> getListByQuery(Position query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean save(Position entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean update(Position entity) throws Exception;

	/**
	 * <b>根据 ID 查询对象</b>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Position getById(String id) throws Exception;

	/**
	 * <b>根据编码查询对象</b>
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	Position getByCode(String code) throws Exception;
}
