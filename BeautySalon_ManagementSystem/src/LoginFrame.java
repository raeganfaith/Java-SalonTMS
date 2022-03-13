import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.sql.Connection;
import javax.swing.JComboBox;

public class LoginFrame extends JFrame {
	
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO.png")).getImage().getScaledInstance(300, 177, Image.SCALE_SMOOTH);
	private Image img_accid = new ImageIcon(LoginFrame.class.getResource("res/ACCID.png")).getImage().getScaledInstance(33, 29, Image.SCALE_SMOOTH);
	private Image img_acc = new ImageIcon(LoginFrame.class.getResource("res/ACCNT.png")).getImage().getScaledInstance(28, 29, Image.SCALE_SMOOTH);
	private Image img_pass = new ImageIcon(LoginFrame.class.getResource("res/PASS.png")).getImage().getScaledInstance(28, 29, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	//private JTextField txtUser;
	private JLabel lbLogo;
	private JLabel lblAcc;
	private JLabel lblPass;
	private JLabel lblclose;
	public static JPasswordField txtPass;
	public static JTextField txtAccountId;
	public static JTextField txtUser;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	//private JTextField txtAccountId;
	
	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;databaseName=SalonTPS;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
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
	public LoginFrame() {
		
		Connection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel UserPanel = new JPanel();
		UserPanel.setBorder(new LineBorder(new Color(252, 193, 213))); // border color
		UserPanel.setBackground(new Color(250, 234, 240)); 
		UserPanel.setBounds(220, 276, 284, 38);
		contentPane.add(UserPanel);
		UserPanel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUser.getText().equals("Username")) {
					txtUser.setText("");
				} else {
					txtUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUser.getText().equals(""))
					txtUser.setText("Username");
			}
		});
		txtUser.setForeground(new Color(114, 115, 115)); // font color
		txtUser.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtUser.setText("Username");
		txtUser.setOpaque(false);
		txtUser.setBounds(10, 0, 250, 38);
		UserPanel.add(txtUser);
		txtUser.setBorder(null);
		txtUser.setColumns(10);
		
		JPanel PassPanel = new JPanel();
		PassPanel.setBorder(new LineBorder(new Color(252, 193, 213)));
		PassPanel.setBackground(new Color(250, 234, 240));
		PassPanel.setBounds(220, 324, 284, 38);
		contentPane.add(PassPanel);
		PassPanel.setLayout(null);
		
		txtPass = new JPasswordField();
		txtPass.setEchoChar('*');
		txtPass.setText("Password");
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPass.getText().equals("Password")) { 
					txtPass.setEchoChar('*');//can also be changed to bullet
					txtPass.setText("");
				} else {
					txtPass.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equals("")) {
					txtPass.setText("Password");
					txtPass.setEchoChar((char)0);//So that the password will default to text
				}
			}
		});
		txtPass.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtPass.setBorder(null);
		txtPass.setBackground(new Color(250, 234, 240));
		txtPass.setForeground(new Color(114, 115, 115)); // font color
		txtPass.setBounds(10, 0, 250, 38);
		PassPanel.add(txtPass);
		
		lbLogo = new JLabel("");
		lbLogo.setBounds(210, 20, 294, 197);
		contentPane.add(lbLogo);
		setUndecorated(true);
		lbLogo.setIcon(new ImageIcon(img_logo));
		
		lblAcc = new JLabel("");
		lblAcc.setBounds(185, 277, 28, 37);
		contentPane.add(lblAcc);
		setLocationRelativeTo(null);
		lblAcc.setIcon(new ImageIcon(img_acc));
		
		lblPass = new JLabel("");
		lblPass.setBounds(185, 325, 28, 37);
		contentPane.add(lblPass);
		lblPass.setIcon(new ImageIcon(img_pass));
		
		JCheckBox ShowPass = new JCheckBox("Show Password");
		ShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShowPass.isSelected()) {
					txtPass.setEchoChar((char)0);
				}else {
					txtPass.setEchoChar('*');//Can be changed to bullet •
				}
			}
		});
		
		ShowPass.setForeground(new Color(114, 115, 115));
		ShowPass.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ShowPass.setOpaque(false);
		ShowPass.setBounds(373, 368, 131, 21);
		contentPane.add(ShowPass);
		
		
		//Hover effects
		JButton btnSignin = new JButton("SIGN IN");	
		btnSignin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignin.setForeground(Color.BLACK);
				btnSignin.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignin.setForeground(Color.GRAY);
				btnSignin.setBackground(new Color(252, 193, 213));
			}
		});
		//Sign in Button function with database 
		btnSignin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
				String connectionsUrl = "jdbc:sqlserver://localhost:1433;databaseName=SalonTPS;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";
				//To Pass Value
						
				try (Connection connection = DriverManager.getConnection(connectionsUrl);) {
				//For position variables
							//declaring variables for fucntions
							String users =  txtUser.getText();
							String passw =  txtPass.getText();
							String accid = txtAccountId.getText();
							
							
							String sqlQuery = "SELECT * FROM Account WHERE Acc_ID=? and Acc_User=? and Acc_Pass=?";
							PreparedStatement pst = connection.prepareStatement(sqlQuery);
							pst.setString(1, txtAccountId.getText());
							pst.setString(2, txtUser.getText());
							pst.setString(3, txtPass.getText());
							ResultSet rs = pst.executeQuery();
							
							String db_ID = "";
							String db_User = "";
							String db_Pass = "";
							String db_Position = "";
							
							while(rs.next()) {
								db_ID = rs.getString("Acc_ID");
								db_User = rs.getString("Acc_User");
								db_Pass = rs.getString("Acc_Pass");
								db_Position = rs.getString("Employee_Position");
							}
							
							String sqlQuery2 = "SELECT * FROM Account WHERE Employee_Position=?";
							PreparedStatement pst1 = connection.prepareStatement(sqlQuery2);
							pst1.setString(1, db_Position);
							ResultSet rs1 = pst.executeQuery();
							
							if (db_User.equals(users) && db_Pass.equals(passw) && db_ID.equals(accid)) {
								
								//To automatically determine if the account logged in is user or admin
								if(db_Position.equals("Admin")) {
									JOptionPane.showMessageDialog(null, "You Successfully logged in as Admin!");
									
									//String user = txtUser.getText();
								   // String pass =  txtPass.getText();
								    //BookingFrame frameOne = new BookingFrame();
								    //frameOne.setUser(user);
								    //frameOne.setPass(pass);
								  //  frameOne.setVisible(false);
								    
									AdminDashboardFrame cv = new AdminDashboardFrame();
							    	cv.setVisible(true);
									LoginFrame.this.dispose();
									
									
								}else if(db_Position.equals("User")) {
									JOptionPane.showMessageDialog(null, "You Successfully logged in as User!");
									
									
									UserDashboardFrame cv = new UserDashboardFrame();
							    	cv.setVisible(true);
									LoginFrame.this.dispose();
									
									
								    //BookingFrame frameOne = new BookingFrame();
								   // frameOne.setUser(user);
								   // frameOne.setPass(pass);
								   // frameOne.setVisible(false);
								    
									
									
								}
							//this will show if the credentials doesn't match
							} else {
								JOptionPane.showMessageDialog(null, "Please enter correct credentials!");
							}						
						} catch (NullPointerException|SQLException ex) {
							ex.printStackTrace();
							System.out.println("");
						}
				}	
					
			});

		btnSignin.setForeground(new Color(114, 115, 115));
		btnSignin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSignin.setBorderPainted(false);
		btnSignin.setBounds(220, 389, 284, 38);
		btnSignin.setBackground(new Color(252, 193, 213));
		contentPane.add(btnSignin);
		
		lblclose = new JLabel("CLOSE");
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginFrame.this.dispose();
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
		
		JLabel lblAccID = new JLabel("");
		lblAccID.setBounds(185, 230, 33, 37);
		lblAccID.setIcon(new ImageIcon(img_accid));
		contentPane.add(lblAccID); 
		
		JPanel UserPanel_1 = new JPanel();
		UserPanel_1.setLayout(null);
		UserPanel_1.setBorder(new LineBorder(new Color(252, 193, 213)));
		UserPanel_1.setBackground(new Color(250, 234, 240));
		UserPanel_1.setBounds(220, 228, 284, 38);
		contentPane.add(UserPanel_1);
		
		txtAccountId = new JTextField();
		txtAccountId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAccountId.getText().equals("Account ID")) {
					txtAccountId.setText("");
				} else {
					txtAccountId.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAccountId.getText().equals(""))
					txtAccountId.setText("Account ID");
			}
		});
		txtAccountId.setText("Account ID");
		txtAccountId.setOpaque(false);
		txtAccountId.setForeground(new Color(114, 115, 115));
		txtAccountId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtAccountId.setColumns(10);
		txtAccountId.setBorder(null);
		txtAccountId.setBounds(10, 0, 250, 38);
		UserPanel_1.add(txtAccountId);
		
		
		
	}
}
