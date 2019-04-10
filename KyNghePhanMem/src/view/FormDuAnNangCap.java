package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.DuAnBean;
import bo.DuAnBo;
import dao.DungChung;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FormDuAnNangCap extends JFrame {

	private JPanel contentPane;
	TextField txtten = new TextField();
	TextField txtnbd = new TextField();
	TextField txtnkt = new TextField();
	TextField txttt = new TextField();
	JButton btnXn = new JButton("Xác Nhận Thay Đổi");
	JButton btnRefresh = new JButton("Refresh");
	JButton btnCapNhat = new JButton("Cập Nhật");
	JButton btnXoa = new JButton("Xóa");
	JComboBox comboBox = new JComboBox();
	DuAnBo bo = new DuAnBo();
	ArrayList<DuAnBean> da;
	private final JLabel lblTnDn_1 = new JLabel("Mã Dự Án");
	private final JLabel lblNgyBtu_1 = new JLabel("Tên Dự Án");
	private final JLabel lblNgyBtu_2 = new JLabel("Ngày Bắt Đầu");
	private final JLabel lblNgyKtThc_1 = new JLabel("Ngày Kết Thúc");
	private final JLabel lblTnhTrng_1 = new JLabel("Tình Trạng");
	private final TextField textField = new TextField();
	private final TextField textField_1 = new TextField();
	private final TextField textField_2 = new TextField();
	private final TextField textField_3 = new TextField();
	private final TextField textField_4 = new TextField();
	private final JButton btnThm = new JButton("Thêm");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDuAnNangCap frame = new FormDuAnNangCap();
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
	public FormDuAnNangCap() {
		setTitle("Dự Án");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					DungChung dc = new DungChung();
					dc.KetNoi();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					da = bo.getDuAn();
					for (DuAnBean thongtin : da) {
						comboBox.addItem(thongtin.getMaDuAn());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 43, 471, 468);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dự Án", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblMDn = new JLabel("Mã Dự Án");
		lblMDn.setBounds(39, 35, 56, 16);
		panel.add(lblMDn);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				for(DuAnBean thongtin : da) {
					if (thongtin.getMaDuAn().equals(comboBox.getSelectedItem().toString())) {
						txtten.setText(thongtin.getTenDuAn());
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						String ngaybd = formatter.format(thongtin.getNgayBatDau());
						String ngaykt = formatter.format(thongtin.getNgayKetThuc());
						txtnbd.setText(ngaybd.toString());
						txtnkt.setText(ngaykt.toString());
						txttt.setText(thongtin.getTinhTrang());
						
					}
				}
			}
		});
		
		
		comboBox.setBounds(149, 32, 148, 22);
		panel.add(comboBox);
		
		JLabel lblTnDn = new JLabel("Tên Dự Án");
		lblTnDn.setBounds(39, 77, 74, 16);
		panel.add(lblTnDn);
		
		JLabel lblNgyBtu = new JLabel("Ngày Bắt Đầu");
		lblNgyBtu.setBounds(39, 123, 89, 16);
		panel.add(lblNgyBtu);
		
		JLabel lblNgyKtThc = new JLabel("Ngày Kết Thúc");
		lblNgyKtThc.setBounds(39, 174, 89, 16);
		panel.add(lblNgyKtThc);
		
		JLabel lblTnhTrng = new JLabel("Tình Trạng");
		lblTnhTrng.setBounds(39, 224, 74, 16);
		panel.add(lblTnhTrng);
		txtten.setEditable(false);
		txtten.setBounds(149, 77, 148, 24);
		panel.add(txtten);
		txtnbd.setEditable(false);
		txtnbd.setBounds(149, 123, 148, 24);
		panel.add(txtnbd);
		
		
		txtnkt.setEditable(false);
		txtnkt.setBounds(149, 174, 148, 24);
		panel.add(txtnkt);
		
		
		txttt.setEditable(false);
		txttt.setBounds(149, 224, 148, 24);
		panel.add(txttt);
		
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showConfirmDialog(new JFrame(),
						"Bạn có chắc muốn xóa nhân viên này, thao tác này ko thể hoàn tác", "Xác nhận xóa",
						JOptionPane.YES_NO_OPTION);
				if(a == JOptionPane.YES_OPTION) {
					for(DuAnBean thongtin : da) {
						if(thongtin.getMaDuAn().equals(comboBox.getSelectedItem().toString())) {
							try {
								bo.Xoa(comboBox.getSelectedItem().toString());
							} catch (Exception e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(new JFrame(), "Có lỗi xảy ra ko xóa được, liên quan khóa ngoài", "Thông báo", JOptionPane.CLOSED_OPTION);
							}
							break;
						}
						
					}
				}
				
			}
		});
		btnXoa.setIcon(new ImageIcon(FormDuAnNangCap.class.getResource("/images/delete.png")));
		btnXoa.setBounds(26, 303, 108, 25);
		panel.add(btnXoa);
		
		
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnCapNhat.getText().equals("Cập Nhật")) {
					txtten.setEditable(true);
					txtnbd.setEditable(true);
					txtnkt.setEditable(true);
					txttt.setEditable(true);
					btnXn.setEnabled(true);
					btnRefresh.setEnabled(false);
					btnXoa.setEnabled(false);
					btnCapNhat.setText("Dừng Cập Nhật");

				}
				else {
					btnCapNhat.setText("Cập Nhật");
					btnXn.setEnabled(false);
					btnXoa.setEnabled(true);
					btnRefresh.setEnabled(true);
					txtten.setEditable(false);
					txtnbd.setEditable(false);
					txtnkt.setEditable(false);
					txttt.setEditable(false);
				}
			}
		});
		btnCapNhat.setIcon(new ImageIcon(FormDuAnNangCap.class.getResource("/images/update.png")));
		btnCapNhat.setBounds(167, 303, 122, 25);
		panel.add(btnCapNhat);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				da.clear();
				comboBox.removeAllItems();
				try {
					da=bo.getDuAn();
					for(DuAnBean thongtin : da) {
						comboBox.addItem(thongtin.getMaDuAn());
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		btnRefresh.setIcon(new ImageIcon(FormDuAnNangCap.class.getResource("/images/refresh.png")));
		btnRefresh.setBounds(326, 303, 115, 25);
		panel.add(btnRefresh);
		btnXn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				for(DuAnBean thongtin : da) {
					int a = JOptionPane.showConfirmDialog(new JFrame(),
							"Bạn có chắc muốn cập nhật dự án này ko, thao tác này ko thể hoàn tác", "Xác nhận cập nhật",
							JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						if(thongtin.getMaDuAn().equals(comboBox.getSelectedItem().toString())) {
							try {
								SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
								DuAnBo bo = new DuAnBo();
								System.out.println(txtnbd.getText());
								Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(txtnbd.getText());
								Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(txtnkt.getText());
								bo.CapNhat(comboBox.getSelectedItem().toString(), txtten.getText(), date1, date2, txttt.getText());
							} catch (Exception e2) {
								// TODO: handle exception
							}
							break;
						}
					}
					
				}
			}
		});
		
		
		btnXn.setEnabled(false);
		btnXn.setIcon(new ImageIcon(FormDuAnNangCap.class.getResource("/images/tick.png")));
		btnXn.setBounds(149, 350, 165, 43);
		panel.add(btnXn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thêm Dự Án", null, panel_1, null);
		panel_1.setLayout(null);
		lblTnDn_1.setBounds(57, 34, 77, 16);
		
		panel_1.add(lblTnDn_1);
		lblNgyBtu_1.setBounds(57, 78, 77, 16);
		
		panel_1.add(lblNgyBtu_1);
		lblNgyBtu_2.setBounds(57, 124, 77, 16);
		
		panel_1.add(lblNgyBtu_2);
		lblNgyKtThc_1.setBounds(57, 172, 94, 16);
		
		panel_1.add(lblNgyKtThc_1);
		lblTnhTrng_1.setBounds(57, 222, 77, 16);
		
		panel_1.add(lblTnhTrng_1);
		textField.setBounds(168, 34, 152, 24);
		
		panel_1.add(textField);
		textField_1.setBounds(168, 78, 152, 24);
		
		panel_1.add(textField_1);
		textField_2.setBounds(168, 124, 152, 24);
		
		panel_1.add(textField_2);
		textField_3.setBounds(169, 172, 151, 24);
		
		panel_1.add(textField_3);
		textField_4.setBounds(168, 222, 152, 24);
		
		panel_1.add(textField_4);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				da.clear();
				try {
					da=bo.getDuAn();
					SimpleDateFormat fm = new SimpleDateFormat("YYYY-MM-DD");
				    if(bo.Them(textField.getText(), textField_1.getText(), fm.parse(textField_2.getText()), fm.parse(textField_3.getText()), textField_4.getText())==1) {
				    	int a = JOptionPane.showConfirmDialog(new JFrame(), "Thêm Dự án thành công", "Thông báo",
								JOptionPane.CLOSED_OPTION);
				    }
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		});
		btnThm.setIcon(new ImageIcon(FormDuAnNangCap.class.getResource("/images/add.png")));
		btnThm.setBounds(212, 295, 108, 25);
		
		panel_1.add(btnThm);
	}
}
