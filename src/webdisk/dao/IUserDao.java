package webdisk.dao;

import java.util.List;

import webdisk.bean.User;



public interface IUserDao {
	/**
	 * 注册用户
	 * @param user User user
	 * @return 注册失败，返回0；否则，返回1
	 */
	 
	public int regist(User user);
	/**
	 * 用户登陆
	 * @param fTel  用户名
	 * @param fPassword 用户密码
	 * @return 登陆成功，返回true；否则返回false
	 */
	public boolean login(String fTel,String fPassword);
	/**
	 * 通过用户名查询用户信息
	 * @param fTel 用户名    User user
	 * @return 返回当前用户user
	 */
	public User findByfTel(String fTel);
	/**
	 * 查询所有用户的信息
	 * @return 返回用户的集合list
	 */
	public List<User> findAll();
	
	/**
	 * 模糊查询
	 * @param prop 含有的字段
	 * @param val
	 * @return 返回用户的集合list
	 */
	public List<User> findByProperty(String prop,Object val);
	
	/**
	 * 通过用户名，修改用户的信息
	 * @param fTel  用户名
	 * @param user  用户
	 * @return 修改成功，返回1；否则，返回0
	 */
	public int update(String fTel,User user);
	
	
	

}
