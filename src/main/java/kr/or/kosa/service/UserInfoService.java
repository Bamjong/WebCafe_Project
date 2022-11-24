package kr.or.kosa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.Board_Info_Dao;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.Board_Info;
import kr.or.kosa.dto.User;
import kr.or.kosa.dto.UserDetails;

public class UserInfoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			//사이드바 정보
	        Board_Info_Dao infodao = new Board_Info_Dao();
	        List<Board_Info> infolist = infodao.getSideBoardList();
	        
	        request.setAttribute("infolist", infolist);
			
	        //유저정보 가져가기
			HttpSession session = request.getSession();
			User user = new User();
			UserDetails details = new UserDetails();
			String userId = "T1@naver.com";//(String) session.getAttribute("userid");
			
			UserDao dao = new UserDao();
			user = dao.selectUserById(userId);
			details = dao.selectUserDetailById(userId);
			
			String phone = details.getPhone();
			String number = phone.substring(0, 3) + " - " + phone.substring(3, 7) + " - " + phone.substring(7, 11);
			
			String birth = user.getBirth();
			//String day = birth.substring(0,5) + "년 " + birth.substring(5,7) + "월 " + birth.substring(7,9) + "일";
			
			request.setAttribute("user", user);
			request.setAttribute("details", details);
			request.setAttribute("phone", number);
			//request.setAttribute("birthday", day);
			
			forward = new ActionForward();
		  	forward.setRedirect(false);
		  	forward.setPath("/user_info_change_board.jsp");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return forward;
	}

}