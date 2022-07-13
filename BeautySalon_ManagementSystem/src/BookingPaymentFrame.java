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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//update
public class BookingPaymentFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_custid;
	private JTextField txt_name;
	private JTextField txt_amount;
	private JTextField txt_total;
	private JTable table;
	private JComboBox<String> cbx_stat; 
	private JComboBox<String> cbx_disc;
	private String  bookingpaymentid = "";
	 //create a string for the foreign keys
	
	//Database connection
	Connection con;
	Connection connection;
	PreparedStatement pst;
	ResultSet rs;
	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;databaseName=SalonTPS;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void ShowData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Payment ID");
		model.addColumn("Name");
		model.addColumn("Status");
		model.addColumn("Amount");
		model.addColumn("Discount");
		model.addColumn("Total");
		
		try {
			String query = "SELECT * FROM BookingPayment JOIN Booking ON BookingPayment.Cust_Name = Booking.Cust_Name;";
			// JOIN Booking ON BookingPayment.Cust_Name = Booking.Cust_Name; 
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				model.addRow(new Object [] {
					rs.getString("Booking_Payment_ID"),	
					rs.getString("Cust_Name"),	
					rs.getString("Cust_Status"),
					rs.getString("Cust_Amount"),
					rs.getString("Cust_Discount"),
					rs.getString("Cust_Total"),
				});
					
				}
			
			table.setModel(model);

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	public void PaymentIDValue(){
		 String sql = "Select Booking_Payment_ID from BookingPayment;";
		 PreparedStatement pstt;
		try {
			pstt = con.prepareStatement(sql);
			ResultSet rs = pstt.executeQuery();
			while (rs.next()) {
				setBookingpaymentid(rs.getString("Booking_Payment_ID"));
           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public BookingPaymentFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
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
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(185, 10, 398, 92);
		contentPane.add(lblLogo);
		setLocationRelativeTo(null); //to center the frame
		setUndecorated(true);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 112, 800, 16);
		contentPane.add(panel);
		
		JLabel lblPaymentTransaction = new JLabel("BOOKING PAYMENT TRANSACTION");
		lblPaymentTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentTransaction.setForeground(new Color(114, 115, 115));
		lblPaymentTransaction.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPaymentTransaction.setBounds(168, 128, 504, 42);
		contentPane.add(lblPaymentTransaction);
		
		JLabel lblCustomerId = new JLabel("PAYMENT ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(22, 169, 121, 26);
		contentPane.add(lblCustomerId);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(22, 205, 121, 21);
		contentPane.add(lblName);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setForeground(new Color(114, 115, 115));
		lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStatus.setBounds(22, 236, 121, 22);
		contentPane.add(lblStatus);
		
		JLabel lblPrices = new JLabel("DISCOUNT:");
		lblPrices.setForeground(new Color(114, 115, 115));
		lblPrices.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPrices.setBounds(22, 301, 121, 23);
		contentPane.add(lblPrices);
		
		JLabel lblTotalPrice = new JLabel("TOTAL:");
		lblTotalPrice.setForeground(new Color(114, 115, 115));
		lblTotalPrice.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalPrice.setBounds(22, 334, 121, 23);
		contentPane.add(lblTotalPrice);
		
		JLabel lblclose = new JLabel("CLOSE");
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					BookingPaymentFrame.this.dispose();
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
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookingFrame cv = new BookingFrame();
		    	cv.setVisible(true);
		    	BookingPaymentFrame.this.dispose();
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
		
		JLabel lblAmount = new JLabel("AMOUNT:");
		lblAmount.setForeground(new Color(114, 115, 115));
		lblAmount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAmount.setBounds(22, 268, 121, 23);
		contentPane.add(lblAmount);
		
		txt_custid = new JTextField();
		txt_custid.setEditable(false);
		txt_custid.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_custid.setForeground(new Color(114, 115, 115));
		txt_custid.setColumns(10);
		txt_custid.setBorder(null);
		txt_custid.setBackground(new Color(250, 234, 240));
		txt_custid.setBounds(141, 169, 160, 23);
		contentPane.add(txt_custid);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_name.setForeground(new Color(114, 115, 115));
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(141, 202, 160, 23);
		contentPane.add(txt_name);
		
		cbx_stat = new JComboBox<String>();
		cbx_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cbx_stat.addItem("Paid");
		cbx_stat.addItem("Unpaid");
		cbx_stat.setForeground(new Color(114, 115, 115));
		cbx_stat.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_stat.setBackground(new Color(250, 234, 240));
		cbx_stat.setBounds(141, 235, 160, 23);
		contentPane.add(cbx_stat);
		
		txt_amount = new JTextField();
		txt_amount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_amount.setForeground(new Color(114, 115, 115));
		txt_amount.setColumns(10);
		txt_amount.setBorder(null);
		txt_amount.setBackground(new Color(250, 234, 240));
		txt_amount.setBounds(140, 268, 161, 23);
		contentPane.add(txt_amount);
		
		txt_total = new JTextField();
		txt_total.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_total.setForeground(new Color(114, 115, 115));
		txt_total.setColumns(10);
		txt_total.setBorder(null);
		txt_total.setBackground(new Color(250, 234, 240));
		txt_total.setBounds(141, 334, 160, 23);
		contentPane.add(txt_total);
		
		cbx_disc = new JComboBox<String>();
		cbx_disc.addItem("50% off");
		cbx_disc.addItem("25% off");
		cbx_disc.addItem("10% off");
		cbx_disc.addItem("5% off");
		cbx_disc.addItem("NO DISCOUNT");
		//COMPUTATION
		cbx_disc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Double AmountNum = Double.parseDouble(txt_amount.getText());
				if(cbx_disc.getSelectedItem().equals("50% off")) {
					//int s= 100-50;
					double computation = ((100-50)*AmountNum)/100;
					txt_total.setText(String.valueOf(computation));
				}else if(cbx_disc.getSelectedItem().equals("25% off")){
					double computation = ((100-25)*AmountNum)/100;
					txt_total.setText(String.valueOf(computation));
				}else if(cbx_disc.getSelectedItem().equals("10% off")){
					double computation = ((100-10)*AmountNum)/100;
					txt_total.setText(String.valueOf(computation));
				}else if(cbx_disc.getSelectedItem().equals("5% off")){
					double computation = ((100-5)*AmountNum)/100;
					txt_total.setText(String.valueOf(computation));
				}else if(cbx_disc.getSelectedItem().equals("NO DISCOUNT")) {
					double computation = (AmountNum);
					txt_total.setText(String.valueOf(computation));
				} else {
					
				}
				  
			}catch(NumberFormatException nfe) {
				return;
			}	
		}
	});
		
		cbx_disc.setForeground(new Color(114, 115, 115));
		cbx_disc.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_disc.setBackground(new Color(250, 234, 240));
		cbx_disc.setBounds(140, 301, 161, 23);
		contentPane.add(cbx_disc);
		
		JButton btnCreate = new JButton("ADD");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please use the edit button for updating data!");	
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
		btnCreate.setBounds(22, 374, 279, 33);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("EDIT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txt_custid.getText();
				String names = txt_name.getText();	
				String status = (String) cbx_stat.getSelectedItem();
				String amount = txt_amount.getText();
				String disc = (String) cbx_disc.getSelectedItem();
				String total = txt_total.getText();	
				//String s = LoginFrame.txtPass.getText();				
				try {
					
					pst = con.prepareStatement("UPDATE BookingPayment SET Cust_Name='"+names+"', Cust_Status='"+status+"', Cust_Amount='"+amount+"', Cust_Discount='"+disc+"',Cust_Total='"+total+"' WHERE Booking_Payment_ID='"+ID+"'");
					
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to make changes?", "ALERT!", JOptionPane.YES_NO_OPTION);
					if(input == JOptionPane.YES_OPTION) {
						pst.execute();
						JOptionPane.showMessageDialog(null, "Successfully updated!");
						ShowData();
						txt_custid.setText("");
						txt_name.setText("");
						cbx_stat.setSelectedIndex(-1);
						txt_amount.setText("");
						cbx_disc.setSelectedIndex(-1);
						txt_total.setText(" ");
						txt_total.setText("");
					}else {
						
					}
						
				} catch (NullPointerException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
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
		btnUpdate.setBounds(22, 417, 279, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Please delete the data from the booking first!");
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
		btnDelete.setBounds(22, 460, 121, 33);
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
			//clear function
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "Are you sure you want to clear your data?", "Warning", JOptionPane.WARNING_MESSAGE,JOptionPane.OK_CANCEL_OPTION);
				txt_custid.setText("");
	            txt_name.setText("");
	            cbx_stat.setSelectedIndex(-1);
	            txt_amount.setText("");
	            cbx_disc.setSelectedIndex(-1);
	            txt_total.setText("");
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(180, 460, 121, 33);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 169, 460, 324);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int SelectRowIndex = table.getSelectedRow();
					txt_custid.setText(model.getValueAt(SelectRowIndex, 0).toString());
					txt_name.setText(model.getValueAt(SelectRowIndex, 1).toString());
					cbx_stat.setSelectedItem(model.getValueAt(SelectRowIndex, 2).toString());
					txt_amount.setText(model.getValueAt(SelectRowIndex, 3).toString());
					cbx_disc.setSelectedItem(model.getValueAt(SelectRowIndex, 4).toString());
					txt_total.setText(model.getValueAt(SelectRowIndex, 5).toString());	
				}catch(NullPointerException ex) {
					
				}
			}
		});
		table.setBackground(new Color(250, 234, 240));
		table.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane.setViewportView(table);
		
		//to customize the header/column
		JTableHeader JTHeader = table.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));
		
		JButton btnSave = new JButton("GO BACK TO DASHBOARD");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserDashboardFrame cv = new UserDashboardFrame();
		    	cv.setVisible(true);
		    	BookingPaymentFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSave.setForeground(Color.BLACK);
				btnSave.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSave.setForeground(Color.GRAY);
				btnSave.setBackground(new Color(252, 193, 213));
			}});
		btnSave.setForeground(new Color(114, 115, 115));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(252, 193, 213));
		btnSave.setBounds(545, 503, 233, 33);
		contentPane.add(btnSave);
		
	}

	public String getBookingpaymentid() {
		return bookingpaymentid;
	}

	public void setBookingpaymentid(String bookingpaymentid) {
		this.bookingpaymentid = bookingpaymentid;
	}
}
