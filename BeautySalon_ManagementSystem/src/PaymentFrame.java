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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaymentFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private Image img_book = new ImageIcon(LoginFrame.class.getResource("res/BOOK.png")).getImage().getScaledInstance(93, 89, Image.SCALE_SMOOTH);
	private Image img_phone = new ImageIcon(LoginFrame.class.getResource("res/PHONE.png")).getImage().getScaledInstance(90, 86, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	
	
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
		setBounds(100, 100, 700, 350); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReservation = new JLabel("");
		lblReservation.setBounds(366, 168, 105, 113);
		contentPane.add(lblReservation);
		
		JLabel lblBook = new JLabel("BOOKING");
		lblBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookingPaymentFrame cv = new BookingPaymentFrame();
		    	cv.setVisible(true);
		    	PaymentFrame.this.dispose();
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
		lblBook.setBounds(215, 272, 105, 33);
		contentPane.add(lblBook);
		
		JLabel lblReserve = new JLabel("RESERVATION");
		lblReserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservationFrame cv = new ReservationFrame();
		    	cv.setVisible(true);
		    	PaymentFrame.this.dispose();
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
		lblReserve.setBounds(366, 272, 129, 33);
		lblReservation.setIcon(new ImageIcon(img_phone));
		contentPane.add(lblReserve);
		
		JLabel lblBooking = new JLabel("");
		lblBooking.setIcon(new ImageIcon(img_book));
		lblBooking.setBounds(215, 168, 105, 113);
		contentPane.add(lblBooking);
		
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
		
		JLabel lblPaymentTransaction = new JLabel("CHOOSE  PAYMENT");
		lblPaymentTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentTransaction.setForeground(new Color(114, 115, 115));
		lblPaymentTransaction.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPaymentTransaction.setBounds(103, 127, 468, 31);
		contentPane.add(lblPaymentTransaction);
		
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
				AdminDashboardFrame cv = new AdminDashboardFrame();
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
		
	}
}
