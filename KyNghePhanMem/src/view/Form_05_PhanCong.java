package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
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

public class Form_05_PhanCong {

	public JFrame frame;
	private JTable tablePhanCong;

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
		scrollPane.setViewportView(tablePhanCong);
		
		JButton btnCpNht = new JButton("Cập nhật");
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 33, 185, 20);
		panel.add(comboBox);
		
		JLabel lblDn = new JLabel("Dự Án:");
		lblDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDn.setBounds(10, 9, 107, 23);
		panel.add(lblDn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thêm/sửa phân công", null, panel_1, null);
	}
}
