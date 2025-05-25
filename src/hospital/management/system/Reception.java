package hospital.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(95, 153, 174));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(95, 153, 174));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("icons/amb.png"));
        Image img = i1.getImage().getScaledInstance(190, 170, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img);
        JLabel label = new JLabel(i2);
        label.setBounds(0, 0, 190, 170);
        panel1.add(label);

        JButton btn10 = new JButton("LogOut");
        btn10.setBounds(1300, 15, 200, 30);
        btn10.setBackground(new Color(246, 215, 118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new Login();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(1100, 58, 200, 30);
        btn2.setBackground(new Color(246, 215, 118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(1100, 100, 200, 30);
        btn3.setBackground(new Color(246, 215, 118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(1100, 15, 200, 30);
        btn4.setBackground(new Color(246, 215, 118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Employee_Info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(900, 58, 200, 30);
        btn5.setBackground(new Color(246, 215, 118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ALL_PATIENT_INFO();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(900, 100, 200, 30);
        btn6.setBackground(new Color(246, 215, 118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(900, 15, 200, 30);
        btn7.setBackground(new Color(246, 215, 118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient_Details();
            }
        });

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(700, 58, 200, 30);
        btn8.setBackground(new Color(246, 215, 118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(700, 100, 200, 30);
        btn9.setBackground(new Color(246, 215, 118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton btn1 = new JButton("Add new Patient");
        btn1.setBounds(700, 15, 200, 30);
        btn1.setBackground(new Color(246, 215, 118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });
        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Reception();
    }

}
