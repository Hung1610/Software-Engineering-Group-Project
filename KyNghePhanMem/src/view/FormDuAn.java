package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.DuAnBean;
import bean.NhanVienBean;
import bo.DuAnBo;
import dao.DungChung;

import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormDuAn extends JFrame {
	
	private JPanel contentPane;
	TextField txttenda = new TextField();
	TextField txtnbd = new TextField();
	TextField txtnkt = new TextField();
	TextField txttt = new TextField();
	JComboBox comboBox = new JComboBox();
	DuAnBo bo = new DuAnBo();
	ArrayList<DuAnBean> da;

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public FormDuAn() {
		setTitle("Dự án");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
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
		setBounds(100, 100, 603, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				for(DuAnBean thongtin : da) {
					if (thongtin.getMaDuAn().equals(comboBox.getSelectedItem().toString())) {
						txttenda.setText(thongtin.getTenDuAn());
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
		
		
		comboBox.setBounds(136, 29, 80, 22);
		contentPane.add(comboBox);
		
		JLabel lblMDn = new JLabel("M\u00E3 D\u1EF1 \u00C1n");
		lblMDn.setBounds(12, 32, 56, 16);
		contentPane.add(lblMDn);
		
		JLabel lblTnDn = new JLabel("T\u00EAn D\u1EF1 \u00C1n");
		lblTnDn.setBounds(12, 135, 80, 16);
		contentPane.add(lblTnDn);
		
		
		txttenda.setBounds(136, 127, 166, 24);
		contentPane.add(txttenda);
		
		JLabel lblNgyBtu = new JLabel("Ng\u00E0y B\u1EAFt \u0110\u1EA7u");
		lblNgyBtu.setBounds(12, 185, 80, 16);
		contentPane.add(lblNgyBtu);
		
		
		txtnbd.setBounds(136, 177, 166, 24);
		contentPane.add(txtnbd);
		
		JLabel lblNgyKtThc = new JLabel("Ng\u00E0y K\u1EBFt Th\u00FAc");
		lblNgyKtThc.setBounds(12, 235, 95, 16);
		contentPane.add(lblNgyKtThc);
		
		
		txtnkt.setBounds(136, 227, 166, 24);
		contentPane.add(txtnkt);
		
		JLabel lblTnhTrng = new JLabel("T\u00ECnh Tr\u1EA1ng");
		lblTnhTrng.setBounds(12, 285, 95, 16);
		contentPane.add(lblTnhTrng);
		
		
		txttt.setBounds(136, 285, 166, 24);
		contentPane.add(txttt);
		
		JButton btnThm = new JButton("Th\u00EAm");
		btnThm.setIcon(new ImageIcon(getClass().getResource("/images/add.png")));
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnThm.setBounds(60, 337, 104, 25);
		contentPane.add(btnThm);
		
		JButton btnCpNht = new JButton("C\u1EADp Nh\u1EADt");
		btnCpNht.setIcon(new ImageIcon(getClass().getResource("/images/update.png")));
		btnCpNht.setBounds(205, 337, 110, 25);
		contentPane.add(btnCpNht);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.setIcon(new ImageIcon(getClass().getResource("/images/delete.png")));
		btnXa.setBounds(365, 337, 97, 25);
		contentPane.add(btnXa);
	}
}
