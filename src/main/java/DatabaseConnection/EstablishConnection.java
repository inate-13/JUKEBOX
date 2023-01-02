package DatabaseConnection;

import java.sql.*;

public class EstablishConnection {
   public static  Connection connection() throws SQLException ,ClassNotFoundException{
      Connection conn;
       Class.forName("com.mysql.cj.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/jukebox";
       String user="root";
       String pwd="Sagar@123";
       conn =DriverManager.getConnection(url,user,pwd);
       return  conn;
   }

}
