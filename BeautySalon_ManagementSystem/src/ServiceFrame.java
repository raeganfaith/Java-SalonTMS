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
import java.sql.SQLException;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServiceFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_serviceid;
	private JTextField txt_stylist;
	private JTextField txt_service;

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
		lblBookingTransaction.setBounds(224, 124, 248, 44);
		contentPane.add(lblBookingTransaction);
		
		txt_serviceid = new JTextField();
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
		txt_service.setColumns(10);
		txt_service.setBorder(null);
		txt_service.setBackground(new Color(250, 234, 240));
		txt_service.setBounds(137, 278, 153, 23);
		contentPane.add(txt_service);
		
		JComboBox<String> cbx_type = new JComboBox();
		cbx_type.setForeground(new Color(114, 115, 115));
		cbx_type.setFont(new Font("Century Gothic", Font.PLAIN, 18));
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
					pst = con.prepareStatement("insert into Services(Service_Stylist, Service_Type, Services_Name)values(?,?,?)");
					pst.setString(1, stylist);
					pst.setString(2, type);
					pst.setString(3, service);
					//pst.executeUpdate();
					
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION);
					//int l = pst.executeUpdate();
					
					if(input == JOptionPane.YES_OPTION) {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Successfully added!");
						txt_stylist.setText("");
						cbx_type.setSelectedItem(null);
						txt_service.setText("");	
						
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
		btnCreate.setBounds(24, 324, 266, 33);
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
		btnUpdate.setBounds(24, 367, 266, 33);
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
		btnDelete.setBounds(24, 410, 266, 33);
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
				cbx_type.setSelectedIndex(0);
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(304, 492, 99, 30);
		contentPane.add(btnClear);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardFrame cv = new DashboardFrame();
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
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(114, 115, 115));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(252, 193, 213));
		btnSave.setBounds(24, 453, 266, 32);
		contentPane.add(btnSave);
		
		JButton btnPreview = new JButton("PREVIEW");
		btnPreview.setForeground(new Color(114, 115, 115));
		btnPreview.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnPreview.setBorderPainted(false);
		btnPreview.setBackground(new Color(252, 193, 213));
		btnPreview.setBounds(578, 491, 99, 33);
		contentPane.add(btnPreview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 178, 372, 303);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Service ID", "Stylist", "Type", "Service"
			}
		));
		setLocationRelativeTo(null);
		setUndecorated(true);
	}

	Connection con;
	PreparedStatement pst;
	private JTable table;
	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
}
