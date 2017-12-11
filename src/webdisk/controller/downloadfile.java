package webdisk.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class downloadfile
 */
@WebServlet("/downloadfile")
public class downloadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
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
    public downloadfile() {
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
		System.out.println("开始下载!");
		SmartUpload su = new SmartUpload();
		su.initialize(config, request, response);
		su.setContentDisposition(null);
		String fileName = request.getParameter("filename");
		String serverPath = request.getServletContext().getRealPath("/uploadfile/");
		
		System.out.println(serverPath+fileName);
		try {
			su.downloadFile(serverPath+fileName);
			System.out.println("下载成功!");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
