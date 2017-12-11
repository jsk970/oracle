package webdisk.bean;

public class Document {
	private int fid;
	private String fTitle;
	private String fType;
	private String fUploadTime;
	private int fViewCount;
	private String fTel;
	private String fShare;
	private String fCatelog;
	private double fSize;
	private String fPath;
	private int fDownloadCount;
	private int fGoodCount;
	private int fBadCount;
	private String fIntroduction;
	private String fkeyword;
	private String fMemo;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getfTitle() {
		return fTitle;
	}
	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}
	public String getfType() {
		return fType;
	}
	public void setfType(String fType) {
		this.fType = fType;
	}
	public String getfUploadTime() {
		return fUploadTime;
	}
	public void setfUploadTime(String fUploadTime) {
		this.fUploadTime = fUploadTime;
	}
	public int getfViewCount() {
		return fViewCount;
	}
	public void setfViewCount(int fViewCount) {
		this.fViewCount = fViewCount;
	}
	public String getfTel() {
		return fTel;
	}
	public void setfTel(String fTel) {
		this.fTel = fTel;
	}
	public String getfShare() {
		return fShare;
	}
	public void setfShare(String fShare) {
		this.fShare = fShare;
	}
	public String getfCatelog() {
		return fCatelog;
	}
	public void setfCatelog(String fCatelog) {
		this.fCatelog = fCatelog;
	}

	public String getfPath() {
		return fPath;
	}
	public void setfPath(String fPath) {
		this.fPath = fPath;
	}
	
	public int getfDownloadCount() {
		return fDownloadCount;
	}
	public void setfDownloadCount(int fDownloadCount) {
		this.fDownloadCount = fDownloadCount;
	}
	public int getfGoodCount() {
		return fGoodCount;
	}
	public void setfGoodCount(int fGoodCount) {
		this.fGoodCount = fGoodCount;
	}
	public int getfBadCount() {
		return fBadCount;
	}
	public void setfBadCount(int fBadCount) {
		this.fBadCount = fBadCount;
	}
	public String getfIntroduction() {
		return fIntroduction;
	}
	public void setfIntroduction(String fIntroduction) {
		this.fIntroduction = fIntroduction;
	}
	public String getFkeyword() {
		return fkeyword;
	}
	public void setFkeyword(String fkeyword) {
		this.fkeyword = fkeyword;
	}
	public String getfMemo() {
		return fMemo;
	}
	public void setfMemo(String fMemo) {
		this.fMemo = fMemo;
	}
	


	public double getfSize() {
		return fSize;
	}
	public void setfSize(double fSize) {
		this.fSize = fSize;
	}
	@Override
	public String toString() {
		return "Document [fid=" + fid + ", fTitle=" + fTitle + ", fType=" + fType + ", fUploadTime=" + fUploadTime
				+ ", fViewCount=" + fViewCount + ", fTel=" + fTel + ", fShare=" + fShare + ", fCatelog=" + fCatelog
				+ ", fSize=" + fSize + ", fPath=" + fPath + ", fDownloadCount=" + fDownloadCount + ", fGoodCount="
				+ fGoodCount + ", fBadCount=" + fBadCount + ", fIntroduction=" + fIntroduction + ", fkeyword="
				+ fkeyword + ", fMemo=" + fMemo + "]";
	}
	
	
	
	
 
}
