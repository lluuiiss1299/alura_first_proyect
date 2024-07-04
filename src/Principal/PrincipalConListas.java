package Principal;

import com.aluraCursos.screenmatch.modelos.Pelicula;
import com.aluraCursos.screenmatch.modelos.Serie;
import com.aluraCursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Lalaland",2017);
        Serie casaDragon = new Serie("La casa del dragon",2022);
        Pelicula otraPelicula = new Pelicula("Matrix",1998);
        Pelicula peliculaLuis = new Pelicula("Señor de los anillos",2001);
        ArrayList<Titulo> lista = new ArrayList<>();
        peliculaLuis.evalua(9);
        miPelicula.evalua(6);
        otraPelicula.evalua(10);
        lista.add(otraPelicula);
        lista.add(miPelicula);
        lista.add(peliculaLuis);
        lista.add(casaDragon);
        var p1 = peliculaLuis;
//        puede ser llamado asi
//        lista.forEach((item) -> System.out.println(item));

//        o asi
        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if ( item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3 ){
                System.out.println(pelicula.getClasificacion());
            }
        }
        List<String> listaArtistas = new LinkedList<>();
        listaArtistas.add("Ibai");
        listaArtistas.add("Knekro");
        listaArtistas.add("Xokas");
        listaArtistas.add("Auronplay");
        listaArtistas.add("Illojuan");

        System.out.println("Lista de artistas desordenada: " + listaArtistas );
        Collections.sort(listaArtistas);
        System.out.println("Lista de artistas ordenada: " + listaArtistas );

        System.out.println("lista desordenada de titulos: " + lista);
        Collections.sort(lista);
        System.out.println("lista ordenada de titulos: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamineto));
        System.out.println("lista ordenada por fechas: " + lista);
    }
}
