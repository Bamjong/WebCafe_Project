package kr.or.kosa.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.AdminDao;

@WebServlet("/Deleterapport")
public class Deleterapport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Deleterapport() {
        super();
    }

private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    		
    	try {  		
    		int idx = Integer.parseInt(request.getParameter("idx"));	
    		
			AdminDao dao = new AdminDao();
		boolean row = dao.deleteRapport(idx);
			
			String msg = "";
			
			if(row == false) {
				msg = "실패";
			}else {
				msg = "확인";
			}
			
			out.print("신고수 결과" +msg);
			
    		
    	} catch(Exception e) {
    		System.out.println("신고"+e.getMessage());
    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
