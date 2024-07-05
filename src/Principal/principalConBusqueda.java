package Principal;

import com.aluraCursos.screenmatch.exceptions.ErrorFechaLanzamientoUndefined;
import com.aluraCursos.screenmatch.modelos.Titulo;
import com.aluraCursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class principalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        List<Titulo> listaTitulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while(true){
            System.out.println("Escribe el nombre de la pelicula");
            var busqueda = teclado.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String direccion = "https://www.omdbapi.com/?t="+URLEncoder.encode(busqueda)+"&apikey=ce685310";
            System.out.println(direccion);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
                String json = response.body();

                TituloOmdb miTitulo = gson.fromJson(json, TituloOmdb.class);
                //        System.out.println("titulo buscado: "+miTitulo);
                Titulo titulo = new Titulo(miTitulo);
                System.out.println("titulo buscado: " + titulo);
                listaTitulos.add(titulo);

            }catch (NumberFormatException e) {
                System.out.println("ocurio un error");
                System.out.println(e.getMessage());
            }catch (ErrorFechaLanzamientoUndefined e){
                System.out.println("si entre");
                System.out.println(e.getMessage());
            }

        }
        System.out.println(listaTitulos);

        FileWriter escritura = new FileWriter("peliculas.json");
        escritura.write(gson.toJson(listaTitulos));
        escritura.close();
        System.out.println("Finalizo la ejecuacion del programa");

    }
}
