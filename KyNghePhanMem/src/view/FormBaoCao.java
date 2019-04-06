package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
import java.awt.event.ActionEvent;

public class FormBaoCao {

	private JFrame frmInBaoCao;
	private JTable table;
	BaoCaoBo bo = new BaoCaoBo();
	ArrayList<BaoCaoBean> bc;
	JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBaoCao window = new FormBaoCao();
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
	public FormBaoCao() {
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
					 //Them ten cua colummn
			        DefaultTableModel model = new DefaultTableModel();
			        model.addColumn("Ma Phan Cong");
			        model.addColumn("So Ngay Da Lam Viec");
			        model.addColumn("Tien Do");
					table = new JTable(model);
					scrollPane.setViewportView(table);
					
					
					//Them hang vao bang
					try {
						bc = bo.getBaoCao();
						Object rowData[] = new Object[3];
						for (BaoCaoBean thongtinbaocao : bc) {
							rowData[0]= thongtinbaocao.getMaPhanCong();
							rowData[1]= thongtinbaocao.getSoNgayDaLamViec();
							rowData[2]= thongtinbaocao.getTienDo();
							model.addRow(rowData);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		JButton btnInRaFile = new JButton("In ra File");
		btnInRaFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileWriter w = new FileWriter("output.txt");
					PrintWriter p = new PrintWriter(w);
					Formatter fmt = new Formatter("output.txt");
					int n = bc.size();
					String formatStr = "%-20s %-15s %-15s%n";
					p.println(String.format("%-20s %-25s %-20s%n","Ma Phan Cong", "So Ngay Da Lam Viec","Tien Do"));
					p.println("-------------------------------------------------------------------------------------------------------------------------");
					for (int i = 0; i < n; i++) {						
						//p.println(bc.get(i).getMaPhanCong()+", "+bc.get(i).getSoNgayDaLamViec()+", "+);
						//fmt.format("%-20s%10d\n", bc.get(i).getMaPhanCong()+", "+bc.get(i).getSoNgayDaLamViec()+", "+bc.get(i).getTienDo() );
						//p.println(fmt);
						//output.write(String.format(formatStr, bc.get(i).getMaPhanCong(), bc.get(i).getSoNgayDaLamViec(),bc.get(i).getTienDo()));
						p.println(String.format("%-20s %-25s %-20s%n",bc.get(i).getMaPhanCong(), bc.get(i).getSoNgayDaLamViec(),bc.get(i).getTienDo() ));
						p.println("-------------------------------------------------------------------------------------------------------------------------");
					}
					w.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnInRaFile.setBounds(318, 51, 97, 25);
		frmInBaoCao.getContentPane().add(btnInRaFile);
		
		//String[] columnNames = {"Ma Phan Cong","So Ngay Da Lam Viec","Tien Do"};
		
      
		
//		JComboBox comboBox = new JComboBox();
//        comboBox.addItem("Snowboarding");
//        comboBox.addItem("Rowing");
//        comboBox.addItem("Knitting");
//        comboBox.addItem("Speed reading");
//        comboBox.addItem("Pool");
//        comboBox.addItem("None of the above");
//        table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBox));
//        System.out.println(table.getColumnModel().getColumn(1).getHeaderValue());
       

        
		

		
	}
}
