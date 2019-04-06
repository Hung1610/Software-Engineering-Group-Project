package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.DuAnBean;
import bean.NhanVien;
import dao.DuAnDao;

public class DuAnBo {
	DuAnDao duandao = new DuAnDao();
	public ArrayList<DuAnBean> da;
	public int Them(String MaDuAn,String TenDuAn,Date NgayBatDau, Date NgayKetThuc,String TinhTrang) throws Exception {
			
		for(DuAnBean thongtin : da) {
			if(thongtin.getMaDuAn().equals(MaDuAn)) {
				return 0;
			}
			else {
				duandao.CapNhat(MaDuAn, TenDuAn, NgayBatDau, NgayKetThuc, TinhTrang);
				return 1;
			}
		}
		return 1;
	}
	public int Xoa(String ma) throws Exception{
		int kq = duandao.Xoa(ma);
		for(DuAnBean thongtin : da) {
			if (thongtin.getMaDuAn().equals(ma)) {
				da.remove(thongtin);
				break;
			}
		}
		return kq;
	}
	public int CapNhat(String MaDuAn,String TenDuAn,Date NgayBatDau, Date NgayKetThuc,String TinhTrang) throws Exception {
		int kq= duandao.CapNhat(MaDuAn, TenDuAn, NgayBatDau, NgayKetThuc, TinhTrang);
		for(DuAnBean thongtin : da) {
			if(thongtin.getMaDuAn().equals(MaDuAn)) {
				thongtin.setTenDuAn(TenDuAn);
				thongtin.setNgayBatDau(NgayBatDau);
				thongtin.setNgayKetThuc(NgayKetThuc);
				thongtin.setTinhTrang(TinhTrang);
			}
			break;
		}
		return kq;
		
	}
	public ArrayList<DuAnBean> getDuAn() throws Exception {
		da=duandao.getDuAn();
		return da;
	}
}
