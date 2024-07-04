package com.aluraCursos.screenmatch.modelos;

public class Serie extends Titulo{
    int temporadas;
    int episodiosPorTemporadas;
    int minutosPorEpisodio;

    public Serie(String nombre, int fechaDeLanzamineto) {
        super(nombre, fechaDeLanzamineto);
    }


    @Override
    public int getDuracionEnMinutos() {
        return temporadas * episodiosPorTemporadas * minutosPorEpisodio;
    }

    public int getEpisodiosPorTemporadas() {
        return episodiosPorTemporadas;
    }

    public void setEpisodiosPorTemporadas(int episodiosPorTemporadas) {
        this.episodiosPorTemporadas = episodiosPorTemporadas;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return "\nSerie " + this.getNombre() + "\nFecha de lanzamiento: "+ getFechaDeLanzamineto();
    }
}
