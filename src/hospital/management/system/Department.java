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

public class Department extends JFrame {

    Department() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(95, 153, 174));
        panel.setForeground(Color.WHITE);
        add(panel);

        JLabel label1 = new JLabel("DEPARTMENT");
        label1.setBounds(145, 11, 105, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("PHONE NUMBER");
        label2.setBounds(431, 11, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JTable table = new JTable();
        table.setBounds(0, 50, 700, 350);
        table.setBackground(new Color(95, 153, 174));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(table);

        JButton back = new JButton("BACK");
        back.setBounds(400, 410, 130, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            }
        });
        panel.add(back);

        try {

            conn c = new conn();
            String q = "select * from department";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Department();
    }

}
