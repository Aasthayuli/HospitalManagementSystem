
package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField passwordField;
    JButton login, back;

    Login() {
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.white);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.white);
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 300, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        // textField.setBackground(new Color(255, 179, 0));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 300, 30);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        // passwordField.setForeground(Color.white);
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(320, -30, 400, 300);
        add(image);

        login = new JButton("Login");
        login.setBounds(40, 140, 130, 30);
        login.setFont(new Font("serif", Font.BOLD, 16));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(190, 140, 130, 30);
        back.setFont(new Font("serif", Font.BOLD, 16));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(new Color(95, 153, 174));
        setTitle("City Hospital");
        setSize(750, 300);
        setLocation(400, 270);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            try {
                conn c = new conn();
                String user = textField.getText();
                char[] passwordArr = passwordField.getPassword();
                String password = String.valueOf(passwordArr);

                String q = "select * from login where ID='" + user + "' and PW='" + password + "'";
                ResultSet rs = c.statement.executeQuery(q);
                if (rs.next()) {
                    if (rs.getString("role").equals("ADMIN")) {
                        new Reception();
                    } else {
                        new StaffDashboard();
                    }

                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials !");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            System.exit(10);
        }

    }
}
