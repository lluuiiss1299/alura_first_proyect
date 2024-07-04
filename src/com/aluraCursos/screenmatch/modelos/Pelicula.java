package com.aluraCursos.screenmatch.modelos;

import com.aluraCursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

    public Pelicula(String nombre, int fechaDeLanzamineto) {
        super(nombre, fechaDeLanzamineto);
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculaMedia()/2);
    }

    @Override
    public String toString() {
        return "\nPelicula " + this.getNombre() + "\nFecha de lanzamiento: "+ getFechaDeLanzamineto();
    }
}
