package bean;

import java.util.Date;

public class NhanVien {
	private String MaNhanVien;
	private String TenNhanVien;
	private Date NgaySinh;
	private String DiaChi;
	private String Sdt;
	private String Email;
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, Date ngaySinh, String diaChi, String sdt, String email) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		Sdt = sdt;
		Email = email;
	}
	
	
	
}
