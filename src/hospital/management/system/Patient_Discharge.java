package hospital.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Patient_Discharge extends JFrame {

    Patient_Discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(95, 153, 174));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        try {

            conn c = new conn();
            String q = "SELECT patient_id FROM patient_info";
            ResultSet rs = c.statement.executeQuery(q);
            while (rs.next()) {
                choice.add(rs.getString("patient_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No.");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel RN = new JLabel();
        RN.setBounds(200, 130, 150, 20);
        RN.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(RN);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 180, 210, 20);
        INTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        JLabel OUTTime = new JLabel("" + java.time.LocalDateTime.now());
        OUTTime.setBounds(200, 230, 210, 20);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(50, 300, 120, 30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                conn c = new conn();
                try {
                    String roomNo = RN.getText();
                    int patientId = Integer.parseInt(choice.getSelectedItem());
                    // Room availability update
                    PreparedStatement ps1 = c.connection.prepareStatement(
                            "UPDATE room SET availability='Available' WHERE room_no=?");
                    ps1.setString(1, roomNo);
                    ps1.executeUpdate();

                    // Patient delete
                    PreparedStatement ps2 = c.connection.prepareStatement(
                            "DELETE FROM patient_info WHERE patient_id=?");
                    ps2.setInt(1, patientId);
                    ps2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Successfully Discharged");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        panel.add(discharge);

        JButton check = new JButton("Check");
        check.setBounds(200, 300, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                conn c = new conn();
                try {
                    int patientId = Integer.parseInt(choice.getSelectedItem());
                    ResultSet rs = c.statement.executeQuery(
                            "SELECT room_no, admit_time FROM patient_info WHERE patient_id = "
                                    + patientId);
                    while (rs.next()) {
                        RN.setText(rs.getString("room_no"));
                        INTime.setText(rs.getString("admit_time"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        panel.add(check);

        JButton back = new JButton("Back");
        back.setBounds(350, 300, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            }
        });
        panel.add(back);

        setUndecorated(true);
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
