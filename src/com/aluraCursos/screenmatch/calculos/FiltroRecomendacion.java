package com.aluraCursos.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtra(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >= 4){
            System.out.println("muy bien evaluado hasta el momento");
        }else if(clasificacion.getClasificacion() >= 2){
            System.out.println("Medianamente popular");
        }else{
            System.out.println("Para ver mas tarde");
        }
    }
}
