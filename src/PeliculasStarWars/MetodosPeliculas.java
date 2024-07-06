package PeliculasStarWars;

import com.aluraCursos.screenmatch.modelos.Titulo;
import com.aluraCursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetodosPeliculas {
    public List<Pelicula> listaPeliculas = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);
    private int episodio;
    private Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();


    public void llenarPeliculas(){

        int desision = 1;
        while(desision == 1){
            System.out.println("Selecciona la pelicula que agregaras al archivo opciones 1-6");
            episodio = teclado.nextInt();
            String direccion = "https://swapi.py4e.com/api/films/"+episodio+"/";
            // compobar si ya esta en el arreglo

            // agregar la pelicula al arreglo
            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                PeliculaSwapi PeliculaSwa = gson.fromJson(json, PeliculaSwapi.class);
                if(comprobarEpisodio(PeliculaSwa.episode_id())){
                    System.out.println("Usted ya ha agregado esa pelicula");
                }else{
                    Pelicula miPelicula = new Pelicula(PeliculaSwa);
                    listaPeliculas.add(miPelicula);

                }
                System.out.println("Pelicula agregada con exito");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("desea agregar otra pelicula al archivo? 1= si, 0= no");
            desision = teclado.nextInt();
        }

    }

    private Boolean comprobarEpisodio(int episodio){
        boolean bandera = false;
        for (Pelicula item: listaPeliculas) {
            if (item.getEpisodio() == episodio) {
                bandera = true;
            }
        }
        return bandera;
    }

    public void verLista(){
        listaPeliculas.forEach(o->System.out.println(o.toString()));
    }

    public void crearArchivo(){
        try {
        FileWriter escribir = new FileWriter("starWars.json");
        escribir.write(gson.toJson(listaPeliculas));
        escribir.close();
        System.out.println("el archivo se ha creado");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
