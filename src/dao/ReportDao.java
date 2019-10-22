package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class ReportDao 
{
	public void AddReport(String memberId,String count,String timer,Connection conn)
	{
		System.out.println("--------AddReport Dao--------");
		System.out.println("memberId : "+ memberId);
		System.out.println("count : "+ count);
		System.out.println("timer : "+ timer);
		
		PreparedStatement stmt =null;
		try 
		{
			ResultSet rs = null;
			String sql = "INSERT INTO report(member_id, count ,timer, report_date) VALUES (?,?,?,NOW())";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			stmt.setInt(2, Integer.parseInt(count));
			stmt.setInt(3, Integer.parseInt(timer));
			rs = stmt.executeQuery();
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
			{
				stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("ooooooooooooooooooooooooo");
		System.out.println("--------Dao-out--------");
		System.out.println("ooooooooooooooooooooooooo");
	}
}
