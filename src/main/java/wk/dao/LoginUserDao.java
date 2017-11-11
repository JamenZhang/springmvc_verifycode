package wk.dao;

import wk.model.LoginUser;

/**
 * 用户登陆dao
 * @author WangKun
 *
 */
public interface LoginUserDao {
	/**
	 * 获取登陆用户的用户名和密码用来与数据库中的数据进行对比
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginUser getLoginUser(String username,String password);

}
