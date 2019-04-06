package bo;

import java.util.ArrayList;

import bean.KyNangBean;
import dao.ThongTinKyNangDao;

public class KyNangBo {
	ThongTinKyNangDao kynangdao= new ThongTinKyNangDao();
	public ArrayList<KyNangBean> knlist;
	
	public int Them(String MaKyNang, String TenKyNang, String ChiTiet) throws Exception{
		
		for(KyNangBean thongtin : knlist) {
			if(thongtin.getMaKyNang().equals(MaKyNang)) 
				return 0;
		}
		kynangdao.Them(MaKyNang, TenKyNang, ChiTiet);
		return 1;
	}
	
	public ArrayList<KyNangBean> getKyNang() throws Exception{
		knlist=kynangdao.getKyNang();
		return knlist;
	}
	
	public int Xoa(String ma) throws Exception{
		int kq = kynangdao.Xoa(ma);
		knlist = getKyNang();
		return kq;
	}
	
	public int CapNhat(String MaKyNang, String TenKyNang, String ChiTiet) throws Exception{
		int kq = kynangdao.CapNhat(MaKyNang,TenKyNang,ChiTiet);
		knlist = getKyNang();
		return kq;
	}
}
