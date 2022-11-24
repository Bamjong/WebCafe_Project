package kr.or.kosa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.Board_Dao;
import kr.or.kosa.dao.Board_Info_Dao;
import kr.or.kosa.dao.Regular_Board_Dao;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Board_Info;
import kr.or.kosa.dto.User;

public class Regular_Board_Post_Service implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		try {
			
			//사이드 바
			Board_Info_Dao infodao = new Board_Info_Dao();
			List<Board_Info> infolist = infodao.getSideBoardList();
			
			int idx = Integer.parseInt(request.getParameter("idx"));

			UserDao udao = new UserDao();
			Regular_Board_Dao dao = new Regular_Board_Dao();
			Board_Dao bdao = new Board_Dao();
			
			
			
			bdao.updateHits(idx);
			Board board = dao.getRegular_BoardByIdx(idx);
			User user = udao.selectUserById(board.getEmail_id());
		
			request.setAttribute("infolist", infolist);
			request.setAttribute("board", board);
			request.setAttribute("user", user);
			
			
			forward = new ActionForward();
		  	forward.setRedirect(false);
		  	forward.setPath("/WEB-INF/view/regularboard_post.jsp");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return forward;
	}

}
