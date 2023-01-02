package Dao;
import java.sql.*;
import DatabaseConnection.EstablishConnection;
import ModelClasses.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static Connection con;
    {
        try {
            con= EstablishConnection.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

     public static  List<User> showAllUser() throws SQLException {
        List<User> list=new ArrayList<>();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select  * from user");
         while (rs.next())
         {
             list.add(new User(rs.getInt(1), rs.getString(2)));
         }
         return list;
     }
     public   static void displayUser(List <User> list){
         System.out.printf("%25s%25s", "UserID", "UserName\n");
         list.stream().forEach(f-> System.out.printf("%25s%25s",f.getUserId(),f.getUserName()));
         System.out.println();

     }
}
