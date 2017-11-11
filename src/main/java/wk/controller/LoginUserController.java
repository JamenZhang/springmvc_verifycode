package wk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wk.model.LoginUser;
import wk.service.LoginUserService;
/**
 * 登陆controller
 * @author WangKun
 * 
 */
@Controller
public class LoginUserController {
	@Autowired
	//会去找LoginUserService的实现类，这里只有一个LoginUserService实现类就是LoginUserServiceImpl.java
	private LoginUserService loginUserservice;
	
	  /**
	   * 用户登陆方法(涉及到用户信息必须POST方法)
	   * @param username
	   * @param password
	   * @param model
	   * @return
	   */
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public String login(String username, String password,Model model,HttpServletRequest request){
		  
		  System.out.println("username:"+username);
		  System.out.println("password:"+password);
		  
		  
		 HttpSession session = request.getSession(true);
		 String checkCode = (String) session.getAttribute("verCode");
		 //验证码
		 String paramsCheckCode = request.getParameter("checkCode").trim();
		 System.out.println("verifydode:"+checkCode);
		
		 LoginUser user = null;
		 try{
			  user = loginUserservice.getLoginUser(username, password);
		  } catch(RuntimeException e){
			  
		  }
		 
		 if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
	        System.out.println("check code ok");	            
	       // request.setAttribute("success_1", "尊敬的admin用户，您的密码为：123456 <br/>验证码 OK");			 
	        if(user!=null) {
				  model.addAttribute("username", user.getUsername());
				  return "Main";
			  } else {
				  model.addAttribute("message","用户名或密码错误请重新登录！");
				  return "Login"; 
			  }	       
		  } else {			  
			  System.out.println("check code not ok");
			  model.addAttribute("message","验证码错误请重新登录！");
	        //request.setAttribute("success_1", "尊敬的admin用户，您的密码为：123456 <br/>验证码 not OK");
			  return "Login";
		  }
		
		 
		
	  }
}
