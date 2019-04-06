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
			string MaNV = 
		}
	}
}
