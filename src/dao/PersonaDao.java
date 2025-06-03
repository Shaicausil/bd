package dao;

import conexion.Conexion;
import vo.PersonaVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDao {

    public String registrarUsuario(PersonaVo miPersonaVo){
        String resultado="";

        Connection connection=null;
        Conexion conexion=new Conexion();
        PreparedStatement preStatement=null;

        connection=conexion.getConnection();
        String consulta="INSERT INTO persona(documento,nombre, direccion,telefono)"+
                "VALUES(?,?,?,?)";

        try {
            preStatement=connection.prepareStatement(consulta);
            preStatement.setString(1,miPersonaVo.getDocumento());
            preStatement.setString(2,miPersonaVo.getNombre());
            preStatement.setString(3,miPersonaVo.getDireccion());
            preStatement.setString(4,miPersonaVo.getTelefono());
            preStatement.execute();

            resultado="ok";


        } catch (SQLException e){
            System.err.println("No se puede registar el dato: "+e.getMessage());
            resultado="No se pudo Registar el dato: "+e.getMessage();

        }

        conexion.desconectar();
        return resultado;
    }

    public ArrayList<PersonaVo> consultarListaPersonas(){
        ArrayList<PersonaVo> listaPersona=new ArrayList<PersonaVo>();
        Connection connection=null;
        Conexion miConexion= new Conexion();
        PreparedStatement statement=null;
        ResultSet result=null;

        PersonaVo miPersona=null;
        connection= miConexion.getConnection();
        String consulta="SELECT*FROM persona";

        try {
            statement=connection.prepareStatement(consulta);
            result=statement.executeQuery();

            while (result.next()==true){
                miPersona=new PersonaVo();
                miPersona.setDocumento(result.getString("documento"));
                miPersona.setNombre(result.getString("nombre"));
                miPersona.setDireccion(result.getString("direccion"));
                miPersona.setTelefono(result.getString("telefono"));

                listaPersona.add(miPersona);

            }
            miConexion.desconectar();
        }catch (SQLException e){
            System.err.println("Error en la consulta del Usuario: "+e.getMessage());
        }
        return listaPersona;
    }
}
