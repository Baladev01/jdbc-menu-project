package sql;

import java.sql.*;
import java.util.Scanner;

public class JDBCMenuApp {

    static final String DB_URL = "jdbc:mysql://localhost:3306/softlogic";
    static final String USER = "root";
    static final String PASS = "Bala032000@";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. View All Users");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    signup(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    viewUsers();
                    break;
                case 4:
                    System.out.println("Thank You");
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    // ---------------- SIGNUP ----------------
    static void signup(Scanner sc) {
        try (Connection conn =
                     DriverManager.getConnection(DB_URL, USER, PASS)) {

            CallableStatement cs =
                    conn.prepareCall("{call signupUser(?,?,?)}");

            System.out.print("Enter Name: ");
            cs.setString(1, sc.next());

            System.out.print("Enter Email: ");
            cs.setString(2, sc.next());

            System.out.print("Enter Password: ");
            cs.setString(3, sc.next());

            cs.executeUpdate();
            System.out.println("Signup Successful");

        } catch (SQLException e) {
            System.out.println("User already exists");
        }
    }

    // ---------------- LOGIN ----------------
    static void login(Scanner sc) {
        try (Connection conn =
                     DriverManager.getConnection(DB_URL, USER, PASS)) {

            CallableStatement cs =
                    conn.prepareCall("{call loginUser(?,?)}");

            System.out.print("Enter Email: ");
            cs.setString(1, sc.next());

            System.out.print("Enter Password: ");
            cs.setString(2, sc.next());

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful");
                System.out.println("Welcome " + rs.getString("name"));
            } else {
                System.out.println("Invalid Credentials");
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------- VIEW USERS ----------------
    static void viewUsers() {
        try (Connection conn =
                     DriverManager.getConnection(DB_URL, USER, PASS)) {

            CallableStatement cs =
                    conn.prepareCall("{call getAllUsers()}");

            ResultSet rs = cs.executeQuery();

            System.out.println("\n--- USERS LIST ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email")
                );
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
