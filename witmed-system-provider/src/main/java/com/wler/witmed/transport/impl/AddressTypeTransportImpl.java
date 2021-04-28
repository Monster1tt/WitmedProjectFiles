package com.wler.witmed.transport.impl;

import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.base.pojo.vo.QueryVO;
import com.wler.witmed.pojo.system.entity.AddressType;
import com.wler.witmed.service.AddressTypeService;
import com.wler.witmed.transport.system.AddressTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>系统功能-地址类型传输层实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("addressTypeTransport")
@RequestMapping("/system/addressType/trans")
public class AddressTypeTransportImpl implements AddressTypeTransport {
	@Autowired
	private AddressTypeService service;

	/**
	 * <b>分页查询</b>
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<AddressType> getPageByQuery(@RequestBody QueryVO<AddressType> queryVO) throws Exception {
		// 通过 QueryVO 获得查询对象和 PageVO
		AddressType addressType = queryVO.getQuery();
		PageVO<AddressType> pageVO = queryVO.getPageVO();
		return service.getPageByQuery(addressType, pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public List<AddressType> getListByQuery(@RequestBody AddressType query) throws Exception {
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
	public boolean save(@RequestBody AddressType entity) throws Exception {
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
	public boolean update(@RequestBody AddressType entity) throws Exception {
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
	public AddressType getById(@RequestParam String id) throws Exception {
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
	public AddressType getByCode(@RequestParam String code) throws Exception {
		return service.getByCode(code);
	}
}
