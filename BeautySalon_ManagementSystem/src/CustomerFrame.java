import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomerFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_custid;
	private JTextField txt_name;
	private JTextField txt_address;
	private JTextField txt_phone;
	private JTable table;
	
	Connection con;
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;
	
	//Database Connection
	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;databaseName=SalonTPS;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}
	//a method to show and fetch data from the database to the Jtable
	public void ShowData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Customer ID");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		try {
			String query = "select * from Customer";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();		
				while(rs.next()) {
					model.addRow(new Object [] {
					rs.getString("Customer_ID"),	
					rs.getString("Cust_Name"),	
					rs.getString("Cust_Address"),	
					rs.getString("Cust_Phone"),
				});				
			}
			table.setModel(model);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}}
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
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
		
		JLabel lblUserManagement = new JLabel("CUSTOMER DETAILS");
		lblUserManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserManagement.setForeground(new Color(114, 115, 115));
		lblUserManagement.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUserManagement.setBounds(224, 114, 280, 47);
		contentPane.add(lblUserManagement);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 100, 700, 16);
		contentPane.add(panel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(194, 0, 310, 92);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(114, 115, 115));
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAddress.setBounds(21, 236, 104, 24);
		contentPane.add(lblAddress);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(21, 202, 85, 24);
		contentPane.add(lblName);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(21, 168, 125, 24);
		contentPane.add(lblCustomerId);
		
		JLabel lblPhone = new JLabel("CONTACT NO.");
		lblPhone.setForeground(new Color(114, 115, 115));
		lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPhone.setBounds(21, 270, 112, 24);
		contentPane.add(lblPhone);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDashboardFrame cv = new AdminDashboardFrame();
		    	cv.setVisible(true);
		    	CustomerFrame.this.dispose();
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
					CustomerFrame.this.dispose();
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
		
		txt_custid = new JTextField();
		txt_custid.setEditable(false);
		txt_custid.setForeground(new Color(114, 115, 115));
		txt_custid.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_custid.setColumns(10);
		txt_custid.setBorder(null);
		txt_custid.setBackground(new Color(250, 234, 240));
		txt_custid.setBounds(128, 169, 165, 23);
		contentPane.add(txt_custid);
		
		txt_name = new JTextField();
		txt_name.setForeground(new Color(114, 115, 115));
		txt_name.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(128, 203, 165, 23);
		contentPane.add(txt_name);
		
		txt_address = new JTextField();
		txt_address.setForeground(new Color(114, 115, 115));
		txt_address.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_address.setColumns(10);
		txt_address.setBorder(null);
		txt_address.setBackground(new Color(250, 234, 240));
		txt_address.setBounds(128, 236, 165, 23);
		contentPane.add(txt_address);
			
		txt_phone = new JTextField();
		txt_phone.setForeground(new Color(114, 115, 115));
		txt_phone.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);
		txt_phone.setBackground(new Color(250, 234, 240));
		txt_phone.setBounds(130, 271, 163, 23);
		contentPane.add(txt_phone);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String names = txt_name.getText();	
				String address = txt_address.getText();
				String contact = txt_phone.getText();	
		
				try {
					pst = con.prepareStatement("insert into Customer(Cust_Name, Cust_Address, Cust_Phone)values(?,?,?)");
					pst.setString(1, names);
					pst.setString(2, address);
					pst.setString(3, contact);
										
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION);
					
					if(input == JOptionPane.YES_OPTION) {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully added!");
						ShowData(); 
						txt_name.setText("");
						txt_address.setText("");
						txt_phone.setText("");				
					} else {
						JOptionPane.showMessageDialog(null, "Error!");
					}

				} catch (NullPointerException | SQLException e2) 
				{
					e2.printStackTrace();
					System.out.println("NullPointerException thrown!");
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
		btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(new Color(252, 193, 213));
		btnCreate.setBounds(21, 304, 272, 33);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txt_custid.getText();
				String names = txt_name.getText();	
				String address = txt_address.getText();
				String phone = txt_phone.getText();			
				try {
					
					pst = con.prepareStatement("UPDATE Customer SET Cust_Name='"+names+"', Cust_Address='"+address+"', Cust_Phone='"+phone+"' WHERE Customer_ID='"+ID+"'");
					
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
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(252, 193, 213));
		btnUpdate.setBounds(21, 346, 272, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	DefaultTableModel model = (DefaultTableModel)table.getModel();
			        int SelectRowIndex = table.getSelectedRow();
			        String hold = model.getValueAt(SelectRowIndex, 0).toString();
		        	String queryy = "DELETE FROM Customer WHERE Customer_ID='"+hold +"'";
		        	 
			        try{
			            PreparedStatement pst = con.prepareStatement(queryy);
			            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
							if (input == JOptionPane.YES_OPTION) {
								pst.executeUpdate();
					               JOptionPane.showMessageDialog(null, "Deleted successfully.");
					               ShowData();
							}
						}
			            txt_custid.setText("");
						txt_name.setText("");
						txt_address.setText("");
						txt_phone.setText("");

			        }catch(HeadlessException | SQLException e11){
			            JOptionPane.showMessageDialog(null,e11);
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
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(252, 193, 213));
		btnDelete.setBounds(21, 391, 272, 33);
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
				//clear function
			}			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "Are you sure you want to clear your data?", "Warning", JOptionPane.WARNING_MESSAGE,JOptionPane.OK_CANCEL_OPTION);
				txt_custid.setText("");
				txt_name.setText("");
				txt_address.setText("");
				txt_phone.setText("");

			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(21, 434, 272, 33);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(303, 168, 375, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int SelectRowIndex = table.getSelectedRow();
				txt_custid.setText(model.getValueAt(SelectRowIndex, 0).toString());
				txt_name.setText(model.getValueAt(SelectRowIndex, 1).toString());
				txt_address.setText(model.getValueAt(SelectRowIndex, 2).toString());
				txt_phone.setText(model.getValueAt(SelectRowIndex, 3).toString());	
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnProceedToPayment = new JButton("PROCEED TO PAYMENT");
		btnProceedToPayment.setForeground(new Color(114, 115, 115));
		btnProceedToPayment.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnProceedToPayment.setBorderPainted(false);
		btnProceedToPayment.setBackground(new Color(252, 193, 213));
		btnProceedToPayment.setBounds(303, 493, 375, 33);
		contentPane.add(btnProceedToPayment);
		
		//to customize the header/column
		JTableHeader JTHeader = table.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));
		
	}
}
