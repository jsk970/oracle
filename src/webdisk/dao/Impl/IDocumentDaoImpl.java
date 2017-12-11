package webdisk.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import webdisk.bean.Document;
import webdisk.dao.IDocumentDao;

public class IDocumentDaoImpl implements IDocumentDao {
	private QueryRunner qr = null;
	

	public IDocumentDaoImpl(QueryRunner qr) {
		super();
		this.qr = qr;
	}

	@Override
	public int addDocument(Document d) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_document(fTitle,fType,fUploadTime,fViewCount,fTel,fShare,fCatelog,"
				+ "fSize,fPath,fDownloadCount,fGoodCount,fBadCount,fIntroduction,fKeyword,fMemo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		Object[] params = {d.getfTitle(),d.getfType(),d.getfUploadTime(),d.getfViewCount(),d.getfTel(),d.getfShare(),d.getfCatelog(),
				d.getfSize(),d.getfPath(),d.getfDownloadCount(),d.getfGoodCount(),d.getfBadCount(),d.getfIntroduction(),d.getFkeyword(),d.getfMemo()};
		try {
			result = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteDocument(int fid) {
		// TODO Auto-generated method stub
		String sql = "delete from t_document where fid="+fid;
		int result = 0;
		try {
			result = qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateDocument(int fid, Document d) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_document SET fTitle=?,fType=?,fUploasTime=?,fViewCount=?,fTel=?,fShare=?,fCatelog=?,"
				+ "fSize=?,fPath=?,fDownloadCount=?,fGoodCount=?,fBadCount=?,fIntroduction=?,fKeyword=?,fMemo=? WHERE fid=?";
		Object[] params = {d.getfTitle(),d.getfType(),d.getfUploadTime(),d.getfViewCount(),d.getfTel(),d.getfShare(),d.getfCatelog(),
				d.getfSize(),d.getfPath(),d.getfDownloadCount(),d.getfGoodCount(),d.getfBadCount(),d.getfIntroduction(),d.getFkeyword(),d.getfMemo()};
		int result = 0;
		try {
			result = qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Document> findAllDocument(String fTel) {
		// TODO Auto-generated method stub
		
		String sql = "select * from t_document where fTel="+fTel;
		List<Document> list = null;
		try {
			list =  qr.query(sql,new BeanListHandler<Document>(Document.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
