package wk.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import wk.dao.LoginUserDao;
import wk.model.LoginUser;
/**
 * 登陆用户信息操作数据库
 * @author Zhang JunMin
 *
 */
@Repository
public class LoginUserDaoImpl implements LoginUserDao {

	@Autowired
	//会去找JdbcTemplate的实现类，这里只有一个JdbcTemplate实现类就是JdbcTemplateImpl.java
	private JdbcTemplate jdbcTemplate;

	@Override
	public LoginUser getLoginUser(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM login_user WHERE username=? AND password=?";
		final LoginUser loginUser = new LoginUser();
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, username, password);
		jdbcTemplate.query(sql, new Object[] { username, password },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						loginUser.setUsername(rs.getString("username"));
						loginUser.setPassword(rs.getString("password"));
					}
				});
		if (list.size() == 0) {
			return null;
		}
		return loginUser;
	}
}
