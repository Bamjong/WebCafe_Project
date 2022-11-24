package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.Img_Board_Dao;
import kr.or.kosa.dto.Img_Board;

public class Img_Board_Read_Service implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		try {
			
			String idx = request.getParameter("idx");
			int idx_tmp = Integer.parseInt(idx);
			
			Img_Board_Dao dao = new Img_Board_Dao();
			
			Img_Board imgboard = dao.getImg_BoardByIdx(idx_tmp);
			
			request.setAttribute("imgboard", imgboard);
			
			forward = new ActionForward();
		  	forward.setRedirect(false);
		  	forward.setPath("/WEB-INF/view/imgboard_read.jsp");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return forward;
	}

}
