package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import service.SelectTopTen;

/**
 * Servlet implementation class TopTen
 */
@WebServlet("/TopTen")
public class TopTen extends HttpServlet 
{
	private SelectTopTen selectTopTen;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/json;charset=utf-8");
		
		String select = request.getParameter("select");
		System.out.println("----------TopTen 서블릿----------");
		System.out.println("select : "+select);
		
		selectTopTen = new SelectTopTen();
		
		List<vo.TopTen> list = selectTopTen.selectTopTenList(select);
		
		System.out.println("----------TopTen 서블릿끝----------");
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		response.getWriter().write(jsonStr);
	}
}
