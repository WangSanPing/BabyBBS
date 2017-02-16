package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository // 通过注解定义一个dao
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getMatchCount(String userName, String password) {
		String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
		int count = jdbcTemplate.queryForObject(sqlStr, new Object[] { userName, password }, Integer.class);
		return count;
	}

	public User FindUserByUserName(final String userName) {
		String sqlStr = "select user_id,user_name,credits from t_user where user_name = ?";
		final User user = new User();

		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_Id"));
				user.setUserName(userName);
				user.setCredits(rs.getInt("credits"));
			}
		});
		return user;
	}


	public void updateLoginInfo(User user) {
		String strSql = "update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
		jdbcTemplate.update(strSql,
				new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId() });
	}
}
