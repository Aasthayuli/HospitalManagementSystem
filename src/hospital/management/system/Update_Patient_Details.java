package hospital.management.system;

import java.awt.Choice;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update_Patient_Details extends JFrame {

    Update_Patient_Details() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(95, 153, 174));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image img = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(img);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 50, 260, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Patient ");
        label2.setBounds(25, 130, 60, 14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 16));

        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 130, 150, 25);
        panel.add(choice);
        try {

            conn c = new conn();
            String q = "SELECT patient_id, name FROM patient_info";
            ResultSet rs = c.statement.executeQuery(q);
            while (rs.next()) {
                choice.add(rs.getString("patient_id") + " - " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Update Patient Room no.:");
        label3.setBounds(25, 174, 260, 25);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 174, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("Check-in Time: ");
        label4.setBounds(25, 216, 160, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248, 216, 140, 20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid(Rs): ");
        label5.setBounds(25, 261, 140, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 261, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount(Rs): ");
        label6.setBounds(25, 300, 160, 20);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 300, 140, 20);
        panel.add(textFieldPending);

        JButton update = new JButton("UPDATE");
        update.setBounds(70, 400, 100, 23);
        update.setFont(new Font("Tahoma", Font.PLAIN, 16));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {

                    conn c = new conn();
                    String selected = choice.getSelectedItem();
                    String patientId = selected.split(" - ")[0].trim();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("UPDATE patient_info SET room_no='" + room +
                            "', admit_time='" + time +
                            "', deposit='" + amount +
                            "' WHERE patient_id='" + patientId + "'");

                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(181, 400, 89, 23);
        back.setFont(new Font("Tahoma", Font.PLAIN, 16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            }
        });

        JButton check = new JButton("CHECK");
        check.setBounds(281, 400, 89, 23);
        check.setFont(new Font("Tahoma", Font.PLAIN, 16));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String patientId = choice.getSelectedItem().split(" - ")[0].trim();
                String q = "select * from patient_info where patient_id='" + patientId + "'";
                try {

                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery(q);
                    while (rs.next()) {
                        textFieldR.setText(rs.getString("room_no"));
                        textFieldINTime.setText(rs.getString("admit_time"));
                        textFieldAmount.setText(rs.getString("deposit"));

                    }

                    ResultSet rs1 = c.statement
                            .executeQuery("select * from room where room_no='" + textFieldR.getText() + "'");
                    while (rs1.next()) {
                        String price = rs1.getString("price");
                        double priceVal = Double.parseDouble(price);
                        double depositVal = Double.parseDouble(textFieldAmount.getText());
                        double pending = priceVal - depositVal;
                        textFieldPending.setText(String.format("%.2f", pending));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setUndecorated(true);
        setSize(950, 500);
        setLocation(400, 250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
