package kr.or.kosa.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.dao.Rank_Dao;
import kr.or.kosa.dto.Rank;
import kr.or.kosa.dto.User;
import net.sf.json.JSONObject;


@WebServlet("/RankEditList")
public class RankEditList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RankEditList() {
        super();
    }

private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
		User user = (User) session.getAttribute("member");

		String msg = "";
		
    	try {
    		
    		Rank_Dao dao = new Rank_Dao();
    		String url = "";
			//로그인 안한경우
			if (user == null && !(user.getIsAdmin().equals("M"))) {
	            msg = "관리자로 로그인하세요";   
			}
			
			List<Rank> list = dao.getRankListAll();
			int size = list.size();
			int max = 0;
			for(Rank rank : list) {
				if(rank.getR_point() > max) {
					max = rank.getR_point();
				}
			}
			
			JSONObject json = new JSONObject();
			json.put("list", list);
			json.put("size", size);
			json.put("max", max);
			
			out.print(json);
			
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
