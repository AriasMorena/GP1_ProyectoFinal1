
package Entidades;

import java.time.LocalDate;
/**
 *
 * @author bustos Guada
 */

public class Pelicula {
    
    private int id_pelicula;
    private String titulo;
    private String director;
    private String actores;
    private String origen;
    private String genero;
    private LocalDate estreno;
    private boolean enCartelera;
    
    
    public Pelicula (){
        
    }

    public Pelicula(int id_pelicula, String titulo, String director, String actores, String origen, String genero, LocalDate estreno, boolean enCartelera) {
        this.id_pelicula = id_pelicula;
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
    }
    

    public Pelicula(String titulo, String director, String actores, 
            String origen, String genero, LocalDate estreno, boolean enCartelera) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }

    public boolean isEnCartelera() {
        return enCartelera;
    }

    public void setEnCartelera(boolean enCartelera) {
        this.enCartelera = enCartelera;
    }
    
    public void agregarActor(String nombre ){
        if(nombre != null && ! nombre.isEmpty()){
            actores.add(nombre);
        }
    }
    
    public void cambiarEstadoCartelera(boolean estado){
        this.enCartelera = estado;
    }
    
    public String obtenerInformación(){
        return "Pelicula: " + titulo +
                "\nDirector: " + director +
                "\nGénero: "  + genero + 
                "\nOrigen: " + origen + 
                "\nEstreno: " + estreno +
                "\nEn Cartelera: " + enCartelera ;
    }
    
  public String toString() {
        return "Título: " + titulo + "\nDirector: " + director + "\nGénero: " + genero + "\nEstreno: " + estreno + "\nActores: " + actores;
    }
}
