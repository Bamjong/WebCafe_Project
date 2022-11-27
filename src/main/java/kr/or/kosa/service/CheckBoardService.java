package kr.or.kosa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.Board_Dao;
import kr.or.kosa.dao.Board_Info_Dao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Board_Info;
import kr.or.kosa.dto.User;

public class CheckBoardService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		List<Board> boardlist = null;
		int count = 0;
		
		//날짜계산 준비
		Date nowdate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowday = format.format(nowdate);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		String nowday2 = sdf2.format(nowdate);
		request.setAttribute(nowday2, nowday2);
		Date date=null;
		try {
			date = format.parse(nowday);
			request.setAttribute("date5", date);
			
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1); //날짜 +1일
		Date nexdate = new Date(cal.getTimeInMillis());
		String nextday = format.format(nexdate);
		//System.out.println(nowday+", "+nextday);
		int month = cal.get(Calendar.MONTH)+1;
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		request.setAttribute("days", days);
		try {
			//사이드바 정보
	        Board_Info_Dao infodao = new Board_Info_Dao();
	        List<Board_Info> infolist = infodao.getSideBoardList();
	        
	        request.setAttribute("infolist", infolist);
	        
	        //유저정보 가져가기
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("member");
			String userId = "";
			if(user != null) {
				userId = user.getEmail_id();
			}
			request.setAttribute("userId", userId);
			//작성목록 가져가기
			Board_Dao dao = new Board_Dao();
			boardlist = dao.getBoardListAttendence(1, nowday, nextday);
			request.setAttribute("boardlist", boardlist);
			
			//총 숫자 가져가기
			count = dao.countAttendenceBoard(nowday, nextday);
			request.setAttribute("count", count);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		forward = new ActionForward();
	  	forward.setRedirect(false);
	  	forward.setPath("/WEB-INF/view/attendancecheck_board.jsp");
	  	
		return forward;
	}

}