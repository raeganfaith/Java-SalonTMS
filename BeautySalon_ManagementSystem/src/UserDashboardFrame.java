import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class UserDashboardFrame extends JFrame {
																													//width and height
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private Image img_pay = new ImageIcon(LoginFrame.class.getResource("res/COIN.png")).getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
	private Image img_book = new ImageIcon(LoginFrame.class.getResource("res/BOOK.png")).getImage().getScaledInstance(93, 89, Image.SCALE_SMOOTH);
	private Image img_phone = new ImageIcon(LoginFrame.class.getResource("res/PHONE.png")).getImage().getScaledInstance(90, 86, Image.SCALE_SMOOTH);
	private Image img_user = new ImageIcon(LoginFrame.class.getResource("res/ACCNT.png")).getImage().getScaledInstance(93, 89, Image.SCALE_SMOOTH);
	private Image img_service = new ImageIcon(LoginFrame.class.getResource("res/MIRROR.png")).getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
	private Image img_exit = new ImageIcon(LoginFrame.class.getResource("res/EXIT.png")).getImage().getScaledInstance(93, 89, Image.SCALE_SMOOTH);
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDashboardFrame frame = new UserDashboardFrame();
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
	public UserDashboardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 390); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblPayment = new JLabel("");
		lblPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaymentFrame cv = new PaymentFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
		});
		lblPayment.setBounds(68, 188, 105, 113);
		contentPane.add(lblPayment);
		lblPayment.setIcon(new ImageIcon(img_pay));
		
		JLabel lblBooking = new JLabel("");
		
		lblBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerFrame cv = new CustomerFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
		});
		
		lblBooking.setBounds(224, 188, 105, 113);
		contentPane.add(lblBooking);
		lblBooking.setIcon(new ImageIcon(img_book));
		
		JLabel lblReservation = new JLabel("");
		lblReservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservationFrame cv = new ReservationFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
		});
		
		lblReservation.setBounds(371, 188, 105, 113);
		contentPane.add(lblReservation);
		lblReservation.setIcon(new ImageIcon(img_phone));
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame cv = new LoginFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
		});
		lblExit.setBounds(539, 181, 93, 113);
		contentPane.add(lblExit);
		lblExit.setIcon(new ImageIcon(img_exit));
		
		JLabel lblPay = new JLabel("PAYMENT");
		lblPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaymentFrame cv = new PaymentFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPay.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPay.setForeground(Color.GRAY);
		}});
		lblPay.setForeground(new Color(114, 115, 115)); // font color
		lblPay.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblPay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPay.setBounds(68, 292, 105, 33);
		contentPane.add(lblPay);
		
		JLabel lblBook = new JLabel("BOOKING");
		lblBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookingFrame cv = new BookingFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
		    	
		    	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBook.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBook.setForeground(Color.GRAY);
		}});
		lblBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblBook.setForeground(new Color(114, 115, 115));
		lblBook.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblBook.setBounds(224, 292, 105, 33);
		contentPane.add(lblBook);
		
		JLabel lblReserve = new JLabel("RESERVATION");
		lblReserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservationFrame cv = new ReservationFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblReserve.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblReserve.setForeground(Color.GRAY);
		}});
		lblReserve.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserve.setForeground(new Color(114, 115, 115));
		lblReserve.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblReserve.setBounds(367, 292, 129, 33);
		contentPane.add(lblReserve);
		
		JLabel lbllogout = new JLabel("EXIT");
		lbllogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame cv = new LoginFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbllogout.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbllogout.setForeground(Color.GRAY);
		}});
		//exit function
		
		lbllogout.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogout.setForeground(new Color(114, 115, 115));
		lbllogout.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lbllogout.setBounds(527, 292, 105, 33);
		contentPane.add(lbllogout);
		
		JLabel lblclose = new JLabel("CLOSE");
		//close button function
		lblclose.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					UserDashboardFrame.this.dispose();
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
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setBounds(185, 10, 310, 92);
		contentPane.add(lbllogo);
		lbllogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame cv = new LoginFrame();
		    	cv.setVisible(true);
		    	UserDashboardFrame.this.dispose();
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
		
		JLabel lblUserDashboard = new JLabel("USER DASHBOARD");
		lblUserDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserDashboard.setForeground(new Color(114, 115, 115));
		lblUserDashboard.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUserDashboard.setBounds(131, 131, 426, 47);
		contentPane.add(lblUserDashboard);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 112, 700, 20);
		contentPane.add(panel);
	}
}
