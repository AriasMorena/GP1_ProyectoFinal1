/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Entidades.Pelicula;
import Persistencia.PeliculaData;
import java.time.LocalDate;

/**
 *
 * @author arias
 */
public class Main {
    
    public static void main (String[] args) {
        
        Pelicula peli = new Pelicula ("Avatar", "James Cameron", "Pepito", "EEUU", "Ciencia Ficcion", LocalDate.of(2009, 11, 10), true);
        PeliculaData pelicula = new PeliculaData();
        pelicula.guardarPelicula(peli);
    }
}
