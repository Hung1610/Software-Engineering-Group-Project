package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.DuAnBean;
import bean.NhanVienBean;
import dao.DuAnDao;

public class DuAnBo {
	DuAnDao duandao = new DuAnDao();
	public ArrayList<DuAnBean> da;
	
	// Thêm dự án vào SQL
	public int Them(String MaDuAn,String TenDuAn,Date NgayBatDau, Date NgayKetThuc,String TinhTrang) throws Exception {
		for(DuAnBean thongtin : da) {
			if(thongtin.getMaDuAn().equals(MaDuAn)) {
				return 0;
			}
		}
		duandao.Them(MaDuAn, TenDuAn, NgayBatDau, NgayKetThuc, TinhTrang);
		da = getDuAn();
		return 1;
	}
	
	// Xóa dự án khỏi SQL theo mã đưa vào
	public int Xoa(String ma) throws Exception{
		int kq = duandao.Xoa(ma);
		da = getDuAn();
		return kq;
	}
	
	// Cập nhật dự án theo mã đưa vào
	public int CapNhat(String MaDuAn,String TenDuAn,Date NgayBatDau, Date NgayKetThuc,String TinhTrang) throws Exception {
		int kq= duandao.CapNhat(MaDuAn, TenDuAn, NgayBatDau, NgayKetThuc, TinhTrang);
		da = getDuAn();
		return kq;
	}
	
	// Lấy toàn bộ dự án có sẵn trong SQL
	public ArrayList<DuAnBean> getDuAn() throws Exception {
		da= duandao.getDuAn();
		return da;
	}
}
