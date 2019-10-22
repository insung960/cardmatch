package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.TopTen;

public class TopTenDao 
{
	private TopTen topten;
	public List<TopTen> selectTopTenList(Connection conn) throws SQLException
	{
		System.out.println("----------All Dao----------");
		
		PreparedStatement stmt =null;
		ResultSet rs = null;
		
		List<TopTen> list = new ArrayList<TopTen>();
		
		
		try 
		{
			String sql = "SELECT * FROM report ORDER BY timer ASC ,count ASC LIMIT 0,10";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{	
				topten = new TopTen();
				topten.setMember(new Member());
				topten.setReportId(rs.getInt("report_id"));
				topten.getMember().setMemberId(rs.getString("member_id"));
				topten.setCount(rs.getInt("count"));
				topten.setTimer(rs.getInt("timer"));
				topten.setReportDate(rs.getString("report_date"));
				list.add(topten);
			}
		}
		
		finally 
		{
			try 
			{
				stmt.close();
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("--------Dao-out--------");
		
		return list;
	}
	
	public List<TopTen> selectTopTenListTotal(Connection conn) throws SQLException
	{
		System.out.println("----------All Dao----------");
		
		PreparedStatement stmt =null;
		ResultSet rs = null;
		
		List<TopTen> list = new ArrayList<TopTen>();
		
		
		try 
		{
			String sql = "SELECT * FROM report ORDER BY timer ASC ,count ASC";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{	
				topten = new TopTen();
				topten.setMember(new Member());
				topten.setReportId(rs.getInt("report_id"));
				topten.getMember().setMemberId(rs.getString("member_id"));
				topten.setCount(rs.getInt("count"));
				topten.setTimer(rs.getInt("timer"));
				topten.setReportDate(rs.getString("report_date"));
				list.add(topten);
			}
		}
		
		finally 
		{
			try 
			{
				stmt.close();
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("--------Dao-out--------");
		
		return list;
	}
	
	public List<TopTen> selectTopTenListToday(Connection conn) throws SQLException
	{
		System.out.println("----------today Dao----------");
		
		PreparedStatement stmt =null;
		ResultSet rs = null;
		
		List<TopTen> list = new ArrayList<TopTen>();
		topten = new TopTen();
		
		try 
		{
			String sql = "SELECT * FROM report  WHERE date(report_date) = date( now() ) ORDER BY timer ASC, count ASC LIMIT 0,10";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{	
				topten = new TopTen();
				topten.setMember(new Member());
				topten.setReportId(rs.getInt("report_id"));
				topten.getMember().setMemberId(rs.getString("member_id"));
				topten.setCount(rs.getInt("count"));
				topten.setTimer(rs.getInt("timer"));
				topten.setReportDate(rs.getString("report_date"));
				list.add(topten);
			}
		}
		
		finally 
		{
			try 
			{
				stmt.close();
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("--------Dao-out--------");
		
		return list;
	}
	
	public List<TopTen> selectTopTenListMonth(Connection conn) throws SQLException
	{
		System.out.println("----------month Dao----------");
		
		PreparedStatement stmt =null;
		ResultSet rs = null;
		
		List<TopTen> list = new ArrayList<TopTen>();
		topten = new TopTen();
		
		try 
		{
			String sql = "SELECT * FROM report WHERE MONTH(report_date) = MONTH( NOW() ) ORDER BY timer ASC, count ASC  LIMIT 0,10";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{	
				topten = new TopTen();
				topten.setMember(new Member());
				topten.setReportId(rs.getInt("report_id"));
				topten.getMember().setMemberId(rs.getString("member_id"));
				topten.setCount(rs.getInt("count"));
				topten.setTimer(rs.getInt("timer"));
				topten.setReportDate(rs.getString("report_date"));
				list.add(topten);
			}
		}
		
		finally 
		{
			try 
			{
				stmt.close();
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("--------Dao-out--------");
		
		return list;
	}
	
	public List<TopTen> selectTopTenListMy(Connection conn,String select) throws SQLException
	{
		System.out.println("----------All Dao----------");
		System.out.println("id : "+select);
		
		PreparedStatement stmt =null;
		ResultSet rs = null;
		
		List<TopTen> list = new ArrayList<TopTen>();
		
		
		try 
		{
			String sql = "SELECT * FROM report where member_id =? ORDER BY timer ASC ,count ASC";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,select);
			rs = stmt.executeQuery();
			while(rs.next())
			{	
				topten = new TopTen();
				topten.setMember(new Member());
				topten.setReportId(rs.getInt("report_id"));
				topten.getMember().setMemberId(rs.getString("member_id"));
				topten.setCount(rs.getInt("count"));
				topten.setTimer(rs.getInt("timer"));
				topten.setReportDate(rs.getString("report_date"));
				list.add(topten);
			}
		}
		
		finally 
		{
			try 
			{
				stmt.close();
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("--------Dao-out--------");
		
		return list;
	}
}
