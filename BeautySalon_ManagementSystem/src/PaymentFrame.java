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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaymentFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_cust;
	private JTextField txt_name;
	private JTextField txt_total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentFrame frame = new PaymentFrame();
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
	public PaymentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(185, 10, 310, 92);
		contentPane.add(lblLogo);
		setLocationRelativeTo(null); //to center the frame
		setUndecorated(true);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 112, 700, 16);
		contentPane.add(panel);
		
		JLabel lblPaymentTransaction = new JLabel("PAYMENT TRANSACTION");
		lblPaymentTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentTransaction.setForeground(new Color(114, 115, 115));
		lblPaymentTransaction.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPaymentTransaction.setBounds(211, 128, 248, 54);
		contentPane.add(lblPaymentTransaction);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID:");
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblCustomerId.setBounds(10, 179, 151, 33);
		contentPane.add(lblCustomerId);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblName.setBounds(10, 221, 87, 33);
		contentPane.add(lblName);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(new Color(114, 115, 115));
		lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblStatus.setBounds(10, 267, 87, 33);
		contentPane.add(lblStatus);
		
		JLabel lblPrices = new JLabel("DISCOUNT:");
		lblPrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrices.setForeground(new Color(114, 115, 115));
		lblPrices.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblPrices.setBounds(10, 310, 119, 33);
		contentPane.add(lblPrices);
		
		txt_cust = new JTextField();
		txt_cust.setBackground(new Color(250, 234, 240));
		txt_cust.setBorder(null);
		txt_cust.setBounds(150, 179, 162, 33);
		contentPane.add(txt_cust);
		txt_cust.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBorder(null);
		txt_name.setColumns(10);
		txt_name.setBounds(150, 222, 162, 33);
		contentPane.add(txt_name);
		
		JComboBox cbx_stat = new JComboBox();
		cbx_stat.setBackground(new Color(250, 234, 240));
		cbx_stat.setBounds(150, 267, 162, 33);
		contentPane.add(cbx_stat);
		
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
		btnCreate.setBounds(20, 393, 292, 38);
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
		btnUpdate.setBounds(20, 441, 292, 38);
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
		btnDelete.setBounds(20, 489, 99, 38);
		contentPane.add(btnDelete);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(250, 234, 240));
		panel_1.setBounds(322, 179, 368, 314);
		contentPane.add(panel_1);
		
		JLabel lblTotalPrice = new JLabel("TOTAL:");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(new Color(114, 115, 115));
		lblTotalPrice.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblTotalPrice.setBounds(10, 353, 87, 33);
		contentPane.add(lblTotalPrice);
		
		txt_total = new JTextField();
		txt_total.setColumns(10);
		txt_total.setBorder(null);
		txt_total.setBackground(new Color(250, 234, 240));
		txt_total.setBounds(150, 353, 162, 33);
		contentPane.add(txt_total);
		
		JComboBox cbx_disc = new JComboBox();
		cbx_disc.setBackground(new Color(250, 234, 240));
		cbx_disc.setBounds(150, 310, 162, 33);
		contentPane.add(cbx_disc);
		
		JLabel lblclose = new JLabel("CLOSE");
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					PaymentFrame.this.dispose();
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
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardFrame cv = new DashboardFrame();
		    	cv.setVisible(true);
		    	PaymentFrame.this.dispose();
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
				txt_cust.setText("");
				txt_name.setText("");
				txt_total.setText("");
				cbx_stat.setSelectedIndex(0);
				cbx_disc.setSelectedIndex(0);
			}});
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(213, 489, 99, 38);
		contentPane.add(btnClear);
		
	}
}
