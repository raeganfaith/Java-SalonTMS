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

public class UserFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_accid;
	public JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_username;
	private JTextField txt_pass;
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

	//To Launch the user frame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//A method to show and fetch data from the database to the Jtable
	public void ShowData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Acc ID");
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Position");
		model.addColumn("Contact No.");
		model.addColumn("User Name");
		model.addColumn("Password");
		try {
			String query = "SELECT * FROM Account;";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				model.addRow(new Object [] {
					rs.getString("Acc_ID"),	
					rs.getString("Employee_Name"),	
					rs.getString("Employee_Type"),	
					rs.getString("Employee_Position"),
					rs.getString("Employee_Phone"),
					rs.getString("Acc_User"),	
					rs.getString("Acc_Pass"),
				});		
			}
			//Fixed size of the table columns
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(65);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(70);
			table.getColumnModel().getColumn(6).setPreferredWidth(70);	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	public UserFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//To automatically loads the 
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
		
		JLabel lblUserManagement = new JLabel("ACCOUNT MANAGEMENT");
		lblUserManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserManagement.setForeground(new Color(114, 115, 115));
		lblUserManagement.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblUserManagement.setBounds(224, 114, 346, 32);
		contentPane.add(lblUserManagement);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 100, 800, 12);
		contentPane.add(panel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(194, 0, 376, 100);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblContactNo = new JLabel("CONTACT NO.");
		lblContactNo.setForeground(new Color(114, 115, 115));
		lblContactNo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblContactNo.setBounds(23, 289, 107, 24);
		contentPane.add(lblContactNo);
		
		JLabel lblType = new JLabel("TYPE:");
		lblType.setForeground(new Color(114, 115, 115));
		lblType.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblType.setBounds(23, 224, 85, 24);
		contentPane.add(lblType);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(23, 190, 85, 24);
		contentPane.add(lblName);
		
		JLabel lblCustomerId = new JLabel("ACCOUNT ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(23, 156, 107, 24);
		contentPane.add(lblCustomerId);
		
		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setForeground(new Color(114, 115, 115));
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUserName.setBounds(23, 322, 99, 24);
		contentPane.add(lblUserName);
		
		JComboBox<String> cbx_type = new JComboBox<String>();
		cbx_type.addItem("Part-time");
		cbx_type.addItem("Full-time");
		cbx_type.setForeground(new Color(114, 115, 115));
		cbx_type.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_type.setBackground(new Color(250, 234, 240));
		cbx_type.setBounds(130, 225, 140, 23);
		contentPane.add(cbx_type);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(114, 115, 115));
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPassword.setBounds(23, 357, 107, 24);
		contentPane.add(lblPassword);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	    	    AdminDashboardFrame cv = new AdminDashboardFrame();
	    	    cv.setVisible(true);
	            UserFrame.this.dispose();
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
					UserFrame.this.dispose();
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
		
		txt_accid = new JTextField();
		txt_accid.setEditable(false);
		txt_accid.setForeground(new Color(114, 115, 115));
		txt_accid.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_accid.setColumns(10);
		txt_accid.setBorder(null);
		txt_accid.setBackground(new Color(250, 234, 240));
		txt_accid.setBounds(130, 157, 140, 23);
		contentPane.add(txt_accid);
		
		txt_name = new JTextField();
		txt_name.setForeground(new Color(114, 115, 115));
		txt_name.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(130, 191, 140, 23);
		contentPane.add(txt_name);
		
		txt_phone = new JTextField();
		txt_phone.setForeground(new Color(114, 115, 115));
		txt_phone.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);
		txt_phone.setBackground(new Color(250, 234, 240));
		txt_phone.setBounds(130, 289, 140, 23);
		contentPane.add(txt_phone);
			
		txt_username = new JTextField();
		txt_username.setForeground(new Color(114, 115, 115));
		txt_username.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_username.setColumns(10);
		txt_username.setBorder(null);
		txt_username.setBackground(new Color(250, 234, 240));
		txt_username.setBounds(132, 323, 138, 23);
		contentPane.add(txt_username);
		
		txt_pass = new JTextField();
		txt_pass.setForeground(new Color(114, 115, 115));
		txt_pass.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txt_pass.setColumns(10);
		txt_pass.setBorder(null);
		txt_pass.setBackground(new Color(250, 234, 240));
		txt_pass.setBounds(130, 357, 140, 23);
		contentPane.add(txt_pass);
		
		JComboBox<String> cbx_position = new JComboBox<String>();
		cbx_position.addItem("Admin");
		cbx_position.addItem("User");
		cbx_position.setForeground(new Color(114, 115, 115));
		cbx_position.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_position.setBackground(new Color(250, 234, 240));
		cbx_position.setBounds(130, 256, 140, 23);
		contentPane.add(cbx_position);
		setLocationRelativeTo(null);
		setUndecorated(true);
		//CREATE/ADD BUTTON FUNCTIONS
		JButton btnCreate = new JButton("ADD");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String names = txt_name.getText();	
				String type = (String) cbx_type.getSelectedItem();
				String position = (String) cbx_position.getSelectedItem();
				String contact = txt_phone.getText();
				String user = txt_username.getText();	
				String pass = txt_pass.getText();
					
				try {
					pst = con.prepareStatement("insert into Account(Employee_Name,Employee_Type,Employee_Position, Employee_Phone,Acc_User,Acc_Pass)values(?,?,?,?,?,?)");
					pst.setString(1, names);
					pst.setString(2, type);
					pst.setString(3, position);
					pst.setString(4, contact);
					pst.setString(5, user);
					pst.setString(6, pass);
					
				    //To prevent duplicate inputs in name, account users, and account passwords from users 
					String s = "";
				    boolean exists = false;
				    for(int i = 0; i < table.getRowCount(); i++) {
				    	 s = table.getValueAt(i, 1).toString().trim();
				    	 if (names.equals(s) | user.equals(s) | pass.equals(s)) {
				                exists = true;
				                JOptionPane.showMessageDialog(null, "The input duplicates some values in the table!"); 
				        } else if(names.isEmpty() |  type.isEmpty() |position.isEmpty() | contact.isEmpty()| 
					    		    user.isEmpty() | pass.isEmpty()) {
				        	 exists = true;
				             JOptionPane.showMessageDialog(null, "Please input complete values!"); break;
				        }
				    }    
				        //to add the inputs of the users that doesn't duplicates the row of the name, user and password column.    
				        if(!exists) {
						JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "CONFIRMATION!", JOptionPane.YES_NO_OPTION);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Successfully added!");
							ShowData(); //to automatically update the table 
							txt_name.setText("");
							cbx_type.setSelectedItem(-1);
							cbx_position.setSelectedItem(-1);
							txt_phone.setText("");
							txt_username.setText("");
							txt_pass.setText("");
					}else {
					}					

				} catch (NullPointerException | SQLException e2) 
				{
					JOptionPane.showMessageDialog(null, "Enter complete values!");
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
		btnCreate.setBounds(20, 391, 250, 32);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("EDIT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txt_accid.getText();
				String names = txt_name.getText();	
				String type = (String) cbx_type.getSelectedItem();
				String position = (String) cbx_position.getSelectedItem();
				String contact = txt_phone.getText();
				String user = txt_username.getText();	
				String pass = txt_pass.getText();
				
				try {
					
					pst = con.prepareStatement("UPDATE Account SET Employee_Name='"+names+"', Employee_Type='"+type+"', Employee_Position='"+position+"', Employee_Phone='"+contact+"',Acc_User='"+user+"',Acc_Pass='"+pass+"' WHERE Acc_ID='"+ID+"'");
					
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
		btnUpdate.setBounds(20, 433, 250, 33);
		contentPane.add(btnUpdate);
		//Delete Button Function
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 	DefaultTableModel model = (DefaultTableModel)table.getModel();
			    int SelectRowIndex = table.getSelectedRow();
			    String hold = model.getValueAt(SelectRowIndex, 0).toString();
		    	String queryy = "DELETE FROM Account WHERE Acc_ID='"+hold +"'";
		        	 
			     try{
			    	 PreparedStatement pst = con.prepareStatement(queryy);
			    	 int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
			    		 if(input == JOptionPane.YES_OPTION) {
			    			 pst.executeUpdate();
			    			 JOptionPane.showMessageDialog(null, "Deleted successfully.");
			    			 ShowData();
							}
						}
			            txt_accid.setText("");
						txt_name.setText("");
						cbx_type.setSelectedIndex(-1);
						cbx_position.setSelectedIndex(-1);
						txt_phone.setText("");
						txt_username.setText("");
						txt_pass.setText("");
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
		btnDelete.setBounds(23, 476, 107, 33);
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
				txt_accid.setText("");
				txt_name.setText("");
				cbx_type.setSelectedIndex(-1);
				cbx_position.setSelectedIndex(-1);
				txt_phone.setText("");
				txt_username.setText("");
				txt_pass.setText("");
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(163, 476, 107, 33);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 156, 498, 353);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
					int SelectRowIndex = table.getSelectedRow();
					txt_accid.setText(model.getValueAt(SelectRowIndex, 0).toString());
					txt_name.setText(model.getValueAt(SelectRowIndex, 1).toString());
					cbx_type.setSelectedItem(model.getValueAt(SelectRowIndex, 2).toString());
					cbx_position.setSelectedItem(model.getValueAt(SelectRowIndex, 3).toString());
					txt_phone.setText(model.getValueAt(SelectRowIndex, 4).toString());
					txt_username.setText(model.getValueAt(SelectRowIndex, 5).toString());
					txt_pass.setText(model.getValueAt(SelectRowIndex, 6).toString());
			}
		});
		table.setBorder(null);
		table.setBackground(new Color(250, 234, 240));
		table.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		scrollPane.setViewportView(table);
		
		JLabel lblPosition = new JLabel("POSITION:");
		lblPosition.setForeground(new Color(114, 115, 115));
		lblPosition.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPosition.setBounds(23, 255, 107, 24);
		contentPane.add(lblPosition);
		
		//to customize the header/column
		JTableHeader JTHeader = table.getTableHeader();
		JTHeader.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		JTHeader.setBackground(new Color(252, 193, 213));
		
	}
}