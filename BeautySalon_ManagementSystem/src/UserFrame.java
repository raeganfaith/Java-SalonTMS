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

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_user;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_username;
	private JTextField txt_pass;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserManagement = new JLabel("USER MANAGEMENT");
		lblUserManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserManagement.setForeground(new Color(114, 115, 115));
		lblUserManagement.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUserManagement.setBounds(224, 114, 280, 44);
		contentPane.add(lblUserManagement);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 100, 700, 16);
		contentPane.add(panel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(194, 0, 310, 92);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblContactNo = new JLabel("CONTACT NO.");
		lblContactNo.setForeground(new Color(114, 115, 115));
		lblContactNo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblContactNo.setBounds(21, 270, 109, 24);
		contentPane.add(lblContactNo);
		
		JLabel lblAddress = new JLabel("TYPE:");
		lblAddress.setForeground(new Color(114, 115, 115));
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAddress.setBounds(21, 236, 70, 24);
		contentPane.add(lblAddress);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(21, 202, 81, 24);
		contentPane.add(lblName);
		
		JLabel lblCustomerId = new JLabel("USER ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(21, 168, 91, 24);
		contentPane.add(lblCustomerId);
		
		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setForeground(new Color(114, 115, 115));
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUserName.setBounds(21, 304, 99, 24);
		contentPane.add(lblUserName);
		
		JComboBox<String> cbx_type = new JComboBox<String>();
		cbx_type.addItem("Part-time");
		cbx_type.addItem("Full-time");
		cbx_type.setForeground(new Color(114, 115, 115));
		cbx_type.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		cbx_type.setBackground(new Color(250, 234, 240));
		cbx_type.setBounds(128, 237, 123, 23);
		contentPane.add(cbx_type);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(114, 115, 115));
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPassword.setBounds(21, 338, 99, 24);
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
		lblclose.setBounds(615, 0, 85, 37);
		contentPane.add(lblclose);
		
		txt_user = new JTextField();
		txt_user.setEditable(false);
		txt_user.setForeground(new Color(114, 115, 115));
		txt_user.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		txt_user.setColumns(10);
		txt_user.setBorder(null);
		txt_user.setBackground(new Color(250, 234, 240));
		txt_user.setBounds(128, 169, 123, 23);
		contentPane.add(txt_user);
		
		txt_name = new JTextField();
		txt_name.setForeground(new Color(114, 115, 115));
		txt_name.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(128, 203, 123, 23);
		contentPane.add(txt_name);
		
		txt_phone = new JTextField();
		txt_phone.setForeground(new Color(114, 115, 115));
		txt_phone.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);
		txt_phone.setBackground(new Color(250, 234, 240));
		txt_phone.setBounds(128, 270, 123, 23);
		contentPane.add(txt_phone);
		
		
		
		txt_username = new JTextField();
		txt_username.setForeground(new Color(114, 115, 115));
		txt_username.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		txt_username.setColumns(10);
		txt_username.setBorder(null);
		txt_username.setBackground(new Color(250, 234, 240));
		txt_username.setBounds(130, 305, 123, 23);
		contentPane.add(txt_username);
		
		txt_pass = new JTextField();
		txt_pass.setForeground(new Color(114, 115, 115));
		txt_pass.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		txt_pass.setColumns(10);
		txt_pass.setBorder(null);
		txt_pass.setBackground(new Color(250, 234, 240));
		txt_pass.setBounds(128, 338, 123, 23);
		contentPane.add(txt_pass);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setForeground(new Color(114, 115, 115));
		btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(new Color(252, 193, 213));
		btnCreate.setBounds(21, 372, 233, 33);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(114, 115, 115));
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(252, 193, 213));
		btnUpdate.setBounds(21, 414, 233, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(114, 115, 115));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(252, 193, 213));
		btnDelete.setBounds(21, 453, 100, 33);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(154, 453, 100, 33);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 168, 417, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTotalNoOf = new JLabel("Total No. of Users:");
		lblTotalNoOf.setForeground(new Color(114, 115, 115));
		lblTotalNoOf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalNoOf.setBounds(262, 490, 159, 23);
		contentPane.add(lblTotalNoOf);
		
		textField = new JTextField();
		textField.setForeground(new Color(114, 115, 115));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(250, 234, 240));
		textField.setBounds(395, 489, 85, 23);
		contentPane.add(textField);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
