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
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet
{
	private Member member;
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=utf-8");
		
		String newId = request.getParameter("newId");
		String newPw = request.getParameter("newPw");
		
		System.out.println("--------사인업서블릿in--------");
		System.out.println("newId : "+newId);
		System.out.println("newPw : "+newPw);
		
		member = new Member();
		member.setMemberId(newId);
		member.setMemberPw(newPw);
		
		memberService = new MemberService();
		String returnmemberId = null;
		
		try 
		{
			memberService.sign(member);
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
