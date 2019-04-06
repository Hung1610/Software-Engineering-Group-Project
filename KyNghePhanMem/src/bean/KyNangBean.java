package bean;


public class KyNangBean {
	public KyNangBean(String maKyNang, String tenKyNang, String chiTiet) {
		super();
		MaKyNang = maKyNang;
		TenKyNang = tenKyNang;
		ChiTiet = chiTiet;
	}
	public KyNangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String MaKyNang;
	private String TenKyNang;
	private String ChiTiet;
	public String getMaKyNang() {
		return MaKyNang;
	}
	public void setMaKyNang(String maKyNang) {
		MaKyNang = maKyNang;
	}
	public String getTenKyNang() {
		return TenKyNang;
	}
	public void setTenKyNang(String tenKyNang) {
		TenKyNang = tenKyNang;
	}
	public String getChiTiet() {
		return ChiTiet;
	}
	public void setChiTiet(String chiTiet) {
		ChiTiet = chiTiet;
	}
	@Override 
	public String toString() {
		return TenKyNang;
	}
}
