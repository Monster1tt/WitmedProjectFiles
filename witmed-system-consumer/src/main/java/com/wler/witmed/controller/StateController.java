package com.wler.witmed.controller;

import com.wler.witmed.base.controller.BaseController;
import com.wler.witmed.base.pojo.vo.PageVO;
import com.wler.witmed.base.pojo.vo.QueryVO;
import com.wler.witmed.base.pojo.vo.ResponseVO;
import com.wler.witmed.pojo.system.entity.State;
import com.wler.witmed.transport.system.StateTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能-国籍控制层类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("stateController")
@RequestMapping("/system/state")
public class StateController extends BaseController {
	@Autowired
	private StateTransport transport;

	/**
	 * <b>分页查询</b>
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO getPageByQuery(@PathVariable("pageNum") Integer pageNum,
	                                 @PathVariable("pageSize") Integer pageSize,
	                                 @RequestBody State query) throws Exception {
		// 创建 PageVO 对象
		PageVO<State> pageVO = new PageVO<State>(pageNum, pageSize);
		// 创建 QueryVO对象
		QueryVO<State> queryVO = new QueryVO<State>();
		queryVO.setPageVO(pageVO);
		queryVO.setQuery(query);
		// 分页查询
		pageVO = transport.getPageByQuery(queryVO);
		return ResponseVO.getSuccessResponseVO(pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO getListByQuery(@RequestBody State query) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getListByQuery(query));
	}

	/**
	 * <b>保存对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public ResponseVO save(@RequestBody State entity) throws Exception {
		// 获得 Code
		String code = entity.getCode();
		if (code != null && !"".equals(code)) {
			// 校验此时的 Code 是否重复
			State state = transport.getByCode(code);
			if (state == null) {
				//保存对象
				if (transport.save(entity)) {
					return ResponseVO.getSuccessResponseVO("保存成功");
				}
				return ResponseVO.getErrorResponseVO("保存失败");
			}
			return ResponseVO.getErrorResponseVO("该编码已经被占用");
		}
		return ResponseVO.getErrorResponseVO("请填写正确的信息");
	}

	/**
	 * <b>修改对象</b>
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public ResponseVO update(@RequestBody State entity) throws Exception {
		// 获得 Code
		String code = entity.getCode();
		if (code != null && !"".equals(code)) {
			// 此时用户修改 Code ，判断 Code 是否重复
			State state = transport.getByCode(code);
			if (state == null || state.getCode().equals(entity.getCode())) {
				// 值为空 或者 Code 相同 可以修改信息
				if (transport.update(entity)) {
					return ResponseVO.getSuccessResponseVO("修改成功");
				}
				return ResponseVO.getErrorResponseVO("修改失败");
			}
			return ResponseVO.getErrorResponseVO("编码已占用");
		} else {
			// 未修改 Code
			if (transport.update(entity)) {
				return ResponseVO.getSuccessResponseVO();
			}
			return ResponseVO.getErrorResponseVO("修改失败");
		}
	}

	/**
	 * <b>根据 ID 查询对象</b>
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/id/{id}")
	public ResponseVO getById(@PathVariable("id") String id) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getById(id));
	}

	/**
	 * <b>根据编码查询对象</b>
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/code/{code}")
	public ResponseVO getByCode(@PathVariable("code") String code) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getByCode(code));
	}
}