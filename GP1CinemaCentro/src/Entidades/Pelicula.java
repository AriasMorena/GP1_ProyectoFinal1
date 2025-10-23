
package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author bustos Guada
 */

public class Pelicula {
    
    private String titulo;
    private String director;
    private List<String> actores;
    private String origen;
    private String género;
    private Date estreno;
    private boolean enCartelera;
    
    
    public Pelicula (){
        this.actores = new ArrayList<>();
    }

    public Pelicula(String titulo, String director,List<String> actores, 
            String origen, String género, Date estreno, boolean enCartelera) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores != null ? actores: new ArrayList<>();
        this.origen = origen;
        this.género = género;
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

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getGénero() {
        return género;
    }

    public void setGénero(String género) {
        this.género = género;
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
                "\nGénero: "  + género + 
                "\nOrigen: " + origen + 
                "\nEstreno: " + estreno +
                "\nEn Cartelera: " + enCartelera ;
    }
    
  
}
