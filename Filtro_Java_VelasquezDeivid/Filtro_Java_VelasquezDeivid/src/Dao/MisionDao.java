/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.Conexion;
import Model.MisionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class MisionDao {
    public boolean addMision(MisionModel mision){
        String sql = "INSERT INTO Mision(descripcion, rango, recompensa) VALUES(?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try{
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, mision.getDescripcion());
            stmt.setString(2, mision.getRango());
            stmt.setDouble(3, mision.getRecompensa());
            
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
}
