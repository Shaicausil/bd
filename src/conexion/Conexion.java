package conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String nombreBd="MVC";
    private String usuario="root";
    private String password="";
    private String url="jdbc:mysql://localhost/MVC";

    Connection conn =null;

    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jbdc.Driver");
            conn= DriverManager.getConnection(url,usuario,password);
            if (conn==null){
                System.err.println("Conexion Fallida a la BD: "+nombreBd);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Ocurre una ClassNotFoundException: "+e.getMessage());
        } catch (SQLException e){
            System.err.println("ocure una SQLException: "+e.getMessage());

        }
    }

    public Connection getConnection(){
        return conn;
    }

    public void desconectar(){
        conn=null;
    }
}
