package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

/**
 * Servlet implementation class changeMemberInfo
 */
@WebServlet("/changeMemberInfo")
public class changeMemberInfo extends HttpServlet
{
		private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String	memberIdOne = request.getParameter("memberIdOne");
		String	memberPw = request.getParameter("memberPw");
		String	level = request.getParameter("level");
		
		System.out.println("--------정보 수정  서블릿--------");
		System.out.println("memberIdOne : "+memberIdOne);
		System.out.println("memberPw : "+memberPw);
		System.out.println("level : "+level);
		
		memberService = new MemberService();
		try {
			memberService.changeInfo(memberIdOne,memberPw,level);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
