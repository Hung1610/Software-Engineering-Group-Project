package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.DuAnBean;
import bean.NhanVienBean;
import bean.PhanCongBean;
import bo.DuAnBo;
import bo.NhanVienBo;
import bo.PhanCongBo;
import dao.DungChung;

import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JCalendar;

public class Form_05_PhanCong {

	DungChung dc = new DungChung();

	private DuAnBo boDuAn = new DuAnBo();
	private NhanVienBo boNhanVien = new NhanVienBo();
	private PhanCongBo boPhanCong = new PhanCongBo();
	
	public JFrame frame;
	private JTable tablePhanCong;
	private JTextField txtMaPC;
	private JTextField txtTienDo;
	private JComboBox cmbDuAn;
	private JComboBox cmbNhanVien;
	private JComboBox cmbFilterDuAn;
	private JSpinner spnSoNgay;
	private JCalendar cldStart;
	private JCalendar cldEnd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Set Look and Feel.
				try {
					  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch(Exception e) {
					  System.out.println("Error setting native LookAndFeel: " + e);
				}
				//
				try {
					Form_05_PhanCong window = new Form_05_PhanCong();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form_05_PhanCong() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					dc.KetNoi();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				getListPhanCong();
				hienThiComboBoxDuAn(cmbDuAn);
				hienThiComboBoxDuAnFilter(cmbFilterDuAn);
				hienThiComboBoxNhanVien(cmbNhanVien);
					/*
					tableModel.addColumn("Mã Phân Công");
					tableModel.addColumn("Dự Án");
					tableModel.addColumn("Nhân Viên");
					tableModel.addColumn("Ngày Bắt Đầu");
					tableModel.addColumn("Ngày Kết Thúc");
					tableModel.addColumn("Số Ngày Làm Việc");
					tableModel.addColumn("Tiến Độ");
					*/


				// hienThiComboBoxDuAn(cmbProject);
			}
		});
		
		frame.setBounds(100, 100, 823, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 787, 442);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Thông tin phân công", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 74, 762, 329);
		panel.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Bảng phân công", null, scrollPane, null);
		
		tablePhanCong = new JTable();
		tablePhanCong.setModel( new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Mã Phân Công","D\u1EF1 \u00C1n", "Nh\u00E2n Vi\u00EAn", "Ng\u00E0y B\u1EAFt \u0110\u1EA7u",  "Ng\u00E0y K\u1EBFt Th\u00FAc", "S\u1ED1 Ng\u00E0y \u0110\u00E3 L\u00E0m Vi\u1EC7c", "Ti\u1EBFn \u0110\u1ED9"
				}
			){
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		tablePhanCong.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablePhanCong);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				int row = tablePhanCong.getSelectedRow();
				txtMaPC.setText(tablePhanCong.getModel().getValueAt(row, 0).toString());
				txtTienDo.setText(tablePhanCong.getModel().getValueAt(row, 6).toString());
				spnSoNgay.setValue(Integer.parseInt(tablePhanCong.getModel().getValueAt(row, 5).toString()));
				cmbDuAn.setSelectedItem(tablePhanCong.getModel().getValueAt(row, 1).toString());
				cmbNhanVien.setSelectedItem(tablePhanCong.getModel().getValueAt(row, 2).toString());
				try {
					cldStart.setDate(formatter.parse(tablePhanCong.getModel().getValueAt(row, 3).toString()));
					cldEnd.setDate(formatter.parse(tablePhanCong.getModel().getValueAt(row, 4).toString()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCpNht.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/save.png")));
		btnCpNht.setBounds(543, 11, 115, 39);
		panel.add(btnCpNht);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tablePhanCong.getSelectedRow();
				int ma = Integer.parseInt(tablePhanCong.getModel().getValueAt(row, 0).toString());
				try {
					boPhanCong.Xoa(ma);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cmbFilterDuAn.setSelectedIndex(0);
			}
		});
		btnXa.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/delete.png")));
		btnXa.setBounds(657, 11, 115, 39);
		panel.add(btnXa);
		
		cmbFilterDuAn = new JComboBox();
		cmbFilterDuAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbFilterDuAn.getSelectedIndex() == 0){
					getListPhanCong();
				}
				else {
					getListPhanCongByDuAn();
				}
			}
		});
		cmbFilterDuAn.setBounds(70, 12, 177, 20);
		panel.add(cmbFilterDuAn);
		
		JLabel lblNewLabel = new JLabel("Dự Án");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 9, 137, 23);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thêm/sửa phân công", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtMaPC = new JTextField();
		txtMaPC.setEditable(false);
		txtMaPC.setBounds(289, 13, 70, 20);
		panel_1.add(txtMaPC);
		txtMaPC.setColumns(10);
		
		JLabel lblMaPhanCong = new JLabel("Mã Phân Công");
		lblMaPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaPhanCong.setBounds(122, 11, 130, 20);
		panel_1.add(lblMaPhanCong);
		
		cmbDuAn = new JComboBox();
		cmbDuAn.setBounds(132, 171, 192, 20);
		panel_1.add(cmbDuAn);
		
		cmbNhanVien = new JComboBox();
		cmbNhanVien.setBounds(429, 171, 186, 20);
		panel_1.add(cmbNhanVien);
		
		JLabel lblDuAn = new JLabel("Dự Án");
		lblDuAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuAn.setBounds(122, 146, 70, 14);
		panel_1.add(lblDuAn);
		
		JLabel lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhanVien.setBounds(405, 146, 121, 14);
		panel_1.add(lblNhanVien);
		
		JLabel lblTienDo = new JLabel("Tiến Độ");
		lblTienDo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienDo.setBounds(122, 56, 70, 14);
		panel_1.add(lblTienDo);
		
		spnSoNgay = new JSpinner();
		spnSoNgay.setBounds(289, 96, 70, 20);
		panel_1.add(spnSoNgay);
		
		JLabel lblSNgy = new JLabel("Số ngày đã làm việc");
		lblSNgy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSNgy.setBounds(122, 97, 152, 14);
		panel_1.add(lblSNgy);
		
		cldStart = new JCalendar();
		cldStart.setBounds(134, 231, 198, 155);
		panel_1.add(cldStart);
		
		cldEnd = new JCalendar();
		cldEnd.setBounds(429, 231, 198, 155);
		panel_1.add(cldEnd);
		
		JLabel lblNgyBtu = new JLabel("Ngày Bắt Đầu");
		lblNgyBtu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyBtu.setBounds(121, 206, 121, 14);
		panel_1.add(lblNgyBtu);
		
		JLabel lblNgyKtThc = new JLabel("Ngày Kết Thúc");
		lblNgyKtThc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyKtThc.setBounds(405, 206, 121, 14);
		panel_1.add(lblNgyKtThc);
		
		txtTienDo = new JTextField();
		txtTienDo.setBounds(289, 55, 70, 20);
		panel_1.add(txtTienDo);
		txtTienDo.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				DuAnBean selecteDuAn = (DuAnBean) cmbDuAn.getSelectedItem();
				NhanVienBean selectedNV = (NhanVienBean) cmbNhanVien.getSelectedItem();
				
				int MaPhanCong = Integer.parseInt(txtMaPC.getText());
				String tienDo = txtTienDo.getText();
				String soNgay = spnSoNgay.getValue().toString();
				String maDuAn = selecteDuAn.getMaDuAn();
				String maNhanVien = selectedNV.getMaNhanVien();
				Date startDate = cldStart.getDate();
				Date endDate = cldEnd.getDate();
				
				try {
					boPhanCong.CapNhat(MaPhanCong, maNhanVien, maDuAn, startDate, endDate, soNgay, tienDo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				getListPhanCong();
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnSave.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/save.png")));
		btnSave.setBounds(429, 52, 186, 40);
		panel_1.add(btnSave);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DuAnBean selecteDuAn = (DuAnBean) cmbDuAn.getSelectedItem();
				NhanVienBean selectedNV = (NhanVienBean) cmbNhanVien.getSelectedItem();
				
				//int MaPhanCong = Integer.parseInt(txtMaPC.getText());
				String tienDo = txtTienDo.getText();
				String soNgay = spnSoNgay.getValue().toString();
				String maDuAn = selecteDuAn.getMaDuAn();
				String maNhanVien = selectedNV.getMaNhanVien();
				Date startDate = cldStart.getDate();
				Date endDate = cldEnd.getDate();
				
				try {
					boPhanCong.Them(maNhanVien, maDuAn, startDate, endDate, soNgay, tienDo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				getListPhanCong();
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAdd.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/add.png")));
		btnAdd.setBounds(429, 12, 186, 40);
		panel_1.add(btnAdd);
	}

	
	private void getListPhanCong(){
		DefaultTableModel model = (DefaultTableModel) tablePhanCong.getModel();
		model.setRowCount(0);
		ArrayList<PhanCongBean> pcList;
		try {
			pcList = boPhanCong.getPhanCong();
			for(PhanCongBean pc : pcList) {
				Object[] t = new Object[7];
				t[0] = pc.getMaPhanCong();
				t[1] = pc.getTenDuAn();
				t[2] = pc.getTenNhanVien();
				t[3] = pc.getNgayStart();
				t[4] = pc.getNgayEnd();
				t[5] = pc.getNgayDone();
				t[6] = pc.getTienDo();
				model.addRow(t);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void getListPhanCongByDuAn(){
		DefaultTableModel model = (DefaultTableModel) tablePhanCong.getModel();
		model.setRowCount(0);
		ArrayList<PhanCongBean> pcList;
		try {
			DuAnBean selected = (DuAnBean) cmbFilterDuAn.getSelectedItem();
			pcList = boPhanCong.getPhanCongByDuAn(selected.getMaDuAn());
			for(PhanCongBean pc : pcList) {
				Object[] t = new Object[7];
				t[0] = pc.getMaPhanCong();
				t[1] = pc.getTenDuAn();
				t[2] = pc.getTenNhanVien();
				t[3] = pc.getNgayStart();
				t[4] = pc.getNgayEnd();
				t[5] = pc.getNgayDone();
				t[6] = pc.getTienDo();
				model.addRow(t);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/*
	
	*/
	private void hienThiComboBoxDuAnFilter(JComboBox comboBox){
		try {
			boDuAn.getDuAn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DuAnBean allItem = new DuAnBean();
		allItem.setTenDuAn("All");
		comboBox.addItem(allItem);
		for (DuAnBean duAn : boDuAn.da) {
			comboBox.addItem(duAn);
		}
	}
	
	/*
	
	*/
	private void hienThiComboBoxDuAn(JComboBox comboBox){
		try {
			boDuAn.getDuAn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (DuAnBean duAn : boDuAn.da) {
			comboBox.addItem(duAn);
		}
	}
	
	/*
	
	*/
	private void hienThiComboBoxNhanVien(JComboBox comboBox){
		try {
			boNhanVien.getNhanVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (NhanVienBean nv : boNhanVien.nv) {
			comboBox.addItem(nv);
		}
	}
}
