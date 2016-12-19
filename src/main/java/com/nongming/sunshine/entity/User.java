package com.nongming.sunshine.entity;
/**
 * 用户类
 * @author Administrator
 *
 */
public class User {
	private int userId;//用户Id
	private String userName;//用户名称：用于实名认证
	private String userNikeName;//用户昵称：常规使用
	private String password;//登录密码
	private int userType;//用户类型：0管理员
	private String payPassword;//支付密码
	private int level;//用户等级
	private int integral;//积分
	private String telephone;//手机号
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNikeName() {
		return userNikeName;
	}
	public void setUserNikeName(String userNikeName) {
		this.userNikeName = userNikeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
