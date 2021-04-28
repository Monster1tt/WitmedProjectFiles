package com.wler.witmed.transport.impl;

import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.base.pojo.vo.QueryVO;
import com.wler.witmed.pojo.system.entity.RiskType;
import com.wler.witmed.service.RiskTypeService;
import com.wler.witmed.transport.system.RiskTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能-个体危险类型传输层实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("riskTypeTransport")
@RequestMapping("/system/riskType/trans")
public class RiskTypeTransportImpl implements RiskTypeTransport {
	@Autowired
	private RiskTypeService service;

	/**
	 * <b>分页查询</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<RiskType> getPageByQuery(@RequestBody QueryVO<RiskType> queryVO) throws Exception {
		// 通过 QueryVO 获得查询对象和 PageVO
		RiskType riskType = queryVO.getQuery();
		PageVO<RiskType> pageVO = queryVO.getPageVO();
		return service.getPageByQuery(riskType, pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<RiskType> getListByQuery(@RequestBody RiskType query) throws Exception {
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
	public boolean save(@RequestBody RiskType entity) throws Exception {
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
	public boolean update(@RequestBody RiskType entity) throws Exception {
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
	public RiskType getById(@RequestParam String id) throws Exception {
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
	public RiskType getByCode(@RequestParam String code) throws Exception {
		return service.getByCode(code);
	}
}
