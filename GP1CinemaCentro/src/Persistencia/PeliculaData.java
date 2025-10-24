/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Pelicula;
import Entidades.conexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author arias
 */
public class PeliculaData {
    private Connection con = null;
    
    public PeliculaData(){
    
        con = conexion.getConexion();
    }
    
    public void guardarPelicula (Pelicula pelicula){
            
         String sql = "INSERT INTO pelicula (titulo, director, actores, origen, genero, estreno, enCartelera)" + "VALUES(?,?,?,?,?,?,?)";
            
         Date fechaUtil = pelicula.getEstreno();
         java.sql.Date fechaSql = null;
         
         if (fechaUtil != null) {
            
             fechaSql = new java.sql.Date (fechaUtil.getTime());
        }
         
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, fechaSql);
            ps.setBoolean(7, pelicula.isEnCartelera());
            ps.executeUpdate();
            System.out.println("Pelicula guardada");
            
        } catch (SQLException ex) {
            System.out.println("Error al guardar pelicula" + ex.getMessage());
        }  
    }
    
    public Pelicula buscarPelicula (int id){
     
         Pelicula pelicula = null;
         
         String sql = "SELECT * FROM pelicula WHERE id_pelicula = ?";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                
            pelicula = new Pelicula();
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setDirector(rs.getString("director"));
            pelicula.setOrigen(rs.getString("origen"));
            pelicula.setGenero(rs.getString("genero"));
            pelicula.setEstreno(rs.getDate("estreno"));
            pelicula.setEnCartelera(rs.getBoolean("estado"));
            
            
            }
             ps.close();
            
        } catch (SQLException ex) {
            
            System.out.println("Error al buscar la pelicula:" + ex.getMessage());
        }
        return pelicula;
     }

    public void modificarPelicula (Pelicula pelicula) {
    
        String sql = "UPDATE pelicula SET titulo = ?, director = ?, actores = ?, origen = ?, genero = ?, estreno = ?, enCartelera = ? WHERE id_pelicula = ?" ;
    
        PreparedStatement ps;
        
        Date fechaUtil = pelicula.getEstreno();
         java.sql.Date fechaSql = null;
         
         if (fechaUtil != null) {
            
             fechaSql = new java.sql.Date (fechaUtil.getTime());
        }
        
        try {
            ps = con.prepareStatement(sql);     
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getOrigen());
            ps.setString(5, pelicula.getGenero());
            ps.setDate(6, fechaSql);
            ps.setBoolean(7, pelicula.isEnCartelera());
            ps.executeUpdate();
            ps.close();
            System.out.println("Pelicula modificada");
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar la pelicula:" + ex.getMessage());
        }
    }
    
    public void eliminarPelicula (int id){
        
        String sql = "DELETE FROM pelicula WHERE id_pelicula = ?";
        
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             
             int filas = ps.executeUpdate();
             
             if(filas > 0) {
                 System.out.println("Pelicula eliminada correctamente.");
             } else{
                 System.out.println("No se encontró ninguna pelicula con ese ID.");
             }
             ps.close();
        }catch(SQLException ex){
            
            System.out.println("Error al eliminar la pelicula:" + ex.getMessage());
        }
    }

    public List<Pelicula>listarPeliculas(){
      
        List<Pelicula>listarPeliculas = new ArrayList<>();
        
        String sql = "SELECT * FROM pelicula WHERE enCartelera = 1";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                Pelicula pelicula = new Pelicula ();
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setActores(rs.getString("actores"));
                pelicula.setOrigen(rs.getString("origen"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setEstreno(rs.getDate("estreno"));
                pelicula.setEnCartelera(true);
                listarPeliculas.add(pelicula);
            }
            ps.close();
        } catch (SQLException ex) {          
            System.out.println("Error al listar las peliculas:" + ex.getMessage());
        }
      return listarPeliculas;  
    }
}
