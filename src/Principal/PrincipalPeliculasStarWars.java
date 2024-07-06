package Principal;

import PeliculasStarWars.MetodosPeliculas;

public class PrincipalPeliculasStarWars {
    public static void main(String[] args) {
        MetodosPeliculas conductor = new MetodosPeliculas();
        conductor.llenarPeliculas();
        conductor.verLista();
        conductor.crearArchivo();
    }
}
