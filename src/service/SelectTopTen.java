package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import dao.TopTenDao;
import vo.TopTen;

public class SelectTopTen 
{
	private TopTenDao topTenDao;
	public List<TopTen> selectTopTenList(String select)
	{
		System.out.println("----------TopTen서비스----------");
		System.out.println("select : "+select);
			
		List<TopTen> list = new ArrayList<TopTen>();
		topTenDao = new TopTenDao();
			Connection conn = null;
			
			try 
			{
				DBService dbService = new DBService();
				conn = dbService.getConnection();
				
				conn.setAutoCommit(false);
				
				//리스트에 매서드실행값받기 !!!! x 4 
				if(select.equals("all"))
				{
					System.out.println("----------서비스 if all----------");
					list = topTenDao.selectTopTenList(conn);
					System.out.println("----------서비스 if today----------");
				}
				else if(select.equals("today"))
				{
					System.out.println("----------서비스 if today----------");
					list = topTenDao.selectTopTenListToday(conn);
					System.out.println("----------서비스 if today----------");
				}
				else if(select.equals("month"))
				{
					System.out.println("----------서비스 if month----------");
					list = topTenDao.selectTopTenListMonth(conn);
					System.out.println("----------서비스 if today----------");
				}
				else if(select.equals("total"))
				{
					System.out.println("----------서비스 if total----------");
					list = topTenDao.selectTopTenListTotal(conn);
					System.out.println("----------서비스 if total----------");
				}
				else 
				{
					System.out.println("----------서비스 if my----id = " +select);
					list = topTenDao.selectTopTenListMy(conn,select);
					System.out.println("----------서비스 if today----------");
				}
				
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
			System.out.println("--------서비스끝--------");
			
			return list;
		
	}
}
