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
import javax.swing.UIManager;
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
import java.awt.Color;

public class Form_0_Login extends JFrame {

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
				// Set Look and Feel.
				try {
					  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch(Exception e) {
					  System.out.println("Error setting native LookAndFeel: " + e);
				}
				//
				
				try {
					Form_0_Login frame = new Form_0_Login();
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
	public Form_0_Login() {
		setResizable(false);
		setTitle("Ðăng nhập ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(25, 11, 132, 31);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/user.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBounds(25, 85, 106, 34);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/images/pass.png")));
		
		txt1 = new JTextField();
		txt1.setBounds(48, 43, 147, 31);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JPasswordField();
		txt2.setBounds(48, 119, 147, 34);
		contentPane.add(txt2);
		ImageIcon icon=  new ImageIcon(getClass().getResource("/images/login.png"));
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.WHITE);
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
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!", "Warning!", JOptionPane.ERROR_MESSAGE);
						}
				
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});
		btnNewButton.setBounds(26, 182, 94, 31);
		contentPane.add(btnNewButton);
		
		btnThot = new JButton("Thoát");
		btnThot.setBackground(Color.WHITE);
		btnThot.setIcon(new ImageIcon(getClass().getResource("/images/delete.png")));
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
		btnThot.setBounds(117, 182, 94, 31);
		contentPane.add(btnThot);
	}
}
