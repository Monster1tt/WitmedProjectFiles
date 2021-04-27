package com.wler.witmed.base.pojo.vo;

import com.wler.witmed.base.pojo.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * <b>系统响应视图信息</b>
 *
 * @param <E>
 * @author Monster
 * @version 1.0.0
 */
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = 9110770012407928715L;
	private Integer code;                   // 系统响应码
	private E data;                         // 系统响应数据

	private ResponseVO(Integer code) {
		this.code = code;
	}

	private ResponseVO(Integer code, E data) {
		this.code = code;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统响应成功视图</b>
	 *
	 * @param data
	 * @return
	 */
	public static ResponseVO getSuccessResponseVO(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS.getCode(), data);
	}

	/**
	 * <b>获得系统业务处理错误视图</b>
	 *
	 * @param data
	 * @return
	 */
	public static ResponseVO getErrorResponseVO(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_ERROR.getCode(), data);
	}

	/**
	 * <b>获得系统业务处理错误视图</b>
	 *
	 * @param responseCodeEnum
	 * @param data
	 * @return
	 */
	public static ResponseVO getErrorResponseVO(ResponseCodeEnum responseCodeEnum, Object data) {
		return new ResponseVO(responseCodeEnum.getCode(), data);
	}

	/**
	 * <b>获得系统响应异常视图</b>
	 *
	 * @param data
	 * @return
	 */
	public static ResponseVO getExceptionResponseVO(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_EXCEPTION.getCode(), data);
	}
}
