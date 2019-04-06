package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KyNangNhanVienBean;

public class KyNangNhanVienDao {
	public ArrayList<KyNangNhanVienBean> listSkill = new ArrayList<KyNangNhanVienBean>();
	
	public ArrayList<KyNangNhanVienBean> getListSkill() throws Exception
	{
		String sql = "select * from KyNangNhanVien";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
		{
			String MaNV = rs.getString(0);
			String MaKyNang = rs.getString(1);
			String MoTaKhac = rs.getString(2);
			KyNangNhanVienBean kn = new KyNangNhanVienBean(MaNV, MaKyNang, MoTaKhac);
			listSkill.add(kn);
		}
		rs.close();
		cmd.close();
		return listSkill;
	}
}
