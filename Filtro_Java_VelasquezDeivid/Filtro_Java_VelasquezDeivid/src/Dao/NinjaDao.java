/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.NinjaModel;
import Connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NinjaDao {
    
    public boolean addNinja(NinjaModel ninja){
        String sql = "INSERT INTO Ninja(nombre, rango, aldea) VALUES(?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try{
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, ninja.getNombre());
            stmt.setString(2, ninja.getRango());
            stmt.setString(3, ninja.getAldea());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }catch(SQLException e){
            System.out.println("Error al añadir un Ninja: " + e.getMessage());
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
