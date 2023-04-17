package team.spring.runup.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.spring.runup.user.vo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;

	@Override
	public User getUser(User insertUser) {
		User user = session.selectOne("user.getUserByUserVo", insertUser);
		return user;
	}

	@Override
	public User getUserById(String userId) {
		User user = session.selectOne("user.getUserByUserId", userId);
		return user;
	}

	@Override
	public int registUser(User user) {
		int result = session.insert("user.registUser", user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = session.update("user.updateUser", user);
		return result;
	}

	@Override
	public int deleteUser(String userId) {
		int result = session.update("user.deleteUser", userId);
		return result;
	}

}