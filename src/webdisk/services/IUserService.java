package webdisk.services;

import webdisk.bean.User;

public interface IUserService {
	/**
	 * 用户注册
	 * @param user
	 * @return  注册成功返回1；否则返回0
	 */
	public int regist(User user);
	/**
	 * 用户登陆
	 * @param fTel
	 * @param fPassword
	 * @return  登录成功返回true；否则返回false
	 */
	public boolean login(String fTel,String fPassword);
	/**
	 * 查询用户信息
	 * @param fTel
	 * @return 返回用户User user
	 */
	public User findByfTel(String fTel);
	/**
	 * 修改用户信息
	 * @param fTel
	 * @param user
	 * @return 成功返回1；否则返回0
	 */
	public int update(String fTel,User user);
	/**
	 * 设置用户等级
	 * @param fTel
	 * 
	 */
	public void setLevel(String fTel);

}
