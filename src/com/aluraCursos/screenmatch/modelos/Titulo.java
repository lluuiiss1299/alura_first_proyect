package com.aluraCursos.screenmatch.modelos;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamineto;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaEvaluaciones;
    private int totalEvaluaciones;
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
}
