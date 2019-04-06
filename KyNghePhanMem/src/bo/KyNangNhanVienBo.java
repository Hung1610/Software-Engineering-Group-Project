package bo;

import java.util.ArrayList;

import bean.KyNangNhanVienBean;
import dao.KyNangNhanVienDao;

public class KyNangNhanVienBo {
	public ArrayList<KyNangNhanVienBean> ds = new ArrayList<KyNangNhanVienBean>();
	KyNangNhanVienDao kndao = new KyNangNhanVienDao();
	public ArrayList<KyNangNhanVienBean> getListSkill() throws Exception
	{
		
		ds = kndao.getListSkill();
		return ds;
	}
}
