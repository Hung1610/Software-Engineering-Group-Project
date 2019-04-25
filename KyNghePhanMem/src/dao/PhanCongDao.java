package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;
import bean.PhanCongBean;

public class PhanCongDao {
ArrayList<PhanCongBean> nv = new ArrayList<>();
	
	public int Them(String MaNhanVien, String MaDuAn, Date NgayStart, Date NgayEnd, String NgayDone, String TienDo)
			throws Exception {
		String sql = "insert into PhanCong values (?,?,?,?,?,?)";
		java.sql.Date startDate = new java.sql.Date(NgayStart.getTime());
		java.sql.Date endDate = new java.sql.Date(NgayEnd.getTime());
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, MaNhanVien);
		cmd.setString(2, MaDuAn);
		cmd.setDate(3, startDate);
		cmd.setDate(4, endDate);
		cmd.setString(5, NgayDone);
		cmd.setString(6, TienDo);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	
	public ArrayList<PhanCongBean> getPhanCong() throws Exception {
		nv.clear();
		String sql = "select PhanCong.*, TenDuAn, Ten from PhanCong JOIN DuAn on PhanCong.MaDuAn = DuAn.MaDuAn JOIN NhanVien on PhanCong.MaNV = NhanVien.MaNV";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			int ma= rs.getInt(1);
			String manv= rs.getString(2);
			String mada= rs.getString(3);
			Date ngaystart= rs.getDate(4);
			Date ngayend= rs.getDate(5);
			String ngaydone= rs.getString(6);
			String tiendo= rs.getString(7);
			String tenda = rs.getString(8);
			String tennv = rs.getString(9);
			PhanCongBean phancong= new PhanCongBean(ma, manv, tennv, mada, tenda, ngaystart, ngayend, ngaydone, tiendo);
			nv.add(phancong);
		}
		
		rs.close();
		return nv;
	}
	
	public ArrayList<PhanCongBean> getPhanCongByDuAn(String MaDuAn) throws Exception {
		nv.clear();
		String sql = "select PhanCong.*, TenDuAn, Ten from PhanCong JOIN DuAn on PhanCong.MaDuAn = DuAn.MaDuAn JOIN NhanVien on PhanCong.MaNV = NhanVien.MaNV Where PhanCong.MaDuAn = ?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, MaDuAn);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			int ma= rs.getInt(1);
			String manv= rs.getString(2);
			String mada= rs.getString(3);
			Date ngaystart= rs.getDate(4);
			Date ngayend= rs.getDate(5);
			String ngaydone= rs.getString(6);
			String tiendo= rs.getString(7);
			String tenda = rs.getString(8);
			String tennv = rs.getString(9);
			PhanCongBean phancong= new PhanCongBean(ma, manv, tennv, mada, tenda, ngaystart, ngayend, ngaydone, tiendo);
			nv.add(phancong);
		}
		
		rs.close();
		return nv;
	}
	
	
	public int Xoa(int ma) throws Exception{
		String sql="delete from PhanCong where MaPhanCong=?";
		PreparedStatement cmd= DungChung.cn.prepareStatement(sql);
		cmd.setInt(1, ma);
		int kq=cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	
	public int CapNhat(int MaPhanCong, String MaNhanVien, String MaDuAn, Date NgayStart, Date NgayEnd, String NgayDone, String TienDo) throws Exception {
		String sql = "update PhanCong set MaNV=?,MaDuAn=?,NgayBatDau=?,NgayKetThuc=?,SoNgayDaLamViec=?,TienDoHoanThanh=? where MaPhanCong=?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		java.sql.Date startDate = new java.sql.Date(NgayStart.getTime());
		java.sql.Date endDate = new java.sql.Date(NgayEnd.getTime());
		cmd.setString(1, MaNhanVien);
		cmd.setString(2, MaDuAn);
		cmd.setDate(3, startDate);
		cmd.setDate(4, endDate);
		cmd.setString(5, NgayDone);
		cmd.setString(6, TienDo);
		cmd.setInt(7, MaPhanCong);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
}
