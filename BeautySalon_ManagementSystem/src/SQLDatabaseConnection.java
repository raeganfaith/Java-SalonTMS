import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLException;
public class SQLDatabaseConnection {

	public void Connection() {
		String connection = "jdbc:sqlserver://localhost:1433;user=sa;password={arithmetic28pitpayt};encrypt = true;trustServerCertificate = true;";	
		try {
			Connection con = DriverManager.getConnection(connection);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}
	

}


/*
 * public void actionPerformed(ActionEvent e) {
                String userName = txtUser.getText();
                String password = txtPass.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:1433/db_Login",
                        "sa", "arithmetic28pitpayt");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("SELECT * FROM Accounts;");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        DashboardFrame ah = new DashboardFrame(userName);
                        //ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });**/
 