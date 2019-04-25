package bean;

import java.util.Date;

public class DuAnBean {
	private String MaDuAn;
	private String TenDuAn;
	private Date NgayBatDau;
	private Date NgayKetThuc;
	private String TinhTrang;
	public String getMaDuAn() {
		return MaDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		MaDuAn = maDuAn;
	}
	public String getTenDuAn() {
		return TenDuAn;
	}
	public void setTenDuAn(String tenDuAn) {
		TenDuAn = tenDuAn;
	}
	public Date getNgayBatDau() {
		return NgayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public DuAnBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DuAnBean(String maDuAn, String tenDuAn, Date ngayBatDau, Date ngayKetThuc, String tinhTrang) {
		super();
		MaDuAn = maDuAn;
		TenDuAn = tenDuAn;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		TinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return getTenDuAn();
	}
	
	
	
}
