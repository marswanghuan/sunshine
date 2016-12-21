package com.nongming.sunshine.entity;

public class User {
	private int id;//用户id
	private String email;//邮箱
	private String password;//用户密码
	private String webName;//网站名称
	private String website;//网站网址
	private int herolist;//0党政机关、1商业、2制造业、3服务业、4农业牧渔也、5其它行业
	private int huge;//1企业、0个人
	private String name;//名称（企业写企业名称，个人写个人姓名）
	private String contacts;//联系人名称
	private String idcard;//身份证，如果是企业的话是营业执照licence
	private String address;//联系地址
	private String phone;//手机号码
	private String qq;//用户QQ号码
	private String time;//注册时间
	private int iflogin;//是否登录(1、登录2、未登录)
	private int iflock;//是否锁定(1、正常，2、锁定)
	private int ifnet;//是否开通网银（1、开通，2、未开通）
	private String paymentLink;//
	private int ifinterface;//是否锁定(1、开通，2、未开通)
	private String shenhetime;//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getHerolist() {
		return herolist;
	}
	public void setHerolist(int herolist) {
		this.herolist = herolist;
	}
	public int getHuge() {
		return huge;
	}
	public void setHuge(int huge) {
		this.huge = huge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIflogin() {
		return iflogin;
	}
	public void setIflogin(int iflogin) {
		this.iflogin = iflogin;
	}
	public int getIflock() {
		return iflock;
	}
	public void setIflock(int iflock) {
		this.iflock = iflock;
	}
	public int getIfnet() {
		return ifnet;
	}
	public void setIfnet(int ifnet) {
		this.ifnet = ifnet;
	}
	public String getPaymentLink() {
		return paymentLink;
	}
	public void setPaymentLink(String paymentLink) {
		this.paymentLink = paymentLink;
	}
	public int getIfinterface() {
		return ifinterface;
	}
	public void setIfinterface(int ifinterface) {
		this.ifinterface = ifinterface;
	}
	public String getShenhetime() {
		return shenhetime;
	}
	public void setShenhetime(String shenhetime) {
		this.shenhetime = shenhetime;
	}
	
	
}
