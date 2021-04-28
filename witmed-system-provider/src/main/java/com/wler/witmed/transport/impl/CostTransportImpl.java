package com.wler.witmed.transport.impl;

import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.base.pojo.vo.QueryVO;
import com.wler.witmed.pojo.system.entity.Cost;
import com.wler.witmed.service.CostService;
import com.wler.witmed.transport.system.CostTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能-费用类别传输层实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("costTransport")
@RequestMapping("/system/cost/trans")
public class CostTransportImpl implements CostTransport {
	@Autowired
	private CostService service;

	/**
	 * <b>分页查询</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<Cost> getPageByQuery(@RequestBody QueryVO<Cost> queryVO) throws Exception {
		// 通过 QueryVO 获得查询对象和 PageVO
		Cost cost = queryVO.getQuery();
		PageVO<Cost> pageVO = queryVO.getPageVO();
		return service.getPageByQuery(cost, pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<Cost> getListByQuery(@RequestBody Cost query) throws Exception {
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
	public boolean save(@RequestBody Cost entity) throws Exception {
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
	public boolean update(@RequestBody Cost entity) throws Exception {
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
	public Cost getById(@RequestParam String id) throws Exception {
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
	public Cost getByCode(@RequestParam String code) throws Exception {
		return service.getByCode(code);
	}
}
