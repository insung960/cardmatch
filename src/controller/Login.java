package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet 
{
	private Member member;
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println("--------로그인서블릿in--------");
		System.out.println("memberId : "+memberId);
		System.out.println("memberPw : "+memberPw);
		
		member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		memberService = new MemberService();
		String returnmemberId = null;
		
		try
		{
			returnmemberId =  memberService.login(member);
			HttpSession session = request.getSession();
			session.setAttribute("sessionInfo", returnmemberId);
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("--------로그인서블릿out--------");
		System.out.println("returnmemberId : "+returnmemberId);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(returnmemberId);
		response.getWriter().write(jsonStr);
	}
}
	
	

