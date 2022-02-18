
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
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReservationFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_cust;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_address;

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
		lblPaymentTransaction.setBounds(211, 128, 248, 33);
		contentPane.add(lblPaymentTransaction);
		
		txt_cust = new JTextField();
		txt_cust.setColumns(10);
		txt_cust.setBorder(null);
		txt_cust.setBackground(new Color(250, 234, 240));
		txt_cust.setBounds(150, 165, 162, 33);
		contentPane.add(txt_cust);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(150, 209, 162, 33);
		contentPane.add(txt_name);
		
		JComboBox cbx_time = new JComboBox();
		cbx_time.setBackground(new Color(250, 234, 240));
		cbx_time.setBounds(150, 338, 162, 33);
		contentPane.add(cbx_time);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBorder(null);
		txt_phone.setBackground(new Color(250, 234, 240));
		txt_phone.setBounds(150, 295, 162, 33);
		contentPane.add(txt_phone);
		
		JLabel lblTotalPrice = new JLabel("CONTACT NO.");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(new Color(114, 115, 115));
		lblTotalPrice.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblTotalPrice.setBounds(10, 295, 140, 33);
		contentPane.add(lblTotalPrice);
		
		JLabel lblPrices = new JLabel("TIME:");
		lblPrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrices.setForeground(new Color(114, 115, 115));
		lblPrices.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblPrices.setBounds(10, 338, 67, 33);
		contentPane.add(lblPrices);
		
		JLabel lblStatus = new JLabel("DATE");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(114, 115, 115));
		lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblStatus.setBounds(10, 381, 67, 33);
		contentPane.add(lblStatus);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblName.setBounds(10, 208, 87, 33);
		contentPane.add(lblName);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID:");
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblCustomerId.setBounds(10, 165, 140, 33);
		contentPane.add(lblCustomerId);
		
		JButton btnCreate = new JButton("CREATE");
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
		btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(new Color(252, 193, 213));
		btnCreate.setBounds(20, 424, 292, 33);
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
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(252, 193, 213));
		btnUpdate.setBounds(20, 463, 292, 33);
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
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(252, 193, 213));
		btnDelete.setBounds(20, 501, 99, 33);
		contentPane.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(250, 234, 240));
		panel_1.setBounds(322, 165, 368, 369);
		contentPane.add(panel_1);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBorder(null);
		txt_address.setBackground(new Color(250, 234, 240));
		txt_address.setBounds(150, 252, 162, 33);
		contentPane.add(txt_address);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(new Color(114, 115, 115));
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblAddress.setBounds(10, 251, 99, 33);
		contentPane.add(lblAddress);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBounds(141, 0, 21, 33);
		dateChooser.setBounds(150, 381, 162, 33);
		contentPane.add(dateChooser);
		dateChooser.setLayout(null);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardFrame cv = new DashboardFrame();
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
				txt_cust.setText("");
				txt_name.setText("");
				txt_address.setText("");
				txt_phone.setText("");
				cbx_time.setSelectedIndex(0);
				dateChooser.setCalendar(null);
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(213, 501, 99, 33);
		contentPane.add(btnClear);
	}
}
