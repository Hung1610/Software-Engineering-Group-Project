package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.PhanCongBean;
import dao.PhanCongDao;


public class PhanCongBo {
	PhanCongDao daoPhanCong= new PhanCongDao();
	public ArrayList<PhanCongBean> pcList;
	
	// Thêm phân công vào SQL
	public int Them(String MaNhanVien, String MaDuAn, Date NgayStart, Date NgayEnd, String NgayDone, String TienDo) throws Exception{
		
		daoPhanCong.Them(MaNhanVien, MaDuAn, NgayStart, NgayEnd, NgayDone, TienDo);
		pcList = getPhanCong();
		return 1;
	}
	
	// Lấy thông tin của một phân công
	public PhanCongBean getInfo(int ma) throws Exception{
		for(PhanCongBean k : pcList) 
			if(k.getMaPhanCong() == ma) 
				return k;
		return null;	
	}
	
	// Lấy toàn bộ phân công có sẵn trong SQL
	public ArrayList<PhanCongBean> getPhanCong() throws Exception{
		pcList=daoPhanCong.getPhanCong();
		return pcList;
	}
	
	// Lấy toàn bộ phân công có sẵn trong SQL
	public ArrayList<PhanCongBean> getPhanCongByDuAn(String MaDuAn) throws Exception{
		pcList=daoPhanCong.getPhanCongByDuAn(MaDuAn);
		return pcList;
	}
	
	// Xóa phân công theo mã đưa vào
	public int Xoa(int ma) throws Exception{
		int kq = daoPhanCong.Xoa(ma);
		pcList = getPhanCong();
		return kq;
	}
	
	// Cập nhật phân công theo mã đưa vào
	public int CapNhat(int MaPhanCong, String MaNhanVien, String MaDuAn, Date NgayStart, Date NgayEnd, String NgayDone, String TienDo) throws Exception{
		int kq = daoPhanCong.CapNhat(MaPhanCong, MaNhanVien, MaDuAn, NgayStart, NgayEnd, NgayDone, TienDo );
		pcList = getPhanCong();
		return kq;
	}
}
