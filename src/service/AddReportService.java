package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import dao.ReportDao;

public class AddReportService 
{
	private ReportDao reportDao;
	public void addReport(String memberId,String count,String timer)
	{
		System.out.println("--------AddReport서비스--------");
		System.out.println("memberId : "+ memberId);
		System.out.println("count : "+ count);
		System.out.println("timer : "+ timer);
		
		Connection conn = null;
		try 
		{
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			
			ReportDao reportDao;
			reportDao = new ReportDao();
			reportDao.AddReport(memberId, count, timer, conn);
		
			conn.commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("ooooooooooooooooooooooooo");
		System.out.println("--------서비스out--------");
		System.out.println("ooooooooooooooooooooooooo");
	}
}
