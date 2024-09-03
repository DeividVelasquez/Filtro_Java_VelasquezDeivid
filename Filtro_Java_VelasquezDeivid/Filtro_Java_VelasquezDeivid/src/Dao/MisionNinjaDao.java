/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.MisionNinjaModel;
import Connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;




public class MisionNinjaDao {
    
    private Connection connection;
    
    public MisionNinjaDao(){
        Conexion conexion = new Conexion();
        this.connection = conexion.establecerConexion();
    }
            
    public boolean isNinjaIDExisist(int ninjaID){
        String sql = "SELECT ninjaID FROM Ninja Where ninjaID = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, ninjaID);
            try(ResultSet resulSet = statement.executeQuery()) {
                return resulSet.next();
            }
        }catch(SQLException e) {
            System.out.println("Error al verificar la existencia del participante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean isMisionIDExisist(int misionID){
        String sql = "SELECT misionID FROM Mision Where misionID = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, misionID);
            try(ResultSet resulSet = statement.executeQuery()) {
                return resulSet.next();
            }
        }catch(SQLException e) {
            System.out.println("Error al verificar la existencia del participante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean AsignarMision(MisionNinjaModel mision){
        
        if(!isNinjaIDExisist(mision.getNinjaID())){
            System.out.println("Error: El ID del ninja no existe.");
            return false;
        }
        
        if(!isMisionIDExisist(mision.getMisionID())){
            System.out.println("Error: El ID de la mision no existe.");
            return false;
        }
        
        String sql = "INSERT INTO MisionNinja(ninjaID, misionID, fechaInicion, fechaFin) VALUES(?, ?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;
        
        try{
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, mision.getNinjaID());
            stmt.setInt(2, mision.getMisionID());
            stmt.setString(3, mision.getFechaInicio());
            stmt.setString(4, mision.getFechaFin());
            
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
    
    public boolean FinalizarMision(String FechaFin, int misionID) {
        String sql = "UPDATE MisionNinja SET fechaFin = ? WHERE misionID = ?";
        Conexion conexion = new Conexion();
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = conexion.establecerConexion();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, FechaFin);
            stmt.setInt(2, misionID);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al Finalizar misión: " + e.getMessage());
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public ResultSet MisionesCompletadasNinja(int ninjaID){
        String sql = "SELECT n.nombre, n.rango, m.descripcion, m.recompensa, nm.fechaInicio, nm.fechaFin" +
                    "FROM MisionNinja mn" +
                    "JOIN Ninja n ON mn.ninjaID = n.ninjaID" +
                    "JOIN Mision m ON mn.misionID = m.misionID" +
                    "WHERE nm.fechaFin != 'null' and nm.ninjaID = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            
            stmt.setInt(1, ninjaID);
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
    
    public ResultSet MisionesDisponiblesNinja(int ninjaID){
        String sql = "SELECT n.nombre, n.rango, m.descripcion, m.recompensa, nm.fechaInicio, nm.fechaFin" +
                    "FROM MisionNinja mn" +
                    "JOIN Ninja n ON mn.ninjaID = n.ninjaID" +
                    "JOIN Mision m ON mn.misionID = m.misionID" +
                    "WHERE nm.fechaFin = 'null' and nm.ninjaID = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            
            stmt.setInt(1, ninjaID);
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
    
    public ResultSet MisionesCompletadas(){
        String sql = "SELECT m.descripcion, m.rango, m.recompensa, nm.fechaInicio, nm.fechaFin" +
                    "FROM MisionNinja mn" +
                    "JOIN Mision m ON mn.misionID = m.misionID" +
                    "WHERE nm.fechaFin != 'null'";
        
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
