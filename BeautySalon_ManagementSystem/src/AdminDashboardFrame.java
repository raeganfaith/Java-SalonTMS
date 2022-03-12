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

public class AdminDashboardFrame extends JFrame {
																													//width and height
	private Image img_logo = new ImageIcon(LoginFrame.class.getResource("res/LOGO-2.png")).getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
	private Image img_transc = new ImageIcon(LoginFrame.class.getResource("res/TRANS.png")).getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
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
					AdminDashboardFrame frame = new AdminDashboardFrame();
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
	public AdminDashboardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 390); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 213, 225)); //background color of the panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblUser = new JLabel("");
		lblUser.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			UserFrame cv = new UserFrame();
	    	cv.setVisible(true);
	    	AdminDashboardFrame.this.dispose();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			lblUser.setForeground(Color.BLACK);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblUser.setForeground(Color.GRAY);
		}});
		lblUser.setBounds(70, 182, 105, 124);
		contentPane.add(lblUser);
		lblUser.setIcon(new ImageIcon(img_user));
		
		JLabel lblServices = new JLabel("");
		lblServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ServiceFrame cv = new ServiceFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
			}
		});
		lblServices.setBounds(219, 182, 105, 113);
		contentPane.add(lblServices);
		lblServices.setIcon(new ImageIcon(img_service));
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame cv = new LoginFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
			}
		});
		lblExit.setBounds(541, 182, 93, 113);
		contentPane.add(lblExit);
		lblExit.setIcon(new ImageIcon(img_exit));
		
		JLabel lblUsers = new JLabel("USERS");
		lblUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserFrame cv = new UserFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUsers.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblUsers.setForeground(Color.GRAY);
		}});
		lblUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsers.setForeground(new Color(114, 115, 115));
		lblUsers.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblUsers.setBounds(70, 293, 98, 33);
		contentPane.add(lblUsers);
		
		JLabel lblService = new JLabel("SERVICES");
		lblService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ServiceFrame cv = new ServiceFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblService.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblService.setForeground(Color.GRAY);
		}});
		
		lblService.setHorizontalAlignment(SwingConstants.CENTER);
		lblService.setForeground(new Color(114, 115, 115));
		lblService.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblService.setBounds(219, 293, 105, 33);
		contentPane.add(lblService);
		
		JLabel lbllogout = new JLabel("EXIT");
		lbllogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame cv = new LoginFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
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
		lbllogout.setBounds(529, 293, 105, 33);
		contentPane.add(lbllogout);
		
		JLabel lblclose = new JLabel("CLOSE");
		//close button function
		lblclose.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminDashboardFrame.this.dispose();
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(250, 234, 240));
		panel.setBounds(0, 112, 700, 20);
		contentPane.add(panel);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame cv = new LoginFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
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
		
		JLabel lblAdminDashboard = new JLabel("ADMIN DASHBOARD");
		lblAdminDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminDashboard.setForeground(new Color(114, 115, 115));
		lblAdminDashboard.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAdminDashboard.setBounds(126, 131, 426, 45);
		contentPane.add(lblAdminDashboard);
		
		JLabel lblTransact = new JLabel("TRANSACTIONS");
		lblTransact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransactionFrame cv = new TransactionFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTransact.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTransact.setForeground(Color.GRAY);
			}});
		lblTransact.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransact.setForeground(new Color(114, 115, 115));
		lblTransact.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblTransact.setBounds(357, 293, 150, 33);
		contentPane.add(lblTransact);
		
		JLabel lblTransc = new JLabel("");
		lblTransc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransactionFrame cv = new TransactionFrame();
		    	cv.setVisible(true);
		    	AdminDashboardFrame.this.dispose();
			}
		});
		lblTransc.setIcon(new ImageIcon(img_transc));
		lblTransc.setBounds(373, 174, 105, 124);
		contentPane.add(lblTransc);
	}
}
