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

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Form_01_DuAnNangCap extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	DefaultTableModel mh = new DefaultTableModel();
	DuAnBo bo = new DuAnBo();
	ArrayList<DuAnBean> da;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_01_DuAnNangCap frame = new Form_01_DuAnNangCap();
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
	public Form_01_DuAnNangCap() {
		setTitle("Dự Án");
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
		setBounds(100, 100, 815, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 42, 734, 361);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dự Án", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(45, 103, 634, 215);
		panel.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnThmDn = new JButton("Thêm Dự Án");
		btnThmDn.setIcon(new ImageIcon("images/add.png"));
		btnThmDn.setBounds(550, 41, 129, 25);
		panel.add(btnThmDn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Chỉnh Sửa Dự Án", null, panel_1, null);
	}

}