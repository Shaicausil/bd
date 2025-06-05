package dao;

import conexion.Conexion;
import vo.PersonaVo;

import java.sql.*;
import java.util.ArrayList;

public class PersonaDao {

    private Connection conexion;

    public PersonaDao() {
        conexion = Conexion.getConnection();
    }


    public void registrarPersona(PersonaVo persona) {
        String sql = "INSERT INTO persona (documento, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, persona.getDocumento());
            stmt.setString(2, persona.getNombre());
            stmt.setString(3, persona.getDireccion());
            stmt.setString(4, persona.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar persona.");
        }
    }


    public ArrayList<PersonaVo> obtenerListaPersonas() {
        ArrayList<PersonaVo> lista = new ArrayList<>();
        String sql = "SELECT * FROM persona";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PersonaVo persona = new PersonaVo();
                persona.setDocumento(rs.getString("documento"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));
                lista.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener lista de personas.");
        }

        return lista;
    }
}
