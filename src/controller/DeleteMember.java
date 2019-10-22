package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class FixMember
 */
@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet 
{	
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/json;charset=utf-8");
		
		String memberId = request.getParameter("id");
		System.out.println("id : "+memberId);
		try { 
			memberService = new MemberService();
			memberService.deleteMember(memberId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().invalidate();
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(memberId);

		response.getWriter().write(jsonStr);
	}
}
