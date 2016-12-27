package com.nongming.sunshine.api;

/**
 * 参数代码
 * 
 * @author hbn
 * 
 */
public class ParameterCode {

	/**
	 * 成功
	 */
	public static int SUCCESS = 0;

	public static final class Error {
		// ============接口公共错误编码==============
		/**
		 * 接口-消息编码不存在
		 */
		public static final int SERVICE_METHOD_CODE = -1;
		/**
		 * 接口-参数错误
		 */
		public static final int SERVICE_PARAMETER = -2;

		/**
		 * 接口-服务器解密失败
		 */
		public static final int SERVICE_DECRYPT = -3;
		/**
		 * 接口-服务器业务处理错误
		 */
		public static final int SERVICE_RESOLVE = -4;
		/**
		 * 接口-服务器无效的请求
		 */
		public static final int SERVICE_INVALID = -5;
		/**
		 * 接口-服务器请求被拒绝
		 */
		public static final int SERVICE_REFUSE = -6;
		/**
		 * 接口-服务器未知错误
		 */
		public static final int SERVICE_UNKNOWN = -7;
		/**
		 * 接口-服务器会话过期
		 */
		public static final int SERVICE_SESSION = -8;
		/**
		 * 接口-签名secretId错误
		 */
		public static final int SERVICE_SIGN_KEY = -9;
		/**
		 * 接口-签名失败
		 */
		public static final int SERVICE_SIGN_FAIL = -10;
		/**
		 * 接口-sysid无效
		 */
		public static final int SERVICE_SYSID_INVALID = -11;
		/**
		 * 接口-版本无效
		 */
		public static final int SERVICE_VERSION_INVALID = -12;
		
		// ============接口业务错误编码==============
		/**
		 * 账号注册-账号已经存在
		 */
		public static final int ACCOUNT_REGISTER_EXIST = -101;
		/**
		 * 账号注册-账号注册失败
		 */
		public static final int ACCOUNT_REGISTER_FAIL = -102;
		/**
		 * 账号登录-验证失败
		 */
		public static final int ACCOUNT_LOGIN_VALIDATE = -103;
		/**
		 * 账号登录-账号禁用
		 */
		public static final int ACCOUNT_DISABLE = -104;
		/**
		 * 账号不存在
		 */
		public static final int ACCOUNT_NOTFOUND = -105;
		/**
		 * 订单-获取统一下单号失败
		 */
		public static final int ORDER_TO_PAY = -106;
		/**
		 * 用户未购买
		 */
		public static final int USER_TO_PAY = -107;
		/**
		 * 没有该问题
		 */
		public static final int NO_QUESTION = -108;
		/**
		 * 账号注册-邮箱已经存在
		 */
		public static final int ACCOUNT_EMAIL_EXIST = -109;
	}
}
