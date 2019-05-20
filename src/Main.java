import java.sql.*;
public class Main {

    private final static String url = "jdbc:postgresql://localhost:5432/19_05_20_am_cw";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            ex1(conn);
//            ex2(conn);
//            ex3(conn);
//            ex4(conn);
//            ex5(conn);
//            ex6(conn);
//            ex7(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static void ex1(Connection conn){
        try {
            String SQL = "SELECT * FROM boxes";
//            String SQL = "INSERT INTO boxes(Code,Contents,Value,Warehouse) VALUES('HG78','Paper',90.1,4)";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.print(" Code: " + rs.getString(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void ex2(Connection conn){
        try {
            String SQL = "SELECT boxes.warehouse,avg(boxes.value) FROM boxes JOIN warehouses w on boxes.warehouse = w.code group by boxes.warehouse";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.print(" Warehouse: " + rs.getString(1));
                System.out.println(" Average Value: " + rs.getString(2));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void ex3(Connection conn){
        try {
            String SQL = "SELECT boxes.warehouse,avg(boxes.value) as averageValue FROM boxes JOIN warehouses w on boxes.warehouse = w.code WHERE averageValue>200 group by boxes.warehouse";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.print(" Warehouse: " + rs.getString(1));
                System.out.println(" Average Value: $" + rs.getString(2));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private static void ex4(Connection conn){
        try {
            String SQL = "SELECT DISTINCT boxes.contents, sum(boxes.value) FROM boxes group by boxes.contents";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.print(" Content: " + rs.getString(1));
                System.out.println(" Value: $" + rs.getString(2));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void ex5(Connection conn){
        try {
            String SQL = "SELECT sum(boxes.value) FROM boxes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.print(" Sum of All Boxes: $" + rs.getString(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void ex6(Connection conn){
        try {
            String SQL = "UPDATE boxes SET boxes.value= boxes.value*0.85";
//            String SQL = "SELECT boxes.value FROM boxes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.println(" Value: $" + rs.getString(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void ex7(Connection conn){
        try {
//            String SQL = "DELETE FROM boxes WHERE boxes.value<100";
            String SQL = "SELECT boxes.value FROM boxes WHERE boxes.value<100";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()){
                System.out.println(" Value: $" + rs.getString(1));
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
