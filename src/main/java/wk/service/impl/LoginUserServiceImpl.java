package wk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wk.dao.LoginUserDao;
import wk.model.LoginUser;
import wk.service.LoginUserService;
/**
 * 用户信息数据处理层
 * @author Zhang JunMin
 *
 */
@Service
//声明LoginUserServiceImpl.java是一个bean，这点很重要，因为LoginUserServiceImpl.java是一个bean，
//其他的类才可以使用@Autowired将LoginUserServiceImpl作为一个成员变量自动注入
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	//会去找LoginUserDao的实现类，这里只有一个LoginUserDao实现类就是LoginUserDaoImpl.java
	private LoginUserDao loginUserDao;

	/**
	 * 用户信息service
	 */
	@Override
	public LoginUser getLoginUser(String username, String password) {
		
		LoginUser loginUser = loginUserDao.getLoginUser(username, password);
		return loginUser;
	}

}
