
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;



import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JCalendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReservationFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_cust;
	private JTextField txt_name;
	private JTextField txt_address;
	private JTextField txt_phone;
	private JTextField textField;
	public JComboBox<String> cbx_services; 
	public JComboBox<String> cbx_hairstylist;
	public JComboBox<String> cbx_time;
	
	private JTable table;
	
	
	Connection con;
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
	
	//to fetch data from the database to the JComboBox
	public void fillComboBoxService()
	{
		try
		{
			String query = "SELECT * FROM Services ";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next())
			{
				cbx_services.addItem(rs.getString("Services_Name"));
			}
			
			//rs.close();
			//ps.close();
			
		}
		catch (NullPointerException | SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("NullPointerException thrown!");
		}
	}
	public void fillComboBoxStylist()
	{
		try
		{
			String query = "SELECT * FROM Services ";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				cbx_hairstylist.addItem(rs.getString("Employee_Name"));		
			}

			//rs.close();
			//ps.close();
			
		}
		catch (NullPointerException | SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("NullPointerException thrown!");
		}
	}
	
	//a method to show and fetch data from the database to the Jtable
		public void ShowData() {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Reservation ID");
			model.addColumn("Name");
			model.addColumn("Address");
			model.addColumn("Contact No.");
			model.addColumn("Service");
			model.addColumn("Stylist");
			model.addColumn("Time");
			model.addColumn("Date");
			try {
				String query = "select * from Reservation";
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					model.addRow(new Object [] {
						rs.getString("Reservation_No"),	
						rs.getString("Cust_Name"),	
						rs.getString("Cust_Address"),	
						rs.getString("Cust_Phone"),
						rs.getString("Services_Name"),	
						rs.getString("Employee_Name"),
						rs.getString("Reserve_Time"),	
						rs.getString("Reserve_Date"),
					});
						
					}
				
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(55);
				table.getColumnModel().getColumn(1).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.getColumnModel().getColumn(3).setPreferredWidth(60);
				table.getColumnModel().getColumn(4).setPreferredWidth(60);
				table.getColumnModel().getColumn(5).setPreferredWidth(60);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
	//still need fixing
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationFrame frame = new ReservationFrame();
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
	public ReservationFrame() {
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
		setLocationRelativeTo(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(185, 10, 310, 92);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 112, 700, 16);
		contentPane.add(panel);
		
		JLabel lblPaymentTransaction = new JLabel("RESERVATION TRANSACT");
		lblPaymentTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentTransaction.setForeground(new Color(114, 115, 115));
		lblPaymentTransaction.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPaymentTransaction.setBounds(211, 128, 297, 27);
		contentPane.add(lblPaymentTransaction);
		
		JLabel lblTotalPrice = new JLabel("CONTACT NO.");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPrice.setForeground(new Color(114, 115, 115));
		lblTotalPrice.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalPrice.setBounds(10, 264, 140, 23);
		contentPane.add(lblTotalPrice);
		
		cbx_hairstylist = new JComboBox();
		cbx_hairstylist.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_hairstylist.setForeground(new Color(114, 115, 115));
		cbx_hairstylist.setBackground(new Color(250, 234, 240));
		cbx_hairstylist.setBounds(119, 329, 152, 23);
		contentPane.add(cbx_hairstylist);
		fillComboBoxStylist();
		
		cbx_services = new JComboBox<String>();
		cbx_services.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_services.setForeground(new Color(114, 115, 115));
		cbx_services.addItemListener(new ItemListener() {
			//To populate the items in the cbx_hairstylist according to the selected item in other bx_services.
			public void itemStateChanged(ItemEvent e) {

				String s = (String) cbx_services.getSelectedItem();
				String sql = "Select * from Services where Services_Name='" + s + "'";
	            try {
	                PreparedStatement pst = con.prepareStatement(sql);
	                ResultSet rs = pst.executeQuery();
	                cbx_hairstylist.removeAllItems();
	                while (rs.next()) {
	                	cbx_hairstylist.addItem(rs.getString("Employee_Name"));
	                }
	            } catch (NullPointerException | SQLException e3) 
				{
					e3.printStackTrace();
					System.out.println("NullPointerException thrown!");
				}
			}
		});
		cbx_services.setBackground(new Color(250, 234, 240));
		cbx_services.setBounds(119, 297, 153, 23);
		contentPane.add(cbx_services);
		fillComboBoxService();
		
		JLabel lblPrices = new JLabel("TIME:");
		lblPrices.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrices.setForeground(new Color(114, 115, 115));
		lblPrices.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPrices.setBounds(10, 360, 67, 23);
		contentPane.add(lblPrices);
		
		JLabel lblStatus = new JLabel("DATE");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(new Color(114, 115, 115));
		lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStatus.setBounds(10, 393, 67, 23);
		contentPane.add(lblStatus);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(10, 198, 76, 23);
		contentPane.add(lblName);
		
		JLabel lblCustomerId = new JLabel("RESERVE ID:");
		lblCustomerId.setHorizontalAlignment(SwingConstants.LEFT);
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(10, 165, 140, 23);
		contentPane.add(lblCustomerId);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setForeground(new Color(114, 115, 115));
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAddress.setBounds(10, 231, 99, 23);
		contentPane.add(lblAddress);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDashboardFrame cv = new AdminDashboardFrame();
		    	cv.setVisible(true);
		    	ReservationFrame.this.dispose();
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
					ReservationFrame.this.dispose();
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
		setUndecorated(true);
		
		cbx_time = new JComboBox<String>();
		cbx_time.addItem("Sample");
		cbx_time.addItem("Sample1");
		cbx_time.addItem("Sample2");
		cbx_time.setForeground(new Color(114, 115, 115));
		cbx_time.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_time.setBackground(new Color(250, 234, 240));
		cbx_time.setBounds(119, 360, 153, 23);
		contentPane.add(cbx_time);
		
		
		txt_cust = new JTextField();
		txt_cust.setEditable(false);
		txt_cust.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_cust.setForeground(new Color(114, 115, 115));
		txt_cust.setColumns(10);
		txt_cust.setBorder(null);
		txt_cust.setBackground(new Color(250, 234, 240));
		txt_cust.setBounds(119, 165, 153, 23);
		contentPane.add(txt_cust);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_name.setForeground(new Color(114, 115, 115));
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(119, 198, 153, 23);
		contentPane.add(txt_name);
		
		txt_address = new JTextField();
		txt_address.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_address.setForeground(new Color(114, 115, 115));
		txt_address.setColumns(10);
		txt_address.setBorder(null);
		txt_address.setBackground(new Color(250, 234, 240));
		txt_address.setBounds(119, 231, 153, 23);
		contentPane.add(txt_address);
		
		txt_phone = new JTextField();
		txt_phone.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_phone.setForeground(new Color(114, 115, 115));
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);
		txt_phone.setBackground(new Color(250, 234, 240));
		txt_phone.setBounds(119, 264, 153, 23);
		contentPane.add(txt_phone);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Century Gothic", Font.PLAIN, 15));
		dateChooser.setForeground(new Color(114, 115, 115));
		dateChooser.setBounds(119, 393, 152, 23);
		contentPane.add(dateChooser);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String id = txt_bookid.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String names = txt_name.getText();	
				String address = txt_address.getText();
				String contact = txt_phone.getText();	
				String service = (String) cbx_services.getSelectedItem();
				String hairstylist = (String) cbx_hairstylist.getSelectedItem();
				String time = (String) cbx_time.getSelectedItem();
				String date = sdf.format(dateChooser.getDate());
				
				try {
					pst = con.prepareStatement("insert into Reservation(Cust_Name, Cust_Address, Cust_Phone, Services_Name, Employee_Name, Reserve_Time, Reserve_Date)values(?,?,?,?,?,?,?)");
					pst.setString(1, names);
					pst.setString(2, address);
					pst.setString(3, contact);
					pst.setString(4, service);
					pst.setString(5, hairstylist);
					pst.setString(6, time);
					pst.setString(7, date);

					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION);
					
					if(input == JOptionPane.YES_OPTION) {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully added!");
						ShowData(); // to automatically update the table
						txt_name.setText("");
						txt_address.setText("");
						txt_phone.setText("");
						cbx_services.setSelectedIndex(-1);
						cbx_hairstylist.setSelectedItem(-1);
						cbx_time.setSelectedItem(-1);
						dateChooser.setDate(null);
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
		btnCreate.setBounds(10, 426, 262, 28);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				String ID = txt_cust.getText();
				String names1 = txt_name.getText();	
				String address1 = txt_address.getText();
				String contact1 = txt_phone.getText();	
				String service1 = (String) cbx_services.getSelectedItem();
				String stylist1 = (String) cbx_hairstylist.getSelectedItem();
				String time = (String) cbx_time.getSelectedItem();
				String date = sdf.format(dateChooser.getDate());
				
				try {
					
					pst = con.prepareStatement("UPDATE Reservation SET Cust_Name='"+names1+"', Cust_Address='"+address1+"', Cust_Phone='"+contact1+"', Services_Name='"+service1+"',Employee_Name='"+stylist1+"',Reserve_Time='"+time+"',Reserve_Date='"+date+"' WHERE Reservation_No='"+ID+"'");
					
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
		btnUpdate.setBounds(10, 464, 262, 28);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
		        int SelectRowIndex = table.getSelectedRow();
		        String hold = model.getValueAt(SelectRowIndex, 0).toString();
	        	String queryy = "DELETE FROM Reservation WHERE Reservation_No='"+hold +"'";
	        	 
		        try{
		            PreparedStatement pst = con.prepareStatement(queryy);
		            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
						if (input == JOptionPane.YES_OPTION) {
							pst.executeUpdate();
				               JOptionPane.showMessageDialog(null, "Deleted successfully.");
				               ShowData();
						}
					}
		            txt_cust.setText("");
		            txt_name.setText("");
					txt_address.setText("");
					txt_phone.setText("");
					cbx_services.setSelectedIndex(-1);
					cbx_hairstylist.setSelectedItem(-1);
					cbx_time.setSelectedIndex(-1);
					dateChooser.setDate(null);
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
		btnDelete.setBounds(11, 502, 108, 28);
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
				txt_name.setText("");
				txt_address.setText("");
				txt_phone.setText("");
				cbx_services.setSelectedIndex(-1);
				cbx_hairstylist.setSelectedItem(-1);
				cbx_time.setSelectedItem(-1);
				dateChooser.setDate(null);
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(163, 502, 108, 28);
		contentPane.add(btnClear);
		
		JLabel lblTotalNoOf = new JLabel("Total No. of Reservations:");
		lblTotalNoOf.setForeground(new Color(114, 115, 115));
		lblTotalNoOf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalNoOf.setBounds(282, 497, 189, 23);
		contentPane.add(lblTotalNoOf);
		
		textField = new JTextField();
		textField.setForeground(new Color(114, 115, 115));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(250, 234, 240));
		textField.setBounds(470, 497, 54, 23);
		contentPane.add(textField);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(114, 115, 115));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(252, 193, 213));
		btnSave.setBounds(566, 497, 108, 33);
		contentPane.add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 165, 409, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//Display selected row in textFields and JComboBox.
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int SelectRowIndex = table.getSelectedRow();
				txt_cust.setText(model.getValueAt(SelectRowIndex, 0).toString());
				txt_name.setText(model.getValueAt(SelectRowIndex, 1).toString());
				txt_address.setText(model.getValueAt(SelectRowIndex, 2).toString());
				txt_phone.setText(model.getValueAt(SelectRowIndex, 3).toString());
				cbx_services.setSelectedItem(model.getValueAt(SelectRowIndex, 4).toString());	
				cbx_hairstylist.setSelectedItem(model.getValueAt(SelectRowIndex, 5).toString());	
				cbx_time.setSelectedItem(model.getValueAt(SelectRowIndex, 6).toString());
				//get value from jTable to jDateChooser
	            try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(SelectRowIndex, 7).toString());
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	            
				
			}
		});
		table.setBackground(new Color(250, 234, 240));
		table.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane.setViewportView(table);
		
		JLabel lblService = new JLabel("SERVICE:");
		lblService.setForeground(new Color(114, 115, 115));
		lblService.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblService.setBounds(10, 297, 87, 22);
		contentPane.add(lblService);
		
		JLabel lblHairSt = new JLabel("STYLIST:");
		lblHairSt.setForeground(new Color(114, 115, 115));
		lblHairSt.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblHairSt.setBounds(10, 329, 119, 21);
		contentPane.add(lblHairSt);
		
		//to customize the header/column
		JTableHeader JTHeader = table.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));		
		
	}
}
