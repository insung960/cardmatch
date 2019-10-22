package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import vo.Member;

public class MemberService 
{
	Member returnMember;
	public String login(Member member) throws SQLException 
	{
		returnMember = new Member();
		returnMember = null;
		String returnmemberId = null;
		Connection conn = null;
		System.out.println("--------서비스in--------");
		System.out.println("memberId : "+member.getMemberId());
		System.out.println("memberPw : "+member.getMemberPw());
		
		
		try 
		{
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			
			MemberDao memberDao = new MemberDao();
			returnMember = memberDao.login(conn, member);
			
			conn.commit();
			returnmemberId = returnMember.getMemberId();
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
		System.out.println("--------서비스out--------");
		System.out.println("returnmemberId : "+returnmemberId);
		return returnmemberId;
	}
	
	public void sign(Member member) throws SQLException 
	{
		Connection conn = null;
		System.out.println("--------사인업 서비스--------");
		System.out.println("memberId : "+member.getMemberId());
		System.out.println("memberPw : "+member.getMemberPw());
		
		try 
		{
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			
			MemberDao memberDao = new MemberDao();
			memberDao.signUp(member, conn);
			
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
		System.out.println("--------서비스out--------");
	}
	
	public void deleteMember(String memberId) throws SQLException 
	{
		Connection conn = null;
		System.out.println("--------회원 삭제 서비스--------");
		System.out.println("memberId : "+memberId);
		
		try 
		{
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			
			MemberDao memberDao = new MemberDao();
			memberDao.deleteMember(memberId,conn);
			
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
		System.out.println("--------서비스out--------");
	}
	////////////////////////////////////////////////////////////////
	
	public void changeInfo(String memberIdOne,String memberPw,String level) throws SQLException 
	{
		Connection conn = null;
		System.out.println("--------정보 수정  서비스--------");
		System.out.println("memberIdOne : "+memberIdOne);
		System.out.println("memberPw : "+memberPw);
		System.out.println("level : "+level);
		
		try 
		{
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			
			MemberDao memberDao = new MemberDao();
			memberDao.changeInfo(memberIdOne, memberPw, level, conn);
			
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
		System.out.println("--------서비스out--------");
	}
}
