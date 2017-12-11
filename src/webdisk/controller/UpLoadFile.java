package webdisk.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


import webdisk.bean.Document;
import webdisk.bean.User;
import webdisk.service.Impl.IDocumentServiceImpl;
import webdisk.services.IDocumentService;
import webdisk.util.DateUtil;

/**
 * Servlet implementation class UpLoadFile
 */
@WebServlet("/UpLoadFile")
public class UpLoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Log log = LogFactory.getLog(UpLoadFile.class);
	
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.config=config;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uploadfile(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uploadfile(request, response);
	}
	protected void uploadfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("开始上传文件！");
		SmartUpload su = new SmartUpload();
		
		su.initialize(config, request, response);
		su.setAllowedFilesList("doc,txt,jpg,JPG,png,PNG");
		su.setMaxFileSize(1024*1024*1024);

		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		Files files = su.getFiles();
		File uploadfile = files.getFile(0);
		System.out.println("uploadfile.size:"+uploadfile.getSize());
		HttpSession session = request.getSession();
		/**
		 * 当前登录用户的fTel
		 */
		User loginuser = (User)session.getAttribute("loginUser");
		String fTel = loginuser.getfTel();
		
		String filename = uploadfile.getFileName();
		String file_extname = uploadfile.getFileExt();
		
		
		
		
		System.out.println("filename:"+filename);
		
		IDocumentService is = new IDocumentServiceImpl();
		List<Document> list = null;
		list = is.findAllDocument(fTel);
		
		System.out.println("Documentlist:"+list);
		int result = 0;
		for(Document doc:list)
		{
			if(doc.getfTitle().equals(filename))
			{
				System.out.println("doc.getfTitle():"+doc.getfTitle());
			result = 0;
			}else {
				result = 1;
			}
		}
		
		System.out.println("result"+result);
		if(result == 1||list.size()==0) {
		System.out.println("开始上传的文件是:"+filename);
		//String exName = uploadfile.getFileExt();
		String path ="/uploadfile/"+filename;
		System.out.println("path:"+path);
			try {
				uploadfile.saveAs(path);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
				filename = new String(filename.getBytes("GBK"),"utf-8");//解决上传文件乱码问题
				Document doc = new Document();
				doc.setfTitle(filename);
				doc.setfType(file_extname);
				
				int size = uploadfile.getSize();
				int da = size/1024*100;
				double fSize=(double)da/100.00;
				
				
				
				
				System.out.println("Size:"+size);
				System.out.println("fSize:"+fSize);
				
				
				doc.setfSize(fSize);
				doc.setfUploadTime(DateUtil.dateToStr(new Date()));
				doc.setfTel(fTel);
				doc.setfPath(path);
				
				is.addDocument(doc);
				System.out.println("上传成功！");
				
				String serverPath = request.getServletContext().getRealPath("/uploadfile/");
				System.out.println("文件上传路径："+serverPath);
				log.info(serverPath);
		
		request.getRequestDispatcher("DocumentController").forward(request, response);
		}else {
			System.out.println("此文件名已存在！请重命名上传文件！");
			request.getRequestDispatcher("mode2/uploadfile_error.jsp").forward(request, response);
		}
		
	}
}


