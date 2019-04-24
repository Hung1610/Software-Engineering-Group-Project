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
			System.out.println("Đã xác định HQT CSDL Microsoft SQL Server");
			// b2: ket noi vao csdl: KyNghe, user: sa, pass: 123 
			String dburl = "jdbc:sqlserver://localhost:1433;databaseName=KyNghe;user=sa;password=123";
			cn = DriverManager.getConnection(dburl);
			System.out.println("Đã kết nối.");

		} catch (Exception tt) {
			tt.printStackTrace();
			System.out.println(tt.getMessage());
			System.out.println("Không kết nối được.");
			// TODO: handle exception
		}
	}
}
