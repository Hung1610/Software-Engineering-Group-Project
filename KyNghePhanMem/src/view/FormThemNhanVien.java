package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.KyNangBean;
import bean.NhanVien;
import bo.KyNangBo;
import bo.KyNangNhanVienBo;
import bo.NhanVienBo;
import dao.DungChung;

import java.awt.Label;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThemNhanVien extends JFrame {

	private JPanel contentPane;
	DungChung kn = new DungChung();
	NhanVienBo nv = new NhanVienBo();
	KyNangBo knbo = new KyNangBo();
	KyNangNhanVienBo kbo = new KyNangNhanVienBo();
	JComboBox<NhanVien> comboBox = new JComboBox<NhanVien>();
	JComboBox<KyNangBean> comboBox1 = new JComboBox<KyNangBean>();
	

	/**
	 * Create the frame.
	 */
	public FormThemNhanVien() {
		setTitle("Thêm Kỹ Năng Nhân Viên");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					kn.KetNoi();
					// add value cho combox Nhân viên
					DefaultComboBoxModel mh = new DefaultComboBoxModel();
					ArrayList<NhanVien> ds = nv.getNhanVien();
					for(NhanVien n : nv.getNhanVien()) {
						mh.addElement(n);
						comboBox.setModel(mh);
					}
					//add value cho combobox Kỹ năng
					DefaultComboBoxModel mh2 = new DefaultComboBoxModel();
					for(KyNangBean ki : knbo.getKyNang()) {
						mh2.addElement(ki);
						comboBox1.setModel(mh2);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Tên nhân viên");
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(10, 43, 103, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Tên kỹ năng");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_1.setBounds(10, 100, 103, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Mô tả khác");
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(10, 152, 82, 22);
		contentPane.add(label_2);
		
		TextArea teaMoTa = new TextArea();
		teaMoTa.setBounds(119, 144, 380, 120);
		contentPane.add(teaMoTa);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					NhanVien nv = (NhanVien)comboBox.getSelectedItem();
					KyNangBean kn = (KyNangBean)comboBox1.getSelectedItem();
					int kt = kbo.themKyNangNhanVien(nv.getMaNhanVien(), kn.getMaKyNang(), teaMoTa.getText());
					if(kt==0) {
						JOptionPane.showMessageDialog(null, "Kỹ năng nhân viên đã tồn tại !!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thêm thành công ");
						FormThemNhanVien frame = new FormThemNhanVien();
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame.dispose();
						//System.exit(0);
					}
				} catch (Exception tt) {
					System.out.println(tt.getMessage());
					tt.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(410, 295, 89, 23);
		contentPane.add(btnAdd);
		
		//JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 43, 154, 20);
		contentPane.add(comboBox);
		
		//JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(119, 100, 154, 20);
		contentPane.add(comboBox1);
	}
}
