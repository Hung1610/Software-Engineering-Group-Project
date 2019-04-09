package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import bean.BaoCaoBean;
import bo.BaoCaoBo;
import dao.DungChung;

import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Form_04_BaoCao {

    JFrame frmInBaoCao;
	private JTable table;
	BaoCaoBo bo = new BaoCaoBo();
	ArrayList<BaoCaoBean> bc;
	JScrollPane scrollPane = new JScrollPane();
	//DefaultTableModel model = new DefaultTableModel();
	ArrayList<String> a = null;
	JComboBox comboBox = new JComboBox();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_04_BaoCao window = new Form_04_BaoCao();
					window.frmInBaoCao.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form_04_BaoCao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInBaoCao = new JFrame();
		frmInBaoCao.setTitle("In Bao Cao");
		frmInBaoCao.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				try {
					DungChung dc = new DungChung();
					dc.KetNoi();
					// model.insertRow(0, new Object[3]);
					// model.insertRow(1, new Object[3]);
					// model.removeRow(0);
					// Them hang vao bang
					// try {
					// bc = bo.getBaoCao();
					// Object rowData[] = new Object[3];
					// for (BaoCaoBean thongtinbaocao : bc) {
					// rowData[0]= thongtinbaocao.getMaPhanCong();
					// rowData[1]= thongtinbaocao.getSoNgayDaLamViec();
					// rowData[2]= thongtinbaocao.getTienDo();
					// model.addRow(rowData);
					// }
					// } catch (Exception e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					try {
						bc = bo.getBaoCao();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (BaoCaoBean thongtinbaocao : bc) {
					comboBox.addItem(thongtinbaocao.getMaPhanCong());
				}

			}
		});
		frmInBaoCao.setBounds(100, 100, 787, 507);
		frmInBaoCao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInBaoCao.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(133, 105, 546, 290);
		frmInBaoCao.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Thong tin phan cong", null, scrollPane, null);
		table = new JTable(model);
		model.addRow(new Object[3]);
		// Them ten cua colummn
				model.addColumn("Ma Phan Cong");
				model.addColumn("So Ngay Da Lam Viec");
				model.addColumn("Tien Do");
		//TableModel model = table.getModel();
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
		scrollPane.setViewportView(table);
		
		
		
		JButton btnInRaFile = new JButton("In ra File");
		btnInRaFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileWriter w = new FileWriter("output.txt");
					PrintWriter p = new PrintWriter(w);
					Formatter fmt = new Formatter("output.txt");
					int n = bc.size();
					String formatStr = "%-20s %-15s %-15s%n";
					p.println(String.format("%-20s %-25s %-20s%n", "Ma Phan Cong", "So Ngay Da Lam Viec", "Tien Do"));
					p.println(
							"-------------------------------------------------------------------------------------------------------------------------");
					for (int i = 0; i < n; i++) {
						p.println(String.format("%-20s %-25s %-20s%n", bc.get(i).getMaPhanCong(),
								bc.get(i).getSoNgayDaLamViec(), bc.get(i).getTienDo()));
						p.println(
								"-------------------------------------------------------------------------------------------------------------------------");
					}
					w.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnInRaFile.setBounds(318, 51, 97, 25);
		frmInBaoCao.getContentPane().add(btnInRaFile);
		//model.setValueAt("thang", 0, 0);
		table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if (e.getType()== e.UPDATE && table.getRowCount()==table.getSelectedRow()+1) {
					// something was entered into the last row, add a new row
					Object rowData[] = new Object[3];
					rowData[0] = null;
					rowData[1] = null;
					rowData[2] = null;
					model.addRow(rowData);
				}
				if(e.getType()==e.INSERT) {
					for (BaoCaoBean thongtinbaocao : bc) {
						if(thongtinbaocao.getMaPhanCong().equals(model.getValueAt(table.getSelectedRow(), 0))) {
							System.out.println("123");
							model.setValueAt(thongtinbaocao.getSoNgayDaLamViec(), table.getSelectedRow(), 1);
							model.setValueAt(thongtinbaocao.getTienDo(), table.getSelectedRow(), 2);
							break;
						}
					}
				}
				
			}
		});
	}
}
