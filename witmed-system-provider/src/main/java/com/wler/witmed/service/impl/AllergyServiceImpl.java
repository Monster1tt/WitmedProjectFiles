package com.wler.witmed.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.dao.AllergyDao;
import com.wler.witmed.pojo.system.entity.Allergy;
import com.wler.witmed.service.AllergyService;
import com.wler.witmed.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>系统功能-是否过敏业务层接口实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Service("allergyService")
@Transactional
public class AllergyServiceImpl implements AllergyService {
	@Autowired
	private AllergyDao dao;
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
	public PageVO<Allergy> getPageByQuery(Allergy query, PageVO<Allergy> pageVO) throws Exception {
		// 打开 PageHelper 的分页过滤器,会将紧挨着的数组进行分页
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		List<Allergy> list = dao.findListByQuery(query);
		// 获得 PageInfo 对象获得数据
		PageInfo<Allergy> pageInfo = new PageInfo<Allergy>(list);
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
	public List<Allergy> getListByQuery(Allergy query) throws Exception {
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
	public boolean save(Allergy entity) throws Exception {
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
	public boolean update(Allergy entity) throws Exception {
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
	public Allergy getById(String id) throws Exception {
		Allergy query = new Allergy();
		query.setId(id);
		// 查询对象
		List<Allergy> list = dao.findListByQuery(query);
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
	public Allergy getByCode(String code) throws Exception {
		Allergy query = new Allergy();
		query.setCode(code);
		// 查询对象
		List<Allergy> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
