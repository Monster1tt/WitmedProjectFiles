package com.wler.witmed.transport.impl;

import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.base.pojo.vo.QueryVO;
import com.wler.witmed.pojo.system.entity.BooldType;
import com.wler.witmed.service.BooldTypeService;
import com.wler.witmed.transport.system.BooldTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能-血型传输层实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("booldTypeTransport")
@RequestMapping("/system/booldType/trans")
public class BooldTypeTransportImpl implements BooldTypeTransport {
	@Autowired
	private BooldTypeService service;

	/**
	 * <b>分页查询</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<BooldType> getPageByQuery(@RequestBody QueryVO<BooldType> queryVO) throws Exception {
		// 通过 QueryVO 获得查询对象和 PageVO
		BooldType booldType = queryVO.getQuery();
		PageVO<BooldType> pageVO = queryVO.getPageVO();
		return service.getPageByQuery(booldType, pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<BooldType> getListByQuery(@RequestBody BooldType query) throws Exception {
		return service.getListByQuery(query);
	}

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean save(@RequestBody BooldType entity) throws Exception {
		return service.save(entity);
	}

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody BooldType entity) throws Exception {
		return service.update(entity);
	}

	/**
	 * <b>根据 ID 查询对象</b>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public BooldType getById(@RequestParam String id) throws Exception {
		return service.getById(id);
	}

	/**
	 * <b>根据编码查询对象</b>
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public BooldType getByCode(@RequestParam String code) throws Exception {
		return service.getByCode(code);
	}
}
