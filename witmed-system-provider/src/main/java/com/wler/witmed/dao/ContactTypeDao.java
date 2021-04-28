package com.wler.witmed.dao;

import com.wler.witmed.pojo.system.entity.ContactType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>系统功能-联系人类别数据持久层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Repository
public interface ContactTypeDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ContactType> findListByQuery(ContactType query) throws Exception;

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(ContactType entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(ContactType entity) throws Exception;
}
