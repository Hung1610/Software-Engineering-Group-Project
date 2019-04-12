package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import bean.NhanVien;
import bo.NhanVienBo;
import dao.DungChung;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.Option;
import javax.swing.event.ChangeEvent;

public class Form_02_NhanVienNangCao {

	JFrame frmQuanLyNhanVien;

	private JTextField textField_TenNhanVien;
	private JTextField textField_DiaChi;
	private JTextField textField_Sdt;
	private JTextField textField_Email;
	private JLabel lblSdt;
	private JLabel lblEmail;
	private JLabel lblNgySinh;

	private JTextField textField_Add_MaNhanVien;
	private JTextField textField_Add_TenNhanVien;
	private JTextField textField_Add_DiaChi;
	private JTextField textField_Add_Sdt;
	private JTextField textField_Add_Email;

	private JButton btnRefresh;
	private JButton btnCapNhat;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnXacNhanThayDoi;

	private JCalendar calendar_Them;
	private JCalendar calendar_thongtin;
	
	private JComboBox comboBox_MaNhanVien;

	NhanVienBo bo = new NhanVienBo();
	ArrayList<NhanVien> nv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_02_NhanVienNangCao window = new Form_02_NhanVienNangCao();
					window.frmQuanLyNhanVien.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form_02_NhanVienNangCao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuanLyNhanVien = new JFrame();
		frmQuanLyNhanVien.setResizable(false);
		frmQuanLyNhanVien.setTitle("Quản Lý Nhân Viên");
		frmQuanLyNhanVien.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				moKetNoiCSDL();

