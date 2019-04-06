package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import dao.DungChung;
import bean.NhanVien;

public class NhanVienDao {
	ArrayList<NhanVien> nv = new ArrayList<>();
	
	public int Them(String MaNhanVien, String TenNhanVien, Date NgaySinh, String DiaChi, String Sdt, String Email)
			throws Exception {
		String sql = "insert into NhanVien values (?,?,?,?,?,?)";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, MaNhanVien);
		cmd.setString(2, TenNhanVien);
		java.sql.Date nn = new java.sql.Date(NgaySinh.getTime());
		cmd.setDate(3, nn);
		cmd.setString(4, DiaChi);
		cmd.setString(5, Sdt);
		cmd.setString(6, Email);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	
	public ArrayList<NhanVien> getNhanVien() throws Exception {
		String sql = "select * from NhanVien";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String ma= rs.getString(1);
			String ten= rs.getString(2);
			Date ngaysinh= rs.getDate(3);
			String dc= rs.getString(4);
			String sdt= rs.getString(5);
			String email= rs.getString(6);
			NhanVien nhanvien= new NhanVien(ma, ten, ngaysinh, dc, sdt, email);
			nv.add(nhanvien);
		}
		rs.close();
		return nv;
	}
	
	public int Xoa(String ma) throws Exception{
		String sql="delete from NhanVien where MaNV=?";
		PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
		cmd.setString(1, ma);
		int kq=cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	
	public int CapNhat(String MaNhanVien, String TenNhanVien, Date NgaySinh, String DiaChi, String Sdt, String Email) throws Exception {
		String sql = "update NhanVien set Ten=?,NgaySinh=?,DiaChi=?,Sdt=?,Email=? where MaNV=?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, TenNhanVien);
		java.sql.Date nn = new java.sql.Date(NgaySinh.getTime());
		cmd.setDate(2, nn);
		cmd.setString(3, DiaChi);
		cmd.setString(4, Sdt);
		cmd.setString(5, Email);
		cmd.setString(6, MaNhanVien);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
}