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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PaymentFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txt_cust;
	private JTextField txt_name;
	private JTextField txt_amount;
	private JTextField txt_total;
	private JTable table;

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
		lblPaymentTransaction.setBounds(223, 128, 284, 31);
		contentPane.add(lblPaymentTransaction);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID:");
		lblCustomerId.setForeground(new Color(114, 115, 115));
		lblCustomerId.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCustomerId.setBounds(20, 160, 121, 26);
		contentPane.add(lblCustomerId);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(114, 115, 115));
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(20, 196, 121, 21);
		contentPane.add(lblName);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setForeground(new Color(114, 115, 115));
		lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblStatus.setBounds(20, 227, 121, 22);
		contentPane.add(lblStatus);
		
		JLabel lblPrices = new JLabel("DISCOUNT:");
		lblPrices.setForeground(new Color(114, 115, 115));
		lblPrices.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblPrices.setBounds(20, 292, 121, 23);
		contentPane.add(lblPrices);
		
		JLabel lblTotalPrice = new JLabel("TOTAL:");
		lblTotalPrice.setForeground(new Color(114, 115, 115));
		lblTotalPrice.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblTotalPrice.setBounds(20, 325, 121, 23);
		contentPane.add(lblTotalPrice);
		
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
		
		JLabel lblAmount = new JLabel("AMOUNT:");
		lblAmount.setForeground(new Color(114, 115, 115));
		lblAmount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAmount.setBounds(20, 259, 121, 23);
		contentPane.add(lblAmount);
		
		txt_cust = new JTextField();
		txt_cust.setColumns(10);
		txt_cust.setBorder(null);
		txt_cust.setBackground(new Color(250, 234, 240));
		txt_cust.setBounds(139, 160, 136, 23);
		contentPane.add(txt_cust);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBorder(null);
		txt_name.setBackground(new Color(250, 234, 240));
		txt_name.setBounds(139, 193, 136, 23);
		contentPane.add(txt_name);
		
		JComboBox cbx_stat = new JComboBox();
		cbx_stat.setForeground(new Color(114, 115, 115));
		cbx_stat.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		cbx_stat.setBackground(new Color(250, 234, 240));
		cbx_stat.setBounds(139, 226, 136, 23);
		contentPane.add(cbx_stat);
		
		txt_amount = new JTextField();
		txt_amount.setColumns(10);
		txt_amount.setBorder(null);
		txt_amount.setBackground(new Color(250, 234, 240));
		txt_amount.setBounds(138, 259, 137, 23);
		contentPane.add(txt_amount);
		
		JComboBox txt_disc = new JComboBox();
		txt_disc.setForeground(new Color(114, 115, 115));
		txt_disc.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txt_disc.setBackground(new Color(250, 234, 240));
		txt_disc.setBounds(138, 292, 137, 23);
		contentPane.add(txt_disc);
		
		txt_total = new JTextField();
		txt_total.setColumns(10);
		txt_total.setBorder(null);
		txt_total.setBackground(new Color(250, 234, 240));
		txt_total.setBounds(139, 325, 136, 23);
		contentPane.add(txt_total);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setForeground(new Color(114, 115, 115));
		btnCreate.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(new Color(252, 193, 213));
		btnCreate.setBounds(20, 365, 255, 33);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(114, 115, 115));
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(252, 193, 213));
		btnUpdate.setBounds(20, 408, 255, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(114, 115, 115));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(252, 193, 213));
		btnDelete.setBounds(20, 451, 255, 33);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(new Color(114, 115, 115));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnClear.setBorderPainted(false);
		btnClear.setBackground(new Color(252, 193, 213));
		btnClear.setBounds(20, 494, 255, 30);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 158, 384, 302);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(114, 115, 115));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(252, 193, 213));
		btnSave.setBounds(551, 470, 123, 33);
		contentPane.add(btnSave);
		
	}
}
