package dao;

import java.lang.ref.PhantomReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.BaoCaoBean;
import bean.NhanVien;

public class BaoCaoDao {
	ArrayList<BaoCaoBean> bc = new ArrayList<>();
	public int CapNhatBaoCao(String MaPhanCong, String SoNgayDaLamViec, String TienDoHoanThanh) throws Exception {
		String sql = "update NhanVien set SoNgayDaLamViec=?,TienDoHoanThanh=? where MaPhanCong=?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, MaPhanCong);
		cmd.setString(2, SoNgayDaLamViec);
		cmd.setString(3, TienDoHoanThanh);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
	
	public ArrayList<BaoCaoBean> getBaoCao() throws Exception {
		String sql = "select MaPhanCong, SoNgayDaLamViec, TienDoHoanThanh from PhanCong";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		while(rs.next()) {
			String ma= rs.getString(1);
			String songay= rs.getString(2);
			String tiendo= rs.getString(3);
			BaoCaoBean baocao = new BaoCaoBean(ma, songay, tiendo);
			bc.add(baocao);
		}
		rs.close();
		return bc;
	}
}
