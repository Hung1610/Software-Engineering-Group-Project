package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DungChung {
	public static Connection cn;

	public void KetNoi() throws ClassNotFoundException {
		try {
			// b1:nap database driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Da xac dinh HQTCSDL");
			// b2: ket noi vao csdl: KyNghe, user: sa, pass: 123 
			String dburl = "jdbc:sqlserver://localhost:1433;databaseName=KyNghe;user=sa;password=123";
			cn = DriverManager.getConnection(dburl);
			System.out.println("Da ket noi");

		} catch (Exception tt) {
			tt.printStackTrace();
			System.out.println(tt.getMessage());
			System.out.println("ko the tao ket noi dc");
			// TODO: handle exception
		}
	}
}
