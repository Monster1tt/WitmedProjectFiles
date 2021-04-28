package com.wler.witmed.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.dao.AllergyLevelDao;
import com.wler.witmed.pojo.system.entity.AllergyLevel;
import com.wler.witmed.service.AllergyLevelService;
import com.wler.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>系统功能-过敏病情状态业务层接口实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Service("allergyLevelService")
@Transactional
public class AllergyLevelServiceImpl implements AllergyLevelService {
	@Autowired
	private AllergyLevelDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>分页查询</b>
	 *
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */


	@Override
	public PageVO<AllergyLevel> getPageByQuery(AllergyLevel query, PageVO<AllergyLevel> pageVO) throws Exception {
		// 打开 PageHelper 的分页过滤器,会将紧挨着的数组进行分页
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		List<AllergyLevel> list = dao.findListByQuery(query);
		// 获得 PageInfo 对象获得数据
		PageInfo<AllergyLevel> pageInfo = new PageInfo<AllergyLevel>(list);
		// 从 PageInfo 中提取数据
		pageVO.setList(pageInfo.getList());
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalSize((long) pageInfo.getPages());
		return pageVO;
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<AllergyLevel> getListByQuery(AllergyLevel query) throws Exception {
		return dao.findListByQuery(query);
	}

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(AllergyLevel entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (dao.save(entity) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(AllergyLevel entity) throws Exception {
		if (dao.update(entity) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据 ID 查询对象</b>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public AllergyLevel getById(String id) throws Exception {
		AllergyLevel query = new AllergyLevel();
		query.setId(id);
		// 查询对象
		List<AllergyLevel> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * <b>根据编码查询对象</b>
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public AllergyLevel getByCode(String code) throws Exception {
		AllergyLevel query = new AllergyLevel();
		query.setCode(code);
		// 查询对象
		List<AllergyLevel> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
