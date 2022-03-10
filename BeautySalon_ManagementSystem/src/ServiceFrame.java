import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServiceFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_serviceid;
	private JTextField txt_stylist;
	private JTextField txt_service;
	private JTable table;
	private JTextField textField;
	
	Connection con;
	PreparedStatement pst;

	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void ShowData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Service ID");
		model.addColumn("Stylist Name");
		model.addColumn("Type");
		model.addColumn("Service");
		
		try {
			String query = "SELECT * FROM Services";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				model.addRow(new Object [] {
					rs.getString("Service_ID"),	
					rs.getString("Employee_Name"),	
					rs.getString("Employee_Type"),
					rs.getString("Services_Name"),
				});
					
				}
			
			table.setModel(model);		
			
		} catch (NullPointerException|SQLException ex) {
			//ex.printStackTrace();
			System.out.println("");
		}}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame frame = new ServiceFrame();
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
	public ServiceFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		Connection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(194, 10, 310, 92);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 110, 700, 16);
		contentPane.add(panel);
		
		JLabel lblBookingTransaction = new JLabel("SERVICE MANAGEMENT");
		lblBookingTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingTransaction.setForeground(new Color(114, 115, 115));
		lblBookingTransaction.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBookingTransaction.setBounds(224, 136, 248, 21);
		contentPane.add(lblBookingTransaction);
		
		txt_serviceid = new JTextField();
		txt_serviceid.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_serviceid.setForeground(new Color(114, 115, 115));
		txt_serviceid.setColumns(10);
		txt_serviceid.setBorder(null);
		txt_serviceid.setBackground(new Color(250, 234, 240));
		txt_serviceid.setBounds(137, 178, 153, 23);
		contentPane.add(txt_serviceid);
		
		JLabel lblCustomerId = new JLabel("SERVICE ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(24, 177, 122, 23);
		contentPane.add(lblCustomerId);
		
		JLabel lblName = new JLabel("STYLIST NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(24, 212, 114, 23);
		contentPane.add(lblName);
		
		txt_stylist = new JTextField();
		txt_stylist.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_stylist.setForeground(new Color(114, 115, 115));
		txt_stylist.setColumns(10);
		txt_stylist.setBorder(null);
		txt_stylist.setBackground(new Color(250, 234, 240));
		txt_stylist.setBounds(137, 211, 153, 23);
		contentPane.add(txt_stylist);
		
		JLabel lblAddress = new JLabel("TYPE:");
		lblAddress.setForeground(new Color(114, 115, 115));
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAddress.setBounds(24, 245, 70, 23);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("SERVICE:");
		lblContactNo.setForeground(new Color(114, 115, 115));
		lblContactNo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblContactNo.setBounds(24, 278, 99, 23);
		contentPane.add(lblContactNo);
		
		txt_service = new JTextField();
		txt_service.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_service.setForeground(new Color(114, 115, 115));
		txt_service.setColumns(10);
		txt_service.setBorder(null);
		txt_service.setBackground(new Color(250, 234, 240));
		txt_service.setBounds(137, 278, 153, 23);
		contentPane.add(txt_service);
		
		JComboBox<String> cbx_type = new JComboBox();
		cbx_type.setForeground(new Color(114, 115, 115));
		cbx_type.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_type.addItem("Part-time");
		cbx_type.addItem("Full-time");
		cbx_type.setBackground(new Color(250, 234, 240));
		cbx_type.setBounds(137, 245, 153, 23);
		contentPane.add(cbx_type);
		
		//Add button function with database
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//variable declaration
				String stylist = txt_stylist.getText();	
				String type = (String) cbx_type.getSelectedItem();
				String service = txt_service.getText();	
				
				try {
					pst = con.prepareStatement("INSERT INTO Services(Employee_Name, Employee_Type, Services_Name)values(?,?,?)");
					pst.setString(1, stylist);
					pst.setString(2, type);
					pst.setString(3, service);
					//pst.executeUpdate();
					
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION);
					//int l = pst.executeUpdate();
					
					if(input == JOptionPane.YES_OPTION) {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully added!");
						ShowData();
						txt_serviceid.setText("");
						txt_stylist.setText("");
						cbx_type.setSelectedItem(null);
						txt_service.setText("");	
						
					}else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
				} catch (NullPointerException|SQLException ex) {
					//ex.printStackTrace();
					System.out.println("");
				}
				
			}
		});
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCreate.setForeground(Color.BLACK);
				btnCreate.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCreate.setForeground(Color.GRAY);
				btnCreate.setBackground(new Color(252, 193, 213));
			}});
		btnCreate.setForeground(new Color(114, 115, 115));
		btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(new Color(252, 193, 213));
		btnCreate.setBounds(24, 324, 266, 33);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txt_serviceid.getText();
				String stylist = txt_stylist.getText();	
				String type = (String) cbx_type.getSelectedItem();
				String service = txt_service.getText();	
				
				try {
					pst = con.prepareStatement("UPDATE Services SET Employee_Name='"+stylist+"', Employee_Type='"+type+"', Services_Name='"+service+"' WHERE Service_ID='"+ID+"'");
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "ALERT!", JOptionPane.YES_NO_OPTION);
					if(input == JOptionPane.YES_OPTION) {
						pst.execute();
						JOptionPane.showMessageDialog(null, "Successfully updated!");
						ShowData();
					}else {
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setForeground(Color.BLACK);
				btnUpdate.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setForeground(Color.GRAY);
				btnUpdate.setBackground(new Color(252, 193, 213));
			}});
		btnUpdate.setForeground(new Color(114, 115, 115));
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(252, 193, 213));
		btnUpdate.setBounds(24, 367, 266, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
		        int SelectRowIndex = table.getSelectedRow();
		        String hold = model.getValueAt(SelectRowIndex, 0).toString();
	        	String query = "DELETE FROM Services WHERE Service_ID='"+hold +"'";
	        	
	        	 try {
					PreparedStatement pst = con.prepareStatement(query);
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
						if (input == JOptionPane.YES_OPTION) {
							pst.executeUpdate();
				               JOptionPane.showMessageDialog(null, "Deleted successfully.");
				               ShowData();
						}
					}
					txt_serviceid.setText("");
					txt_stylist.setText("");
			        txt_service.setText("");
			        cbx_type.setSelectedItem(null); 
			            
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setForeground(Color.BLACK);
				btnDelete.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setForeground(Color.GRAY);
				btnDelete.setBackground(new Color(252, 193, 213));
			}});
		btnDelete.setForeground(new Color(114, 115, 115));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(252, 193, 213));
		btnDelete.setBounds(24, 410, 108, 33);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClear.setForeground(Color.BLACK);
				btnClear.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClear.setForeground(Color.GRAY);
				btnClear.setBackground(new Color(252, 193, 213));
			}			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "Are you sure you want to clear your data?", "Warning", JOptionPane.WARNING_MESSAGE,JOptionPane.OK_CANCEL_OPTION);
				txt_serviceid.setText("");
				txt_stylist.setText("");
				txt_service.setText("");
				cbx_type.setSelectedItem(null);
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(181, 410, 108, 33);
		contentPane.add(btnClear);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDashboardFrame cv = new AdminDashboardFrame();
		    	cv.setVisible(true);
		    	ServiceFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setForeground(Color.GRAY);
			
			}
		});
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(new Color(114, 115, 115));
		lblBack.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblBack.setBounds(0, 0, 85, 37);
		contentPane.add(lblBack);
		
		JLabel lblclose = new JLabel("CLOSE");
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ServiceFrame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblclose.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblclose.setForeground(Color.GRAY);
			}
		});
		lblclose.setHorizontalAlignment(SwingConstants.CENTER);
		lblclose.setForeground(new Color(114, 115, 115));
		lblclose.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblclose.setBounds(615, 0, 85, 37);
		contentPane.add(lblclose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 178, 372, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(250, 234, 240));
		table.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int SelectRowIndex = table.getSelectedRow();
				txt_serviceid.setText(model.getValueAt(SelectRowIndex, 0).toString());
				txt_stylist.setText(model.getValueAt(SelectRowIndex, 1).toString());
				cbx_type.setSelectedItem(model.getValueAt(SelectRowIndex, 2).toString());
				txt_service.setText(model.getValueAt(SelectRowIndex, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Service ID", "Stylist", "Type", "Service"
			}
		));
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(114, 115, 115));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(252, 193, 213));
		btnSave.setBounds(554, 493, 123, 33);
		contentPane.add(btnSave);
		
		textField = new JTextField();
		textField.setForeground(new Color(114, 115, 115));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(250, 234, 240));
		textField.setBounds(427, 493, 85, 23);
		contentPane.add(textField);
		
		JLabel lblTotalAccounts = new JLabel("Total Accounts:");
		lblTotalAccounts.setForeground(new Color(114, 115, 115));
		lblTotalAccounts.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalAccounts.setBounds(305, 493, 124, 23);
		contentPane.add(lblTotalAccounts);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		//to customize the header/column
		JTableHeader JTHeader = table.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));
	}


}
