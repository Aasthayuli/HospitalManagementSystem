
package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Employee_Info extends JFrame {

    Employee_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1000, 590);
        panel.setBackground(new Color(95, 153, 174));
        panel.setForeground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(95, 153, 174));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(table);

        JLabel label1 = new JLabel("EMP ID");
        label1.setBounds(13, 9, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("NAME");
        label2.setBounds(150, 9, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("AGE");
        label3.setBounds(290, 9, 100, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label7 = new JLabel("Phone no.");
        label7.setBounds(430, 9, 100, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(570, 9, 70, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Email");
        label5.setBounds(710, 9, 50, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar No.");
        label6.setBounds(850, 9, 100, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        try {

            conn c = new conn();
            String q = "select emp_id, name, age, phone_number, salary, gmail, aadhar_number from emp_info";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);

            }
        });

        setUndecorated(true);
        setSize(1010, 600);
        setLocation(350, 230);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Employee_Info();
    }
}
