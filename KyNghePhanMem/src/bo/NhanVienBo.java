package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.NhanVien;
import dao.NhanVienDao;

public class NhanVienBo {
	NhanVienDao nhanviendao= new NhanVienDao();
	public ArrayList<NhanVien> nv;
	
	public int Them(String MaNhanVien, String TenNhanVien,Date NgaySinh, String DiaChi, String Sdt, String Email) throws Exception{
		
		for(NhanVien thongtin : nv) {
			if(thongtin.getMaNhanVien().equals(MaNhanVien)) 
				return 0;
			else {
				nhanviendao.Them(MaNhanVien, TenNhanVien, NgaySinh, DiaChi, Sdt, Email);
				return 1;
				
			}
		}
		return 1;
	}
	
	public ArrayList<NhanVien> getNhanVien() throws Exception{
		nv=nhanviendao.getNhanVien();
		return nv;
	}
	
	public int Xoa(String ma) throws Exception{
		int kq = nhanviendao.Xoa(ma);
		for(NhanVien thongtin : nv) {
			if (thongtin.getMaNhanVien().equals(ma)) {
				nv.remove(thongtin);
				break;
			}
		}
		return kq;
	}
	
	public int CapNhat(String MaNhanVien, String TenNhanVien, Date NgaySinh, String DiaChi, String Sdt, String Email) throws Exception{
		int kq = nhanviendao.CapNhat(MaNhanVien, TenNhanVien, NgaySinh, DiaChi, Sdt, Email);
		for(NhanVien thongtin : nv) {
			if(thongtin.getMaNhanVien().equals(MaNhanVien)) {
				thongtin.setTenNhanVien(TenNhanVien);
				thongtin.setNgaySinh(NgaySinh);
				thongtin.setDiaChi(DiaChi);
				thongtin.setSdt(Sdt);
				thongtin.setEmail(Email);
			}
			break;
		}
		return kq;
	}
	
}
