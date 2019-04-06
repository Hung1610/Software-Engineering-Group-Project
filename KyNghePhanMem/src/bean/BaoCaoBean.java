package bean;

public class BaoCaoBean {
	private String MaPhanCong;
	private String SoNgayDaLamViec;
	private String TienDo;
	public String getMaPhanCong() {
		return MaPhanCong;
	}
	public void setMaPhanCong(String maPhanCong) {
		MaPhanCong = maPhanCong;
	}
	public String getSoNgayDaLamViec() {
		return SoNgayDaLamViec;
	}
	public void setSoNgayDaLamViec(String soNgayDaLamViec) {
		SoNgayDaLamViec = soNgayDaLamViec;
	}
	public String getTienDo() {
		return TienDo;
	}
	public void setTienDo(String tienDo) {
		TienDo = tienDo;
	}
	public BaoCaoBean(String maPhanCong, String soNgayDaLamViec, String tienDo) {
		super();
		MaPhanCong = maPhanCong;
		SoNgayDaLamViec = soNgayDaLamViec;
		TienDo = tienDo;
	}
	
	
}
