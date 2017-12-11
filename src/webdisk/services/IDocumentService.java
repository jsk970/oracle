package webdisk.services;

import java.util.List;

import webdisk.bean.Document;

public interface IDocumentService {
	/**
	 * 添加文件
	 * @param d
	 * @return 添加成功返回1；否则返回0
	 */
	public int addDocument(Document d);
	/**
	 * 通过文件编号删除文件
	 * @param fid
	 * @return 删除成功返回1；否则返回0
	 */
	public int deleteDocument(int fid);
	/**
	 * 修改文件
	 * @param fid
	 * @param d
	 * @return 修改成功返回1；否则返回0
	 */
	public int updateDocument(int fid,Document d);
	/**
	 * 查看文件
	 * @param fTel
	 * @return
	 */
	public List<Document> findAllDocument(String fTel);
}
