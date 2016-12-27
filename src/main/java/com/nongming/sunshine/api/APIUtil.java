package com.nongming.sunshine.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class APIUtil {
	Logger loger = Logger.getLogger(APIUtil.class);

	public String getErrorInfo(int errorCode) {
		String errorInfo = "";
		switch (errorCode) {
		case 0:
			errorInfo = "成功！";
			break;
		case -1:
			errorInfo = "接口不存在！";
			break;
		case -2:
			errorInfo = "参数错误！";
			break;
		case -3:
			errorInfo = "数据为空，或服务器解密失败！";
			break;
		case -4:
			errorInfo = "服务器业务处理错误！";
			break;
		case -5:
			errorInfo = "服务器无效的请求！";
			break;
		case -6:
			errorInfo = "服务器请求被拒绝！";
			break;
		case -7:
			errorInfo = "服务器未知错误！";
			break;
		case -8:
			errorInfo = "服务器会话过期！";
			break;
		case -9:
			errorInfo = "签名secretId错误！";
			break;
		case -10:
			errorInfo = "签名失败！";
			break;
		case -11:
			errorInfo = "sysid无效！";
			break;
		case -12:
			errorInfo = "版本号无效！";
			break;
		case -101:
			errorInfo = "账号已经存在！";
			break;
		case -102:
			errorInfo = "账号注册失败！";
			break;
		case -103:
			errorInfo = "登录验证失败！";
			break;
		case -104:
			errorInfo = "账号已经禁用！";
			break;
		case -105:
			errorInfo = "用户不存在！";
			break;
		case -106:
			errorInfo = "获取统一下单号失败！";
			break;
		case -107:
			errorInfo = "用户未购买！";
			break;
		case -108:
			errorInfo = "没有该问题！";
			break;
		case -109:
			errorInfo = "邮箱已存在！";
			break;
		default:
			errorInfo = "未知错误！";
			break;
		}
		return errorInfo;
	}

}
