package gr.aueb.cf.schoolpro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSearchUsers extends JFrame{
	
	private static final long serialVersionUID = 1234563423;
	private JTextField usernameTxt;
	private String username = "";

	public AdminSearchUsers() {
		setTitle("AdminSearchUsers");
		getContentPane().setLayout(null);
		
		JLabel UsrSrchLbl = new JLabel("Αναζήτηση Χρηστών (Users)");
		UsrSrchLbl.setHorizontalAlignment(SwingConstants.CENTER);
		UsrSrchLbl.setForeground(new Color(255, 76, 0));
		UsrSrchLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		UsrSrchLbl.setBounds(129, 20, 217, 16);
		getContentPane().add(UsrSrchLbl);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(255, 76, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(26, 65, 106, 16);
		getContentPane().add(lblUsername);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(164, 61, 130, 26);
		getContentPane().add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JButton SearchUsrBtn = new JButton("Αναζήτηση");
		SearchUsrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getAdminUpdateDeleteUsers().setVisible(true);
				Main.getAdminSearchUsers().setEnabled(true);
				username = usernameTxt.getText();
			}
		});
		SearchUsrBtn.setForeground(new Color(255, 76, 0));
		SearchUsrBtn.setBounds(177, 134, 117, 29);
		getContentPane().add(SearchUsrBtn);
	}

	public JTextField getUsernameTxt() {
		return usernameTxt;
	}
	
	
}
