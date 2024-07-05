package com.aluraCursos.screenmatch.modelos;

import com.aluraCursos.screenmatch.exceptions.ErrorFechaLanzamientoUndefined;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamineto;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaEvaluaciones;
    private int totalEvaluaciones;

    public Titulo(TituloOmdb miTitulo) {
        this.nombre = miTitulo.title();
        this.fechaDeLanzamineto = Integer.valueOf(miTitulo.year());
        if (miTitulo.runtime().contains("N/A")){
            throw new ErrorFechaLanzamientoUndefined("No se puede convertir la fecha porque es N/A");
        }

        this.duracionEnMinutos = Integer.valueOf(miTitulo.runtime().substring(0,3).replace(" ", ""));
    }

    int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    public Titulo(String nombre, int fechaDeLanzamineto) {
        this.nombre = nombre;
        this.fechaDeLanzamineto = fechaDeLanzamineto;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setFechaDeLanzamineto(int fechaDeLanzamineto) {
        this.fechaDeLanzamineto = fechaDeLanzamineto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getFechaDeLanzamineto() {
        return fechaDeLanzamineto;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getNombre() {
        return nombre;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("la fecha de lanzamiento es: " + fechaDeLanzamineto);
        System.out.println("La duracion es: " + getDuracionEnMinutos());
    }
    public void evalua(double nota){
        sumaEvaluaciones += nota;
        totalEvaluaciones++;
    }
    public double calculaMedia(){
        return sumaEvaluaciones/totalEvaluaciones;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "Pelicula= " + nombre + '\n' +
                "FechaDeLanzamineto= " + fechaDeLanzamineto + '\n' +
                "Duracion en minutos= " + duracionEnMinutos+ '\n'+'\n';
    }
}
