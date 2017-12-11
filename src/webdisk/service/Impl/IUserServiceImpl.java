package webdisk.service.Impl;



import webdisk.bean.User;
import webdisk.dao.IUserDao;
import webdisk.factory.DaoFactory;
import webdisk.services.IUserService;

public class IUserServiceImpl implements IUserService {
	private IUserDao dao = DaoFactory.CreateUserDao();

	@Override
	public int regist(User user) {
		// TODO Auto-generated method stub
		if(dao.regist(user)!=0)
			return 1;
		return 0;
	}

	@Override
	public boolean login(String fTel, String fPassword) {
		// TODO Auto-generated method stub
		if(dao.login(fTel, fPassword))
			return true;
		return false;
	}

	@Override
	public User findByfTel(String fTel) {
		// TODO Auto-generated method stub
		if(dao.findByfTel(fTel)!=null)
			return dao.findByfTel(fTel);
		return null;
	}

	@Override
	public int update(String fTel,User user) {
		// TODO Auto-generated method stub
		if(dao.update(fTel, user)!=0)
			return 1;
		return 0;
	}

	@Override
	public void setLevel(String fTel) {
		// TODO Auto-generated method stub
		String level="1级";
		
		int scouse = 0;
		if(scouse >=0 && scouse<100)
			level="1级";
		else if(scouse <200)
			level="2级";
		else if(scouse <200)
			level="3级";
		else if(scouse <200)
			level="4级";
		else if(scouse <200)
			level="5级";
		else
			level="1级";
			

	}

}
