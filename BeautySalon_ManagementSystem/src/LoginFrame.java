import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO.png")).getImage().getScaledInstance(300, 177, Image.SCALE_SMOOTH);
	private Image img_acc = new ImageIcon(LoginFrame.class.getResource("res/ACCNT.png")).getImage().getScaledInstance(28, 29, Image.SCALE_SMOOTH);
	private Image img_pass = new ImageIcon(LoginFrame.class.getResource("res/PASS.png")).getImage().getScaledInstance(28, 29, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtUser;
	private JLabel lbLogo;
	private JLabel lblAcc;
	private JLabel lblPass;
	private JLabel lblclose;
	private JPasswordField txtPass;

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
		UserPanel.setBounds(214, 237, 270, 38);
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
		PassPanel.setBounds(214, 285, 270, 38);
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
		lbLogo.setBounds(190, 17, 294, 210);
		contentPane.add(lbLogo);
		setUndecorated(true);
		lbLogo.setIcon(new ImageIcon(img_logo));
		
		lblAcc = new JLabel("");
		lblAcc.setBounds(184, 238, 28, 37);
		contentPane.add(lblAcc);
		setLocationRelativeTo(null);
		lblAcc.setIcon(new ImageIcon(img_acc));
		
		lblPass = new JLabel("");
		lblPass.setBounds(184, 286, 28, 37);
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
		ShowPass.setBounds(353, 329, 131, 21);
		contentPane.add(ShowPass);
		
		JButton btnSignin = new JButton("SIGN IN");
		btnSignin.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//to change frame 
				DashboardFrame cv = new DashboardFrame();
		    	cv.setVisible(true);
				LoginFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignin.setForeground(Color.BLACK);
				btnSignin.setBackground(new Color(253, 139, 180));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignin.setForeground(Color.GRAY);
				btnSignin.setBackground(new Color(252, 193, 213));
			}});
		btnSignin.setForeground(new Color(114, 115, 115));
		btnSignin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSignin.setBorderPainted(false);
		btnSignin.setBounds(214, 356, 270, 38);
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
		
		
		
	}
}
