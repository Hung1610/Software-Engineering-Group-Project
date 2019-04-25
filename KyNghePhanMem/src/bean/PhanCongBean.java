package bean;

import java.util.Date;

public class PhanCongBean {
	public PhanCongBean(int maPhanCong, String maNhanVien, String tenNhanVien, String maDuAn, String tenDuAn,
			Date ngayStart, Date ngayEnd, String ngayDone, String tienDo) {
		super();
		MaPhanCong = maPhanCong;
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		MaDuAn = maDuAn;
		TenDuAn = tenDuAn;
		NgayStart = ngayStart;
		NgayEnd = ngayEnd;
		NgayDone = ngayDone;
		TienDo = tienDo;
	}
	public PhanCongBean(int maPhanCong, String maNhanVien, String maDuAn, Date ngayStart, Date ngayEnd, String ngayDone,
			String tienDo) {
		super();
		MaPhanCong = maPhanCong;
		MaNhanVien = maNhanVien;
		MaDuAn = maDuAn;
		NgayStart = ngayStart;
		NgayEnd = ngayEnd;
		NgayDone = ngayDone;
		TienDo = tienDo;
	}
	public PhanCongBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int MaPhanCong;
	private String MaNhanVien;
	private String TenNhanVien;
	private String MaDuAn;
	private String TenDuAn;
	private Date NgayStart;
	private Date NgayEnd;
	private String NgayDone;
	private String TienDo;
	public int getMaPhanCong() {
		return MaPhanCong;
	}
	public void setMaPhanCong(int maPhanCong) {
		MaPhanCong = maPhanCong;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getMaDuAn() {
		return MaDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		MaDuAn = maDuAn;
	}
	public Date getNgayStart() {
		return NgayStart;
	}
	public void setNgayStart(Date ngayStart) {
		NgayStart = ngayStart;
	}
	public Date getNgayEnd() {
		return NgayEnd;
	}
	public void setNgayEnd(Date ngayEnd) {
		NgayEnd = ngayEnd;
	}
	public String getNgayDone() {
		return NgayDone;
	}
	public void setNgayDone(String ngayDone) {
		NgayDone = ngayDone;
	}
	public String getTienDo() {
		return TienDo;
	}
	public void setTienDo(String tienDo) {
		TienDo = tienDo;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	public String getTenDuAn() {
		return TenDuAn;
	}
	public void setTenDuAn(String tenDuAn) {
		TenDuAn = tenDuAn;
	}
	@Override
	public String toString() {
		return "PhanCongBean [toString()=" + super.toString() + "]";
	}
}
