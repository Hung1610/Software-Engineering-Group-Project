package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.KyNangBean;

public class ThongTinKyNangDao {
	ArrayList<KyNangBean> knlist = new ArrayList<>();
	
	// Them vao db SQL record kynang
	public int Them(String MaKyNang, String TenKyNang, String ChiTiet)
			throws Exception {
		String sql = "insert into KiNang values (?,?,?)";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, MaKyNang);
		cmd.setString(2, TenKyNang);
		cmd.setString(3, ChiTiet);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}

	// get all ky nang
	public ArrayList<KyNangBean> getKyNang() throws Exception {
		String sql = "select * from KyNang";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String ma= rs.getString(1);
			String ten= rs.getString(2);
			String ct= rs.getString(3);
			KyNangBean kyNang = new KyNangBean(ma, ten, ct);
			knlist.add(kyNang);
		}
		rs.close();
		return knlist;
	}

	// xoa ky nang theo ma~
	public int Xoa(String ma) throws Exception{
		String sql="delete from KyNang where MaKyNang=?";
		PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
		cmd.setString(1, ma);
		int kq=cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	
	// cap nhat ky nang theo ma~
	public int CapNhat(String MaKyNang, String TenKyNang, String ChiTiet) throws Exception {
		String sql = "update KyNang set TenKyNang=?,MoTa=? where MaKyNang=?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, TenKyNang);
		cmd.setString(2, ChiTiet);
		cmd.setString(3, MaKyNang);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
}
