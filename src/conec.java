import java.sql.*;
public class conec {
    //create connection
    Connection dri;
    Statement s;
    public conec(){
        try{
            dri=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","9063799258");
            s=dri.createStatement();
        }catch(Exception e){
           System.out.println(e); 
        }
    }
}
