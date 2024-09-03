/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.Conexion;
import Model.HabilidadModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class HabilidadDao {
    
    private Connection connection;
    
    public HabilidadDao(){
        Conexion conexion = new Conexion();
        this.connection = conexion.establecerConexion();
    }
    
    public boolean addHabilidad(HabilidadModel habilidad){
        String sql = "INSERT INTO Habilidad(nombre, descripcion) VALUES(?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try{
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, habilidad.getNombre());
            stmt.setString(2, habilidad.getDescripcion());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }catch(SQLException e){
            System.out.println("Error al añadir una misión: " + e.getMessage());
            return false;
        }finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public ResultSet HabilidadesNinja(){
        String sql = "SELECT n.nombre, n.rango, n.aldea, h.nombre, h.descripcion" +
                    "FROM Habilidad h" +
                    "JOIN Ninja n ON h.ninjaID = n.ninjaID";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                return resultSet;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
