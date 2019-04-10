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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import bean.NhanVien;
import bo.NhanVienBo;
import dao.DungChung;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class FormNhanVien {

	JFrame frmQuanLyNhan;
	private JTextField textField_TenNhanVien;
	private JTextField textField_DiaChi;
	private JTextField textField_Sdt;
	private JLabel lblSdt;
	private JLabel lblEmail;
	private JTextField textField_Email;
	private JLabel lblNgySinh;
	private JTextField textField_MaNhanVien;
	JComboBox comboBox_MaNhanVien = new JComboBox();

	NhanVienBo bo = new NhanVienBo();
	ArrayList<NhanVien> nv;
	private JTextField textField_NgaySinh;
	private JButton btnRefresh;
	private JButton btnCapNhat;

	

	/**
	 * Create the application.
	 */
	public FormNhanVien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuanLyNhan = new JFrame();
		frmQuanLyNhan.setResizable(false);
		frmQuanLyNhan.setTitle("Quan Ly Nhan Vien");
		frmQuanLyNhan.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// Mo ket noi voi CSDL
				try {
					DungChung dc = new DungChung();
					dc.KetNoi();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Hien thi combo box MaNhanVien
				try {
					nv = bo.getNhanVien();
					for (NhanVien thongtin : nv) {
						comboBox_MaNhanVien.addItem(thongtin.getMaNhanVien());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				//
			}
		});
		frmQuanLyNhan.setBounds(100, 100, 405, 528);
		frmQuanLyNhan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuanLyNhan.getContentPane().setLayout(null);

		textField_TenNhanVien = new JTextField();
		textField_TenNhanVien.setBounds(111, 50, 116, 22);
		frmQuanLyNhan.getContentPane().add(textField_TenNhanVien);
		textField_TenNhanVien.setColumns(10);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setBounds(111, 184, 116, 22);
		frmQuanLyNhan.getContentPane().add(textField_DiaChi);
		textField_DiaChi.setColumns(10);

		textField_Sdt = new JTextField();
		textField_Sdt.setBounds(111, 251, 116, 22);
		frmQuanLyNhan.getContentPane().add(textField_Sdt);
		textField_Sdt.setColumns(10);

		JLabel lblTn = new JLabel("Tên");
		lblTn.setBounds(12, 53, 56, 16);
		frmQuanLyNhan.getContentPane().add(lblTn);

		JLabel lblNewLabel = new JLabel("Địa chỉ");
		lblNewLabel.setBounds(12, 187, 56, 16);
		frmQuanLyNhan.getContentPane().add(lblNewLabel);

		lblSdt = new JLabel("Sdt");
		lblSdt.setBounds(12, 254, 56, 16);
		frmQuanLyNhan.getContentPane().add(lblSdt);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 326, 56, 16);
		frmQuanLyNhan.getContentPane().add(lblEmail);

		textField_Email = new JTextField();
		textField_Email.setBounds(111, 323, 116, 22);
		frmQuanLyNhan.getContentPane().add(textField_Email);
		textField_Email.setColumns(10);
		comboBox_MaNhanVien.addItemListener(new ItemListener() {
			// hien thi thong tin cua nhan vien sau khi chon ma nhan vien tu combo box
			public void itemStateChanged(ItemEvent arg0) {
				for (NhanVien thongtin : nv) {
					if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
						textField_TenNhanVien.setText(thongtin.getTenNhanVien());
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						String ngay = formatter.format(thongtin.getNgaySinh());
						textField_NgaySinh.setText(ngay.toString());
						textField_DiaChi.setText(thongtin.getDiaChi());
						textField_Sdt.setText(thongtin.getSdt());
						textField_Email.setText(thongtin.getEmail());
					}

				}
			}
		});

		//////////////////////////////////////////////
		comboBox_MaNhanVien.setBounds(121, 10, 81, 22);
		frmQuanLyNhan.getContentPane().add(comboBox_MaNhanVien);

		lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setBounds(12, 115, 56, 16);
		frmQuanLyNhan.getContentPane().add(lblNgySinh);

		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nv.clear();
				try {
					nv = bo.getNhanVien();
					Date ngay = new SimpleDateFormat("dd/MM/yyyy").parse(textField_NgaySinh.getText());
					if (bo.Them(textField_MaNhanVien.getText(), textField_TenNhanVien.getText(),
							ngay, textField_DiaChi.getText(), textField_Sdt.getText(),
							textField_Email.getText()) == 1) {
						int a = JOptionPane.showConfirmDialog(new JFrame(), "Them nhan vien thanh cong", "Thông báo",
								JOptionPane.CLOSED_OPTION);
					}
					textField_MaNhanVien.setText("");
					textField_TenNhanVien.setText("");
					textField_DiaChi.setText("");
					textField_Sdt.setText("");
					textField_Email.setText("");
					textField_NgaySinh.setText("");

				} catch (Exception ee) {
					// TODO Auto-generated catch block
					// ee.printStackTrace();
					int a = JOptionPane.showConfirmDialog(new JFrame(),
							"Mã nhân viên: " + textField_MaNhanVien.getText() + " này đã bị trùng", "Thông báo",
							JOptionPane.CLOSED_OPTION);
				}
			}
		});
		btnThem.setBounds(12, 400, 97, 25);
		frmQuanLyNhan.getContentPane().add(btnThem);

		textField_MaNhanVien = new JTextField();
		textField_MaNhanVien.setBounds(237, 10, 116, 22);
		frmQuanLyNhan.getContentPane().add(textField_MaNhanVien);
		textField_MaNhanVien.setColumns(10);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setBounds(111, 112, 116, 22);
		frmQuanLyNhan.getContentPane().add(textField_NgaySinh);
		textField_NgaySinh.setColumns(10);

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nv.clear();
				comboBox_MaNhanVien.removeAllItems();
				try {
					nv = bo.getNhanVien();
					for (NhanVien thongtin : nv) {
						comboBox_MaNhanVien.addItem(thongtin.getMaNhanVien());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(248, 400, 97, 25);
		frmQuanLyNhan.getContentPane().add(btnRefresh);

		btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(new JFrame(),
						"Bạn có chắc muốn cập nhật nhân viên này ko, thao tác này ko thể hoàn tác", "Xác nhận cập nhật",
						JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					for (NhanVien thongtin : nv) {
						if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
							// nv.remove(thongtin);
							try {
								Date ngay = new SimpleDateFormat("dd/MM/yyyy").parse(textField_NgaySinh.getText());
								bo.CapNhat(comboBox_MaNhanVien.getSelectedItem().toString(),
										textField_TenNhanVien.getText(), ngay, textField_DiaChi.getText(),
										textField_Sdt.getText(), textField_Email.getText());

							} catch (Exception ee) {
								// TODO Auto-generated catch block
								ee.printStackTrace();
							}
							break;
						}
					}
				}
			}
		});
		btnCapNhat.setBounds(139, 400, 97, 25);
		frmQuanLyNhan.getContentPane().add(btnCapNhat);

		JLabel label = new JLabel("Mã nhân viên");
		label.setBounds(12, 10, 81, 22);
		frmQuanLyNhan.getContentPane().add(label);
	}
}
