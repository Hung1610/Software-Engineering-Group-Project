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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPhnCng = new JButton("Phân Công");
		btnPhnCng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPhnCng.setBounds(34, 87, 97, 25);
		contentPane.add(btnPhnCng);
		
		JButton btnDn = new JButton("Dự Án");
		btnDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 FormDuAn da = new FormDuAn();
				 da.setVisible(true);
				 da.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnDn.setBounds(160, 87, 97, 25);
		contentPane.add(btnDn);
		
		JButton btnNhnVin = new JButton("Nhân Viên");
		btnNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Form_02_NhanVienNangCao nv = new Form_02_NhanVienNangCao();
				nv.frmQuanLyNhan.setVisible(true);
				nv.frmQuanLyNhan.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
		});
		btnNhnVin.setBounds(293, 87, 97, 25);
		contentPane.add(btnNhnVin);
		
		JButton btnBoCoCng = new JButton("Báo Cáo Công Việc");
		btnBoCoCng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Form_04_BaoCao bc = new Form_04_BaoCao();
			    bc.frmInBaoCao.setVisible(true);
			    bc.frmInBaoCao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnBoCoCng.setBounds(433, 87, 149, 25);
		contentPane.add(btnBoCoCng);
		
		JButton btnCpNhtK = new JButton("Cập Nhật Kỹ Năng");
		btnCpNhtK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form_03_KyNangNhanVien kn = new Form_03_KyNangNhanVien();
				kn.setVisible(true);
				kn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCpNhtK.setBounds(625, 87, 135, 25);
		contentPane.add(btnCpNhtK);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 169, 910, 253);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Dự Án", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(796, 25, 148, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(61, 42, 61, 52);
		panel.add(lblLogo);
	}
}
