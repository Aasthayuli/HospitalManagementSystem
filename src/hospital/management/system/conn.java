package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    conn() {
        String user = "root";
        String pass = "Mysqlp@ss23";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", user,
                    pass);
            statement = connection.createStatement();
            // System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {

        new conn();
    }
}
