package hospital.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(95, 153, 174));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image img = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(img);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[] { "Aadhar Card", "Voter ID", "Driving License" });
        comboBox.setBounds(271, 73, 150, 20);

        comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);

        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name : ");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);

        panel.add(textName);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 16));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 16));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(350, 191, 100, 15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease : ");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);

        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room : ");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelRoom);

        // Room choice

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from Room");
            while (rs.next()) {
                c1.add(rs.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));

        panel.add(c1);

        JLabel labelDate = new JLabel("Time : ");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelDate);

        Date date1 = new Date();

        date = new JLabel("" + date1);
        date.setBounds(271, 316, 230, 14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite : ");
        labelDeposite.setBounds(35, 359, 200, 17);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 359, 150, 20);

        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100, 430, 120, 30);
        b1.setBackground(new Color(3, 45, 48));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260, 430, 120, 30);
        b2.setBackground(new Color(3, 45, 48));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                PreparedStatement ps1 = c.connection
                        .prepareStatement("insert into Patient_Info values(?, ?, ?, ?, ?, ?, ?, ?)");
                ps1.setString(1, s1);
                ps1.setString(2, s2);
                ps1.setString(3, s3);
                ps1.setString(4, s4);
                ps1.setString(5, s5);
                ps1.setString(6, s6);
                ps1.setString(7, s7);
                ps1.setString(8, s8);
                ps1.executeUpdate();

                PreparedStatement ps2 = c.connection
                        .prepareStatement("update room set Availability = 'Occupied' where room_no = ?");
                ps2.setString(1, s6);
                ps2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Added Successfully !");
                setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else {
            setVisible(false);

        }
    }

}
