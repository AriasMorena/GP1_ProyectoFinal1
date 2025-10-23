
package Entidades;

import java.util.Date;
/**
 *
 * @author bustos Guada
 */

public class Pelicula {
    
    private String titulo;
    private String director;
    private String actores;
    private String origen;
    private String genero;
    private Date estreno;
    private boolean enCartelera;
    
    
    public Pelicula (){
        
    }

    public Pelicula(String titulo, String director, String actores, 
            String origen, String genero, Date estreno, boolean enCartelera) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.origen = origen;
        this.genero = genero;
        this.estreno = estreno;
        this.enCartelera = enCartelera;
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

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
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
