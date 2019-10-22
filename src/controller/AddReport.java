package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AddReportService;

/**
 * Servlet implementation class AddReport
 */
@WebServlet("/AddReport")
public class AddReport extends HttpServlet 
{
	private AddReportService addReportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String memberId = request.getParameter("memberId");
		String count =	request.getParameter("count");
		String timer =	request.getParameter("timer");
		
		System.out.println("--------AddReport--------");
		System.out.println("memberId : "+ memberId);
		System.out.println("count : "+ count);
		System.out.println("timer : "+ timer);
		
		addReportService = new AddReportService();
		addReportService.addReport(memberId, count, timer);
	}
}
