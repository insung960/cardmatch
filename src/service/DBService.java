package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class DBService //디폴트로 다른패키지,자식 에 접근제한
{
		public Connection getConnection() throws Exception {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/puzzle", "root", "java1234");
			return conn;
		}
		
	// finally에서 rs,stmt,conn을 종료시켜주는 문이 매번 반복되기떄문에 줄이기 위한 메소드
		public void close(ResultSet rs, Statement stmt, Connection conn) 
		{
			if(rs != null) 
			{
				try {
					rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
}
}

