package wk.service;

import wk.model.LoginUser;
/**
 * 用户登陆service
 * @author Zhang JunMin
 *
 */
public interface LoginUserService {
	/**
	 * 获取登陆用户名和密码
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginUser getLoginUser(String username,String password);
	
}
