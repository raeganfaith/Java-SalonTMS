import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
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
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class BookingFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_cust;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_address;
	private JTable table;
	public JComboBox<String> cbx_services; 
	public JComboBox<String> cbx_hairstylist;
	
	Connection con;
	Connection conn;
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	public void fillComboBoxService()
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;");
			String query = "SELECT * FROM Services ";
//			String query = "select EID, Name, Surname, Age from EmployeeInfo";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				//String db_serve = "Services_Name";
				cbx_services.addItem(rs.getString("Services_Name"));
				//cbx_hairstylist.addItem(rs.getString("Service_Stylist"));		
			}
			
			//table.setModel(.resultSetToTableModel(rs));
			rs.close();
			ps.close();
			
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
	public void fillComboBoxStylist()
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;");
			String query = "SELECT * FROM Services ";
//			String query = "select EID, Name, Surname, Age from EmployeeInfo";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				//String db_serve = "Services_Name";
				//cbx_services.addItem(rs.getString("Services_Name"));
				cbx_hairstylist.addItem(rs.getString("Service_Stylist"));		
			}
			
			//table.setModel(.resultSetToTableModel(rs));
			rs.close();
			ps.close();
			
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingFrame frame = new BookingFrame();
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
	public BookingFrame() {
		Connection(); //method for the database
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(194, 10, 310, 92);
		contentPane.add(lblLogo);
		setUndecorated(true);
		lblLogo.setIcon(new ImageIcon(img_logo)); //insert logo
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 110, 700, 16);
		contentPane.add(panel);
		
		JLabel lblBookingTransaction = new JLabel("BOOKING TRANSACTION");
		lblBookingTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingTransaction.setForeground(new Color(114, 115, 115));
		lblBookingTransaction.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBookingTransaction.setBounds(224, 124, 248, 44);
		contentPane.add(lblBookingTransaction);
		
		txt_cust = new JTextField();
		txt_cust.setColumns(10);
		txt_cust.setBorder(null);
		txt_cust.setBackground(new Color(250, 234, 240));
		txt_cust.setBounds(150, 178, 162, 23);
		contentPane.add(txt_cust);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(150, 208, 162, 23);
		contentPane.add(txt_name);

		cbx_hairstylist = new JComboBox();
		cbx_hairstylist.setBackground(new Color(250, 234, 240));
		cbx_hairstylist.setBounds(150, 341, 162, 23);
		contentPane.add(cbx_hairstylist);
		fillComboBoxStylist();
		
		cbx_services = new JComboBox();
		cbx_services.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s = cbx_services.getSelectedItem().toString();
	            String sql = "Select * from Services where Services_Name='" + s + "'";
	            try {
	            	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;");
	                PreparedStatement pst = conn.prepareStatement(sql);
	                ResultSet rs = pst.executeQuery();
	                cbx_hairstylist.removeAllItems();
	                while (rs.next()) {
	                	cbx_hairstylist.addItem(rs.getString("Service_Stylist"));
	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
			}
		});
		
		//cbx_services.addItem("SAMPLE1");
		//cbx_service.addItem("SAMPLE2");
		cbx_services.setBackground(new Color(250, 234, 240));
		cbx_services.setBounds(150, 308, 162, 23);
		contentPane.add(cbx_services);
		fillComboBoxService();
		

		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);
		txt_phone.setBackground(new Color(250, 234, 240));
		txt_phone.setBounds(150, 275, 162, 23);
		contentPane.add(txt_phone);
		
		JLabel lblContactNo = new JLabel("CONTACT NO:");
		lblContactNo.setForeground(new Color(114, 115, 115));
		lblContactNo.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblContactNo.setBounds(10, 275, 138, 20);
		contentPane.add(lblContactNo);
		
		JLabel lblHairSt = new JLabel("HAIR STYLIST:");
		lblHairSt.setForeground(new Color(114, 115, 115));
		lblHairSt.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblHairSt.setBounds(10, 341, 119, 26);
		contentPane.add(lblHairSt);
		
		JLabel lblService = new JLabel("SERVICE:");
		lblService.setForeground(new Color(114, 115, 115));
		lblService.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblService.setBounds(10, 308, 87, 22);
		contentPane.add(lblService);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblName.setBounds(10, 207, 87, 25);
		contentPane.add(lblName);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblCustomerId.setBounds(10, 178, 143, 23);
		contentPane.add(lblCustomerId);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBorder(null);
		txt_address.setBackground(new Color(250, 234, 240));
		txt_address.setBounds(150, 242, 162, 23);
		contentPane.add(txt_address);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setForeground(new Color(114, 115, 115));
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblAddress.setBounds(10, 242, 100, 25);
		contentPane.add(lblAddress);
		/** 
		name
		address
		contact number
		service
		hairstylist

		 * */
		//Add button function linked with database
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String names = txt_name.getText();	
				String address = txt_address.getText();
				String contact = txt_phone.getText();	
				String service = (String) cbx_services.getSelectedItem();
				String hairstylist = (String) cbx_hairstylist.getSelectedItem();
				
				try {
					pst = con.prepareStatement("insert into Booking(Booking_name, Booking_address, Booking_contact, Services_Name, Service_Stylist)values(?,?,?,?,?)");
					pst.setString(1, names);
					pst.setString(2, address);
					pst.setString(3, contact);
					pst.setString(4, service);
					pst.setString(5, hairstylist);
					//pst.executeUpdate();
					
					int k = pst.executeUpdate();
					
					if(k==1) {
						JOptionPane.showMessageDialog(null, "Successfully added!");
					}else {
						JOptionPane.showMessageDialog(null, "Error!");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
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
		btnCreate.setBounds(20, 387, 292, 33);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
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
		btnUpdate.setBounds(20, 429, 292, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
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
		btnDelete.setBounds(20, 468, 99, 33);
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
				txt_cust.setText("");
				txt_name.setText("");
				txt_address.setText("");
				txt_phone.setText("");
				cbx_services.setSelectedIndex(0);
				cbx_hairstylist.setSelectedIndex(0);
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(213, 468, 99, 33);
		contentPane.add(btnClear);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardFrame cv = new DashboardFrame();
		    	cv.setVisible(true);
		    	BookingFrame.this.dispose();
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
					BookingFrame.this.dispose();
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
		scrollPane.setBorder(null);
		scrollPane.setBounds(333, 168, 346, 294);
		scrollPane.setBackground(new Color(250, 234, 240));
		
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		table.setBackground(new Color(250, 234, 240));
		scrollPane.setColumnHeaderView(table);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(114, 115, 115));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(252, 193, 213));
		btnSave.setBounds(333, 468, 99, 33);
		contentPane.add(btnSave);
		
		JButton btnPreview = new JButton("PREVIEW");
		btnPreview.setForeground(new Color(114, 115, 115));
		btnPreview.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnPreview.setBorderPainted(false);
		btnPreview.setBackground(new Color(252, 193, 213));
		btnPreview.setBounds(580, 468, 99, 33);
		contentPane.add(btnPreview);
	}
	//Database connection
	//Connection con;
	//This is the connection for add button in booking


}


















