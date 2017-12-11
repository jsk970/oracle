package webdisk.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webdisk.bean.Document;

import webdisk.bean.User;
import webdisk.service.Impl.IDocumentServiceImpl;

import webdisk.service.Impl.IUserServiceImpl;
import webdisk.services.IDocumentService;

import webdisk.services.IUserService;
import webdisk.util.DateUtil;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	
	
	
	
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.config=config;
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		choose(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		choose(request,response);
		
	}
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SmartUpload su = new SmartUpload();
		su.initialize(config, request, response);
		
		su.setAllowedFilesList("png,jpg,PNG,JPG");
		su.setMaxFileSize(1*1024*1024);
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			
			e.printStackTrace();
		}
		
		Request req = su.getRequest();
		
		Files files = su.getFiles();
		File photo = files.getFile(0);
		
		String exName = photo.getFileExt();
		String mainName = req.getParameter("fTel");
		String path ="/image/user/"+mainName+"."+exName;
		try {
			photo.saveAs(path);
		} catch (SmartUploadException e) {
			
			e.printStackTrace();
		}
		
		User user = new User();
		
		user.setfPhoto(path.substring(1));
		user.setfUser(req.getParameter("fUser"));
		user.setfLevel("1级");
		user.setfPassword(req.getParameter("fPassword"));
		user.setfScore("0");
		user.setfSize(5);
		user.setfTel(req.getParameter("fTel"));
		user.setfIntroduction(req.getParameter("fintroduction"));
		Date now = new Date();
		user.setfRegist(DateUtil.dateToStr(now));
		IUserService us = new IUserServiceImpl();
		us.regist(user);
		
		RequestDispatcher disoatcher = request.getRequestDispatcher("mode2/userLogin.jsp");
		disoatcher.forward(request, response);
		
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fTel = request.getParameter("fTel");
		String fPassword = request.getParameter("fPassword");
		
		IUserService us = new IUserServiceImpl();
		
		if(us.login(fTel, fPassword)){
			User user = null;
			user = us.findByfTel(fTel);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			
			IDocumentService is = new IDocumentServiceImpl();
			HttpSession session2 = request.getSession();
			
			User loginuser = (User)session2.getAttribute("loginUser");
			String myTel = loginuser.getfTel();
			List<Document> list = null; 
			list = is.findAllDocument(myTel);
			request.setAttribute("DocumentList", list);
			
			RequestDispatcher disoatcher = request.getRequestDispatcher("/mode2/userMenu.jsp");
			disoatcher.forward(request, response);
		}else{
			response.sendRedirect("mode2/userLogin.jsp");

		}
		
	}
	public void findById(HttpServletRequest request, HttpServletResponse response) {
//		IUserService us = new IUserServiceImpl();
//		User user = null;
//		HttpSession session = request.getSession();
//		user = (User) session.getAttribute("loginUser");
//		user = us.findByfTel(user.getfTel());
//		if(user != null)
//		{
//				HttpSession session = request.getSession();
//				session.setAttribute("user", user);
//				
//				RequestDispatcher disoatcher = request.getRequestDispatcher("mode2/update_user.jsp");
//				try {
//					disoatcher.forward(request, response);
//				} catch (ServletException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			
//		}

	}
	public void update_user(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				SmartUpload su = new SmartUpload();
						
				
				su.initialize(config, request, response);
				
				su.setAllowedFilesList("png,jpg,PNG,JPG");
				su.setMaxFileSize(1*1024*1024);
				
				try {
					su.upload();
				} catch (SmartUploadException e) {
					
					e.printStackTrace();
				}
				
				
				
				Request req = su.getRequest();
				
				Files files = su.getFiles();
				File photo = files.getFile(0);
				
				String exName = photo.getFileExt();
				String mainName = req.getParameter("fTel");
				String path ="/image/user/"+mainName+"."+exName;
				try {
					photo.saveAs(path);
				} catch (SmartUploadException e) {
					
					e.printStackTrace();
				}
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("loginUser");
				String fTel = user.getfTel();
				user.setfPhoto(path.substring(1));
				user.setfUser(req.getParameter("fUser"));
				user.setfLevel("1级");
				user.setfPassword(req.getParameter("fPassword"));
				user.setfScore("0");
				user.setfSize(5);
				user.setfIntroduction(req.getParameter("fintroduction"));
				Date now = new Date();
				user.setfRegist(DateUtil.dateToStr(now));
				IUserService us = new IUserServiceImpl();
				us.update(fTel, user);
				session.setAttribute("loginUser", user);
				
				List<Document> list = null; 
				IDocumentService is = new IDocumentServiceImpl();
				list = is.findAllDocument(fTel);
				request.setAttribute("DocumentList", list);
				
				RequestDispatcher disoatcher = request.getRequestDispatcher("/mode2/userMenu.jsp");
				disoatcher.forward(request, response);
				
}	

	public void choose(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String action = request.getParameter("action");
		if("regist".equals(action)){
			try {
				regist(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("login".equals(action)){
			try {
				login(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("findById".equals(action)){
			
				findById(request, response);
		}else if("update_user".equals(action)){
			
			update_user(request, response);
		}
	}
}

			
		
	
	


