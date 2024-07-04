package Principal;

import com.aluraCursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluraCursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluraCursos.screenmatch.modelos.Episodio;
import com.aluraCursos.screenmatch.modelos.Pelicula;
import com.aluraCursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Lalaland",2017);
        // miPelicula.setNombre();
//        miPelicula.setFechaDeLanzamineto(2017);
        miPelicula.setDuracionEnMinutos(140);
        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(7);
        miPelicula.evalua(9);
        System.out.println("media de la pelicula" + miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del dragon",2022);
//        casaDragon.setNombre("La casa del dragon");
//        casaDragon.setFechaDeLanzamineto(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(60);
        casaDragon.setEpisodiosPorTemporadas(12);
        casaDragon.muestraFichaTecnica();
        System.out.println("Duracion En Minutos: " + casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Matrix",1998);
        // otraPelicula.setNombre();
//        otraPelicula.setFechaDeLanzamineto(1998);
        otraPelicula.setDuracionEnMinutos(180);


        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa de masha");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);
        filtroRecomendacion.filtra(episodio);

        Pelicula peliculaLuis = new Pelicula("Señor de los anillos",2001);
        // peliculaLuis.setNombre("Señor de los anillos");
        peliculaLuis.setDuracionEnMinutos(180);
//        peliculaLuis.setFechaDeLanzamineto(2001);
        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(peliculaLuis);
        listaDePeliculas.add(otraPelicula);
        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        System.out.println("La ultima pelicula de la lista es: " + listaDePeliculas.get(listaDePeliculas.size()-1).getNombre());
        System.out.println(listaDePeliculas);
        System.out.println(listaDePeliculas.get(0).toString());

    }
}
