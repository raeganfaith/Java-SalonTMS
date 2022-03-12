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
				String query = "SELECT * FROM Payment JOIN Reservation ON Payment.Payment_ID = Reservation.Payment_ID;";
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
						rs.getString("Payment_ID"),
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
				String query = "SELECT * FROM Payment JOIN Booking ON Payment.Payment_ID = Booking.Payment_ID;";
				// JOIN Booking ON Payment.Cust_Name = Booking.Cust_Name; 
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
							rs.getString("Payment_ID"),
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
		lblUserManagement.setBounds(224, 114, 361, 44);
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
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setForeground(new Color(114, 115, 115));
		btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(new Color(252, 193, 213));
		btnCreate.setBounds(631, 498, 147, 33);
		contentPane.add(btnCreate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 168, 758, 150);
		contentPane.add(scrollPane);
		
		tableReservationPayment = new JTable();
		tableReservationPayment.setBackground(new Color(250, 234, 240));
		tableReservationPayment.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane.setViewportView(tableReservationPayment);
		
		JLabel lblTotalNoOf = new JLabel("Total No. of Users:");
		lblTotalNoOf.setForeground(new Color(114, 115, 115));
		lblTotalNoOf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalNoOf.setBounds(21, 503, 132, 23);
		contentPane.add(lblTotalNoOf);
		
		textField = new JTextField();
		textField.setForeground(new Color(114, 115, 115));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(250, 234, 240));
		textField.setBounds(154, 502, 85, 23);
		contentPane.add(textField);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(21, 342, 758, 150);
		contentPane.add(scrollPane_3);
		
		tableBookingPayments = new JTable();
		tableBookingPayments.setBackground(new Color(250, 234, 240));
		tableBookingPayments.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane_3.setViewportView(tableBookingPayments);
		
		JLabel lblTotalNoOf_1 = new JLabel("Reservation:");
		lblTotalNoOf_1.setForeground(new Color(114, 115, 115));
		lblTotalNoOf_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalNoOf_1.setBounds(21, 145, 132, 23);
		contentPane.add(lblTotalNoOf_1);
		
		JLabel lblTotalNoOf_1_1 = new JLabel("Booking:");
		lblTotalNoOf_1_1.setForeground(new Color(114, 115, 115));
		lblTotalNoOf_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalNoOf_1_1.setBounds(21, 320, 132, 23);
		contentPane.add(lblTotalNoOf_1_1);
		
		//to customize the header/column
		JTableHeader JTHeader = tableReservationPayment.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));
		
		
		JTableHeader JTHeader2 = tableBookingPayments.getTableHeader();
		JTHeader2.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader2.setBackground(new Color(252, 193, 213));

	}
}
