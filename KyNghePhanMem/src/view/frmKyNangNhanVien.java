package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.KyNangNhanVienBean;
import bo.KyNangNhanVienBo;
import dao.DungChung;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTable;

public class frmKyNangNhanVien extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel mh = new DefaultTableModel();
	KyNangNhanVienBo knBo = new KyNangNhanVienBo();
	DungChung kn = new DungChung();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKyNangNhanVien frame = new frmKyNangNhanVien();
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
	public frmKyNangNhanVien() {
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				// add colum to table
				mh.addColumn("Mã nhân viên");
				mh.addColumn("Mã kỹ năng");
				mh.addColumn("Mô tả khác");
				try {
					kn.KetNoi();
					ArrayList<KyNangNhanVienBean>  ds = knBo.getListSkill();
					((DefaultTableModel)table.getModel()).setRowCount(0);
					for(KyNangNhanVienBean kn : ds) {
						Object[] t = new Object[3];
						t[0] = kn.getMaNV();
						t[1] = kn.getMaKyNang();
						t[2] = kn.getMoTaKhac();
						mh.addRow(t);
					}
					table.setModel(mh);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 717, 348);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("K\u1EF9 N\u0103ng", null, panel, null);
		
		JButton btnNewButton = new JButton("Th\u00EAm k\u1EF9 n\u0103ng");
		btnNewButton.setBounds(478, 21, 130, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 67, 692, 242);
		panel.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Danh sách kỹ năng", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ch\u1EC9nh s\u1EEDa k\u1EF9 n\u0103ng", null, panel_1, null);
	}
}
