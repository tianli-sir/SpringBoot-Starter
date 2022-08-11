package com.tianlisir.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *   接口返回数据格式
 * @author scott
 * @email Another
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	@ApiModelProperty(value = "成功标志")
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "返回处理消息")
	private String message = "操作成功！";

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer code = 0;
	
	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "返回数据对象")
	private T result;
	
	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private long timestamp = System.currentTimeMillis();

	public Result() {
		
	}
//	/**
//	 * 成功构造器,无返回数据
//	 */
//	private Result() {
//		this(ResultCode.SUCCESS);
//	}

	/**
	 * 成功构造器,自定义返回数据
	 *
	 * @param data 返回数据
	 */
	private Result(T data) {
		this(ResultCode.SUCCESS, data);
	}

	/**
	 * 成功构造器,自定义返回消息,无返回数据
	 *
	 * @param msg 返回消息
	 */
	private Result(String msg) {
		this(ResultCode.SUCCESS.getCode(), msg);
	}

	/**
	 * 成功构造器,自定义返回信息,返回数据
	 *
	 * @param msg  返回信息
	 * @param data 返回数据
	 */
	private Result(String msg, T data) {
		this(ResultCode.SUCCESS.getCode(), msg, data);
	}

	/**
	 * 构造器,自定义状态码,返回消息
	 *
	 * @param code 状态码
	 * @param msg  返回消息
	 */
	private Result(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	/**
	 * 构造器,自定义状态码,返回消息,返回数据
	 *
	 * @param code 状态码
	 * @param msg  返回消息
	 * @param data 返回数据
	 */
	private Result(int code, String msg, T data) {
		this(code, msg);
		this.result = data;
	}

	/**
	 * 构造器,使用CodeMsg状态码与返回信息
	 *
	 * @param resultCode CodeMsg,参数如下:
	 *                   <p> code 状态码
	 *                   <p> msg  返回消息
	 */
	private Result(ResultCode resultCode) {
		this(resultCode.getCode(), resultCode.getMsg());
	}

	/**
	 * 构造器,使用CodeMsg状态码与返回信息,自定义返回数据
	 *
	 * @param resultCode CodeMsg,参数如下:
	 *                   <p> code 状态码
	 *                   <p> msg  返回消息
	 * @param data       返回数据
	 */
	private Result(ResultCode resultCode, T data) {
		this(resultCode);
		this.result = data;
	}
	
	public Result<T> success(String message) {
		this.message = message;
		this.code = CommonConstant.SC_OK_200;
		this.success = true;
		return this;
	}

	@Deprecated
	public static Result<Object> ok() {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage("成功");
		return r;
	}

	@Deprecated
	public static Result<Object> ok(String msg) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(msg);
		return r;
	}

	@Deprecated
	public static Result<Object> ok(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> OK() {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage("成功");
		return r;
	}

	public static<T> Result<T> OK(T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> OK(String msg, T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}
	
	public static Result<Object> error(String msg) {
		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
	}
	/**
	 * 失败,使用CodeMsg状态码,返回消息,无返回数据
	 *
	 * @param resultCode CodeMsg,参数如下:
	 *                   <p> code 状态码
	 *                   <p> msg  返回消息
	 * @param <T>        返回类泛型
	 * @return 通用返回Result
	 */
	public static <T> Result<T> error(ResultCode resultCode) {
		return new Result<>(resultCode);
	}


	public static Result<Object> error(int code, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}

	public Result<T> error500(String message) {
		this.message = message;
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
		return this;
	}
	/**
	 * 无权限访问返回结果
	 */
	public static Result<Object> noauth(String msg) {
		return error(CommonConstant.SC_JEECG_NO_AUTHZ, msg);
	}

	@JsonIgnore
	private String onlTable;

}