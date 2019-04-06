package bean;

public class KyNangNhanVienBean {
	private String MaNV;
	private String MaKyNang;
	private String MoTaKhac;
	public KyNangNhanVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KyNangNhanVienBean(String maNV, String maKyNang, String moTaKhac) {
		super();
		MaNV = maNV;
		MaKyNang = maKyNang;
		MoTaKhac = moTaKhac;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaKyNang() {
		return MaKyNang;
	}
	public void setMaKyNang(String maKyNang) {
		MaKyNang = maKyNang;
	}
	public String getMoTaKhac() {
		return MoTaKhac;
	}
	public void setMoTaKhac(String moTaKhac) {
		MoTaKhac = moTaKhac;
	}
	
}
