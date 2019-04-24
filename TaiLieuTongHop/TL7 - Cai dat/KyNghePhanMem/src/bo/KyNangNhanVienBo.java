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
	public int themKyNangNhanVien(String manv,String makn,String motakhac) throws Exception{
		for(KyNangNhanVienBean k : kndao.getListSkill()) {
			if(k.getMaNV().equals(manv) == true && k.getMaKyNang().equals(makn)==true)
				return 0;
		}
		kndao.themKyNangNhanVien(manv, makn, motakhac);
		return 1;
	}
}
