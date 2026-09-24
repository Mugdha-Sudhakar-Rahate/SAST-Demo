import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Addition = " + (a + b));
                break;

            case 2:
                System.out.println("Subtraction = " + (a - b));
                break;

            case 3:
                System.out.println("Multiplication = " + (a * b));
                break;

            case 4:
                System.out.println("Division = " + (a / b));
                break;

            default:
                System.out.println("Invalid choice");
        }

        // Security Hotspot: hard-coded credential
        String password = "admin123";

        // Code Smell: unused variable
        int unusedNumber = 100;

        // Security issue example: database connection with hard-coded password
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    password
            );

            Statement stmt = con.createStatement();

            System.out.println("Database connected");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Bug example: possible division by zero
        int x = 10;
        int y = 0;

        int result = x / y;

        System.out.println("Result = " + result);

        sc.close();
    }
}
