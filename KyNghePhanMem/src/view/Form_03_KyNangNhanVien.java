package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.KyNangBean;
import bean.KyNangNhanVienBean;
import bo.KyNangBo;
import bo.KyNangNhanVienBo;
import dao.DungChung;

import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class Form_03_KyNangNhanVien extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	private JTextArea textArea = new JTextArea();
	JComboBox<KyNangBean> comboBox3 = new JComboBox<KyNangBean>();
	private JScrollPane scrollPane;
	DefaultTableModel mh;
	KyNangNhanVienBo knBo = new KyNangNhanVienBo();
	DungChung kn = new DungChung();
	private JTextField txtTenKyNang;
	KyNangBo kbo = new KyNangBo();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_03_KyNangNhanVien frame = new Form_03_KyNangNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public Form_03_KyNangNhanVien() {
		setTitle("Kỹ Năng Nhân Viên");
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				mh= new DefaultTableModel();
				// add colum to table
				mh.addColumn("Mã nhân viên");
				mh.addColumn("Tên nhân viên");
				mh.addColumn("Tên kỹ năng");
				mh.addColumn("Mô tả khác");
				try {
					kn.KetNoi();
					ArrayList<KyNangNhanVienBean>  ds = knBo.getListSkill();
					System.out.println(ds.size());
					((DefaultTableModel)table.getModel()).setRowCount(0);
					for(KyNangNhanVienBean kn : ds) {
						Object[] t = new Object[4];
						t[0] = kn.getMaNV();
						t[1] = knBo.getTenNhanVien(kn.getMaNV());
						t[2] = knBo.getTenKyNang(kn.getMaKyNang());
						t[3] = kn.getMoTaKhac();
						mh.addRow(t);
					}
					table.setModel(mh);
					
					// add value combobox
					DefaultComboBoxModel mh2 = new DefaultComboBoxModel();
					ArrayList<KyNangBean> ds2 = kbo.getKyNang();
					for(KyNangBean kn : ds2) {
						mh2.addElement(kn);
						comboBox3.setModel(mh2);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 663, 348);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("K\u1EF9 N\u0103ng", null, panel, null);
		
		JButton btnNewButton = new JButton("Th\u00EAm k\u1EF9 n\u0103ng");
		btnNewButton.setBounds(497, 33, 151, 23);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/images/add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormThemNhanVien frame = new FormThemNhanVien();
				frame.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 67, 648, 242);
		panel.add(tabbedPane_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Danh sách kỹ năng", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					KyNangNhanVienBo ktbo = new KyNangNhanVienBo();
					mh = new DefaultTableModel();
					// thêm cột cho bảng
					mh.addColumn("Mã nhân viên");
					mh.addColumn("Tên nhân viên");
					mh.addColumn("Tên kỹ năng");
					mh.addColumn("Mô tả khác");
					// xóa dữ liệu của bảng
					((DefaultTableModel)table.getModel()).setRowCount(0);
					ArrayList<KyNangNhanVienBean>  ds2 = new ArrayList<KyNangNhanVienBean>();
					ds2 = ktbo.getListSkill();
					//thiết lập lại mô hình
					for(KyNangNhanVienBean kn : ds2) {
						Object[] t = new Object[4];
						t[0] = kn.getMaNV();
						t[1] = knBo.getTenNhanVien(kn.getMaNV());
						t[2] = knBo.getTenKyNang(kn.getMaKyNang());
						t[3] = kn.getMoTaKhac();
						mh.addRow(t);
					}
					table.setModel(mh);
					ktbo = new KyNangNhanVienBo();
				} catch (Exception tt) {
					tt.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(360, 33, 89, 23);
		panel.add(btnRefresh);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ch\u1EC9nh s\u1EEDa k\u1EF9 n\u0103ng", null, panel_1, null);
		panel_1.setLayout(null);
		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					ArrayList<KyNangBean> ds2 = kbo.getKyNang();
					KyNangBean kn = (KyNangBean)comboBox3.getSelectedItem();
					KyNangBean kyNang = kbo.getInfo(kn.getMaKyNang(), ds2);
					txtTenKyNang.setText(kyNang.getTenKyNang());
					textArea.setText(kyNang.getChiTiet());
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
		//JComboBox comboBox3 = new JComboBox();
		comboBox3.setBounds(148, 32, 186, 20);
		panel_1.add(comboBox3);
		
		JLabel lblChnKNng = new JLabel("Chọn kỹ năng");
		lblChnKNng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChnKNng.setBounds(28, 31, 95, 20);
		panel_1.add(lblChnKNng);
		
		txtTenKyNang = new JTextField();
		txtTenKyNang.setBounds(148, 91, 380, 20);
		panel_1.add(txtTenKyNang);
		txtTenKyNang.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên kỹ năng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(28, 93, 83, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mô tả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(40, 158, 83, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(getClass().getResource("/images/save.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					KyNangBean kn = (KyNangBean)comboBox3.getSelectedItem();
					kbo.CapNhat(kn.getMaKyNang(), txtTenKyNang.getText(), textArea.getText());
					JOptionPane.showMessageDialog(null, "Cập nhật thành công !!");;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuu.setBounds(148, 286, 89, 23);
		panel_1.add(btnLuu);
		
		
		textArea.setBounds(148, 154, 380, 90);
		panel_1.add(textArea);
	}
}