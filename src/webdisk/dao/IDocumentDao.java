package webdisk.dao;

import java.util.List;

import webdisk.bean.Document;

public interface IDocumentDao {
	/**
	 * 添加文件
	 * @param d
	 * @return
	 */
	public int addDocument(Document d);
	/**
	 * 删除文件
	 * @param fid
	 * @return
	 */
	public int deleteDocument(int fid);
	/**
	 * 修改文件
	 * @param fid
	 * @param d
	 * @return
	 */
	public int updateDocument(int fid,Document d);
	
	/**
	 * 查看文件
	 * @return 
	 */
	public List<Document> findAllDocument(String fTel);
}
