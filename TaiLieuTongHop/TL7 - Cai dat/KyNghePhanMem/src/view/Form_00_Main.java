package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.DuAnBean;
import bo.DuAnBo;
import dao.DungChung;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Form_00_Main extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel mh = new DefaultTableModel();
	DuAnBo bo = new DuAnBo();
	ArrayList<DuAnBean> da;

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
					Form_00_Main frame = new Form_00_Main();
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
	public Form_00_Main() {
		setResizable(false);
		setTitle("Menu");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				mh.addColumn("Mã Dự Án");
				mh.addColumn("Tên Dự Án");
				mh.addColumn("Ngày Bắt Đầu");
				mh.addColumn("Ngày Kết Thúc");
				mh.addColumn("Tình Trạng");
				try {
					DungChung dc = new DungChung();
					dc.KetNoi();
					ArrayList<DuAnBean> da2 = bo.getDuAn();
					((DefaultTableModel)table.getModel()).setRowCount(0);
					for(DuAnBean da : da2) {
						Object[] t = new Object[5];
						t[0] = da.getMaDuAn();
						t[1] = da.getTenDuAn();
						t[2] = da.getNgayBatDau();
						t[3] = da.getNgayKetThuc();
						t[4] = da.getTinhTrang();
						mh.addRow(t);
 					}
					table.setModel(mh);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 501);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPhnCng = new JButton("Phân Công");
		btnPhnCng.setBackground(Color.WHITE);
		btnPhnCng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Form_05_PhanCong pc = new Form_05_PhanCong();
				pc.frame.setVisible(true);
				pc.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnPhnCng.setBounds(35, 91, 149, 51);
		contentPane.add(btnPhnCng);
		
		JButton btnDn = new JButton("Dự Án");
		btnDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Form_01_DuAnNangCap da = new Form_01_DuAnNangCap();
				 da.setVisible(true);
				 da.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//				Form_01_DuAnNangCap da = new Form_01_DuAnNangCap();
//				da.setVisible(true);
			}
		});
		btnDn.setBounds(194, 91, 140, 51);
		contentPane.add(btnDn);
		
		JButton btnNhnVin = new JButton("Nhân Viên");
		
		btnNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Form_02_NhanVienNangCao nv = new Form_02_NhanVienNangCao();
				nv.frmQuanLyNhanVien.setVisible(true);
				nv.frmQuanLyNhanVien.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
		});
		btnNhnVin.setBounds(344, 91, 134, 51);
		contentPane.add(btnNhnVin);
		
		JButton btnBoCoCng = new JButton("Báo Cáo Công Việc");
		btnBoCoCng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Form_04_BaoCao bc = new Form_04_BaoCao();
			    bc.frmInBaoCao.setVisible(true);
			    bc.frmInBaoCao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnBoCoCng.setBounds(488, 91, 149, 51);
		contentPane.add(btnBoCoCng);
		
		JButton btnCpNhtK = new JButton("Cập Nhật Kỹ Năng");
		btnCpNhtK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form_03_KyNangNhanVien kn = new Form_03_KyNangNhanVien();
				kn.setVisible(true);
				kn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCpNhtK.setBounds(647, 91, 135, 51);
		contentPane.add(btnCpNhtK);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 153, 975, 296);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Dự Án", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(839, 13, 148, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(20, 13, 128, 119);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(getClass().getResource("/images/dhkh.png")));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/images/assign1.png")));
		label.setBounds(87, 13, 97, 65);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(getClass().getResource("/images/pj1.png")));
		label_1.setBounds(237, 15, 97, 65);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(getClass().getResource("/images/user1.png")));
		label_2.setBounds(381, 15, 97, 65);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(getClass().getResource("/images/report1.png")));
		label_3.setBounds(540, 15, 97, 65);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(getClass().getResource("/images/update1.png")));
		label_4.setBounds(685, 15, 97, 65);
		contentPane.add(label_4);
	}
}