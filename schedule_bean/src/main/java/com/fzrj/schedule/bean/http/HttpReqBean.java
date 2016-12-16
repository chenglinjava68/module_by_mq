package com.fzrj.schedule.bean.http;

import java.util.Map;

import com.fzrj.schedule.constant.HttpConstant;

/**
 * @className:com.fzrj.schedule.bean.http.HttpReqBean
 * @description:Http请求bean
 * @version:v1.0.0
 * @date:2016年11月23日 下午2:51:16
 * @author:WangHao
 */
public class HttpReqBean
{
	/**
	 * 请求url
	 */
	private String reqUrl;

	/**
	 * 请求头
	 */
	private Map<String, String> headMap;

	public HttpReqBean(String reqUrl, Map<String, String> head)
	{
		super();
		this.reqUrl = reqUrl;
		this.headMap = head;
	}

	/**
	 * 默认POST请求
	 */
	private String reqMethod = HttpConstant.METHOD.POST;

	/**
	 * 默认JSON格式请求
	 */
	private String reqFormat = HttpConstant.FORMAT.JSON;

	/**
	 * 请求体
	 */
	private String reqBody = "";

	public String getReqUrl()
	{
		return reqUrl;
	}

	public void setReqUrl(String reqUrl)
	{
		this.reqUrl = reqUrl;
	}

	public String getReqMethod()
	{
		return reqMethod;
	}

	public void setReqMethod(String reqMethod)
	{
		this.reqMethod = reqMethod;
	}

	public String getReqFormat()
	{
		return reqFormat;
	}

	public void setReqFormat(String reqFormat)
	{
		this.reqFormat = reqFormat;
	}

	public String getReqBody()
	{
		return reqBody;
	}

	public void setReqBody(String reqBody)
	{
		this.reqBody = reqBody;
	}

	public Map<String, String> getHeadMap()
	{
		return headMap;
	}

	public void setHeadMap(Map<String, String> headMap)
	{
		this.headMap = headMap;
	}

	@Override
	public String toString()
	{
		return "HttpReqBean [reqUrl=" + reqUrl + ", headMap=" + headMap + ", reqMethod=" + reqMethod + ", reqFormat="
				+ reqFormat + ", reqBody=" + reqBody + "]";
	}
}
