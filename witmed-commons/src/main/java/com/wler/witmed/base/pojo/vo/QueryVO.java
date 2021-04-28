package com.wler.witmed.base.pojo.vo;

import com.wler.witmed.pojo.system.entity.IdType;

import java.io.Serializable;

/**
 * <b>系统查询视图信息</b>
 *
 * @param <E>
 * @author Monster
 * @version 1.0.0
 */
public class QueryVO<E> implements Serializable {
	private static final long serialVersionUID = 9141990797075326801L;
	private E query;
	PageVO<E> pageVO;

	public E getQuery() {
		return query;
	}

	public void setQuery(E query) {
		this.query = query;
	}

	public PageVO<E> getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO<E> pageVO) {
		this.pageVO = pageVO;
	}
}
