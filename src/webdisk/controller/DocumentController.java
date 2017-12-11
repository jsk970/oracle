package webdisk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webdisk.bean.Document;
import webdisk.bean.User;
import webdisk.service.Impl.IDocumentServiceImpl;
import webdisk.services.IDocumentService;

/**
 * Servlet implementation class DocumentController
 */
@WebServlet("/DocumentController")
public class DocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		findAllDocument(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		findAllDocument(request, response);
	}
	protected void findAllDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDocumentService is = new IDocumentServiceImpl();
		HttpSession session = request.getSession();
		/**
		 * 当前登录账户的fTel
		 */
		User loginuser = (User)session.getAttribute("loginUser");
		String myTel = loginuser.getfTel();
		List<Document> list = null; 
		list = is.findAllDocument(myTel);
		request.setAttribute("DocumentList", list);
		request.getRequestDispatcher("mode2/mydocument.jsp").forward(request, response);
	}
	

}
