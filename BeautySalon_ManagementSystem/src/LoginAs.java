import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class LoginAs extends JFrame {
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO.png")).getImage().getScaledInstance(300, 177, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtLoginAs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAs frame = new LoginAs();
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
	public LoginAs() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 600, 350); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setBounds(147, 10, 300, 188);
		contentPane.add(lbLogo);
		setLocationRelativeTo(null);
		lbLogo.setIcon(new ImageIcon(img_logo));
		
		txtLoginAs = new JTextField();
		txtLoginAs.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginAs.setText("SIGN IN AS:");
		txtLoginAs.setOpaque(false);
		txtLoginAs.setForeground(new Color(114, 115, 115));
		txtLoginAs.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtLoginAs.setColumns(10);
		txtLoginAs.setBorder(null);
		txtLoginAs.setBounds(214, 200, 140, 26);
		contentPane.add(txtLoginAs);
		
		JComboBox<String> cbbx_Position = new JComboBox<String>();
		cbbx_Position.setForeground(new Color(114, 115, 115));
		cbbx_Position.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		//String ADMIN = "Admin";
		cbbx_Position.addItem("Admin");
		cbbx_Position.addItem("User");
		cbbx_Position.setBorder(new LineBorder(new Color(252, 193, 213))); // border color
		cbbx_Position.setBackground(new Color(250, 234, 240)); 
		cbbx_Position.setBounds(288, 327, 73, 21);
		contentPane.add(cbbx_Position);
		
		JButton btnSignin = new JButton("SIGN IN");
		btnSignin.setForeground(new Color(114, 115, 115));
		btnSignin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSignin.setBorderPainted(false);
		btnSignin.setBackground(new Color(252, 193, 213));
		btnSignin.setBounds(147, 280, 284, 38);
		contentPane.add(btnSignin);
	}
}
