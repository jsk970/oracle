package webdisk.factory;

import org.apache.commons.dbutils.QueryRunner;


import webdisk.dao.IDocumentDao;


import webdisk.dao.IUserDao;

import webdisk.dao.Impl.IDocumentDaoImpl;


import webdisk.dao.Impl.IUserDaoImpl;
import webdisk.util.DbUtil;

public class DaoFactory {
	private static QueryRunner qr = new QueryRunner(DbUtil.getDataSource());
	
	
	public static IUserDao CreateUserDao(){
		return new IUserDaoImpl(qr);
	}
	public static IDocumentDao CreateDocumentDao(){
		return new IDocumentDaoImpl(qr);
		
	}
	

}
