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
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TransactionFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTable tableReservationPayment;
	private JTextField textField;
	
	Connection con;
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;
	private JTable tableBookingPayments;
	private JTextField textField_1;
	
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
		public void ShowDataReservationPayment() {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("R No.");
			model.addColumn("Name");
			model.addColumn("Address");
			model.addColumn("Phone");
			model.addColumn("Time");
			model.addColumn("Date");
			model.addColumn("Service ID");
			model.addColumn("Service");
			model.addColumn("Stylist");
			model.addColumn("Payment ID");
			model.addColumn("Status");
			model.addColumn("Amount");
			model.addColumn("Discount");
			model.addColumn("Total");
			model.addColumn("Acc No.");
			try {
				String query = "SELECT * FROM ReservationPayment JOIN Reservation ON ReservationPayment.Reservation_Payment_ID = Reservation.Reservation_Payment_ID;";
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					model.addRow(new Object [] {
						rs.getString("Reservation_No"),							
						rs.getString("Cust_Name"),		
						rs.getString("Cust_Address"),
						rs.getString("Cust_Phone"),
						rs.getString("Reserve_Time"),	
						rs.getString("Reserve_Date"),
						rs.getString("Service_ID"),
						rs.getString("Services_Name"), 
						rs.getString("Employee_Name"),
						rs.getString("Reservation_Payment_ID"),
						rs.getString("Cust_Status"),
						rs.getString("Cust_Amount"),
						rs.getString("Cust_Discount"),
						rs.getString("Cust_Total"),
						rs.getString("Acc_ID"),
					});
						
					}
				
				tableReservationPayment.setModel(model);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		//DO IT LATER
		public void ShowDataBookingPayment() {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("B No.");
			model.addColumn("Name");
			model.addColumn("Address");
			model.addColumn("Phone");
			model.addColumn("Service ID");
			model.addColumn("Service");
			model.addColumn("Stylist");
			model.addColumn("Payment ID");
			model.addColumn("Status");
			model.addColumn("Amount");
			model.addColumn("Discount");
			model.addColumn("Total");
			model.addColumn("Acc No.");
			
			try {
				String query = "SELECT * FROM BookingPayment JOIN Booking ON BookingPayment.Booking_Payment_ID = Booking.Booking_Payment_ID;";
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					model.addRow(new Object [] {
							rs.getString("Booking_No"),							
							rs.getString("Cust_Name"),		
							rs.getString("Cust_Address"),
							rs.getString("Cust_Phone"),
							rs.getString("Service_ID"),
							rs.getString("Services_Name"), 
							rs.getString("Employee_Name"),
							rs.getString("Booking_Payment_ID"),
							rs.getString("Cust_Status"),
							rs.getString("Cust_Amount"),
							rs.getString("Cust_Discount"),
							rs.getString("Cust_Total"),
							rs.getString("Acc_ID"),
					});
						
					}
				
				tableBookingPayments.setModel(model);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}

	public void search(String  str) {
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) tableBookingPayments.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tableBookingPayments.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	public void search1(String  str) {
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) tableReservationPayment.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tableReservationPayment.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionFrame frame = new TransactionFrame();
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
	public TransactionFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//To automatically loads the tables from the dt to the gui
				ShowDataReservationPayment();
				ShowDataBookingPayment();
			}
		});
		Connection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserManagement = new JLabel("TRANSACTIONS HISTORY");
		lblUserManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserManagement.setForeground(new Color(114, 115, 115));
		lblUserManagement.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUserManagement.setBounds(171, 114, 414, 53);
		contentPane.add(lblUserManagement);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 100, 800, 16);
		contentPane.add(panel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(194, 0, 372, 104);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDashboardFrame cv = new AdminDashboardFrame();
		    	cv.setVisible(true);
		    	TransactionFrame.this.dispose();
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
					TransactionFrame.this.dispose();
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
		lblclose.setBounds(715, 0, 85, 37);
		contentPane.add(lblclose);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 200, 758, 142);
		contentPane.add(scrollPane);
		
		tableReservationPayment = new JTable();
		tableReservationPayment.setBackground(new Color(250, 234, 240));
		tableReservationPayment.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane.setViewportView(tableReservationPayment);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = textField.getText();
				search(searchString);
			}
		});
		textField.setForeground(new Color(114, 115, 115));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(250, 234, 240));
		textField.setBounds(92, 352, 156, 23);
		contentPane.add(textField);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(21, 385, 758, 142);
		contentPane.add(scrollPane_3);
		
		tableBookingPayments = new JTable();
		tableBookingPayments.setBackground(new Color(250, 234, 240));
		tableBookingPayments.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane_3.setViewportView(tableBookingPayments);
		
		JLabel lblReserve = new JLabel("Reservation:");
		lblReserve.setForeground(new Color(114, 115, 115));
		lblReserve.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReserve.setBounds(21, 165, 91, 24);
		contentPane.add(lblReserve);
		
		JLabel lblBook = new JLabel("Booking:");
		lblBook.setForeground(new Color(114, 115, 115));
		lblBook.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblBook.setBounds(21, 344, 91, 37);
		contentPane.add(lblBook);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search1String = textField_1.getText();
				search1(search1String);
			}
		});
		textField_1.setForeground(new Color(114, 115, 115));
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(250, 234, 240));
		textField_1.setBounds(122, 165, 156, 25);
		contentPane.add(textField_1);
		
		//to customize the header/column
		JTableHeader JTHeader = tableReservationPayment.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));
		
		
		JTableHeader JTHeader2 = tableBookingPayments.getTableHeader();
		JTHeader2.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader2.setBackground(new Color(252, 193, 213));

	}
}
