package com.wler.witmed.base.pojo.vo;

import com.wler.witmed.util.Constants;

import java.io.Serializable;
import java.util.List;

/**
 * <b>智慧医疗系统分页视图信息</b>
 *
 * @param <E>
 * @author Monster
 * @version 1.0.0
 */
public class PageVO<E> implements Serializable {
	private static final long serialVersionUID = -322993148391493219L;
	private Integer pageNum;                    // 当前页码
	private Integer pageSize;                   // 每页显示数量
	private List<E> list;                       // 分页列表
	private Long totalCount;                    // 总条数
	private Long totalSize;                     // 总页数

	public PageVO() {
	}

	public PageVO(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = Constants.PAGE_NUM;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = Constants.PAGE_SIZE;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
}
