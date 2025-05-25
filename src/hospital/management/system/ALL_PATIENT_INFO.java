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

public class ALL_PATIENT_INFO extends JFrame {

    ALL_PATIENT_INFO() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(95, 153, 174));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(95, 153, 174));
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setForeground(Color.WHITE);
        panel.add(table);

        JLabel label1 = new JLabel("ID");
        label1.setBounds(15, 11, 100, 16);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(125, 11, 100, 16);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(235, 11, 100, 16);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(350, 11, 100, 16);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(460, 11, 100, 16);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JLabel label6 = new JLabel("Room No.");
        label6.setBounds(575, 11, 100, 16);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JLabel label7 = new JLabel("Date");
        label7.setBounds(685, 11, 100, 16);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(800, 11, 100, 16);
        label8.setFont(new Font("Tahoma", Font.BOLD, 14));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        try {

            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(450, 510, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);

            }
        });

        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ALL_PATIENT_INFO();
    }
}
