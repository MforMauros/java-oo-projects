package gr.aueb.cf.schoolpro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUpdateDeleteUsers extends JFrame {

    private JTextField usernameTxt;
    private JPasswordField newPasswordTxt;
    private JButton updatePasswordBtn, deleteUserBtn;

    public AdminUpdateDeleteUsers() {
        setTitle("Update or Delete User");
        getContentPane().setLayout(new FlowLayout());

        usernameTxt = new JTextField(20);
        usernameTxt.setEditable(false); 
        JLabel label = new JLabel("Username:");
        label.setForeground(new Color(255, 76, 0));
        getContentPane().add(label);
        getContentPane().add(usernameTxt);

        newPasswordTxt = new JPasswordField(20);
        JLabel label_1 = new JLabel("New Password:");
        label_1.setForeground(new Color(255, 76, 0));
        getContentPane().add(label_1);
        getContentPane().add(newPasswordTxt);

        updatePasswordBtn = new JButton("Update Password");
        updatePasswordBtn.setForeground(new Color(0, 29, 255));
        updatePasswordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(newPasswordTxt.getPassword());
                JOptionPane.showMessageDialog(AdminUpdateDeleteUsers.this, "Password updated successfully!");
            }
        });
        getContentPane().add(updatePasswordBtn);

        deleteUserBtn = new JButton("Delete User");
        deleteUserBtn.setForeground(new Color(0, 29, 255));
        deleteUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminUpdateDeleteUsers.this, "User deleted successfully!");
                AdminUpdateDeleteUsers.this.dispose(); 
            }
        });
        getContentPane().add(deleteUserBtn);

        setSize(300, 200);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setUsername(String username) {
        usernameTxt.setText(username);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	AdminUpdateDeleteUsers frame = new AdminUpdateDeleteUsers();
                frame.setUsername("demoUser"); 
                frame.setVisible(true);
            }
        });
    }
}
