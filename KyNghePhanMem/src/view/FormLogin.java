package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DungChung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.server.LoaderHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JPasswordField txt2;
	private JButton btnThot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	public FormLogin() {
		setTitle("Ðăng nhập ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(25, 30, 132, 31);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("images/user.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBounds(25, 85, 106, 34);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("images/pass.png"));
		
		txt1 = new JTextField();
		txt1.setBounds(167, 30, 147, 31);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JPasswordField();
		txt2.setBounds(167, 85, 147, 34);
		contentPane.add(txt2);
		ImageIcon icon=  new ImageIcon("images/login.png");
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(icon);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txt1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập!");
				}else if(txt2.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!");
				}else {
					try {
						String dburl = "jdbc:sqlserver://localhost:1433;databaseName=KyNghe;user=sa;password=123";
						Connection conn = DriverManager.getConnection(dburl);
						String sql = "Select *from Login\n "+ "where username=? and password=?";
						PreparedStatement ps= conn.prepareStatement(sql);
						ps.setString(1, txt1.getText());
						ps.setString(2, txt2.getText());
						ResultSet rs= ps.executeQuery();
						if (rs.next()) {
//							JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
							Form_00_Main.main(null);
						} else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!", "Warning!", JOptionPane.ERROR_MESSAGE);
						}
				
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});
		btnNewButton.setBounds(167, 138, 94, 31);
		contentPane.add(btnNewButton);
		
		btnThot = new JButton("Thoát");
		btnThot.setIcon(new ImageIcon("images/delete.png"));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có chắc xác nhận thoát","Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
			}
		});
		btnThot.setBounds(167, 181, 94, 31);
		contentPane.add(btnThot);
	}
}
