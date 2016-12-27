package com.nongming.sunshine.entity;

public class User {
	private int id;//用户id
	private int userId;//用户Id
	private String userName;//用户名称：用于实名认证
	private String userNikeName;//用户昵称：常规使用
	private String password;//登录密码
	private int userType;//用户类型：0管理员
	private String payPassword;//支付密码
	private int level;//用户等级
	private int integral;//积分
	private String telephone;//手机号
	private int ifInterface;//是否锁定(1、开通，2、未开通)
	private int ifNet;//是否开通网银（1、开通，2、未开通）
	private int ifLogin;//是否登录(1、登录2、未登录)
	private String idCard;//身份证，如果是企业的话是营业执照licence
	private String createDate;//创建时间
	private String email;//邮箱
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getIfInterface() {
		return ifInterface;
	}
	public void setIfInterface(int ifInterface) {
		this.ifInterface = ifInterface;
	}
	public int getIfNet() {
		return ifNet;
	}
	public void setIfNet(int ifNet) {
		this.ifNet = ifNet;
	}
	public int getIfLogin() {
		return ifLogin;
	}
	public void setIfLogin(int ifLogin) {
		this.ifLogin = ifLogin;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
