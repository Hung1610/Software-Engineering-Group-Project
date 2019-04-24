package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;
import dao.NhanVienDao;

public class NhanVienBo {
	NhanVienDao nhanviendao= new NhanVienDao();
	public ArrayList<NhanVienBean> nv;
	
	// Thêm nhân viên vào SQL
	public int Them(String MaNhanVien, String TenNhanVien,Date NgaySinh, String DiaChi, String Sdt, String Email) throws Exception{
		for(NhanVienBean thongtin : nv) {
			if(thongtin.getMaNhanVien().equals(MaNhanVien)) 
				return 0;
		}
		nhanviendao.Them(MaNhanVien, TenNhanVien, NgaySinh, DiaChi, Sdt, Email);
		nv = getNhanVien();
		return 1;
	}
	
	// Lấy toàn bộ nhân viên từ SQL
	public ArrayList<NhanVienBean> getNhanVien() throws Exception{
		nv= nhanviendao.getNhanVien();
		return nv;
	}
	
	// Xóa nhân viên theo mã đưa vào
	public int Xoa(String ma) throws Exception{
		int kq = nhanviendao.Xoa(ma);
		nv= getNhanVien();
		return kq;
	}
	
	// Cập nhật nhân viên theo mã đưa vào
	public int CapNhat(String MaNhanVien, String TenNhanVien, Date NgaySinh, String DiaChi, String Sdt, String Email) throws Exception{
		int kq = nhanviendao.CapNhat(MaNhanVien, TenNhanVien, NgaySinh, DiaChi, Sdt, Email);
		nv= getNhanVien();
		return kq;
	}
	
}
