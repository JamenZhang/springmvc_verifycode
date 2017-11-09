package wk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wk.dao.LoginUserDao;
import wk.model.LoginUser;
import wk.service.LoginUserService;
/**
 * 用户信息数据处理层
 * @author WangKun
 *
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserDao loginUserDao;

	/**
	 * 用户信息service
	 */
	@Override
	public LoginUser getLoginUser(String username, String password) {
		// TODO Auto-generated method stub
		LoginUser loginUser = loginUserDao.getLoginUser(username, password);
		return loginUser;
	}

}
