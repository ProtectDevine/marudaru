package marudaru.common.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectTester {
	public static void main(String[] args) throws SQLException {
	
		final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		final String USER = "KH21";
		final String PW = "hiu99080";
		
	
		try{
			Connection con = DriverManager.getConnection(URL, USER, DRIVER);
			System.out.println("연결완료");
			System.out.println(con);
	
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
		
	}
	
	
	
	
}