				hienThiComboBoxMaNV(comboBox_MaNhanVien);
			}
		});
		frmQuanLyNhanVien.setBounds(100, 100, 492, 530);
		frmQuanLyNhanVien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuanLyNhanVien.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 462, 481);
		frmQuanLyNhanVien.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Thông tin", null, panel, null);
		panel.setLayout(null);

		JLabel label = new JLabel("Mã nhân viên");
		label.setBounds(41, 13, 81, 22);
		panel.add(label);
		comboBox_MaNhanVien = new JComboBox();
		comboBox_MaNhanVien.setBounds(127, 13, 164, 22);
		panel.add(comboBox_MaNhanVien);

		JLabel lblTn = new JLabel("Tên");
		lblTn.setBounds(41, 47, 56, 16);
		panel.add(lblTn);

		textField_TenNhanVien = new JTextField();
		textField_TenNhanVien.setEditable(false);
		textField_TenNhanVien.setBounds(127, 44, 164, 22);
		panel.add(textField_TenNhanVien);
		textField_TenNhanVien.setColumns(10);

		lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setBounds(41, 74, 56, 16);
		panel.add(lblNgySinh);

		JLabel lblNewLabel = new JLabel("Địa chỉ");
		lblNewLabel.setBounds(41, 239, 56, 16);
		panel.add(lblNewLabel);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setEditable(false);
		textField_DiaChi.setBounds(127, 236, 164, 22);
		panel.add(textField_DiaChi);
		textField_DiaChi.setColumns(10);

		lblSdt = new JLabel("Sdt");
		lblSdt.setBounds(41, 266, 56, 16);
		panel.add(lblSdt);

		textField_Sdt = new JTextField();
		textField_Sdt.setEditable(false);
		textField_Sdt.setBounds(127, 263, 164, 22);
		panel.add(textField_Sdt);
		textField_Sdt.setColumns(10);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(41, 293, 56, 16);
		panel.add(lblEmail);

		textField_Email = new JTextField();
		textField_Email.setEditable(false);
		textField_Email.setBounds(127, 290, 164, 22);
		panel.add(textField_Email);
		textField_Email.setColumns(10);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(hienThiIconForm("/images/delete.png"));
		btnXoa.setBounds(12, 363, 97, 25);
		panel.add(btnXoa);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(hienThiIconForm("/images/refresh.png"));
		btnRefresh.setBounds(323, 363, 122, 25);
		panel.add(btnRefresh);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(hienThiIconForm("/images/update.png"));
		btnCapNhat.setBounds(127, 363, 184, 25);
		panel.add(btnCapNhat);

		btnXacNhanThayDoi = new JButton("Xác Nhận Thay Đổi");
		btnXacNhanThayDoi.setIcon(hienThiIconForm("/images/tick.png"));
		btnXacNhanThayDoi.setEnabled(false);
		btnXacNhanThayDoi.setBounds(139, 401, 164, 37);
		panel.add(btnXacNhanThayDoi);
		
		calendar_thongtin = new JCalendar();
		calendar_thongtin.setBounds(127, 73, 198, 155);
		panel.add(calendar_thongtin);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thêm Nhân Viên", null, panel_1, null);
		panel_1.setLayout(null);

		calendar_Them = new JCalendar();
		calendar_Them.setBounds(129, 86, 198, 155);
		panel_1.add(calendar_Them);
		calendar_Them.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(hienThiIconForm("/images/add.png"));
		btnThem.setBounds(298, 395, 149, 47);
		panel_1.add(btnThem);

		textField_Add_MaNhanVien = new JTextField();
		textField_Add_MaNhanVien.setBounds(131, 13, 175, 22);
		panel_1.add(textField_Add_MaNhanVien);
		textField_Add_MaNhanVien.setColumns(10);

		JLabel label_1 = new JLabel("Mã nhân viên");
		label_1.setBounds(41, 13, 81, 22);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Tên");
		label_2.setBounds(41, 47, 56, 16);
		panel_1.add(label_2);

		textField_Add_TenNhanVien = new JTextField();
		textField_Add_TenNhanVien.setColumns(10);
		textField_Add_TenNhanVien.setBounds(131, 48, 175, 22);
		panel_1.add(textField_Add_TenNhanVien);

		JLabel label_3 = new JLabel("Ngày sinh");
		label_3.setBounds(41, 86, 56, 16);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Địa chỉ");
		label_4.setBounds(41, 255, 56, 16);
		panel_1.add(label_4);

		textField_Add_DiaChi = new JTextField();
		textField_Add_DiaChi.setColumns(10);
		textField_Add_DiaChi.setBounds(129, 252, 177, 22);
		panel_1.add(textField_Add_DiaChi);

		JLabel label_5 = new JLabel("Sdt");
		label_5.setBounds(41, 288, 56, 16);
		panel_1.add(label_5);

		textField_Add_Sdt = new JTextField();
		textField_Add_Sdt.setColumns(10);
		textField_Add_Sdt.setBounds(127, 285, 179, 22);
		panel_1.add(textField_Add_Sdt);

		JLabel label_6 = new JLabel("Email");
		label_6.setBounds(41, 321, 56, 16);
		panel_1.add(label_6);

		textField_Add_Email = new JTextField();
		textField_Add_Email.setColumns(10);
		textField_Add_Email.setBounds(127, 318, 179, 22);
		panel_1.add(textField_Add_Email);

		// bam vao nut cap nhat thi se bat dau cap nhat, de dung cap nhat an nut nay
		// them 1 lan nua
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiNutCapNhat();
			}
		});

		// refresh thong tin nhan vien
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});

		// Xoa 1 nhan vien, co xac nhan xoa
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xoaNhanVien();
			}
		});

		// Neu dong y thay doi thi bam nut xac nhan thay doi
		btnXacNhanThayDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				capNhat();
			}
		});

		// them ma nhan vien vao combo box
		comboBox_MaNhanVien.addItemListener(new ItemListener() {
			// hien thi thong tin cua nhan vien sau khi chon ma nhan vien tu combo box
			public void itemStateChanged(ItemEvent arg0) {
				hienThiTextfield();
			}
		});

		// them nhan vien, neu thanh cong thi cac textfield ve rong, them ko thanh cong
		// thi se hien thi thong bao trung ma
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				themNhanVien();
			}
		});

	}

	public void moKetNoiCSDL() {
		try {
			DungChung dc = new DungChung();
			dc.KetNoi();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void themNhanVienVaoArrayList() {
		try {
			nv = bo.getNhanVien();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hienThiComboBoxMaNV(JComboBox comboBox) {
		themNhanVienVaoArrayList();
		for (NhanVien thongtinnhanvien : nv) {
			comboBox.addItem(thongtinnhanvien.getMaNhanVien());
		}
	}

	// Them nhan vien
	public void themNhanVien() {
		nv.clear();
		try {
			nv = bo.getNhanVien();
			if (bo.Them(textField_Add_MaNhanVien.getText(), textField_Add_TenNhanVien.getText(),
					calendar_Them.getDate(), textField_Add_DiaChi.getText(), textField_Add_Sdt.getText(),
					textField_Add_Email.getText()) == 1) {

				formThongBao("Thêm ok");

				clearTextfieldThemNhanVien();
			}

			else {
				formThongBao("Trùng mã");
			}
		} catch (Exception ee) {

		}
	}

	// Xoa nhan vien
	public void xoaNhanVien() {
		int xacnhancapnhat = formThongBao("Xóa");
		if (xacnhancapnhat == JOptionPane.YES_OPTION) {
			for (NhanVien thongtin : nv) {
				if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
					try {
						bo.Xoa(comboBox_MaNhanVien.getSelectedItem().toString());
					} catch (Exception e) {

						formThongBao("Lỗi xóa");
					}
					break;
				}
			}
		}
	}

	// Xu li cho nut xac nhan thay doi
	public void capNhat() {
		int kiemtracapnhat = formThongBao("Cập nhật");
		if (kiemtracapnhat == JOptionPane.YES_OPTION) {

			capNhatThongTinNhanVien();
		}
	}

	public void capNhatThongTinNhanVien() {
		for (NhanVien thongtinnhanvien : nv) {
			if (thongtinnhanvien.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {

				capNhatCSDLNhanVien();
				break;
			}
		}
	}

	public void capNhatCSDLNhanVien() {
		try {
			bo.CapNhat(comboBox_MaNhanVien.getSelectedItem().toString(), textField_TenNhanVien.getText(),
					calendar_thongtin.getDate(), textField_DiaChi.getText(), textField_Sdt.getText(),
					textField_Email.getText().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Ket thuc nut xac nhan thay doi

	// Refresh lai thong tin
	public void refresh() {
		nv.clear();
		comboBox_MaNhanVien.removeAllItems();
		hienThiComboBoxMaNV(comboBox_MaNhanVien);
	}

	// Hien thi cac form thong bao
	public int formThongBao(String noidungthongbao) {
		if (noidungthongbao.equals("Xóa")) {
			return JOptionPane.showConfirmDialog(new JFrame(),
					"Bạn có chắc muốn xóa nhân viên này ko, thao tác này ko thể hoàn tác", "Xác nhận xóa",
					JOptionPane.YES_NO_OPTION);
		}

		if (noidungthongbao.equals("Cập nhật")) {
			return JOptionPane.showConfirmDialog(new JFrame(),
					"Bạn có chắc muốn cập nhật nhân viên này ko, thao tác này ko thể hoàn tác", "Xác nhận cập nhật",
					JOptionPane.YES_NO_OPTION);
		}
		if (noidungthongbao.equals("Lỗi xóa")) {
			JOptionPane.showMessageDialog(new JFrame(), "Có lỗi xảy ra ko xóa được, liên quan khóa ngoài", "Thông báo",
					JOptionPane.CLOSED_OPTION);
		}

		if (noidungthongbao.equals("Thêm ok")) {
			JOptionPane.showConfirmDialog(new JFrame(), "Thêm nhân viên thành công", "Thông báo",
					JOptionPane.CLOSED_OPTION);
		}

		if (noidungthongbao.equals("Trùng mã")) {
			JOptionPane.showConfirmDialog(new JFrame(),
					"Mã nhân viên: " + textField_Add_MaNhanVien.getText() + " này đã bị trùng", "Thông báo",
					JOptionPane.CLOSED_OPTION);
		}
		return 1;
	}

	public void hienThiTextfield() {
		for (NhanVien thongtin : nv) {
			if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
				textField_TenNhanVien.setText(thongtin.getTenNhanVien());
				calendar_thongtin.setDate(thongtin.getNgaySinh());
				textField_DiaChi.setText(thongtin.getDiaChi());
				textField_Sdt.setText(thongtin.getSdt());
				textField_Email.setText(thongtin.getEmail());
			}
		}
	}

	public void clearTextfieldThemNhanVien() {
		textField_Add_MaNhanVien.setText("");
		textField_Add_TenNhanVien.setText("");
		textField_Add_DiaChi.setText("");
		textField_Add_Sdt.setText("");
		textField_Add_Email.setText("");
		calendar_Them.setDate(new Date());
	}

	public void hienThiNutCapNhat() {
		if (btnCapNhat.getText().equals("Cập nhật")) {
			textField_TenNhanVien.setEditable(true);
			// textField_NgaySinh.setEditable(true);
			textField_DiaChi.setEditable(true);
			textField_Sdt.setEditable(true);
			textField_Email.setEditable(true);
			btnXacNhanThayDoi.setEnabled(true);
			btnRefresh.setEnabled(false);
			btnXoa.setEnabled(false);
			btnCapNhat.setText("Dừng cập nhật");
		} else {
			btnCapNhat.setText("Cập nhật");
			btnXacNhanThayDoi.setEnabled(false);
			btnRefresh.setEnabled(true);
			btnXoa.setEnabled(true);
			textField_TenNhanVien.setEditable(false);
			// textField_NgaySinh.setEditable(false);
			textField_DiaChi.setEditable(false);
			textField_Sdt.setEditable(false);
			textField_Email.setEditable(false);
		}
	}

	public ImageIcon hienThiIconForm(String linkIcon) {
		return new ImageIcon(getClass().getResource(linkIcon));
	}
}
