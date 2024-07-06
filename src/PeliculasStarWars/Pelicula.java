package PeliculasStarWars;

public class Pelicula {
    private String nombre;
    private String fechaLanzamiento;
    private int episodio;
    private String resumen;

    public Pelicula(PeliculaSwapi apiPelicula) {
        this.nombre = apiPelicula.title();
        this.fechaLanzamiento = apiPelicula.release_date();
        this.episodio = apiPelicula.episode_id();
        this.resumen = apiPelicula.opening_crawl();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getEpisodio() {
        return episodio;
    }

    public String getResumen() {
        return resumen;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "\nnombre='" + nombre + '\'' +
                "\nfechaLanzamiento='" + fechaLanzamiento + '\'' +
                "\nepisodio=" + episodio +
//                "\nresumen='" + resumen + '\'' +
                "\n}";
    }
}
