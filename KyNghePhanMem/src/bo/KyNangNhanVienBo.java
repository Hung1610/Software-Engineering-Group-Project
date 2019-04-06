package bo;

import java.util.ArrayList;

import bean.KyNangNhanVienBean;
import dao.KyNangNhanVienDao;

public class KyNangNhanVienBo {
	public ArrayList<KyNangNhanVienBean> getListSkill() throws Exception
	{
		KyNangNhanVienDao kndao = new KyNangNhanVienDao();
		return kndao.getListSkill();
	}
}
