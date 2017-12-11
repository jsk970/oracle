package webdisk.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import webdisk.bean.User;
import webdisk.dao.IUserDao;

import webdisk.util.Md5Token;

public class IUserDaoImpl implements IUserDao {
	
	private QueryRunner qr = null;
	
	public IUserDaoImpl(QueryRunner qr) {
		super();
		this.qr = qr;
	}

	

	@Override
	public int regist(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_user(fTel,fPassword,fUser,fLevel,fPhoto,"
				+ "fScore,fIntroduction,fRegist,fSize) VALUES(?,?,?,?,?,?,?,?,?)";
		int result = 0;
		String password = Md5Token.getInstance().getLongLongToken(user.getfPassword());
		/*
		System.out.println("mima :"+user.getfPassword());
		System.out.println("fTel :"+user.getfTel());
		*/
		Object[] params = {user.getfTel(),password,user.getfUser(),user.getfLevel(),user.getfPhoto()
				,user.getfScore(),user.getfIntroduction(),user.getfRegist(),user.getfSize()};
		try {
			result = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean login(String fTel, String fPassword) {
		// TODO Auto-generated method stub
		User user = null;
		user = findByfTel(fTel);
		System.out.println("user:"+user);
		//System.out.println(user);
		if(user != null){
			fPassword = Md5Token.getInstance().getLongLongToken(fPassword);
			if(fPassword.equals(user.getfPassword())){
				return true;
			}
		}
		
		return false;
	}

	
	@Override
	public User findByfTel(String fTel) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_user WHERE fTel="+fTel;
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_user ORDER BY fTel ASC";
		List<User> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> findByProperty(String prop, Object val) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_user WHERE"+prop+"LIKE '%"+val+"%' ORDER BY fTel ASC";
		List<User> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(String fTel, User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_user SET fpassword=?,fuser=?,fLevel=?,fPhoto=?,fScore=?,"
				+ "fIntroduction=?,fRegist=? WHERE fTel="+fTel;
		int result = 0;
		String password = Md5Token.getInstance().getLongLongToken(user.getfPassword());
		Object[] params = {password,user.getfUser(),user.getfLevel(),user.getfPhoto(),
				user.getfScore(),user.getfIntroduction(),user.getfRegist()};
		try {
			result = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
