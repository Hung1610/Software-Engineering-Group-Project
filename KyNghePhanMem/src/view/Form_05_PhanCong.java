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
import java.util.ArrayList;

public class Form_05_PhanCong {

	public JFrame frame;
	private JTable tablePhanCong;
	private JComboBox cmbProject;
	private PhanCongBo boPhanCong = new PhanCongBo();
	private DuAnBo boDuAn = new DuAnBo();
	private NhanVienBo boNhanVien = new NhanVienBo();
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableModel = new DefaultTableModel(
						new Object[][] {
							
						},
						new String[] {
							"D\u1EF1 \u00C1n", "Nh\u00E2n Vi\u00EAn", "S\u1ED1 Ng\u00E0y \u0110\u00E3 L\u00E0m Vi\u1EC7c", "Ng\u00E0y K\u1EBFt Th\u00FAc", "Ng\u00E0y B\u1EAFt \u0110\u1EA7u", "Ti\u1EBFn \u0110\u1ED9"
						}
					){
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					};
					/*
					tableModel.addColumn("Dự Án");
					tableModel.addColumn("Nhân Viên");
					tableModel.addColumn("Ngày Bắt Đầu");
					tableModel.addColumn("Ngày Kết Thúc");
					tableModel.addColumn("Số Ngày Làm Việc");
					tableModel.addColumn("Tiến Độ");
					*/
					try {
						DungChung dc = new DungChung();
						dc.KetNoi();
						ArrayList<PhanCongBean> pcList = boPhanCong.getPhanCong();
						for(PhanCongBean pc : pcList) {
							Object[] t = new Object[6];
							t[0] = pc.getMaDuAn();
							t[1] = pc.getMaNhanVien();
							t[2] = pc.getNgayStart();
							t[3] = pc.getNgayEnd();
							t[4] = pc.getNgayDone();
							t[5] = pc.getTienDo();
							tableModel.addRow(t);
	 					}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				tablePhanCong.setModel(tableModel);

				hienThiComboBoxDuAn(cmbProject);
			}
		});
		
		frame.setBounds(100, 100, 615, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 579, 336);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Thông tin phân công", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 80, 554, 217);
		panel.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Bảng phân công", null, scrollPane, null);
		
		tablePhanCong = new JTable();
		tablePhanCong.setModel(new DefaultTableModel());
		tablePhanCong.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablePhanCong);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCpNht.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/save.png")));
		btnCpNht.setBounds(449, 11, 115, 23);
		panel.add(btnCpNht);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/delete.png")));
		btnXa.setBounds(449, 32, 115, 23);
		panel.add(btnXa);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setIcon(new ImageIcon(Form_05_PhanCong.class.getResource("/images/refresh.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(449, 53, 115, 23);
		panel.add(btnNewButton);
		
		cmbProject = new JComboBox();
		cmbProject.setBounds(10, 33, 185, 20);
		panel.add(cmbProject);
		
		JLabel lblDn = new JLabel("Dự Án:");
		lblDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDn.setBounds(10, 9, 107, 23);
		panel.add(lblDn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thêm/sửa phân công", null, panel_1, null);
	}

	private void hienThiComboBoxDuAn(JComboBox comboBox){
		try {
			boDuAn.getDuAn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (DuAnBean duAn : boDuAn.da) {
			comboBox.addItem(new Item(duAn.getMaDuAn(),duAn.getTenDuAn()));
		}
	}
	 class Item{
	        private String id;
	        private String description;
	 
	        public Item(String string, String description)
	        {
	            this.id = string;
	            this.description = description;
	        }
	 
	        public String getId()
	        {
	            return id;
	        }
	 
	        public String getDescription()
	        {
	            return description;
	        }
	 
	        public String toString()
	        {
	            return description;
	        }
	    }
}
