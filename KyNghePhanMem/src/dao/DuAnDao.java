package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.DuAnBean;
import bean.NhanVien;

public class DuAnDao {
	ArrayList<DuAnBean> da = new ArrayList<DuAnBean>();
	public int Them(String MaDuAn,String TenDuAn,Date NgayBatDau, Date NgayKetThuc,String TinhTrang) throws Exception {
			String sql = "insert into DuAn values (?,?,?,?,?)";
			PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
			cmd.setString(1, MaDuAn);
			cmd.setString(2, TenDuAn);
			java.sql.Date nbd = new java.sql.Date(NgayBatDau.getTime());
			java.sql.Date nkt = new java.sql.Date(NgayKetThuc.getTime());
			cmd.setDate(3, nbd);
			cmd.setDate(4, nkt);
			cmd.setString(5, TinhTrang);
			int kq= cmd.executeUpdate();
			cmd.close();
			return kq;
	
	}
	public int Xoa(String ma) throws Exception{
		String sql="delete from DuAn where MaDuAn=?";
		PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
		cmd.setString(1, ma);
		int kq=cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	public int CapNhat(String MaDuAn,String TenDuAn,Date NgayBatDau, Date NgayKetThuc,String TinhTrang) throws Exception {
		String sql = "update DuAn set MaDuAn=?,TenDuAn=?,NgayBatDau=?,NgayKetThuc=?,TinhTrang=? where MaDuAn=?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, MaDuAn);
		cmd.setString(2, TenDuAn);
		java.sql.Date nbd = new java.sql.Date(NgayBatDau.getTime());
		cmd.setDate(3, nbd);
		java.sql.Date nkt = new java.sql.Date(NgayKetThuc.getTime());
		cmd.setDate(4, nkt);
		cmd.setString(5, TinhTrang);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	public ArrayList<DuAnBean> getDuAn() throws Exception {
		String sql = "select * from DuAn";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String ma=rs.getString(1);
			String ten= rs.getString(2);
			Date nbd = rs.getDate(3);
			Date nkt= rs.getDate(4);
			String tinhtrang= rs.getString(5);
			DuAnBean duan = new DuAnBean(ma, ten, nbd, nkt, tinhtrang);
			da.add(duan);
			
			
		}
		rs.close();
		return da;
		
	}
	
}
