package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo.Member;

public class MemberDao 
{
	public Member login(Connection conn, Member member) throws SQLException
	{
		System.out.println("--------Dao-in--------");
		System.out.println("memberId : "+member.getMemberId());
		System.out.println("memberPw : "+member.getMemberPw());
		
		PreparedStatement stmt =null;
		Member returnMember = new Member();
		try 
		{
			ResultSet rs = null;
			String sql = "SELECT id FROM member WHERE id=? AND pw=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			while(rs.next())
			{	
				
				returnMember.setMemberId(rs.getString("id"));
			}
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
		System.out.println("--------Dao-out--------");
		System.out.println("returnMember : "+returnMember.getMemberId());
		return returnMember;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	public void signUp(Member member ,Connection conn) throws SQLException
	{
		System.out.println("--------사인업Dao-in--------");
		System.out.println("memberId : "+member.getMemberId());
		System.out.println("memberPw : "+member.getMemberPw());
		
		PreparedStatement stmt =null;
		try 
		{
			ResultSet rs = null;
			String sql = "INSERT INTO member(id,pw) VALUES (?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
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
		System.out.println("--------Dao-out--------");
	}
	///////////////////////////////////////////////////////////
	public void deleteMember(String memberId, Connection conn) throws SQLException
	{
		System.out.println("--------탈퇴Dao-in--------");
		System.out.println("memberId : "+ memberId);
		
		PreparedStatement stmt =null;
		try 
		{
			ResultSet rs = null;
			String sql = "DELETE FROM member WHERE id =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
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
	}
	////////////////////////////////////////////////////////////////
	public void changeInfo(String memberIdOne,String memberPw,String level,Connection conn) throws SQLException
	{
		System.out.println("--------탈퇴Dao-in--------");
		System.out.println("memberIdOne : "+memberIdOne);
		System.out.println("memberPw : "+memberPw);
		System.out.println("level : "+level);
		
		PreparedStatement stmt =null;
		try 
		{
			ResultSet rs = null;
			String sql = "UPDATE member SET pw=?, LEVEL=? WHERE id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberPw);
			stmt.setString(2, level);
			stmt.setString(3, memberIdOne);
			rs = stmt.executeQuery();
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
	}
}
