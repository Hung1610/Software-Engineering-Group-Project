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

	JFrame frmQuanLyNhan;
	private JTextField textField_TenNhanVien;
	private JTextField textField_DiaChi;
	private JTextField textField_Sdt;
	private JLabel lblSdt;
	private JLabel lblEmail;
	private JTextField textField_Email;
	private JLabel lblNgySinh;
	private JTextField textField_Add_MaNhanVien;
	JCalendar calendar_1 = new JCalendar();
	JComboBox comboBox_MaNhanVien = new JComboBox();

	NhanVienBo bo = new NhanVienBo();
	ArrayList<NhanVien> nv;
	private JButton btnRefresh;
	private JButton btnCapNhat;
	private JTextField textField_Add_TenNhanVien;
	private JTextField textField_Add_DiaChi;
	private JTextField textField_Add_Sdt;
	private JTextField textField_Add_Email;

	/**
	 * Launch the application.
	 */

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
		frmQuanLyNhan.setBounds(100, 100, 492, 530);
		frmQuanLyNhan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuanLyNhan.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 462, 481);
		frmQuanLyNhan.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Thong tin", null, panel, null);
		panel.setLayout(null);

		JLabel label = new JLabel("Mã nhân viên");
		label.setBounds(41, 13, 81, 22);
		panel.add(label);
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


		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("images/delete.png"));

		btnXoa.setBounds(12, 363, 97, 25);
		panel.add(btnXoa);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon("images/refresh.png"));
		btnRefresh.setBounds(323, 363, 122, 25);
		panel.add(btnRefresh);


		btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.setBounds(175, 363, 97, 25);
		panel.add(btnCapNhat);


		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(new ImageIcon("images/update.png"));
		btnCapNhat.setBounds(162, 363, 122, 25);
		panel.add(btnCapNhat);
		
		//Neu dong y thay doi thi bam nut xac nhan thay doi
		JButton btnXacNhanThayDoi = new JButton("Xác Nhận Thay Đổi");
		btnXacNhanThayDoi.setIcon(new ImageIcon("images/tick.png"));

		btnXacNhanThayDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showConfirmDialog(new JFrame(),
						"Bạn có chắc muốn cập nhật nhân viên này ko, thao tác này ko thể hoàn tác", "Xác nhận cập nhật",
						JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					for (NhanVien thongtin : nv) {
						if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
							// ngay textbox doi thanh calendar.
							// Date ngay = new
							// SimpleDateFormat("dd/MM/yyyy").parse(textField_NgaySinh.getText());
							try {
								// ngay textbox doi thanh calendar.
								bo.CapNhat(comboBox_MaNhanVien.getSelectedItem().toString(),
										textField_TenNhanVien.getText(), calendar_1.getDate(),
										textField_DiaChi.getText(), textField_Sdt.getText(),
										textField_Email.getText().toString());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {

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
		btnXacNhanThayDoi.setEnabled(false);
		btnXacNhanThayDoi.setBounds(139, 401, 164, 37);
		panel.add(btnXacNhanThayDoi);

		calendar_1.setBounds(127, 73, 198, 155);
		panel.add(calendar_1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Them Nhan Vien", null, panel_1, null);
		panel_1.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(129, 86, 198, 155);
		panel_1.add(calendar);
		calendar.setBorder(new LineBorder(new Color(0, 0, 0)));



		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("images/add.png"));

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

		// them nhan vien, neu thanh cong thi cac textfield ve rong, them ko thanh cong
		// thi se hien thi thong bao trung ma
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nv.clear();

				try {
					nv = bo.getNhanVien();
					// nv.g
					if (bo.Them(textField_Add_MaNhanVien.getText(), textField_Add_TenNhanVien.getText(),
							calendar.getDate(), textField_Add_DiaChi.getText(), textField_Add_Sdt.getText(),
							textField_Add_Email.getText()) == 1) {
						int a = JOptionPane.showConfirmDialog(new JFrame(), "Them nhan vien thanh cong", "Thông báo",
								JOptionPane.CLOSED_OPTION);
					}
					textField_Add_MaNhanVien.setText("");
					textField_Add_TenNhanVien.setText("");
					textField_Add_DiaChi.setText("");
					textField_Add_Sdt.setText("");
					textField_Add_Email.setText("");
					calendar.setDate(new Date());

				} catch (Exception ee) {
					// TODO Auto-generated catch block
					// ee.printStackTrace();
					int a = JOptionPane.showConfirmDialog(new JFrame(),
							"Mã nhân viên: " + textField_Add_MaNhanVien.getText() + " này đã bị trùng", "Thông báo",
							JOptionPane.CLOSED_OPTION);
				}
			}
		});

		// bam vao nut cap nhat thi se bat dau cap nhat, de dung cap nhat an nut nay
		// them 1 lan nua
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnCapNhat.getText().equals("Cap Nhat")) {
					textField_TenNhanVien.setEditable(true);
					// textField_NgaySinh.setEditable(true);
					textField_DiaChi.setEditable(true);
					textField_Sdt.setEditable(true);
					textField_Email.setEditable(true);
					btnXacNhanThayDoi.setEnabled(true);
					btnRefresh.setEnabled(false);
					btnXoa.setEnabled(false);
					btnCapNhat.setText("Dung Cap Nhat");
				} else {
					btnCapNhat.setText("Cap Nhat");
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
		});

		// refresh thong tin nhan vien
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

		// Xoa 1 nhan vien, co xac nhan xoa
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showConfirmDialog(new JFrame(),
						"Bạn có chắc muốn xóa nhân viên này, thao tác này ko thể hoàn tác", "Xác nhận xóa",
						JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					for (NhanVien thongtin : nv) {
						if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
							// nv.remove(thongtin);
							try {
								bo.Xoa(comboBox_MaNhanVien.getSelectedItem().toString());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		});

		// them ma nhan vien vao combo box
		comboBox_MaNhanVien.addItemListener(new ItemListener() {
			// hien thi thong tin cua nhan vien sau khi chon ma nhan vien tu combo box
			public void itemStateChanged(ItemEvent arg0) {
				for (NhanVien thongtin : nv) {
					if (thongtin.getMaNhanVien().equals(comboBox_MaNhanVien.getSelectedItem().toString())) {
						textField_TenNhanVien.setText(thongtin.getTenNhanVien());
						// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						// String ngay = formatter.format(thongtin.getNgaySinh());
						calendar_1.setDate(thongtin.getNgaySinh());
						// textField_NgaySinh.setText(ngay.toString());
						textField_DiaChi.setText(thongtin.getDiaChi());
						textField_Sdt.setText(thongtin.getSdt());
						textField_Email.setText(thongtin.getEmail());
					}

				}
			}
		});
	}
}
