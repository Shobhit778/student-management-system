package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection() throws SQLException{

        Properties prop = new Properties();
        try(FileInputStream fis = new FileInputStream("db.properties")) {
            prop.load(fis);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.pass");
        return DriverManager.getConnection(url, user, password);
    }
}
