package wk.model;

import java.io.Serializable;

/**
 * 登陆用户model
 * @author WangKun
 *
 */
public class LoginUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String username; 
	
	/**
	 * 密码
	 */
	private String password;  
	
	public LoginUser() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginUser(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
