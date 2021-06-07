package NewYorkerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

    public static Connection connectToDB() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:Users/jennapetersen/Desktop/NewYorker.db";
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(url);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
        return conn;
    }

    public static void selectFromPersonData(String email) {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = connectToDB();

            String sqlPersonInfo = "SELECT * FROM PersonData WHERE email = '" + email + "'";


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlPersonInfo);

            System.out.println(sqlPersonInfo);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\n" +
                        rs.getString(2) + "\n" +
                        rs.getString(3) + "\n" +
                        rs.getString(4) + "\n"
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void insertIntoPersonData(String name, String phonenumber, String email) {
        Connection conn = null;
        try {
            // db parameters
            //String url = "/Users/jennapetersen/AndroidStudioProjects/NewYorker-UI_Iteration2_1/05 Implementation/New-Yorker designer app/app/src/main/java/DB/NewYorker.db";
            // create a connection to the database
            conn = connectToDB();

            String sqlPersonInfo = "Insert into PersonData (name, phonenumber, email) values ('" + name + "', '" + phonenumber + "', '" + email + "'" + ")";


            Statement stmt = conn.createStatement();
            stmt.executeQuery(sqlPersonInfo);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }

    public static void deleteFromPersonData(String email) {
        Connection conn = null;
        try {
            conn = connectToDB();

            String sqlPersonInfo = "Delete From PersonData Where email = '" + email + "'";


            Statement stmt = conn.createStatement();
            stmt.executeQuery(sqlPersonInfo);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }

//    public static void main(String[] args) {
//        insertIntoPersonData("jenna", "53", "jennafuttrup@gmail.com");
//        selectFromPersonData("jennafuttrup@gmail.com");
//    }



}
