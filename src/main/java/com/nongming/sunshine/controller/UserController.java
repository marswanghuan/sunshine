package com.nongming.sunshine.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nongming.sunshine.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 初始化
	 */
	public void index() {
		try {
			User per = getSessionAttr("session");
			List<Logrecord> logs = UserService.userService.getLogrecords(per
					.getInt("id"));
			setAttr("logs", logs);
			setAttr("balance", UserService.userService.getBalance(per.getInt("id"))
					.get(0));
			setAttr("rate", UserService.userService.getRate(per.getInt("id"))
					.get(0));
			setAttr("payment", UserService.userService.getPaymList(per.getInt("id")).get(0));
			setAttr("ordercount", UserService.userService.getOrdersCount());
			setAttr("cardordercount", UserService.userService.getCardOrdersCount());
			setAttr("circlipcount", UserService.userService.getCirclipCount());
			setAttr("rechargecount", UserService.userService.getRechargeCount());
			
			 MerchantCertificate imagePath= MerchantCertificate.dao.findById(per.getInt("id"));
			 if(imagePath!=null){

			 setAttr("cardid1", imagePath.get("cardid1")!=null?imagePath.get("cardid1"):"");
			 setAttr("cardid2", imagePath.get("cardid2")!=null?imagePath.get("cardid2"):"");
			 setAttr("banknum", imagePath.get("banknum")!=null?imagePath.get("banknum"):"");
			 setAttr("businesslicense1", imagePath.get("businesslicense1")!=null?imagePath.get("businesslicense1"):"");
			 setAttr("businesslicense2", imagePath.get("businesslicense2")!=null?imagePath.get("businesslicense2"):"");
			 setAttr("taxregistrationcertificate", imagePath.get("taxregistrationcertificate")!=null?imagePath.get("taxregistrationcertificate"):"");
			 setAttr("organizationcodecertificate", imagePath.get("organizationcodecertificate")!=null?imagePath.get("organizationcodecertificate"):"");
			 }else {
				 setAttr("cardid1","");
				 setAttr("cardid2","");
				 setAttr("banknum","");
				 setAttr("businesslicense1","");
				 setAttr("businesslicense2","");
				 setAttr("taxregistrationcertificate","");
				 setAttr("organizationcodecertificate","");
			}
			renderJsp("/WEB-INF/jsp/user1.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void getannouncement(){
		int pageNum = getParaToInt("pageNum");
		Page<Dynamic> dynamicPage = DynamicService.service.getDynamicPage(pageNum, 10);
		setAttr("pageNum", dynamicPage.getPageNumber());
		setAttr("totalpage", dynamicPage.getTotalPage());
		setAttr("dynamiclist", dynamicPage.getList());
		renderJsp("/WEB-INF/jsp/announcement.jsp");
	}
	
	public void getHelp(){
		renderJsp("/WEB-INF/jsp/help.jsp");
	}
	
	public void getAbout(){
		renderJsp("/WEB-INF/jsp/about.jsp");
	}

	/**
	 * 证件上传
	 */
	public void verifyfileUpload(){
		 String uploadFile = "";
	     String path = UserController.class.getResource("").toString();;
	     uploadFile = path.replace("file:/","");
	     uploadFile = uploadFile.substring(0,uploadFile.indexOf("WEB-INF"))+"verify/";
		 SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHHmmss"); 
		 Date cDate = new Date();	
		 String cfileDate = myFmt.format(cDate);
		
		 int maxpost = 30*1024*1024;
		 
		 try {

			 Person per = getSessionAttr("session");
			  
			 //身份证正面
			 String cardid1 = per.getStr("email")+"_"+"cardid1"+cfileDate+".jpg";
			 String filepath1 = uploadFile+ cardid1;
			 File cardid1Name = new File(filepath1);
			 UploadFile  cardid1path1 = getFile("filecridid1", uploadFile,maxpost);
			 cardid1path1.getFile().renameTo(cardid1Name);
			 
			 
			 //身份证反面 
			 String cardid2 = per.getStr("email")+"_"+"cardid2"+cfileDate+".jpg";
			 String filepath2 = uploadFile+ cardid2;
			 File cardid2Name = new File(filepath2);
			 UploadFile  cardid1path2 = getFile("filecridid2", uploadFile,maxpost);
			 cardid1path2.getFile().renameTo(cardid2Name);
			 
			 //银行卡正面
			 String cardid3 = per.getStr("email")+"_"+"cardid3"+cfileDate+".jpg";
			 String filepath3 = uploadFile+ cardid3;
			 File cardid3Name = new File(filepath3);
			 UploadFile  cardid1path3 = getFile("filecridid3", uploadFile,maxpost);
			 cardid1path3.getFile().renameTo(cardid3Name);
			 
			 MerchantCertificate isExist= MerchantCertificate.dao.findById(per.getInt("id"));
			 String dbcardid1 = "verify/"+cardid1;
			 String dbcardid2 = "verify/"+cardid2;
			 String dbcardid3 = "verify/"+cardid3;
			 String dbcardid4 = "";
			 String dbcardid5 = "";
			 String dbcardid6 = "";
			 String dbcardid7 = "";
			 
             //企业
			 if(per.getInt("huge") == 1){
				 
			 //营业执照(正本)
			 String cardid4 = per.getStr("email")+"_"+"cardid4"+cfileDate+".jpg";
			 String filepath4 = uploadFile+ cardid4;
			 File cardid4Name = new File(filepath4);
			 UploadFile  cardid1path4 = getFile("filecridid4", uploadFile,maxpost);
			 cardid1path4.getFile().renameTo(cardid4Name);
			 
			 //营业执照(副本)
			 String cardid5 = per.getStr("email")+"_"+"cardid5"+cfileDate+".jpg";
			 String filepath5 = uploadFile+ cardid5;
			 File cardid5Name = new File(filepath5);
			 UploadFile  cardid1path5 = getFile("filecridid5", uploadFile,maxpost);
			 cardid1path5.getFile().renameTo(cardid5Name);
			 
			 //税务登记证
			 String cardid6 = per.getStr("email")+"_"+"cardid6"+cfileDate+".jpg";
			 String filepath6 = uploadFile+ cardid6;
			 File cardid6Name = new File(filepath6);
			 UploadFile  cardid1path6 = getFile("filecridid6", uploadFile,maxpost);
			 cardid1path6.getFile().renameTo(cardid6Name);
			 
			 //组织机构代码证
			 String cardid7 = per.getStr("email")+"_"+"cardid7"+cfileDate+".jpg";
			 String filepath7 = uploadFile+ cardid7;
			 File cardid7Name = new File(filepath7);
			 UploadFile  cardid1path7 = getFile("filecridid7", uploadFile,maxpost);
			 cardid1path7.getFile().renameTo(cardid7Name);
			 
			 dbcardid4 = "verify/"+cardid4;
			 dbcardid5 = "verify/"+cardid5;
			 dbcardid6 = "verify/"+cardid6;
			 dbcardid7 = "verify/"+cardid7;

			 if(isExist!=null){
				 MerchantCertificate.dao.findById(per.getInt("id")).set("cardid1",dbcardid1).set("cardid2", dbcardid2)
				 .set("banknum", dbcardid3).set("businesslicense1", dbcardid4).set("businesslicense2", dbcardid5)
				 .set("taxregistrationcertificate", dbcardid6).set("organizationcodecertificate", dbcardid7).update();
			 }else{
				 MerchantCertificate merchantCertificate = new MerchantCertificate();
				 merchantCertificate.set("per_id", per.getInt("id"));
				 merchantCertificate.set("cardid1", dbcardid1);
				 merchantCertificate.set("cardid2", dbcardid2);
				 merchantCertificate.set("banknum", dbcardid3);
				 merchantCertificate.set("businesslicense1", dbcardid4);
				 merchantCertificate.set("businesslicense2", dbcardid5);
				 merchantCertificate.set("taxregistrationcertificate", dbcardid6);
				 merchantCertificate.set("organizationcodecertificate", dbcardid7);
				 merchantCertificate.save();
			 }

			 }else{
				 if(isExist!=null){
					 MerchantCertificate.dao.findById(per.getInt("id")).set("cardid1",dbcardid1).set("cardid2", dbcardid2)
					 .set("banknum", dbcardid3).update();
				 }else{
					 MerchantCertificate merchantCertificate = new MerchantCertificate();
					 merchantCertificate.set("per_id", per.getInt("id"));
					 merchantCertificate.set("cardid1", dbcardid1);
					 merchantCertificate.set("cardid2", dbcardid2);
					 merchantCertificate.set("banknum", dbcardid3);
					 merchantCertificate.save(); 
				 }
			 }
			 
			 
			 MerchantCertificate imagePath= MerchantCertificate.dao.findById(per.getInt("id"));
			 if(imagePath!=null){
			 setAttr("cardid1", imagePath.get("cardid1")!=null?imagePath.get("cardid1"):"");
			 setAttr("cardid2", imagePath.get("cardid2")!=null?imagePath.get("cardid2"):"");
			 setAttr("banknum", imagePath.get("banknum")!=null?imagePath.get("banknum"):"");
			 setAttr("businesslicense1", imagePath.get("businesslicense1")!=null?imagePath.get("businesslicense1"):"");
			 setAttr("businesslicense2", imagePath.get("businesslicense2")!=null?imagePath.get("businesslicense2"):"");
			 setAttr("taxregistrationcertificate", imagePath.get("taxregistrationcertificate")!=null?imagePath.get("taxregistrationcertificate"):"");
			 setAttr("organizationcodecertificate", imagePath.get("organizationcodecertificate")!=null?imagePath.get("organizationcodecertificate"):"");
			 }else {
				 setAttr("cardid1","");
				 setAttr("cardid2","");
				 setAttr("banknum","");
				 setAttr("businesslicense1","");
				 setAttr("businesslicense2","");
				 setAttr("taxregistrationcertificate","");
				 setAttr("organizationcodecertificate","");
			}
			 
			 setAttr("messages","提交成功,请耐心等待审核");
			 renderJsp("/WEB-INF/examineok.jsp");
			 
		} catch (Exception e) {
			//renderJson("{\"info\":\"提交失败！\",\"status\":\"n\"}");
			 setAttr("messages","提交失败,可能是文件过大，单个文件不超过20M.");
			 renderJsp("/WEB-INF/examineok.jsp");
			e.printStackTrace();
		} 
	}

	/**
	 * 获取短信
	 */
	@Before(SmsInterceptor.class)
	public void getSms() {
		Person person = getSessionAttr("session");
		String phone = person.getStr("phone");
		String key = CryptTool.getPassword(6);
		String content = "您的验证码是：【"+key+"】。请不要把验证码泄露给其他人。如非本人操作，可不用理会！";
		try {
			String res = Yunsms.sms(phone, content);
			if (res.equals("100")) {
				setSessionAttr("sms", key);
				renderText(res);
			} else {
				renderText("短信获取失败，请联系工作人眼");
			}
		} catch (Exception e) {
			renderText("短信获取失败，请联系工作人眼");
			e.printStackTrace();
		}
	}
	
	/**
	 * 更改新手机时，获取新短信
	 */
	@Before(SmsInterceptor.class)
	public void getNewSms(){
		String newphone = getPara("newphone");
		String key = CryptTool.getPassword(6);
		String content = "您的验证码是：【"+key+"】。请不要把验证码泄露给其他人。如非本人操作，可不用理会！";
		try {
			String res = Yunsms.sms(newphone, content);
			if (res.equals("100")) {
				setSessionAttr("newsms", key);
				renderText(res);
			} else {
				renderText("短信获取失败，请联系工作人眼");
			}
		} catch (Exception e) {
			renderText("短信获取失败，请联系工作人眼");
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证新手机短信
	 */
	public void newPhoneSms(){
		String keys = getPara("param");
		String key = getSessionAttr("newsms");
		if(keys.equals(key)){
			renderText("y");
		}else {
			renderText("验证码错误");
		}
	}

	/**
	 * 判断原支付密码是否正确
	 */
	public void getPaymentboo() {
		String paypassw = getPara("param");
		Person person = getSessionAttr("session");
		String payment = "";
		try {
			payment = MD5Utils.createMD5(MD5Utils.createMD5(paypassw));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo = UserService.userService.getPaymentboo(
				person.getInt("id"), payment);
		if (boo) {
			renderText("y");
		} else {
			renderText("原支付密码错误!");
		}
	}

	/**
	 * 判断原密码是否正确
	 */
	public void getPasswordboo() {
		String paword = getPara("param");
		Person person = getSessionAttr("session");
		String password = "";
		try {
			password = MD5Utils.createMD5(paword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo = UserService.userService.getPasswordboo(
				person.getInt("id"), password);
		if (boo) {
			renderText("y");
		} else {
			renderText("原密码错误!");
		}
	}

	/**
	 * 更换支付和登陆密码
	 */
	@Before(UpdateInterceptor.class)
	public void upPassword() {
		String passwtype = getPara("passwtype");
		Person person = getSessionAttr("session");
		try {
			if (passwtype.equals("1")) {
				String password = getPara("password");
				password = MD5Utils.createMD5(password);
				Person.dao.findById(person.getInt("id")).set("password", password).update();
				renderJson("{\"info\":\"更改成功！\",\"status\":\"y\"}");
			}else if(passwtype.equals("2")){
				String payment = getPara("payment");
				payment = MD5Utils.createMD5(MD5Utils.createMD5(payment));
				Payment.dao.find("UPDATE payment SET payment = '"+payment+"' WHERE id="+person.getInt("id"));
				renderJson("{\"info\":\"更改成功！\",\"status\":\"y\"}");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			renderJson("{\"info\":\"更改失败！\",\"status\":\"n\"}");
			e.printStackTrace();
		}
	}
	
	/**
	 * 更换手机号
	 */
	@Before(UpdateInterceptor.class)
	public void upPhone(){
		try {
			String newphone = getPara("newphone");
			Person person = getSessionAttr("session");
			Person.dao.findById(person.get("id")).set("phone", newphone).update();
			renderJson("{\"info\":\"更改成功！\",\"status\":\"y\"}");
		} catch (Exception e) {
			// TODO: handle exception
			renderJson("{\"info\":\"更改失败！\",\"status\":\"n\"}");
			e.printStackTrace();
		}
	}
	
	/**
	 * 更换key值
	 */
	@Before(UpdateInterceptor.class)
	public void upKey(){
		try {
			String key = CryptTool.getPassword(32);
			Person person = getSessionAttr("session");
			Payment pay = Payment.dao.findById(person.getInt("id"));
			pay.set("key", key);
			pay.update();
			renderJson("{\"info\":\"更改成功！\",\"status\":\"y\"}");
		} catch (Exception e) {
			// TODO: handle exception
			renderJson("{\"info\":\"更改失败！\",\"status\":\"n\"}");
			e.printStackTrace();
		}
	}
}
