package webdisk.service.Impl;

import java.util.List;

import webdisk.bean.Document;
import webdisk.dao.IDocumentDao;
import webdisk.factory.DaoFactory;
import webdisk.services.IDocumentService;

public class IDocumentServiceImpl implements IDocumentService {
	private IDocumentDao dao = DaoFactory.CreateDocumentDao();
	@Override
	public int addDocument(Document d) {
		// TODO Auto-generated method stub
		if(dao.addDocument(d)!=0)
			return 1;
		return 0;
	}

	@Override
	public int deleteDocument(int fid) {
		// TODO Auto-generated method stub
		if(dao.deleteDocument(fid)!=0)
			return 1;
		return 0;
	}

	@Override
	public int updateDocument(int fid, Document d) {
		// TODO Auto-generated method stub
		if(dao.updateDocument(fid, d)!=0)
			return 1;
		return 0;
	}

	@Override
	public List<Document> findAllDocument(String fTel) {
		if(dao.findAllDocument(fTel)!=null)
			return dao.findAllDocument(fTel);
		return null;
	}

}
