/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simple_postgresconnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author D E L L
 */
public class Simple_PostgresConnectivity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/test";
        String username="postgres";
        String pass="postgresql";
        String qry="select * from student";
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn=DriverManager.getConnection(url, username, pass);
            System.out.println("Database Connected");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next()){
                System.out.println("ID:"+rs.getInt("id")+" NAME:"+rs.getString("name")+" Department:"+rs.getString("dept"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            
        }
        // TODO code application logic here
    }
    
}
