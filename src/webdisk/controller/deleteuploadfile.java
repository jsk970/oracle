package webdisk.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webdisk.bean.Document;
import webdisk.bean.User;
import webdisk.dao.Impl.IDocumentDaoImpl;
import webdisk.service.Impl.IDocumentServiceImpl;
import webdisk.services.IDocumentService;

/**
 * Servlet implementation class deleteuploadfile
 */
@WebServlet("/deleteuploadfile")
public class deleteuploadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteuploadfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deletefile(request, response);
	}
	protected void deletefile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		
		String serverPath = request.getServletContext().getRealPath("/uploadfile/");
		String fileName = request.getParameter("filename");
		String path =serverPath+fileName;
		System.out.println(path);
		
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		IDocumentService is = new IDocumentServiceImpl();
		int fid = Integer.parseInt(request.getParameter("fid"));
		 is.deleteDocument(fid);
		 System.out.println("删除成功!");
		 request.getRequestDispatcher("DocumentController").forward(request, response);
		}
		
		
		
		
		
	}


