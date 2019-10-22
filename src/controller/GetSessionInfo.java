package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetSessionInfo
 */
@WebServlet("/GetSessionInfo")
public class GetSessionInfo extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=utf-8");
		
		HttpSession session = request.getSession();
		String sesseionInfo = (String)session.getAttribute("sessionInfo");
		
		System.out.println(sesseionInfo);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(sesseionInfo);

		response.getWriter().write(jsonStr);
		
	}
}
