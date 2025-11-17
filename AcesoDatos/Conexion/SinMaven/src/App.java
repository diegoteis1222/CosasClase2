
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conn = "jdbc:mysql://localhost:3306/Northwind";
            Connection connection = DriverManager.getConnection(conn, "root", "");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println(metaData.getColumnName(i) + " ");
            }

            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.println(resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
