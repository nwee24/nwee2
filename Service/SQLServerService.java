package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerService {
    protected Connection conn = null;

    public SQLServerService() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DBQLSP;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
            conn = DriverManager.getConnection(url);
            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy JDBC!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Lỗi khi kết nối cơ sở dữ liệu!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Lỗi không xác định!");
            e.printStackTrace();
        }
    }
}
